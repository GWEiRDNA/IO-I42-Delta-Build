package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.app.BuildingsApplication;
import pl.put.poznan.transformer.buildings.*;
import pl.put.poznan.transformer.visitors.HeatAvgVisitor;
import pl.put.poznan.transformer.visitors.HeatExceededVisitor;
import pl.put.poznan.transformer.visitors.Visitor;

import java.util.ArrayList;
import java.util.LinkedHashMap;


@RestController
public class BuildingsController {

    @RequestMapping(value = {"/","/{id1}","/{id1}/{id2}","/{id1}/{id2}/{id3}","/{id1}/{id2}/{id3}/{id4}"}, method = RequestMethod.GET, produces = "application/json")
    public Response get(@PathVariable(required = false) Integer id1, @PathVariable(required = false) Integer id2, @PathVariable(required = false) Integer id3, @PathVariable(required = false) Integer id4, @RequestParam(defaultValue = "-1") String limit) {

        double limitDouble = HeatExceededVisitor.DEFAULT_LIMIT;
        try
        {
            limitDouble = Double.parseDouble(limit);
            if (limitDouble != -1)
                ((HeatExceededVisitor) BuildingsApplication.visitors[2]).setLimit(limitDouble);
        }
        catch (Exception e){}

        ArrayList<Integer> address = new ArrayList<>();
        if(id1 != null)
            address.add(id1);
        if(id2 != null)
            address.add(id2);
        if(id3 != null)
            address.add(id3);
        if(id4 != null)
            address.add(id4);
        return getArray(address.toArray(new Integer[0]));
    }

    @RequestMapping(value = {"/","/{id1}","/{id1}/{id2}","/{id1}/{id2}/{id3}","/{id1}/{id2}/{id3}/{id4}"}, method = RequestMethod.DELETE, produces = "application/json")
    public Response delete(@PathVariable(required = false) Integer id1, @PathVariable(required = false) Integer id2, @PathVariable(required = false) Integer id3, @PathVariable(required = false) Integer id4) {
        ArrayList<Integer> address = new ArrayList<>();
        if(id1 != null)
            address.add(id1);
        if(id2 != null)
            address.add(id2);
        if(id3 != null)
            address.add(id3);
        if(id4 != null)
            address.add(id4);
        return deleteArray(address.toArray(new Integer[0]));
    }

    @RequestMapping(value = {"/","/{id1}","/{id1}/{id2}","/{id1}/{id2}/{id3}","/{id1}/{id2}/{id3}/{id4}"},method = {RequestMethod.POST, RequestMethod.PUT}, produces = "application/json")
    public Response post(@PathVariable(required = false) Integer id1, @PathVariable(required = false) Integer id2, @PathVariable(required = false) Integer id3, @PathVariable(required = false) Integer id4, @RequestBody LinkedHashMap map, @RequestParam(defaultValue = "r") String type) {
        ArrayList<Integer> address = new ArrayList<>();
        if(id1 != null)
            address.add(id1);
        if(id2 != null)
            address.add(id2);
        if(id3 != null)
            address.add(id3);
        if(id4 != null)
            address.add(id4);
        return postArray(address.toArray(new Integer[0]), map, type);
    }

    @RequestMapping(value = {"/","/{id1}","/{id1}/{id2}","/{id1}/{id2}/{id3}","/{id1}/{id2}/{id3}/{id4}"}, method = RequestMethod.PATCH, produces = "application/json")
    public Response patch(@PathVariable(required = false) Integer id1, @PathVariable(required = false) Integer id2, @PathVariable(required = false) Integer id3, @PathVariable(required = false) Integer id4, @RequestBody LinkedHashMap map) {
        ArrayList<Integer> address = new ArrayList<>();
        if(id1 != null)
            address.add(id1);
        if(id2 != null)
            address.add(id2);
        if(id3 != null)
            address.add(id3);
        if(id4 != null)
            address.add(id4);
        return patchArray(address.toArray(new Integer[0]), map);
    }



    private Response getArray(Integer[] address)
    {
        if(address.length == 0)
            return new Response(BuildingsApplication.compound);
        try
        {
            LocationComposite lastComposite = getLastComposite(BuildingsApplication.compound, address);
            return new Response(lastComposite.at(address[address.length-1]));
        }
        catch (Exception e)
        {
            if(e.getClass().equals(ClassCastException.class))
                return new Response("This location can't contain other locations");
            return new Response(e.getMessage()); // different thrown errors (for example: "composite don't have this index")
        }
    }

    private Response deleteArray(Integer[] address)
    {
        if(address.length == 0)
            return new Response("You can't remove main container");
        try
        {
            LocationComposite lastComposite = getLastComposite(BuildingsApplication.compound, address);
            lastComposite.remove(address[address.length-1]);
            return new Response(lastComposite);
        }
        catch (Exception e)
        {
            if(e.getClass().equals(ClassCastException.class))
                return new Response("This location can't contain other locations");
            return new Response(e.getMessage()); // different thrown errors (for example: "composite don't have this index")
        }
    }

    private LocationComposite getLastComposite(LocationComposite start,Integer[] address) throws Exception
    {
        LocationComposite curLocation = BuildingsApplication.compound;
        int i=0;
        while (i < address.length-1)
            curLocation = (LocationComposite) curLocation.at(address[i++]);
        return curLocation;
    }

    private Response postArray(Integer[] address, LinkedHashMap map, String type)
    {
        try {
            type = type.toLowerCase().trim();

            Location location;
            switch(type) { //creating location from map
                case "r":
                case "room":
                    location = new Room(
                            getFromMapInt(map,"id"),
                            getFromMapDouble(map, "area"),
                            getFromMapDouble(map,"capacity"),
                            getFromMapDouble(map,"light"),
                            getFromMapDouble(map,"heating")
                    );
                    location.setName(getFromMapString(map,"name"));
                    break;
                case "s":
                case "storey":
                    location = new Storey(getFromMapInt(map,"id"));
                    location.setName(getFromMapString(map,"name"));
                    break;
                case "b":
                case "building":
                    location = new Building(getFromMapInt(map,"id"));
                    location.setName(getFromMapString(map,"name"));
                    break;
                default:
                    throw new Exception("type not recognized: '"+type+"' posible types: room/storey/building");
            }

            LocationComposite curLocation = BuildingsApplication.compound;

            for (int i : address)
                curLocation = (LocationComposite) curLocation.at(i);

            if(curLocation.getClass() == CompoundLocation.class)
                ((CompoundLocation)curLocation).add(location);
            else if(curLocation.getClass() == Building.class)
                ((Building)curLocation).add((Storey) location);
            else if(curLocation.getClass() == Storey.class)
                ((Storey)curLocation).add((Room) location);

            return new Response(curLocation);

        }catch (Exception e) {
            if(e.getClass().equals(ClassCastException.class))
                return new Response("This location can't contain that type of locations");
            return new Response(e.getMessage()); // different thrown errors (for example: "composite don't have this index")
        }
    }

    private int getFromMapInt(LinkedHashMap map, String name)
    {
        return (int) map.getOrDefault(name, 0);
    }

    private double getFromMapDouble(LinkedHashMap map, String name)
    {
        if(map.get(name) != null && map.get(name).getClass() == Integer.class) //conversion from int to double
            return ((Integer) map.get(name)).doubleValue();
        return (double) map.getOrDefault(name, 0.0);
    }

    private String getFromMapString(LinkedHashMap map, String name)
    {
        return (String) map.getOrDefault(name, null);
    }

    private Response patchArray(Integer[] address, LinkedHashMap map)
    {
        try{
            Location curLocation = BuildingsApplication.compound;

            for (int i : address)
                curLocation = ((LocationComposite) curLocation).at(i);

            if(map.get("id") != null)
                curLocation.setId(getFromMapInt(map, "id"));
            if(map.get("name") != null)
                curLocation.setName(getFromMapString(map, "name"));
            if(curLocation.getClass() == Room.class)
            {
                Room r = (Room) curLocation;
                if(map.get("area") != null)
                    r.setArea(getFromMapDouble(map, "area"));
                if(map.get("capacity") != null)
                    r.setCapacity(getFromMapDouble(map, "capacity"));
                if(map.get("light") != null)
                    r.setLight(getFromMapDouble(map, "light"));
                if(map.get("heating") != null)
                    r.setHeating(getFromMapDouble(map, "heating"));
            }

            return new Response(curLocation);
        }catch (Exception e) {
            if(e.getClass().equals(ClassCastException.class))
                return new Response("Wrong type of variable");
            return new Response(e.getMessage()); // different thrown errors (for example: "composite don't have this index")
        }
    }
}

class Response
{
    private String type;
    private Object object;
    private LinkedHashMap<String,Object> visitorsOutcomes;

    Response(Object object)
    {
        if(object == null)
            return;

        this.object = object;
        this.type = getLastClass(object);

        if(Location.class.isAssignableFrom(object.getClass()) && object.getClass() != CompoundLocation.class)
        {
            this.visitorsOutcomes = new LinkedHashMap<String,Object>();
            for(Visitor visitor : BuildingsApplication.visitors)
            {
                visitor.reset();
                ((Location) object).accept(visitor);
                visitorsOutcomes.put(getLastClass(visitor), visitor.getOutcome());
            }
        }
    }

    private static String getLastClass(Object object)
    {
        String type = object.getClass().toString();
        if(type.lastIndexOf('.') != -1) //leaving only last part of class name (removing packet name)
            type = type.substring(type.lastIndexOf('.')+1);
        return type;
    }

    public String getType() {
        return type;
    }
    public Object getObject() {
        return object;
    }

    public LinkedHashMap<String,Object> getVisitorsOutcomes() {
        return visitorsOutcomes;
    }
}




