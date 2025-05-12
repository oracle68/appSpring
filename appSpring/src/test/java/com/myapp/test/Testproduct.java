package com.myapp.test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.myapp.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-servlet.xml" })
@WebAppConfiguration
public class Testproduct {

	@Autowired
    private ProductService productService; 

	private MockMvc mockMvc; 
	
	@Before
    public void setUp(){
    	  // Process mock annotations
        MockitoAnnotations.initMocks(this);

         //Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(productService).build();
    }

	@Test
    public void testproduct() {
         Long Id =1L;		  String nom = productService.findById(Id).getNom();
		  assertEquals(nom,"BAR");
	}
}