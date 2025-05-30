package com.myapp.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.entity.Book;
import com.myapp.service.BookService;
import com.myapp.util.HibernateUtil;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/bookListJson", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List<Book> getAllBook() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Book.class);
		//criteria.add(Restrictions.not(Restrictions.like("autor","a%",MatchMode.ANYWHERE)));
		criteria.add(Restrictions.like("autor","%",MatchMode.ANYWHERE));
		//criteria.add(Restrictions.ge("price", 60.0));
		List<Book> bookList = criteria.list();

		tx.commit();
		
		return bookList;
	}

	@RequestMapping(value = "/bookListAngular", method = RequestMethod.GET)
	public String bookListAJS() {
		return "bookListAngular";
	}

	
	
}