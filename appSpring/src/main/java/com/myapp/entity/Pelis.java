package com.myapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name="Pelis")
@NamedQueries({
@NamedQuery(name="PelisCount", query="select p from Pelis p")
})
public class Pelis {

	public Pelis() {
	}
    @Id
    @GeneratedValue
	Long id;
    
    @Column(name="NOM")
    String nom;
    @Column(name="DESCRIPCIO")
    String descripcio;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescripcio() {
		return descripcio;
	}
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	public Pelis(Long id, String nom, String descripcio) {
		super();
		this.id = id;
		this.nom = nom;
		this.descripcio = descripcio;
	}
	@Override
	public String toString() {
		return "Pelis [id=" + id + ", nom=" + nom + ", descripcio=" + descripcio + "]";
	}
    
    
    
    
}
