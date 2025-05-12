package com.myapp.dao;

import java.util.List;

import com.myapp.entity.Pelis;
import com.myapp.entity.User;

public interface PelisDao {

	Pelis findById(long Id);

	List<Pelis> getPelisList();
	
	List<Pelis> findAll();
	
	List<Pelis> findAllOrderById();	

	void addPelis(Pelis peli);

	void deletePelis(long Id);
	
	void updatePelis(Pelis peli);

	public Pelis getPelis(Integer id);
	
	public Integer getCount();
	
	public Integer getDistinct();

	public Integer getNamedQuery();	


}