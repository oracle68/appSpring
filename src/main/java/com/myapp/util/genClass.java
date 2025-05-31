package com.myapp.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class genClass {

	private static String dao="Product";
	private static String daom="product";
	private static String url="src/main/java/com/myapp";
	private static String urlEntity=url+"/entity";
	private static String pack="com.myapp.";
	private static String fromDao="from "+dao;
	private static String packdao=pack+"dao";
	private static String packentity=pack+"entity";
	private static String packservice=pack+"service";
	private static String packcontroller=pack+"controller";
	private static String nameDao="name=\""+dao+"";
	private static String urlJsp="src/main/webapp/WEB-INF/view/";
	private static String urlTest = "src/test/java/com/myapp/test/";
	private static String packTest = "com.myapp.test";
	private static String clase = "Producte";
	private static String clasem = "producte";
	private static String ficheroTest = "Test"+daom;
	//urlTest+packTest+ficheroTest
	public static void main(String[] args) throws IOException {
		/*createModel();
		createDao();
		createDaoImpl();
		createService();
		createServiceImpl();
		createController();
		createAngularJs();
		*/
		
		createTest();

	}

	private static void createController() throws IOException{
		System.out.println("createController\n");
		File file = new File(url+"/controller/"+dao+"Controller.java");
		String texto="package "+packcontroller+";\n" + 
				"\n" + 
				"import java.util.List;\n" + 
				"\n" + 
				"import org.springframework.beans.factory.annotation.Autowired;\n" + 
				"import org.springframework.stereotype.Controller;\n" + 
				"import org.springframework.web.bind.annotation.RequestMapping;\n" + 
				"import org.springframework.web.bind.annotation.RequestMethod;\n" + 
				"import org.springframework.web.bind.annotation.ResponseBody;\n" + 
				"\n" + 
				"import "+packentity+"."+dao+";\n" + 
				"import "+packservice+"."+dao+"Service;\n" + 
				"\n" + 
				"@Controller\n" + 
				"public class "+dao+"Controller {\n" + 
				"\n" + 
				"	@Autowired\n" + 
				"	private "+dao+"Service "+daom+"Service;      \n" + 
				"	@RequestMapping(value = \"/"+daom+"ListJson\", method = RequestMethod.GET, produces=\"application/json\")\n" + 
				"	public @ResponseBody List getAll"+dao+"() {\n" + 
				"		System.out.println(\"#########getAll()#########\");\n" + 
				"		List<"+dao+"> "+daom+"List = "+daom+"Service.findAll();\n" + 
				"		return "+daom+"List;\n" + 
				"	}\n" + 
				"	\n" + 
				"}";
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();				
	}
			
	
	private static void createModel() throws IOException{
		System.out.println("createModel\n");
		File file = new File(urlEntity+"/"+dao+".java");
		String texto = "package "+packentity+";\n" + 
				"\n" + 
				"import javax.persistence.Column;\n" + 
				"import javax.persistence.Entity;\n" + 
				"import javax.persistence.GeneratedValue;\n" + 
				"import javax.persistence.GenerationType;\n" + 
				"import javax.persistence.Id;\n" + 
				"import javax.persistence.Table;\n" + 
				"\n" + 
				"\n" + 
				"@Entity("+nameDao+"\")\n" + 
				"@Table("+nameDao+"\")\n" + 
				"\n" + 
				"public class "+dao +" {\n" + 
				"	@Id\n" + 
				"	@GeneratedValue(strategy = GenerationType.AUTO)\n" + 
				"	private Long id;\n" + 
				"	@Column(name=\"name\")\n" + 
				"	private String nom;\n" + 
				"	@Column(name=\"description\")\n" + 
				"	private String description;\n" + 
				"	@Column(name=\"price\")\n" + 
				"	private String price;\n"
				+ "}";
					
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();		
	}
	
	private static void createService() throws IOException{
		System.out.println("createService\n");

		File file = new File(url+"/service/"+dao+"Service.java");
		  
		String texto = "package "+pack+"service;\n" + 
				"\n" + 
				"import java.util.List;\n" + 
				"\n" + 
				"import "+packentity+"."+dao+";\n" + 
				"\n" + 
				"public interface "+dao+"Service {\n" + 
				"\n" + 
				"	"+dao+" findById(long Id);\n" + 
				"\n" + 
				"	List<"+dao+"> findAll();\n" + 
				"\n" + 
				"	void add"+dao+"("+dao+" "+daom+");\n" + 
				"\n" + 
				"	void delete"+dao+"(long Id);\n" + 
				"	\n" + 
				"	void update"+dao+"("+dao+" "+daom+");\n" + 
				"\n" + 
			    "}";
					
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();		
	}

	private static void createServiceImpl() throws IOException{
		System.out.println("createServiceImpl\n");
		File file = new File(url+"/service/"+dao+"ServiceImpl.java");
		String texto = "package "+pack+"service;\n" + 
				"\n" + 
				"import java.util.List;\n" + 
				"import org.springframework.beans.factory.annotation.Autowired;\n" + 
				"import org.springframework.stereotype.Service;\n" + 
				"import org.springframework.transaction.annotation.Transactional;\n" + 
				"import "+packdao+"."+dao+"Dao;\n" + 
				"import "+packentity+"."+dao+";\n" + 
				"import "+packservice+"."+dao+"Service;\n" + 
				"\n" + 
				"@Service\n" + 
				"@Transactional\n" + 
				"public class "+dao+"ServiceImpl implements "+dao+"Service { \n" + 
				"\n" + 
				"	@Autowired\n" + 
				"	private "+dao+"Dao "+daom+"Dao;\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public "+dao+" findById(long Id) { \n" + 
				"\n" + 
				"		return "+daom+"Dao.findById(Id);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	\n" + 
				"	public List<"+dao+"> findAll() {\n" + 
				"		return "+daom+"Dao.findAll();\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"\n" + 
				"	public void add"+dao+"("+dao+" "+daom+") {\n" + 
				"		"+daom+"Dao.add"+dao+"("+daom+");\n" + 
				"\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void delete"+dao+"(long Id) {\n" + 
				"		"+daom+"Dao.delete"+dao+"(Id);\n" + 
				"\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void update"+dao+"("+dao+" "+daom+") {\n" + 
				"		"+daom+"Dao.update"+dao+"("+daom+");\n" + 
				"		\n" + 
				"	}\n" + 
				"\n" + 
				"}\n"; 
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();		
		
	}
	
	private static void createDao() throws IOException{
		System.out.println("createDao\n");
		File file = new File(url+"/dao/"+dao+"Dao.java");
		  
		String texto = "package "+packdao+";\n" + 
				"\n" + 
				"import java.util.List;\n" + 
				"\n" + 
				"import "+packentity+"."+dao+";\n" + 
				"\n" + 
				"public interface "+dao+"Dao {\n" + 
				"\n" + 
				"	"+dao+" findById(long Id);\n" + 
				"\n" + 
				"	List<"+dao+"> findAll();\n" + 
				"\n" + 
				"	void add"+dao+"("+dao+" "+daom+");\n" + 
				"\n" + 
				"	void delete"+dao+"(long Id);\n" + 
				"	\n" + 
				"	void update"+dao+"("+dao+" "+daom+");\n" + 
				"\n" + 
			    "}";
					
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();		
	}
	private static void createDaoImpl() throws IOException{
		
		System.out.println("createDaoImpl\n");
		File file = new File(url+"/dao/"+dao+"DaoImpl.java");
		  
		String texto = "package "+packdao+";\n" + 
				"\n" + 
				"import java.util.List;\n" + 
				"\n" + 
				"import org.hibernate.SessionFactory;\n" + 
				"import org.springframework.beans.factory.annotation.Autowired;\n" + 
				"import org.springframework.stereotype.Repository;\n" + 
				"\n" + 
				"import "+packentity+"."+dao+";\n" + 
				"\n" + 
				"@Repository\n" + 
				"public class "+dao+"DaoImpl implements "+dao+"Dao{\n" + 
				"\n" + 
				"	@Autowired\n" + 
				"    private SessionFactory sessionFactory;\n" + 
				"\n" + 
				"@Override\n" + 
				"				public "+dao+" findById(long Id) {\n" + 
				"					"+dao+" "+daom+" = ("+dao+") sessionFactory.getCurrentSession().get("+dao+".class, Id);\n" + 
				"					return "+daom+";\n" + 
				"				}"+
				"\n" + 
				"	@Override\n" + 
				"	public List<"+dao+"> findAll() {\n" + 
				"		 return sessionFactory.getCurrentSession().createQuery(\""+fromDao+"\").list(); \n" +
				
				"	}\n" + 
				"	@Override\n" + 
				"	public void add"+dao+"("+dao+" "+daom+") {\n" + 
				"		sessionFactory.getCurrentSession().save("+daom+");\n" + 
				"		\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void delete"+dao+"(long Id) {\n" + 
				"		"+dao+" "+daom+" = ("+dao+") sessionFactory.getCurrentSession().get("+dao+".class, Id); \n" + 
				"        if (null != "+daom+") {\n" + 
				"            sessionFactory.getCurrentSession().delete("+daom+");\n" + 
				"        }\n" + 
				"		\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void update"+dao+"("+dao+" "+daom+") {\n" + 
				"		sessionFactory.getCurrentSession().update("+daom+");\n" + 
				"		\n" + 
				"	}"+
				"}";
					
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();
		
	}
	
	private static void createAngularJs() throws IOException {
		System.out.println("createAngularJs\n");
		File file = new File(urlJsp+dao+"AngularJS.jsp");		
		String texto ="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" + 
				"<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\"\n" + 
				"    pageEncoding=\"UTF-8\"%>\n" + 
				"<!DOCTYPE html><html><head>    <title>AngularJS"+ dao +"List</title>  \n" + 
				"  <script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular.js\"></script>  \n" + 
				" </head>\n" + 
				"<body ng-app ng-controller=\"MyFilter\">\n" + 
				" AngularJS"+ dao +"List\n" + 
				"\n" + 
				"<table>\n" + 
				"<tr>\n" + 
				"  <td>id</td>\n" + 
				"  <td>nom</td>\n" + 
				"</tr>  \n" + 
				"<tr ng-repeat=\"elemento in lista track by $index\">\n" + 
				"   <td>{{elemento.id}}</td>\n" + 
				"  <td>{{elemento.nom}}</td> \n" + 
				"</tr>	\n" + 
				"</table>\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				" <script> \n" + 
				"       function MyFilter($scope,$http)\n" + 
				"  {           \n" + 
				"     \n" + 
				"    	   $http.get('"+daom+"ListJson')\n" + 
				"   	    .success(function (response){\n" + 
				"   	        $scope.lista = response;\n" + 
				"   	        console.log($scope.lista);\n" + 
				"   	    })\n" + 
				"   	    .error(function (response){\n" + 
				"   	        	        console.log(response); \n" + 
				"   	  }); \n" + 
				"    \n" + 
				"	}\n" + 
				"  \n" + 
				"</script>\n" + 
				"</body>\n" + 
				"</html>";
		
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();		
	}

	private static void createTest() throws IOException {
		
		String f = urlTest+ficheroTest+".java";
		System.out.println("createTest : File :"+f+"\n");
		File file = new File (f);
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
				"import com.myapp.service."+dao+"Service;\n" + 
				"\n" + 
				"@RunWith(SpringJUnit4ClassRunner.class)\n" + 
				"@ContextConfiguration(locations = { \"classpath*:spring-servlet.xml\" })\n" + 
				"@WebAppConfiguration\n"+
				"public class "+ficheroTest+" {\n" + 
				"\n" + 
				"	@Autowired\n" + 
				"    private "+dao+"Service"+" "+daom+"Service; \n" + 
				"\n" + 
				"	private MockMvc mockMvc; \n" + 
				"	\n" + 
				"	@Before\n" + 
				"    public void setUp(){\n" + 
				"    	  // Process mock annotations\n" + 
				"        MockitoAnnotations.initMocks(this);\n" + 
				"\n" + 
				"         //Setup Spring test in standalone mode\n" + 
				"        this.mockMvc = MockMvcBuilders.standaloneSetup("+daom+"Service).build();\n" + 
				"    }\n" + 
				"\n" + 
				"	@Test\n" + 
				"    public void test"+daom+"() {\n" + 
				"         Long Id =1L;"+
				"		  String nom = "+daom+"Service.findById(Id).getNom();\n" + 
				"		  assertEquals(nom,\"BAR\");\n" + 
				"	}\n" + 
				"}";
		
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(texto);
		writer.close();			
	}	
}
