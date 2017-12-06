package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by timon on 04.12.2017.
 */

@RestController
@RequestMapping("/tracks")
public class TrackServiceController {

    @Autowired
    private TrackRepository trackRepo;


    //users - GET
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Track> listTracks() {
        //logger.debug("listUsers");

        List<Track> result = new ArrayList<>();
        //trackRepo.findAll().forEach(result::add);

        return result;
    }

}
