package com.spring.rest.demo.validator;

import org.apache.commons.lang.StringUtils;

import com.spring.rest.demo.enums.ErrorMapping;
import com.spring.rest.demo.exception.UserException;
import com.spring.rest.demo.wrapper.UserWrapper;

public class UserValidator {

    private static final String ALPHABET_PATTERN = "^[a-zA-Z\\s]+$";
    
    private static final String DIGIT_PATTERN = "\\d+";

    public static void validateUserDetails(UserWrapper userDetail) {

        if (StringUtils.isEmpty(userDetail.getFirstName())) {
            throw new UserException(ErrorMapping.INVALID_FIRST_NAME);
        }
        else if (!userDetail.getFirstName().matches(ALPHABET_PATTERN)) {
            throw new UserException(ErrorMapping.INVALID_FIRST_NAME_PATTERN);
        }
        else if (StringUtils.isEmpty(userDetail.getLastName())) {
            throw new UserException(ErrorMapping.INVALID_LAST_NAME);
        }
        else if (!userDetail.getLastName().matches(ALPHABET_PATTERN)) {
            throw new UserException(ErrorMapping.INVALID_LAST_NAME_PATTERN);
        }
        else if (userDetail.getAge() <= 0) {
            throw new UserException(ErrorMapping.INVALID_AGE);
        }
        else if(StringUtils.isEmpty(userDetail.getGender())){
            throw new UserException(ErrorMapping.GENDER_MANDATORY);
        }
        else if(!userDetail.getGender().equals("M") && !userDetail.getGender().equals("F")){
            throw new UserException(ErrorMapping.INVALID_GENDER);
        }
        else if (!StringUtils.isEmpty(userDetail.getMiddleName()) && !userDetail.getMiddleName().matches(ALPHABET_PATTERN)) {
            throw new UserException(ErrorMapping.INVALID_MIDDLE_NAME_PATTERN);
        }
        else if(StringUtils.isEmpty(userDetail.getPhone())){
            throw new UserException(ErrorMapping.EMPTY_PHONE_NUMBER);
        }
        else if(!userDetail.getPhone().matches(DIGIT_PATTERN)){
            throw new UserException(ErrorMapping.INVALID_PHONE_NUMBER);
        }
        else if(userDetail.getPhone().trim().length() != 10){
            throw new UserException(ErrorMapping.INVALID_PHONE_NUMBER_LENGTH);
        }
    }
    
}
