package com.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.entity.Product;
import com.myapp.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;      
	@RequestMapping(value = "/productListJson", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List getAllProduct() {
		System.out.println("#########getAll()#########");
		List<Product> productList = productService.findAll();
		return productList;
	}
	
}