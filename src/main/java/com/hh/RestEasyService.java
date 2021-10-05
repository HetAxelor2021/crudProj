package com.hh;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.hh.resource.HelloResource;

@ApplicationPath("/restapi")
public class RestEasyService extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	
	public RestEasyService() {
		singletons.add(new HelloResource());
	}
	
	@Override
	public Set<Object> getSingletons(){
		return singletons;
	}
}
