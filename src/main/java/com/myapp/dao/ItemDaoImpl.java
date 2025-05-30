package com.myapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.entity.Item;

@Repository
public class ItemDaoImpl implements ItemDao{

	@Autowired
    private SessionFactory sessionFactory;

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Item findById(long Id) {
		Item item = (Item) sessionFactory.getCurrentSession().get(Item.class, Id);
		return item;
	}
	@Override
	public List<Item> findAll() {
		 return sessionFactory.getCurrentSession().createQuery("from Item").list(); 
	}
	@Override
	public void addItem(Item item) {
		sessionFactory.getCurrentSession().save(item);
		
	}

	@Override
	public void deleteItem(long Id) {
		Item item = (Item) sessionFactory.getCurrentSession().load(Item.class, Id); 
        if (null != item) {
            sessionFactory.getCurrentSession().delete(item);
        }
		
	}

	@Override
	public void updateItem(Item item) {
		sessionFactory.getCurrentSession().update(item);
		
	}}