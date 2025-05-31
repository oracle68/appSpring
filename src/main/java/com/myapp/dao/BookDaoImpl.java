package com.myapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.entity.Book;

@Repository
public class BookDaoImpl implements BookDao{
   
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public Book findById(long Id) {
		Book book = (Book) sessionFactory.getCurrentSession().get(Book.class, Id);
		return book;
	}
	@Override
	public List<Book> findAll() {
		 return sessionFactory.getCurrentSession().createQuery("from Book").list(); 
	}
	@Override
	public void addBook(Book book) {
		sessionFactory.getCurrentSession().save(book);
		
	}

	@Override
	public void deleteBook(long Id) {
		Book book = (Book) sessionFactory.getCurrentSession().load(Book.class, Id); 
        if (null != book) {
            sessionFactory.getCurrentSession().delete(book);
        }
		
	}

	@Override
	public void updateBook(Book book) {
		sessionFactory.getCurrentSession().update(book);
		
	}
	
}