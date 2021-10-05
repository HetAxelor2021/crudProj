package com.hh.resource;

import java.util.ArrayList;
import java.util.List;

import org.jboss.resteasy.annotations.Form;
import org.jboss.resteasy.annotations.jaxrs.FormParam;

public class EmployeeForm {
	
//	EmployeeForm(){
//		
//	} 
//	
//	public int getLid() {
//		return lid;
//	}
//
//	public void setLid(int lid) {
//		this.lid = lid;
//	}
//
//	public String getLname() {
//		return lname;
//	}
//
//	public void setLname(String lname) {
//		this.lname = lname;
//	}

	@FormParam("ename")
	private String ename;

	@FormParam("email")
	private String email;

//	@FormParam("lid")
//	private int lid;
//	
//	@FormParam("lname")
//	private String lname;
	
	
	@Form private List<LaptopForm> laptops =new ArrayList<LaptopForm>();
	
	
	public String getEname() {
		return ename;
	}

	public List<LaptopForm> getLaptops() {
		return laptops;
	}

	public void setLaptops(List<LaptopForm> laptops) {
		this.laptops = laptops;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//laptop class
	public static class LaptopForm{
		
		
		@FormParam("lid")
		private int lid;
		
		@FormParam("lname")
		private String name;
		public int getLid() {
			return lid;
		}

		public void setLid(int lid) {
			this.lid = lid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}


	}
	
}
