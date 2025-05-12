package com.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dao.PelisDao;
import com.myapp.entity.Pelis;

@Service
public class PelisServiceImpl implements PelisService {

	@Autowired
	PelisDao pelisDAO;

	@Override
        @Transactional
	public void addPelis(Pelis peli) {
		pelisDAO.addPelis(peli);
	}

	@Override
        @Transactional
	public List<Pelis> getPelisList() {
		return pelisDAO.getPelisList();
	}

	@Override
    @Transactional
    public List<Pelis> findAll() {
	return pelisDAO.findAll();
}

	@Override
    @Transactional
    public List<Pelis> findAllOrderById() {
	return pelisDAO.findAllOrderById();
}
	
	@Override
        @Transactional
	public void deletePelis(Integer id) {
		pelisDAO.deletePelis(id);
		
	}

	@Override
        @Transactional
	public Pelis getPelis(Integer id) {
		return pelisDAO.getPelis(id);
	}

	@Override
        @Transactional
	public void updatePelis(Pelis peli) {
		pelisDAO.updatePelis(peli);
		
	}
	public void setPelisDAO(PelisDao pelisDAO) {
		this.pelisDAO = pelisDAO;
	}


	
	public Integer getCount() {
		return pelisDAO.getCount();
	
	}
	
	public Integer getDistinct() {
		return pelisDAO.getDistinct();
		
	}
	
	public Integer getNamedQuery() {
		return pelisDAO.getNamedQuery();
		
	}
	
	
		
	
}
