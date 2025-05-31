package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dao.BookDao;
import com.myapp.entity.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService { 

	@Autowired
	private BookDao bookDao;

	@Override
	public Book findById(long Id) { 

		return bookDao.findById(Id);
	}

	@Override
	
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override

	public void addBook(Book book) {
		bookDao.addBook(book);

	}

	@Override
	public void deleteBook(long Id) {
		bookDao.deleteBook(Id);

	}

	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);
		
	}

}
