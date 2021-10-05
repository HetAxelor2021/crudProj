package com.hh.model;

import java.util.ArrayList;
import java.util.List;

import javax.json.bind.annotation.JsonbCreator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.jboss.resteasy.annotations.jaxrs.FormParam;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@XmlRootElement
@Entity
@Table(name="laptop")
@JsonPropertyOrder({"lid", "lname"})
public class Laptop {
	@Id
	
	private int lid;
	
	
	private String lname;
	
	public Laptop() {
		
	}
	
	
	@JsonCreator
	public Laptop(
			 @JsonProperty("lid") final int lid,
	            @JsonProperty("lname") final String lname){
		this.lid=lid;
		this.lname = lname;
	}
	
	@ManyToMany
	private List<Employee> employee= new ArrayList<Employee>();

	public int getLid() {
		return lid;
	}

	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lname=" + lname + ", employee=" + employee + "]";
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
}
