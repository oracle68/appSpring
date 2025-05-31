package com.myapp.dao;

import java.util.List;

import com.myapp.entity.Item;

public interface ItemDao {

	Item findById(long Id);

	List<Item> findAll();

	void addItem(Item item);

	void deleteItem(long Id);
	
	void updateItem(Item item);

}