package com.spring.rest.demo.wrapper;

import org.apache.commons.lang.StringUtils;

import com.spring.rest.demo.model.UserEntity;

public class UserWrapper {

    private String id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Integer age;
    private String gender;
    private String phone;
    private String zip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public UserEntity unwrap() {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(this.age);
        userEntity.setFirstName(this.firstName);
        userEntity.setMiddleName(StringUtils.isEmpty(this.middleName) ? "" : this.middleName);
        userEntity.setGender(this.gender);
        userEntity.setId(this.id);
        userEntity.setLastName(this.lastName);
        userEntity.setPhone(this.phone);
        userEntity.setZip(this.zip);
        return userEntity;
    }

    public UserEntity unwrapForUpdate(UserEntity userEntity) {
        userEntity.setAge(this.age);
        userEntity.setFirstName(this.firstName);
        userEntity.setGender(this.gender);
        userEntity.setId(this.id);
        userEntity.setLastName(this.lastName);
        userEntity.setMiddleName(StringUtils.isEmpty(this.middleName) ? "" : this.middleName);
        userEntity.setPhone(this.phone);
        userEntity.setZip(this.zip);
        return userEntity;
    }

    public void wrap(UserEntity userEntity) {
        this.age = userEntity.getAge();
        this.firstName = userEntity.getFirstName();
        this.gender = userEntity.getGender();
        this.id = userEntity.getId();
        this.lastName = userEntity.getLastName();
        this.middleName = StringUtils.isEmpty(userEntity.getMiddleName()) ? "" : userEntity.getMiddleName(); 
        this.phone = userEntity.getPhone();
        this.zip = userEntity.getZip();
    }
}
