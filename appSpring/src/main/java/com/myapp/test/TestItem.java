package com.myapp.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.myapp.entity.Item;
import com.myapp.util.HibernateUtil;



public class TestItem {
	public static void main (String[] args) throws Exception
	{

	  new TestItem().tu();
	}
	public void tu() throws Exception
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Item.class);
		criteria.add(Restrictions.like("name","%",MatchMode.ANYWHERE));
		criteria.add(Restrictions.ge("price", 10.0));
		List<Item> itemList = criteria.list();
		for (Item var: itemList)
		{
			System.out.println(var.toString());	
		}
		tx.commit();

	}
	
/*	public void ti2()
	{
	 final String PERSISTENCE_UNIT_NAME = "Item";
	 final  EntityManagerFactory em = 
		    Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);		
		//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    //final Transaction tx = session.beginTransaction();		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Item> cr = cb.createQuery(Item.class);
		Root<Item> root = cr.from(Item.class);
		cr.select(root);
		 
		Query<Item> query = em.createQuery(cr);
		List<Item> results = query.getResultList();		
		
	}
	public void ti3()
	{
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		CriteriaBuilder cb = HibernateUtil.getSessionFactory().getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<Item> cr = cb.createQuery(Item.class);
		Root<Item> root = cr.from(Item.class);
		cr.select(root);
		 
		Query<Item> query = session.createQuery(cr);
		List<Item> results = query.getResultList();		
	}
*/
}