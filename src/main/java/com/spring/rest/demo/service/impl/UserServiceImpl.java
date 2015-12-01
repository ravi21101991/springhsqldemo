package com.spring.rest.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rest.demo.dao.UserDao;
import com.spring.rest.demo.enums.ErrorMapping;
import com.spring.rest.demo.exception.UserException;
import com.spring.rest.demo.model.UserEntity;
import com.spring.rest.demo.service.UserService;
import com.spring.rest.demo.wrapper.UserWrapper;

@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public List<UserWrapper> getAllUsers() {
		List<UserEntity> userEntityList = userDao.getAllUsers();
		List<UserWrapper> userWrapperList = new ArrayList<UserWrapper>();
		UserWrapper userWrapper = null;

		for (UserEntity userEntity : userEntityList) {
			userWrapper = new UserWrapper();
			userWrapper.wrap(userEntity);
			userWrapperList.add(userWrapper);
		}
		return userWrapperList;
	}

	@Transactional(readOnly = false)
	public void createUser(UserWrapper userWrapper) {
	    UserEntity userEntity = userDao.fetchUserByName(userWrapper.getFirstName(), userWrapper.getLastName());
		if(userEntity != null){
		    throw new UserException(ErrorMapping.USER_ALREADY_EXISTS);
		}
	    
	    userEntity = userWrapper.unwrap();
		userEntity.setId(generateUUID());
		userDao.createUser(userEntity);
	}

	@Transactional(readOnly = false)
	public void updateUser(UserWrapper userDetails) {
		UserEntity userEntity = userDao.fetchUserByUserId(userDetails.getId());
		if(userEntity == null){
			throw new UserException(ErrorMapping.USER_NOT_FOUND);
		}
		
		userEntity = userDetails.unwrapForUpdate(userEntity);
		userDao.updateUser(userEntity);
	}

	private String generateUUID(){
		return UUID.randomUUID().toString();
	}
}
