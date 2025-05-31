package com.myapp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
 
@Entity (name = "Contacts")
@Table(name="CONTACTS")
public class Contact {
	
	 @Id
	    @Column(name="CID")
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id")
        @SequenceGenerator(name="seq_id", sequenceName = "seqid")
	    private Integer cId;
	     
	    @Column(name="NOM")
	    private String nom;
	 
	    @Column(name="COGNOM")
	    private String cognom;
	 
	    @Column(name="MAIL")
	    private String mail;
	     
	    @Column(name="TELEFON")
	    private String telefon;
	     
	     
	    public String getMail() {
	        return mail;
	    }
	    public String getTelefon() {
	        return telefon;
	    }
	    public String getNom() {
	        return nom;
	    }
	    public String getCognom() {
	        return cognom;
	    }            
	    public void setMail(String mail) {
	        this.mail = mail;
	    }
	    public void setTelefon(String telefon) {
	        this.telefon = telefon;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }
	    public void setCognom(String cognom) {
	        this.cognom = cognom;
	    }
	    public Integer getcId() {
	        return cId;
	    }
	    public void setcId(Integer cId) {
	        this.cId = cId;
	    }

}
