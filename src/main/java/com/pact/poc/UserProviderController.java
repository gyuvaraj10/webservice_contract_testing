package com.pact.poc;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Yuvaraj on 26/01/2018.
 */
@RestController
@RequestMapping(path = "/atom")
public class UserProviderController {

    @RequestMapping(method = RequestMethod.GET, path = "/user")
    public ResponseEntity<User> getUsersInformation() {
        User user = new User();
        user.setName("Yuvaraj");
        user.setDepartment("IT");
        user.setId("n465290");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/user")
    public ResponseEntity createUser(User user) {
        System.out.println(new Gson().toJson(user));
        return new ResponseEntity(user, HttpStatus.CREATED);
    }
}
