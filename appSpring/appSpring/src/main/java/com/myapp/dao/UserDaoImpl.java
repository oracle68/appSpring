package com.myapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.entity.User;
import com.myapp.service.CityService;

@Repository
public class UserDaoImpl implements UserDAO {

    	
	@Autowired
    private SessionFactory sessionFactory;
	@Autowired
	private CityService cityService;
	
	public void insertData(User user) {
		String nom = user.getCity().getNom();
		user.getCity().setId(cityService.getIdByNom(nom));
		System.out.println(" city.id:"+user.getCity().getId()+ " nom: "+user.getCity().getNom());
		this.sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList(){
		return this.sessionFactory.getCurrentSession().createQuery("from Usuarios").list();
	}

	//@SuppressWarnings("unchecked")
	@Override
	//@Transactional
	public List<User> findAll(){
		//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//Session session =this.sessionFactory.getCurrentSession();
	    //final Transaction tx = this.sessionFactory.getCurrentSession().beginTransaction();
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(User.class);
		List<User> userList = criteria.list();			
		//System.out.println(userList.size());
		//tx.commit();
		return userList;
	}

	@Override
	//@Transactional
	public List<User> findAllOrderById(){
		//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//Session session =this.sessionFactory.getCurrentSession();
	    //final Transaction tx = this.sessionFactory.getCurrentSession().beginTransaction();
		//Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(User.class);
		//List<User> userList = criteria.orderbyId().list().;			
		//System.out.println(userList.size());
		//tx.commit();
		//return userList;
		return sessionFactory.getCurrentSession().createQuery("from com.myapp.entity.User ORDER BY id").list(); 
	}
	
	@Override
	public void deleteData(Integer id) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
                //User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
        if (null != user) {
        	this.sessionFactory.getCurrentSession().delete(user);
        }
	}
	
	@Override
	public void updateData(User user) {

            this.sessionFactory.getCurrentSession().update(user); 

	}

        @Override
	public User getUser(Integer id) {
            User user =(User) this.sessionFactory.getCurrentSession().get(User.class, id);
            return user;
        }
        
    @Override
    public String getExistFirstname(String firstname){
        //String fn = firstname;
        String existe;
        User user = new User(); //) this.sessionFactory.getCurrentSession().get(User.class, firstname);
        user = (User) this.sessionFactory.getCurrentSession()
        		 .createQuery("from Usuarios where firstname=:firstname")
        		 .setParameter("firstname", firstname).uniqueResult();
        
        if (user!=null){
            System.out.println("USUARIO :"+user.getFirstName());
            existe ="Existe el user";
        }
        else
        {existe ="NO Existe el user";}    
        System.out.println("EXISTE USUARIOS :"+existe);
         return existe;
    }  
    
    @Transactional
    public Integer getCount()
        {
    	System.out.println("User getCount ini:");
        //Integer c = ((Integer) this.sessionFactory.getCurrentSession().createQuery("select count(*) from User").iterate().next()).intValue();
    	Integer c = (Integer) this.sessionFactory.getCurrentSession().createQuery("from Usuarios").list().size();
        System.out.println("User getCount c: "+c);
    	return c ;    	
    }
    
    @Transactional
    public Integer getDistinct()
        {
    	System.out.println("User getDistinct ini:");
        //Integer c = ((Integer) this.sessionFactory.getCurrentSession().createQuery("select count(*) from User").iterate().next()).intValue();
    	Integer c = (Integer) this.sessionFactory.getCurrentSession().
   		  createCriteria(User.class).
   		  //setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).
   		  setProjection(Projections.distinct(Projections.property("firstname"))).
   		  list().size();
   
        System.out.println("User getDistinct c: "+c);
    	return c ;    	
    }    

    @Transactional
    public Integer getNamedQuery()
        {
    	System.out.println("User getNamedQuery ini:");
        //Integer c = ((Integer) this.sessionFactory.getCurrentSession().createQuery("select count(*) from User").iterate().next()).intValue();
    	Integer c = (Integer) this.sessionFactory.getCurrentSession().
   		  getNamedQuery("UserCount").
   		  //setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).
   		  //setProjection(Projections.distinct(Projections.property("firstname"))).
   		  list().size();
   
        System.out.println("User getNamedQuery c: "+c);
    	return c ;    	
    } 
}
