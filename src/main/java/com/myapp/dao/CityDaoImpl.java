
package com.myapp.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.entity.City;
import com.myapp.entity.User;

@Repository
public class CityDaoImpl implements CityDAO {
       
       
	@Autowired
    private SessionFactory sessionFactory;
	
	
	public void insertData(City city) {
		this.sessionFactory.getCurrentSession().save(city);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<City> getCityList(){
		return this.sessionFactory.getCurrentSession().createQuery("from City").list();
	}

	@Override
	public void deleteData(Integer id) {
		City city = (City) sessionFactory.getCurrentSession().get(City.class, id);

        if (null != city) {
        	this.sessionFactory.getCurrentSession().delete(city);
        }
	}
	
	@Override
	public void updateData(City city) {

            this.sessionFactory.getCurrentSession().update(city); 

	}

        @Override
	public City getCity(Integer id) {
            City city =(City) this.sessionFactory.getCurrentSession().get(City.class, id);
            return city;
        }
        
        @Override
        public String getExistCity(String nom){
            //String fn = firstname;
            String existe;
            City city = new City(); 
            city = (City) this.sessionFactory.getCurrentSession().createQuery("from City where nom=:nom").setParameter("nom", nom).uniqueResult();
            
            if (city!=null){
                System.out.println("City :"+city.getNom());
                existe ="Existe city";
            }
            else
            {existe ="NO Existe city";}    
            System.out.println("EXISTE city :"+existe);
             return existe;
        } 
        
        @Override
        public List<String> getListNomCity()
        {
		List<String> cityList = new ArrayList<String>();
                List<City> cList = new ArrayList<City>();
                cList=getCityList();
                 for (City cl: cList) {
                    cityList.add(cl.getNom());
                }         
               return cityList;     
        }  
        
        public Integer getIdByNom(String nom) {
        	
            Integer id;
            City city = new City(); 
            city = (City) this.sessionFactory.getCurrentSession().createQuery("from City where nom=:nom").setParameter("nom", nom).uniqueResult();
            
            if (city!=null){
            	id = city.getId();
                System.out.println("City :"+city.getNom());
                	
            }
            else
            { id=-1;}    
            

            return id;	
        }          
    
}
