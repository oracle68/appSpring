package com.myapp.service;

import com.myapp.dao.CityDAO;
import com.myapp.entity.City;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service 
public class CityServiceImpl implements CityService{ 

	@Autowired
	CityDAO cityDAO;

	@Override
        @Transactional
	public void insertData(City city) {

		cityDAO.insertData(city);
	}

	@Override
        @Transactional
	public List<City> getCityList() {
		return cityDAO.getCityList();
	}

	@Override
        @Transactional
	public void deleteData(Integer id) {
		cityDAO.deleteData(id);
		
	}

	@Override
        @Transactional
	public City getCity (Integer id) {
		return cityDAO.getCity(id);
	}

	@Override
        @Transactional
	public void updateData(City city) {
		cityDAO.updateData(city);
		
	}
	public void setCityDAO(CityDAO citydao) {
		this.cityDAO = citydao;
	}

	@Override
        @Transactional
	public String getExistCity(String nom) {
		return cityDAO.getExistCity(nom);
	}

	@Override
    @Transactional
	public List<String> getListNomCity() {
		return cityDAO.getListNomCity();
	}        

	@Override
    @Transactional
    public Integer getIdByNom(String nom) {
    	return cityDAO.getIdByNom(nom);    	
    };      
	
}    
    

