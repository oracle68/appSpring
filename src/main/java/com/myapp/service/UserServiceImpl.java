package com.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dao.UserDAO;
import com.myapp.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
        @Transactional
	public void insertData(User user) {
		userDAO.insertData(user);
	}

	@Override
        @Transactional
	public List<User> getUserList() {
		return userDAO.getUserList();
	}

	@Override
    @Transactional
    public List<User> findAll() {
	return userDAO.findAll();
}

	@Override
    @Transactional
    public List<User> findAllOrderById() {
	return userDAO.findAllOrderById();
}
	
	@Override
        @Transactional
	public void deleteData(Integer id) {
		userDAO.deleteData(id);
		
	}

	@Override
        @Transactional
	public User getUser(Integer id) {
		return userDAO.getUser(id);
	}

	@Override
        @Transactional
	public void updateData(User user) {
		userDAO.updateData(user);
		
	}
	public void setUserDAO(UserDAO userdao) {
		this.userDAO = userdao;
	}

	@Override
    @Transactional
	public String getExistFirstname(String firstname) {
		return userDAO.getExistFirstname(firstname);
	}
	
	public Integer getCount() {
		return userDAO.getCount();
		
	}
	
	public Integer getDistinct() {
		return userDAO.getDistinct();
		
	}
	
	public Integer getNamedQuery() {
		return userDAO.getNamedQuery();
		
	}
	
	
		
	
}
