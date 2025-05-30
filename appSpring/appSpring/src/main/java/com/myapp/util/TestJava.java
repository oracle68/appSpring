package com.myapp.util;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.myapp.entity.City;

public class TestJava {
	 public static void main(String[] args) {
		 
	
	try {		
		
	    try {
	        // Create the SessionFactory from hibernate.cfg.xml
	        //sessionFactory = new Configuration().configure(new File("hibernate.cfg.xml")).buildSessionFactory();
	        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg2.xml").buildSessionFactory();
	    
	    } catch (Throwable ex) {
	        // Make sure you log the exception, as it might be swallowed
	        System.err.println("Initial SessionFactory creation failed." + ex);
	        throw new ExceptionInInitializerError(ex);
	    }
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(City.class);
		criteria.add(Restrictions.like("nom","%",MatchMode.ANYWHERE));
		List<City> lista = criteria.list();
		for (City var: lista)
		{
			System.out.println(var.toString());	
		}
		tx.commit();

	} catch (Exception e) {
		System.out.println(e);
	    //throw new Exception(e);
	 
	} 	
}	
}
