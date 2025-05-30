package com.myapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity (name = "Usuarios")
@Table(name="USUARIOS")
@NamedQueries({
@NamedQuery(name="UserCount", query="select u from Usuarios u")
})
public class User {

    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id")
    @SequenceGenerator(name="seq_id", sequenceName = "seqid")
     private Integer id;
     
    @Column(name="FIRST_NAME")
    private String firstname;
 
    @Column(name="LAST_NAME")
    private String lastname;
 
    @Column(name="GENDER")
    private String gender;
    
    @OneToOne(cascade = CascadeType.PERSIST) //, orphanRemoval = false) //fetch = FetchType.EAGER, 
	@JoinColumn(name="IDCITY")
    private City city;
     
    public Integer getId() {
        return id;
    }
     
    public String getFirstName() {
        return firstname;
    }
    public String getLastName() {
        return lastname;
    }

    public String getGender() {
        return gender;
    }
    public City getCity() {
        return city;
    }

    public void setCity (City city) {
        this.city = city;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }
    public void setLastName(String lastname) {
        this.lastname = lastname;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
