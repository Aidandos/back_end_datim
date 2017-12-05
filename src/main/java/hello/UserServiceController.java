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
@RequestMapping("/users")
public class UserServiceController {

    @Autowired
    private UserRepository userRepo;
    

    //users - GET
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<User> listUsers() {
        //logger.debug("listUsers");

        List<User> result = new ArrayList<>();
        userRepo.findAll().forEach(result::add);

        return result;
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
        user = userRepo.save(user);

        UserAuthenticationWrapper userAuthenticationWrapper = new UserAuthenticationWrapper();
        userAuthenticationWrapper.setUserToken(token);
        userAuthenticationWrapper.setUserId(user.getId());
        return userAuthenticationWrapper;
    }
}


