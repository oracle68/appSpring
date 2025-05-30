package com.myapp.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.myapp.controller.ItemController;
import com.myapp.service.ItemService;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = { "claspath:spring-servlet.xml" })
@WebAppConfiguration
public class TestItemController {

	
    @Mock
    private ItemService itemService;


    @InjectMocks
    private ItemController itemController;

    private MockMvc mockMvc;    

    @Before
    public void setUp(){
    	  // Process mock annotations
        MockitoAnnotations.initMocks(this);

        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
    }

	/*@Test
    public void test00() {
		  String nom =itemService.findById(1L).getName();
		  assertEquals(nom,"n1");
	}*/
	
    @Test
    public void test0() throws Exception {

         mockMvc.perform(get("/getItemNom/{id}/",1))
    	// mockMvc.perform(get("/getItemNom/1"))
	    .andDo(print())
	    .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.id").value("1"));
	    
	    //.andExpect(status().isOk())
	    //.andExpect(content().string("n1"));
    }
 
/*    @Test
    public void test1() throws Exception {
        when(itemService.findById(1).getName()).thenReturn("n1");
        
    }

    
    @Test
    public void test2() throws Exception {
    	 RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getItemNom/1");

    	    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    	    System.out.println("*************************************"+result.getResponse());    	
    }
*/
	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}




}
