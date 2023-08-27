package com.nagarro.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.LoginDetails;

@Repository
public class RegisterDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void saveUser(String username,String password) {
		LoginDetails user = new LoginDetails(username,password);
		hibernateTemplate.saveOrUpdate(user);
	}
	@Transactional
	public boolean authenticate(String username,String password) {
		Session session= sessionFactory.openSession();
		LoginDetails user = (LoginDetails)session.get(LoginDetails.class,username);
		if(user != null && user.getPassword().equals(password)) {
			return true;
		}
		
		return false;
	}
	 
}
