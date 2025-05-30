package com.myapp.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.myapp.entity.City;
import com.myapp.util.HibernateUtil;

public class TestCity {

	public static void main (String[] args) throws Exception
	{

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
	}	
}
