package com.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.myapp.entity.Item;
import com.myapp.service.ItemService;

@EnableWebMvc
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;   
	
	@RequestMapping(value = "/itemListJson", method = RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody List getAllItem() {
		System.out.println("#########getAll()#########");
		List<Item> itemList = itemService.findAll();
		return itemList;
	}
	@RequestMapping(value = "/itemListAngular", method = RequestMethod.GET)
	public String  getAllItemListAngular() {
		return "itemListAngular";
	}	

	@RequestMapping(value = "/itemListAngular2", method = RequestMethod.GET)
	public String  getAllItemListAngular2() {
		return "itemListAngular2";
	}	

	
	@RequestMapping(value = "/getitem/{id}", method = RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody Item getItemId (@PathVariable("id") Integer Id) {
	 
		return itemService.findById(Id);
	 }
	
	@RequestMapping(value = "/getitemnom/{id}", method = RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody String getItemNom (@PathVariable("id") Integer Id) {
	 
		return itemService.findById(Id).getName();
			 
	 }	
	 	
}