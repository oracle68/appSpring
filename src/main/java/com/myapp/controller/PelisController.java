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

import com.myapp.entity.Pelis;
import com.myapp.service.PelisService;
import com.myapp.util.HibernateUtil;

@Controller
//@CrossOrigin(origins = "http://localhost:8180")
public class PelisController {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PelisService pelisService;
	
	@RequestMapping(value = "/pelisList2", method = RequestMethod.GET)
	public ModelAndView getPelisList2() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    final Transaction tx = session.beginTransaction();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Pelis.class);
		List<Pelis> pelisList = criteria.list();
		tx.commit();
		return new ModelAndView("pelisList", "pelisList", pelisList);
	}	
	
	@RequestMapping(value = "/pelisListJson", method = RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody List getAllPelisJson() {

		List<Pelis> pelisList = pelisService.findAll();
		return pelisList;
	}	
	
	@RequestMapping(value = "/pelisListAngular", method = RequestMethod.GET)
	public String getAllPelisListJson() {
		return "pelisListAngular";
	}	
	
	@RequestMapping(value = "/pelisListAngularJs2", method = RequestMethod.GET)
	public String getAllPelisListJson2() {
		return "pelisListAngularJs2";
	}		
	
	@RequestMapping(value = "/pelisListGrid", method = RequestMethod.GET)
	public String getAllUsersListGrid() {
		return "pelisListGrid";
	}	

	@RequestMapping(value = "/pelisTreeList", method = RequestMethod.GET)
	public ModelAndView getAllPelisTreeList() {
		List<Pelis> pelislist = pelisService.getPelisList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pelislist", pelislist);
		Integer c = pelisService.getCount();
		map.put("count",c );
		Integer d = pelisService.getDistinct();
		map.put("distinct",d );
		//Integer e = pelisService.getNamedQuery();
		//map.put("namedquery",e );		
		return new ModelAndView("pelisTreeList", "map", map);		

	}		
	
	@RequestMapping(value = "/pelisTreeList2", method = RequestMethod.GET)
	public ModelAndView getAllPelisTreeList2() {
		List<Pelis> pelisList = pelisService.findAllOrderById();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pelislist", pelisList);
		Integer c = pelisService.getCount();
		map.put("count",c );
		Integer d = pelisService.getDistinct();
		map.put("distinct",d );
		Integer e = pelisService.getNamedQuery();
		map.put("namedquery",e );		
		return new ModelAndView("pelisTreeList2", "map", map);		

	}	
	
}
