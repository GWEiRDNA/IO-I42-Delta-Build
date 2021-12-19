package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.app.TextTransformerApplication;
import pl.put.poznan.transformer.buildings.*;


@RestController
public class BuildingsController {

    private static final Logger logger = LoggerFactory.getLogger(BuildingsController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public Response get() {
        return new Response(TextTransformerApplication.compound);
    }

    @RequestMapping(value = "/{locationID}", method = RequestMethod.GET, produces = "application/json")
    public Response get(@PathVariable Integer locationID) {
        try {
            Location loc = TextTransformerApplication.compound.at(locationID);
            return new Response(loc);
        }catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    @RequestMapping(value = "/{locationID}/{childID}", method = RequestMethod.GET, produces = "application/json")
    public Response get(@PathVariable Integer locationID, @PathVariable Integer childID) {
        try{
            LocationComposite com = (LocationComposite) TextTransformerApplication.compound.at(locationID);
            Location loc = com.at(childID);
            return new Response(loc);
        }catch (Exception e) {
            return new Response(e.getMessage());
        }
    }

    @RequestMapping(value = "/{locationID}/{childID1}/{childID2}", method = RequestMethod.GET, produces = "application/json")
    public Response get(@PathVariable Integer locationID, @PathVariable Integer childID1, @PathVariable Integer childID2) {
        try{
            LocationComposite com1 = (LocationComposite) TextTransformerApplication.compound.at(locationID);
            LocationComposite com2 = (LocationComposite) com1.at(childID1);
            Location loc = com2.at(childID2);
            return new Response(loc);
        }catch (Exception e) {
            return new Response(e.getMessage());
        }
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




