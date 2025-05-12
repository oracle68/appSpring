package com.myapp.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.entity.Pelis;



@Repository
public class PelisDaoImpl implements PelisDao{
	

	@Autowired
    private SessionFactory sessionFactory;

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Pelis findById(long Id) {
		Pelis peli = (Pelis) sessionFactory.getCurrentSession().get(Pelis.class, Id);
		return peli;
	}
	@Override
	public List<Pelis> getPelisList() {
		 return sessionFactory.getCurrentSession().createQuery("from com.myapp.entity.Pelis").list(); 
	}
	
	@Override
	public List<Pelis> findAll() {
		 return sessionFactory.getCurrentSession().createQuery("from com.myapp.entity.Pelis").list(); 
	}
	@Override
	public void addPelis(Pelis peli) {
		sessionFactory.getCurrentSession().save(peli);
		
	}

	@Override
	public void deletePelis(long Id) {
		Pelis peli = (Pelis) sessionFactory.getCurrentSession().load(Pelis.class, Id); 
        if (null != peli) {
            sessionFactory.getCurrentSession().delete(peli);
        }
		
	}

	@Override
	public void updatePelis(Pelis peli) {
		sessionFactory.getCurrentSession().update(peli);
		
	}
	
	@Override
	public List<Pelis> findAllOrderById(){
		return sessionFactory.getCurrentSession().createQuery("from com.myapp.entity.Pelis ORDER BY id").list(); 
	}

    @Override
public Pelis getPelis(Integer id) {
        Pelis peli =(Pelis) this.sessionFactory.getCurrentSession().get(Pelis.class, id);
        return peli;
    }	
    
    @Transactional
    public Integer getCount()
        {
    	System.out.println("Pelis getCount ini:");
        //Integer c = ((Integer) this.sessionFactory.getCurrentSession().createQuery("select count(*) from User").iterate().next()).intValue();
    	Integer c = (Integer) this.sessionFactory.getCurrentSession().createQuery("from com.myapp.entity.Pelis").list().size();
        System.out.println("Pelis getCount c: "+c);
    	return c ;    	
    }
    
    @Transactional
    public Integer getDistinct()
        {
    	System.out.println("Pelis getDistinct ini:");
       // Integer c = ((Integer) this.sessionFactory.getCurrentSession().createQuery("select count(*) from com.myapp.entity.Pelis").iterate().next()).intValue();
     	Integer c = (Integer) this.sessionFactory.getCurrentSession().
   		  createCriteria(Pelis.class).
   		  //setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).
   		  setProjection(Projections.distinct(Projections.property("nom"))).
   		  list().size();
   

        System.out.println("Pelis getDistinct c: "+c);
    	return c ;    	
    }    

    @Transactional
    public Integer getNamedQuery()
        {
    	System.out.println("Pelis getNamedQuery ini:");
        //Integer c = ((Integer) this.sessionFactory.getCurrentSession().createQuery("select count(*) from User").iterate().next()).intValue();
    	Integer c = (Integer) this.sessionFactory.getCurrentSession().
   		  getNamedQuery("PelisCount").
   		  //setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).
   		  //setProjection(Projections.distinct(Projections.property("firstname"))).
   		  list().size();
   
        System.out.println("Pelis getNamedQuery c: "+c);
    	return c ;    	
    } 	
}