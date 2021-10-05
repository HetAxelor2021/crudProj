package com.hh.resource;

import org.jboss.resteasy.annotations.jaxrs.FormParam;

public class LaptopForm {
	
	public LaptopForm() {
		
	}
	
	
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

	@FormParam("lid")
	private int lid;
	
	@FormParam("lname")
	private String name;
}
