package com.myapp.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.entity.City;
import com.myapp.util.HibernateUtil;

public class SqlController {

   // @Autowired
   // EntityManager entityManager;

	@Autowired
	private SessionFactory sessionFactory;
	
	@RequestMapping(value = "/execSql3", method = RequestMethod.GET)
//	public  @ResponseBody void ExecSqlCommand3(HttpServletRequest request, 
	public  String ExecSqlCommand3(HttpServletRequest request,
	        HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
try {		
	
    try {
        // Create the SessionFactory from hibernate.cfg.xml
        //sessionFactory = new Configuration().configure(new File("hibernate.cfg.xml")).buildSessionFactory();
        sessionFactory = new Configuration().configure("hibernate.cfg2.xml").buildSessionFactory();
    
    } catch (Throwable ex) {
        // Make sure you log the exception, as it might be swallowed
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
    }
	
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    final Transaction tx = session.beginTransaction();
	Criteria criteria = session.createCriteria(City.class);
	criteria.add(Restrictions.like("nom","%",MatchMode.ANYWHERE));
	List<City> lista = criteria.list();
	for (City var: lista)
	{
		out.println(var.toString());	
	}
	tx.commit();

} catch (Exception e) {
	System.out.println(e);
    //throw new Exception(e);
 
} 	
     return "OK";
}		
	
/*	@RequestMapping(value = "/execSql2", method = RequestMethod.GET)
	public  @ResponseBody void ExecSqlCommand2(HttpServletRequest request, 
	        HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		
		try {

			String sql ="SELECT * FROM City";	
					
			 response.setContentType("text/html");
			 out.println("query: "+sql+"<br>");	
			@SuppressWarnings("unchecked")
			List<Object[]> query = (List<Object[]>) entityManager
				    .createNativeQuery(sql)
				   // .getSingleResult();
				    .getResultList();
			for (Object[] result: query)
			{	
			 out.println(result[0]+"<br>");
			}
			
      
		} catch (Exception e) {
			System.out.println(e);
		    //throw new Exception(e);

		    
		}	    

		
	}	
	
	
	@RequestMapping(value = "/execSql", method = RequestMethod.GET)
	public  @ResponseBody void ExecSqlCommand(@RequestParam String sql,HttpServletRequest request, 
	        HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		
		try {

	
			 response.setContentType("text/html");
			 out.println("query: "+sql+"<br>");	
			@SuppressWarnings("unchecked")
			List<Object[]> query = (List<Object[]>) entityManager
				    .createNativeQuery(sql)
				   // .getSingleResult();
				    .getResultList();
			for (Object[] result: query)
			{	
			 out.println(result[0]+"<br>");
			}
			
     
		} catch (Exception e) {
			System.out.println(e);
		    //throw new Exception(e);
			
		    
		}	    

		
	}	
	
*/

}
