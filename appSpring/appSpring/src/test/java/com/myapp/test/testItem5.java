package com.myapp.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.myapp.entity.Item;
import com.myapp.service.ItemService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-servlet.xml" })
@WebAppConfiguration
public class testItem5 {

	@Autowired
    private ItemService itemService; 

	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	
	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	//}

	@Test
    public void testItem5() {
		  List <Item> list = itemService.findAll();
	        for(Item item : list) {
	            System.out.println(item.toString());
	        }  
		  
	}
}
