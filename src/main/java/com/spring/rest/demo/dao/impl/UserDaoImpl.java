package com.spring.rest.demo.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rest.demo.dao.UserDao;
import com.spring.rest.demo.model.UserEntity;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@SuppressWarnings("restriction")
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<UserEntity> getAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserEntity.class);
		return criteria.list();
	}

	public void createUser(UserEntity userDetails) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(userDetails);
		session.flush();
	}

	public void updateUser(UserEntity userDetails) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(userDetails);
	}

	public UserEntity fetchUserByUserId(String userId) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserEntity.class);
		criteria.add(Restrictions.eq("id", userId));
		return (UserEntity) criteria.uniqueResult();
	}

    public UserEntity fetchUserByName(String firstName, String lastName) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(UserEntity.class);
        criteria.add(Restrictions.eq("firstName", firstName));
        criteria.add(Restrictions.eq("lastName", lastName));
        return (UserEntity) criteria.uniqueResult();
    }
}
