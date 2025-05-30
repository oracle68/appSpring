package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dao.ItemDao;
import com.myapp.entity.Item;

@Service
@Transactional
public class ItemServiceImpl implements ItemService { 

	@Autowired
	private ItemDao itemDao;

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public Item findById(long Id) { 

		return itemDao.findById(Id);
	}

	@Override
	
	public List<Item> findAll() {
		return itemDao.findAll();
	}

	@Override

	public void addItem(Item item) {
		itemDao.addItem(item);

	}

	@Override
	public void deleteItem(long Id) {
		itemDao.deleteItem(Id);

	}

	@Override
	public void updateItem(Item item) {
		itemDao.updateItem(item);
		
	}

}
