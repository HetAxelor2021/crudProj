package com.hh.listener;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.hh.module.HelloModule;

@WebListener
public class MyServletContextListener extends GuiceResteasyBootstrapServletContextListener{
	@Override
	protected List<? extends Module> getModules(ServletContext context){
		return Arrays.asList(new JpaPersistModule("first-crud"), new HelloModule());
		
	}
	@Override
	public void withInjector(Injector injector) {
		injector.getInstance(PersistService.class).start();
	}
}
