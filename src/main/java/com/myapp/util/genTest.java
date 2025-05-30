package com.myapp.util;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;




public class genTest {

	private static String urlTest = "src/test/java/com/myapp/test/";
	private static String packTest = "com.myapp.test";
	private static String clase = "Contact";
	private static String clasem = "contact";
	private static String ficheroTest = "Test"+clase+"2.java";
	
	public static void main(String[] args) throws IOException {
		creaTest();

	}	
	
	private static void creaTest() throws IOException {
		
		File file = new File (urlTest+packTest+ficheroTest);
		String texto = "package "+packTest+";\n"
				+ "import static org.junit.Assert.assertEquals;\n" + 
				"\n" + 
				"import org.junit.Before;\n" + 
				"import org.junit.Test;\n" + 
				"import org.junit.runner.RunWith;\n" + 
				"import org.mockito.MockitoAnnotations;\n" + 
				"import org.springframework.beans.factory.annotation.Autowired;\n" + 
				"import org.springframework.test.context.ContextConfiguration;\n" + 
				"import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;\n" + 
				"import org.springframework.test.context.web.WebAppConfiguration;\n" + 
				"import org.springframework.test.web.servlet.MockMvc;\n" + 
				"import org.springframework.test.web.servlet.setup.MockMvcBuilders;\n" + 
				"\n" + 
				"import com.myapp.service."+clase+"Service;\n" + 
				"\n" + 
				"@RunWith(SpringJUnit4ClassRunner.class)\n" + 
				"@ContextConfiguration(locations = { \"classpath*:spring-servlet.xml\" })\n" + 
				"@WebAppConfiguration\n"+
				"public class Test"+clase+"2 {\n" + 
				"\n" + 
				"	@Autowired\n" + 
				"    private "+clase+"Service"+" "+clasem+"Service; \n" + 
				"\n" + 
				"	private MockMvc mockMvc; \n" + 
				"	\n" + 
				"	@Before\n" + 
				"    public void setUp(){\n" + 
				"    	  // Process mock annotations\n" + 
				"        MockitoAnnotations.initMocks(this);\n" + 
				"\n" + 
				"         //Setup Spring test in standalone mode\n" + 
				"        this.mockMvc = MockMvcBuilders.standaloneSetup("+clasem+"Service).build();\n" + 
				"    }\n" + 
				"\n" + 
				"	@Test\n" + 
				"    public void test"+clasem+"() {\n" + 
				"		  String nom = "+clasem+"Service.getCity(21).getNom();\n" + 
				"		  assertEquals(nom,\"BAR\");\n" + 
				"	}\n" + 
				"}";
		
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();			
	}
}
