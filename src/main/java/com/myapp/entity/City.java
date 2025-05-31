package com.myapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity (name = "City")
@Table(name="CITY")
public class City {

    @Id
    @Column(name="IDCITY")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id")
    @SequenceGenerator(name="seq_id", sequenceName = "seqid")
     private Integer id;
     
    @Column(name="NOM")
    private String nom;
     
    public Integer getId() {
        return id;
    }
    
    public String getNom() {
        return nom;
    }

     public void setNom (String nom) {
        this.nom = nom;
    }
    public void setId(Integer id) {
        this.id = id;
    }    
}
