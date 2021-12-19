package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.app.TextTransformerApplication;
import pl.put.poznan.transformer.buildings.*;


@RestController
public class BuildingsController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingsController.class);

    public Response getArray(int[] address)
    {
        if(address.length == 0)
            return new Response(TextTransformerApplication.compound);
        try {
            LocationComposite currComposite = TextTransformerApplication.compound;
            int i=0;
            while (i < address.length-1) {
                currComposite = (LocationComposite) currComposite.at(address[i++]);
            }
            return new Response(currComposite.at(address[i]));
        }catch (Exception e) {
            if(e.getClass().equals(ClassCastException.class))
                return new Response("This location can't contain other locations");
            return new Response(e.getMessage()); // different thrown errors (for example: "composite don't have this index")
        }
    }

    public Response deleteArray(int[] address)
    {
        if(address.length == 0)
            return new Response("You can't remove main container");
        try {
            LocationComposite currComposite = TextTransformerApplication.compound;
            int i=0;
            while (i < address.length-1) {
                currComposite = (LocationComposite) currComposite.at(address[i++]);
            }
            currComposite.remove(address[i]);
            return new Response(currComposite);
        }catch (Exception e) {
            if(e.getClass().equals(ClassCastException.class))
                return new Response("This location can't contain other locations");
            return new Response(e.getMessage()); // different thrown errors (for example: "composite don't have this index")
        }
    }




    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public Response get() {
        int[] address = {};
        return getArray(address);
    }

    @RequestMapping(value = "/{locationID}", method = RequestMethod.GET, produces = "application/json")
    public Response get(@PathVariable Integer locationID) {
        int[] address = {locationID};
        return getArray(address);
    }

    @RequestMapping(value = "/{locationID}/{childID}", method = RequestMethod.GET, produces = "application/json")
    public Response get(@PathVariable Integer locationID, @PathVariable Integer childID) {
        int[] address = {locationID, childID};
        return getArray(address);
    }

    @RequestMapping(value = "/{locationID}/{childID1}/{childID2}", method = RequestMethod.GET, produces = "application/json")
    public Response get(@PathVariable Integer locationID, @PathVariable Integer childID1, @PathVariable Integer childID2) {
        int[] address = {locationID, childID1, childID2};
        return getArray(address);
    }

    @RequestMapping(value = "/{locationID}/{childID1}/{childID2}/{childID3}", method = RequestMethod.GET, produces = "application/json")
    public Response get(@PathVariable Integer locationID, @PathVariable Integer childID1, @PathVariable Integer childID2, @PathVariable Integer childID3) {
        int[] address = {locationID, childID1, childID2, childID3};
        return getArray(address);
    }





    @RequestMapping(value = "/", method = RequestMethod.DELETE, produces = "application/json")
    public Response delete() {
        int[] address = {};
        return deleteArray(address);
    }

    @RequestMapping(value = "/{locationID}", method = RequestMethod.DELETE, produces = "application/json")
    public Response delete(@PathVariable Integer locationID) {
        int[] address = {locationID};
        return deleteArray(address);
    }

    @RequestMapping(value = "/{locationID}/{childID}", method = RequestMethod.DELETE, produces = "application/json")
    public Response delete(@PathVariable Integer locationID, @PathVariable Integer childID) {
        int[] address = {locationID, childID};
        return deleteArray(address);
    }

    @RequestMapping(value = "/{locationID}/{childID1}/{childID2}", method = RequestMethod.DELETE, produces = "application/json")
    public Response delete(@PathVariable Integer locationID, @PathVariable Integer childID1, @PathVariable Integer childID2) {
        int[] address = {locationID, childID1, childID2};
        return deleteArray(address);
    }

    @RequestMapping(value = "/{locationID}/{childID1}/{childID2}/{childID3}", method = RequestMethod.DELETE, produces = "application/json")
    public Response delete(@PathVariable Integer locationID, @PathVariable Integer childID1, @PathVariable Integer childID2, @PathVariable Integer childID3) {
        int[] address = {locationID, childID1, childID2, childID3};
        return deleteArray(address);
    }

//    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
//    public String post(@PathVariable String text, @RequestBody String[] transforms) {
//
//        // log the parameters
//        logger.debug(text);
//        logger.debug(Arrays.toString(transforms));
//
//        // perform the transformation, you should run your logic here, below is just a silly example
//        TextTransformer transformer = new TextTransformer(transforms);
//        return transformer.transform(text);
//    }

}

class Response
{
    String type;
    Object object;

    Response(Object object)
    {
        if(object == null)
            return;

        this.object = object;

        type = object.getClass().toString();
        if(type.lastIndexOf('.') != -1) //zostawianie tylko ostatniej części nazwy klasy (pomijanie pakietu)
            type = type.substring(type.lastIndexOf('.')+1);
    }

    public String getType() {
        return type;
    }

    public Object getObject() {
        return object;
    }
}




