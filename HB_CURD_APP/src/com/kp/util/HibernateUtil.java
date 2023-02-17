package com.kp.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	public static Configuration config=null;
	public static SessionFactory sessionFactory=null;
	public static Session session=null;
	public static Transaction transaction=null;
	
	static {
		
		try {
		config=new Configuration();
		
		config.configure();
		sessionFactory=config.buildSessionFactory();
		}
		catch(HibernateException hbe) {
			hbe.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static Session getSession() {
		
		if(session == null)
			session=sessionFactory.openSession();
		
		return session;
	}
	
	public static void closeSession(Session s) {
		
		if(s!=null)
			s.close();
		
	}
	
	public static void closeSessionFactory(SessionFactory sf) {
		
		if(sf!=null)
			sf.close();
	}

}
