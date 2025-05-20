package com.myapp.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	@RequestMapping(value = "/productList", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody List getAllProduct() {
		System.out.println("#########getAll()#########");
		java.util.List<Product> productList = productService.findAll();
		return productList;
	}
	
	@RequestMapping(value = "/ProductListAngular", method = RequestMethod.GET)
	public String getProductListAngular() {
		return "ProductListAngular";
	}
	
	
	
}