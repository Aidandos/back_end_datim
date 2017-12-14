package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/users")
public class UserServiceController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ActivityRepository activityRepository;


    //users - GET
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<User> listUsers() {
        //logger.debug("listUsers");

        List<User> result = new ArrayList<>();
        userRepo.findAll().forEach(result::add);

        return result;
    }

    //users - GET
    @RequestMapping(method = RequestMethod.GET, value = "{userName}/login")
    @ResponseStatus(HttpStatus.OK)
    public List<Activity> listActivities(@RequestParam("userName") String username) {
        //logger.debug("listUsers");
        User user = userRepo.findByName(username);

        return user.getActivities();
    }

    //users - POST
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public UserAuthenticationWrapper addUser(@RequestBody User user) {

        //logger.debug("addUser: " + user);

        user.setStatus(UserStatus.OFFLINE);
        String token = UUID.randomUUID().toString();
        user.setToken(token);
        user.setActivities(new ArrayList<Activity>());
        user = userRepo.save(user);

        UserAuthenticationWrapper userAuthenticationWrapper = new UserAuthenticationWrapper();
        userAuthenticationWrapper.setUserToken(token);
        userAuthenticationWrapper.setUserId(user.getId());
        return userAuthenticationWrapper;
    }

    //users/{userId}/login - POST
    @RequestMapping(method = RequestMethod.POST, value = "{userName}/login")
    @ResponseStatus(HttpStatus.OK)
    public UserAuthenticationWrapper login(@PathVariable String userName, @RequestParam("password") String password) {
        //logger.debug("login: " + userId);

        User user = userRepo.findByUsername(userName);

        if (user != null) {
            if(user.getPassword().equals(password)){
            user.setToken(UUID.randomUUID().toString());
            user.setStatus(UserStatus.ONLINE);
            user = userRepo.save(user);
            UserAuthenticationWrapper userAuthenticationWrapper = new UserAuthenticationWrapper();
            userAuthenticationWrapper.setUserToken(user.getToken());
            userAuthenticationWrapper.setUserId(user.getId());
            return userAuthenticationWrapper;
            }
            else{
                return null;
            }

        }

        return null;
    }

    //users/{userId}/login - POST
    @RequestMapping(method = RequestMethod.POST, value = "{userName}/activity")
    @ResponseStatus(HttpStatus.OK)
    public Long addAcitivty(@RequestBody Activity activity, @PathVariable String userName) {
        //logger.debug("login: " + userId);

        User user = userRepo.findByUsername(userName);

        if (user != null) {
            activity.setToken(UUID.randomUUID().toString());
            activityRepository.save(activity);
            user.getActivities().add(activity);
            userRepo.save(user);
            return user.getId();
        }
        return null;

    }
}


