package com.myapp.dao;

import java.util.List;

import com.myapp.entity.Book;
import com.myapp.entity.Item;

public interface BookDao { 
	
	Book findById(long Id);

	List<Book> findAll();

	void addBook(Book book);

	void deleteBook(long Id);
	
	void updateBook(Book book);

}