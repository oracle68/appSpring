package com.myapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity (name = "Book")
@Table(name="BOOK")
public class Book {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id")
	@SequenceGenerator(name="seq_id", sequenceName = "seqid")
	 private Long id;
	 
	@Column(name="AUTOR")
	private String autor;
	@Column(name="TITULO")
	private String titulo;
	@Column(name="PRECIO")
	private Double precio;
	@Column(name="FECHA")
	@Temporal(TemporalType.DATE)
	private Date fecha;
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
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", autor=" + autor + ", titulo=" + titulo + ", precio=" + precio + ", fecha=" + fecha
				+ "]";
	}

	

}
