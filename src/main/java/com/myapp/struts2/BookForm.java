package com.myapp.struts2;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.myapp.entity.Book;
import com.myapp.service.BookService;
import com.opensymphony.xwork2.ActionSupport;

public class BookForm extends ActionSupport implements SessionAware{  
	  
	SessionMap<String,String> sessionmap;  

	@Autowired 
	private BookService bookService;
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String autor;
	private String titulo;
	private String precio;
	private String fecha ; //= new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {

		this.fecha = fecha;
	}
	
	public BookForm(Long id, String autor, String titulo, String precio, String fecha) {
		super();
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.precio = precio;
		this.fecha = fecha;
	}
	

	public BookForm() {
		super();
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.precio = precio;
		this.fecha = fecha;
	}
	
	public String execute() {
		try {
			if (id==null) {

			  addActionError("Id Required field.");
			  return "error";
			}
			if (autor.equals("")|| autor==null) {
					addActionError("Autor Required field.");
					return "error";
			}
			if (titulo.equals("")||titulo==null) {
				addActionError("Titulo Required field.");
				return "error";
			}				
			if (precio.equals("")||precio==null) {
				addActionError("Precio Required field.");
				return "error";
			}
			
			/*if (fecha.equals("")||fecha==null) {
				addActionError("Fecha Required field.");
				fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
				return "error";
			}	
			if (!fecha.contains("/")) {
				addActionError("Fecha Format dd/mm/yyyy.");
				fecha = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
				return "error";
			}				
			*/
			
			addActionMessage("You are valid user!");
			Book book = new Book();
			book.setId(id);
			book.setAutor(autor);
			book.setTitulo(titulo);
			Double d = Double.parseDouble(precio);
			book.setPrecio(d);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			System.out.println("Fecha:" +fecha);
			if (!fecha.equals(""))
				date =  formatter.parse(fecha);

			book.setFecha(date);
			
			System.out.println("GRABAR");
			bookService.addBook(book);
			System.out.println("OK");
			return "success";  

		}catch (Exception ex) {
				ex.printStackTrace();
				return "error";
			}
		
	       
	}
	
	
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public void setSession(Map map) {  
	    sessionmap=(SessionMap)map;  
	    sessionmap.put("alta","true");  
	}
 

}
