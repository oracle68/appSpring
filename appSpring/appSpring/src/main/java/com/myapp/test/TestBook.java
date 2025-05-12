package com.myapp.test;

import java.util.List;

import javax.servlet.ServletRegistration;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.myapp.entity.Book;
import com.myapp.util.HibernateUtil;

public class TestBook {

	public static void main (String[] args) throws Exception
	{

	  new TestBook().tu();
		
	/*	//ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-servlet.xml");
		XmlWebApplicationContext normalWebAppContext = new XmlWebApplicationContext();
		normalWebAppContext.setConfigLocation("classpath:spring-servlet.xml");
		ServletRegistration.Dynamic normal  = servletContext.addServlet("spring", 
		    new DispatcherServlet(normalWebAppContext));
		normal.setLoadOnStartup(1);
		normal.addMapping("/*");		
		System.out.println("context adquired");
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		System.out.println("session adquired");
		int size  = sessionFactory.openSession().createSQLQuery("select * from Book").list().size(); 
		System.out.println("size: "+size);
*/		
		
	}
	public void tu() throws Exception
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Book.class);
		//criteria.add(Restrictions.like("name","Item%",MatchMode.ANYWHERE));
		//criteria.add(Restrictions.ge("price", 60.0));
		@SuppressWarnings("unchecked")
		List<Book> bookList = criteria.list();
		for (Book var: bookList)
		{
			System.out.println(var.toString());	
		}
		tx.commit();

	}
}
