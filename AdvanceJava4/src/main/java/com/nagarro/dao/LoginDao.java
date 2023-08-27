package com.nagarro.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.model.User;

@Repository
@Transactional
public class LoginDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void Register(String uname,String pass) {
		Session session=sessionFactory.getCurrentSession();
		User user=new User(uname,pass);
		session.saveOrUpdate(user);
	}
	
	
	
	public String Login(String username,String password) {
		Session session=sessionFactory.getCurrentSession();
		Query q;
		q = session.createQuery("from User as t where t.username=:username AND t.password=:password").setParameter("username",username).setParameter("password",password);
        if(q.list().isEmpty()) {
        	return "False";
        }
        else {
        	return "True";
        }
		        
	}
}
