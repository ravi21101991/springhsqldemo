package com.spring.rest.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.demo.dao.UserDao;
import com.spring.rest.demo.model.UserEntity;
import com.spring.rest.demo.service.UserService;
import com.spring.rest.demo.wrapper.UserWrapper;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired private UserDao userDao;
    
    public List<UserWrapper> getAllUsers() {
       List<UserEntity> users = userDao.getAllUsers();
       List<UserWrapper> userWrappers = new ArrayList<UserWrapper>();
       
       UserWrapper userWrapper = null;
               
       for (UserEntity userEntity : users) {
        userWrapper = new UserWrapper();
        userWrapper.setAge(userEntity.getAge());
        userWrapper.setFirstName(userEntity.getFirstName());
        userWrapper.setGender(userEntity.getGender());
        userWrapper.setId(userEntity.getId());
        userWrapper.setLastName(userEntity.getLastName());
        userWrapper.setPhone(userEntity.getPhone());
        userWrapper.setZip(userEntity.getZip());
        userWrappers.add(userWrapper);
    }
        return userWrappers;
    }

    public void createUser(UserWrapper userDetails) {
        // TODO Auto-generated method stub

    }

    public void updateUser(UserWrapper userDetails) {
        // TODO Auto-generated method stub

    }

}
