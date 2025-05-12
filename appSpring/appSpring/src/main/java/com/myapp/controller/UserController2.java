package com.myapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.entity.User;
import com.myapp.service.UserService;
import com.myapp.util.HibernateUtil;

@Controller
//@CrossOrigin(origins = "http://localhost:8180")
public class UserController2 {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/userList2", method = RequestMethod.GET)
	public ModelAndView getUserList2() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		List<User> userList = criteria.list();
		tx.commit();
		return new ModelAndView("userList", "userList", userList);
	}	
	
	@RequestMapping(value = "/userListJson", method = RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody List getAllUsersJson() {

		List<User> userList = userService.findAll();
		return userList;
	}	
	
	@RequestMapping(value = "/userListAngular", method = RequestMethod.GET)
	public String getAllUsersListJson() {
		return "userListAngular";
	}	
	
	@RequestMapping(value = "/userListAngularJs2", method = RequestMethod.GET)
	public String getAllUsersListJson2() {
		return "userListAngularJs2";
	}		
	
	@RequestMapping(value = "/userListGrid", method = RequestMethod.GET)
	public String getAllUsersListGrid() {
		return "userListGrid";
	}	

	@RequestMapping(value = "/userTreeList", method = RequestMethod.GET)
	public ModelAndView getAllUsersTreeList() {
		List<User> userList = userService.getUserList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userlist", userList);
		Integer c = userService.getCount();
		map.put("count",c );
		Integer d = userService.getDistinct();
		map.put("distinct",d );
		Integer e = userService.getNamedQuery();
		map.put("namedquery",e );		
		return new ModelAndView("userTreeList", "map", map);		

	}		
	
	@RequestMapping(value = "/userTreeList2", method = RequestMethod.GET)
	public ModelAndView getAllUsersTreeList2() {
		List<User> userList = userService.findAllOrderById();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userlist", userList);
		Integer c = userService.getCount();
		map.put("count",c );
		Integer d = userService.getDistinct();
		map.put("distinct",d );
		Integer e = userService.getNamedQuery();
		map.put("namedquery",e );		
		return new ModelAndView("userTreeList2", "map", map);		

	}	
	
}
