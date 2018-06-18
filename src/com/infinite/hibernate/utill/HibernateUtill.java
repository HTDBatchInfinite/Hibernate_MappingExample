package com.infinite.hibernate.utill;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtill {
	private static  SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		//test();
	}
	
	
	static{
		System.out.println("in hibernatutill");
		Configuration cfg=new Configuration();
                      cfg.configure("hibernate.cfg.xml");
                      System.out.println("Configuration::::::::"+cfg);
                      System.out.println(cfg.buildSessionFactory());
		sessionFactory=cfg.buildSessionFactory();
		
		/*Session session=sessionFactory.openSession();
		System.out.println("session::::::  "+session);*/
		
	}
	public static  Session getsession()
	{
		return sessionFactory.openSession();
		
	}
	}
	

