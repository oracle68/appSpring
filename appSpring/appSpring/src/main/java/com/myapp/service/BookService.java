package com.myapp.service;

import java.util.List;

import com.myapp.entity.Book;

public interface BookService {

	Book findById(long Id);

	List<Book> findAll();

	void addBook(Book book);

	void deleteBook(long Id);
	
	void updateBook(Book book);

}