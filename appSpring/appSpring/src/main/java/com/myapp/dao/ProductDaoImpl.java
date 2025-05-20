package com.myapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
    private SessionFactory sessionFactory;

@Override
				public Product findById(long Id) {
					Product product = (Product) sessionFactory.getCurrentSession().get(Product.class, Id);
					return product;
				}
	@Override
	public List<Product> findAll() {
		 return sessionFactory.getCurrentSession().createQuery("from Product").list(); 
	}
	
	@Override
	public List<Product> findAllOrderById() {
		 return sessionFactory.getCurrentSession().createQuery("from Product order by id").list(); 
	}


	
	@Override
	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
		
	}

	@Override
	public void deleteProduct(long Id) {
		Product product = (Product) sessionFactory.getCurrentSession().get(Product.class, Id); 
        if (null != product) {
            sessionFactory.getCurrentSession().delete(product);
        }
		
	}

	@Override
	public void updateProduct(Product product) {
		sessionFactory.getCurrentSession().update(product);
		
	}}