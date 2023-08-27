package com.nagarro.servletjsp.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.nagarro.servletjsp.pojo.Login;

public class UserDbUtil {
	private static final SessionFactory sessionFactory;
	static {
		Configuration con=new Configuration().configure().addAnnotatedClass(Login.class);
		org.hibernate.service.ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		sessionFactory =con.buildSessionFactory(reg);	
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}


