package com.myapp.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myapp.entity.User;
import com.myapp.util.HibernateUtil;



public class TestUser {
	public static void main (String[] args) throws Exception
	{

	  new TestUser().tu();
	}
	public void tu() throws Exception
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		List<User> userList = criteria.list();			
		System.out.println(userList.size());
		tx.commit();
		//session.close();
	}

}