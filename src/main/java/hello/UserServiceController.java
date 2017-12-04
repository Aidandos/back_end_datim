package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by timon on 04.12.2017.
 */

@RestController
@RequestMapping(UserServiceController.CONTEXT)
public class UserServiceController {

    static final String CONTEXT = "/users";
    public String index() {
        return "Greetings from Spring Boot!";
    }

}

