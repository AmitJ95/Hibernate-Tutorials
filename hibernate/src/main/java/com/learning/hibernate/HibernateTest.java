package com.learning.hibernate;

//import javax.security.auth.login.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.learning.hibernate.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("First User");
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = 
				new StandardServiceRegistryBuilder().
				applySettings(config.getProperties()).build();
		SessionFactory sessionFactory = config.
				buildSessionFactory(serviceRegistry);

				
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}

}
