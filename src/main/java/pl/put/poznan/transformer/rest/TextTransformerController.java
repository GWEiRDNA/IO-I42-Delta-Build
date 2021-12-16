package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.buildings.*;

import java.util.Arrays;


@RestController
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);
    private CompoundLocation cLocation = new CompoundLocation();

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String get() {
        // log the parameters - debug
        return cLocation.toString();
    }

    @RequestMapping(value = "/room",method = RequestMethod.POST)
    public String postRoom(@RequestBody Room room) {
        logger.debug("adding room");
        logger.debug(room.toString());

        cLocation.add(room);
        return room.toString();
    }

    @RequestMapping(value = "/storey",method = RequestMethod.POST)
    public String postStorey(@RequestBody Storey storey) {
        logger.debug("adding storey");
        logger.debug(storey.toString());

        cLocation.add(storey);
        return storey.toString();
    }

    @RequestMapping(value = "/",method = RequestMethod.DELETE)
    public String delete(@RequestBody int[] indexes) {
        logger.debug(Arrays.toString(indexes));
        for(int i : indexes)
            cLocation.remove(i);

        return "ok";
    }
}


