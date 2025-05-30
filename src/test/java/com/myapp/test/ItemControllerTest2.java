package com.myapp.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "claspath*:spring-servlet.xml" })
@WebAppConfiguration
public class ItemControllerTest2 {

	@Autowired    
	private WebApplicationContext wac;    
	private MockMvc mockMvc;    
	@Before  
	public void setup() {        
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		}

	@Test
	public void testGetItemById() throws Exception {
	    //mockMvc.perform(get("/getItemNom/{id}", 1)).andDo(print()).andExpect(status().isOk())
		/*mockMvc.perform(get("/getItemNom//{Id}").param("Id", "1")).andDo(print()).andExpect(status().isOk())
	            .andExpect(content().contentType("application/json"))
	            .andExpect(jsonPath("$.id").value("1"));
	            */
	
		this.mockMvc.perform(get("/getitemnom/1").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().is(404));
	
	}
}
