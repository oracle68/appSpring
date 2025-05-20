package com.myapp.service;

import java.util.List;

import com.myapp.entity.Product;

public interface ProductService {

	Product findById(long Id);

	List<Product> findAll();
	
	List<Product> findAllOrderById();
	
	void addProduct(Product product);

	void deleteProduct(long Id);
	
	void updateProduct(Product product);

}