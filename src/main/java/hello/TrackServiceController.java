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
import java.util.HashMap;
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


    //tracks - GET
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Track> findAllObjects() {

        List<Track> objects = new ArrayList<Track>();
        trackRepo.findAll().forEach(objects::add);
        if(objects!= null){
            return objects;
        }
        return null;
    }

    //tracks - POST
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public TrackAuthenticationWrapper addTrack(@RequestBody Track track) {

        //logger.debug("addUser: " + user);
        String token = UUID.randomUUID().toString();
        track.setToken(token);
        track.setRanking(new HashMap<Long, Double>());
        trackRepo.save(track);

        TrackAuthenticationWrapper trackAuthenticationWrapper = new TrackAuthenticationWrapper();
        trackAuthenticationWrapper.setTrackToken(token);
        trackAuthenticationWrapper.setTrackId(track.getId());
        return trackAuthenticationWrapper;
    }

}
