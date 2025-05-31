package com.myapp.service;

import java.util.List;

import com.myapp.entity.User;


public interface UserService {
	public void insertData(User user);

	public List<User> getUserList();
	public List<User> findAllOrderById();
	
	public List<User> findAll();

	public void deleteData(Integer id);

	public User getUser(Integer id);

	public void updateData(User user);
    
	public String getExistFirstname(String firstname);
	
	public Integer getCount();
	
	public Integer getDistinct();

	public Integer getNamedQuery();	

        
}
