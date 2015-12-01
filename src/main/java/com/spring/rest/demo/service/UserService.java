package com.spring.rest.demo.service;

import java.util.List;

import com.spring.rest.demo.wrapper.UserWrapper;

public interface UserService {

    List<UserWrapper> getAllUsers();
    
    void createUser(UserWrapper userDetails);
    
    void updateUser(UserWrapper userDetails);
}
