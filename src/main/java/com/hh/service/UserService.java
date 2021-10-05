package com.hh.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.resteasy.annotations.jaxrs.FormParam;

import com.hh.model.Employee;
import com.hh.resource.EmployeeForm;

public interface UserService {
	public Employee createMd(EntityManager em, String ename, String email, int lid, String lname);
//	public Employee createMd(EntityManager em, EmployeeForm e);

	public List<Employee> readMd(EntityManager em);
	
	public Employee updateDb( EntityManager em, int eid, String ename,  String email,  int lid,  String lname);
	
	public Employee getEmployee(EntityManager em,int id);
	
	public void deleteDb(EntityManager em, int eid);
}
