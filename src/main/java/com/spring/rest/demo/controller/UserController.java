package com.spring.rest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.rest.demo.service.UserService;
import com.spring.rest.demo.validator.UserValidator;
import com.spring.rest.demo.wrapper.UserWrapper;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<UserWrapper> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createUser(@RequestBody UserWrapper userDetails) {
        UserValidator.validateUserDetails(userDetails);
        userService.createUser(userDetails);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateUser(@RequestBody UserWrapper userDetails) {
        UserValidator.validateUserDetails(userDetails);
        userService.updateUser(userDetails);
    }
}
