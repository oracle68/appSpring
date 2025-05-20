package com.myapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.myapp.dao.ProductDao;
import com.myapp.entity.Product;
import com.myapp.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService { 

	@Autowired
	private ProductDao productDao;

	@Override
	public Product findById(long Id) { 

		return productDao.findById(Id);
	}

	@Override
	
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	
	public List<Product> findAllOrderById() {
		return productDao.findAllOrderById();
	}	
	@Override

	public void addProduct(Product product) {
		productDao.addProduct(product);

	}

	@Override
	public void deleteProduct(long Id) {
		productDao.deleteProduct(Id);

	}

	@Override
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
		
	}

}
