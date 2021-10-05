package com.hh.module;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.hh.resource.HelloResource;
import com.hh.service.UserService;
import com.hh.service.UserServiceImpl;

public class HelloModule implements Module{
	@Override
	public void configure(Binder binder) {
		binder.bind(UserService.class).to(UserServiceImpl.class);
		binder.bind(HelloResource.class);
//		binder.bind(Integer.class).annotatedWith(Count.class).
	}
}
