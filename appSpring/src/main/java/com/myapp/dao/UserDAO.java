package com.myapp.dao;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.myapp.entity.User;


public interface UserDAO {
	public void insertData(User user);

	public List<User> getUserList();
	
	public List<User> findAll();

	public void updateData(User user);

	public void deleteData(Integer id);

	public User getUser(Integer id);

	public String getExistFirstname(String firstname);
    
	public Integer getCount(); 
	
	public Integer getDistinct();

	public Integer getNamedQuery();

	public List<User> findAllOrderById();	

}
