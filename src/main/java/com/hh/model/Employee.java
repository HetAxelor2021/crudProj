package com.hh.model;

import java.util.ArrayList;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.jboss.resteasy.annotations.Form;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@XmlRootElement
@Table(name="employee")

public class Employee {

	public Employee() {
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="email")
	private String email;
	
	 @JsonCreator
	  public Employee(
	            @JsonProperty("id") final int id,
	            @JsonProperty("name") final String name,
	            @JsonProperty("email") final String email){
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        
	    }
	
	
	 @JsonbTransient
	@ManyToMany(mappedBy="employee" , fetch=FetchType.LAZY, cascade= { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
	private List<Laptop> laptop = new ArrayList<Laptop>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Laptop> getLaptop() {
		return laptop;
	}

	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	
	
}
