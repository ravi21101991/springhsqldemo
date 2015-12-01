package com.spring.rest.demo.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rest.demo.dao.UserDao;
import com.spring.rest.demo.model.UserEntity;

@Repository("userDao")
@Transactional(readOnly = true)
public class UserDaoImpl implements UserDao {

    @SuppressWarnings("restriction")
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<UserEntity> getAllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from UserEntity");
        return query.list();
    }

    public void createUser(UserEntity userDetails) {
        
    }

    public void updateUser(UserEntity userDetails) {
        
    }
}
