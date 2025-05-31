package com.myapp.dao;

import java.util.List;

import com.myapp.entity.City;

	public interface CityDAO {

	public void insertData(City city);

	public List<City> getCityList();

	public void updateData(City city);

	public void deleteData(Integer id);

	public City getCity(Integer id);
        
    public String getExistCity(String nom);   
    public List<String> getListNomCity();
    public Integer getIdByNom(String nom);        
}
