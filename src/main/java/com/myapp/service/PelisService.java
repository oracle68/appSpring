package com.myapp.service;

import java.util.List;

import com.myapp.entity.Pelis;


public interface PelisService {
	public void addPelis(Pelis peli);

	public List<Pelis> getPelisList();
	public List<Pelis> findAllOrderById();
	
	public List<Pelis> findAll();

	public void deletePelis(Integer id);

	public Pelis getPelis(Integer id);

	public void updatePelis(Pelis peli);
    
	//public String getExistFirstname(String firstname);
	
	public Integer getCount();
	
	public Integer getDistinct();

	public Integer getNamedQuery();	

        
}
