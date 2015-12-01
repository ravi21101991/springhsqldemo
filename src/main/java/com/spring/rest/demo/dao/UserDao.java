package com.spring.rest.demo.dao;

import java.util.List;

import com.spring.rest.demo.model.UserEntity;

public interface UserDao {
    
    List<UserEntity> getAllUsers();

    void createUser(UserEntity userDetails);

    void updateUser(UserEntity userDetails);
    
    UserEntity fetchUserByUserId(String userId);
    
    UserEntity fetchUserByName(String firstName, String lastName);
}
