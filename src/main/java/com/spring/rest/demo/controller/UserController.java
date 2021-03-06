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

import com.spring.rest.demo.enums.ErrorMapping;
import com.spring.rest.demo.exception.UserException;
import com.spring.rest.demo.service.UserService;
import com.spring.rest.demo.validator.UserValidator;
import com.spring.rest.demo.wrapper.SuccessWrapper;
import com.spring.rest.demo.wrapper.UserWrapper;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<UserWrapper> getAllUsers() {
        List<UserWrapper> userWrapperList = userService.getAllUsers();

        if (userWrapperList == null || userWrapperList.isEmpty()) {
            throw new UserException(ErrorMapping.USERS_NOT_FOUND);
        }
        return userWrapperList;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public @ResponseBody SuccessWrapper createUser(@RequestBody UserWrapper userDetails) {
        UserValidator.validateUserDetails(userDetails);
        userService.createUser(userDetails);
        return new SuccessWrapper("User created successfully.");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody SuccessWrapper updateUser(@RequestBody UserWrapper userDetails) {
        UserValidator.validateUserDetails(userDetails);
        userService.updateUser(userDetails);
        return new SuccessWrapper("User updated successfully.");
    }
}
