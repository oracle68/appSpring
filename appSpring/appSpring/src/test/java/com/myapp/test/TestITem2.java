package com.myapp.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;

import com.myapp.entity.Item;
import com.myapp.service.ItemService;
import com.myapp.service.ItemServiceImpl;
import com.myapp.util.HibernateUtil;

//@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-servlet.xml" })
@ContextConfiguration(classes = { ItemService.class })
public class TestITem2 {

    @InjectMocks
    private ItemServiceImpl itemService;


	@Before
    public void setUp(){
    	  // Process mock annotations
        MockitoAnnotations.initMocks(this);

         //Setup Spring test in standalone mode
       // this.mockMvc = MockMvcBuilders.standaloneSetup(itemService).build();
    }
 
	@Test
 public void tamany() {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.beginTransaction();
	
	Item item=(Item)session.get(Item.class,1L);
	String result = item.getName(); 
	assertEquals(result, "n1");
 }
	
/*	@Test
 public void test2() {
	
 //  when(itemService.findById(1L).getName()).thenReturn("n1");		
	Item item=(Item) itemService.findById(1L);
	System.out.println("item.getName(): "+item.getName());
	String result = item.getName(); 
	assertEquals(result, "n1");

 }*/
	
	

}
