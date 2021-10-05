package com.hh.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.hh.model.Employee;
import com.hh.model.Laptop;
import com.hh.resource.EmployeeForm;

public class UserServiceImpl implements UserService{
private static final int Employee = 0;

	//	public Employee createMd(EntityManager em, EmployeeForm ef) {
	public Employee createMd(EntityManager em, String ename, String email, int lid, String lname) {
		// TODO Auto-generated method stub
		Employee e = new Employee();
		Laptop l = new Laptop();
		
		e.setName(ename);
		e.setEmail(email);
//
		l.setLid(lid);
		l.setLname(lname);
		
		l.getEmployee().add(e);
//		
		e.getLaptop().add(l);
		
		//normal form
		
		
		
		
//		for(int i=0;i<e.getLaptop().size();i++) {
//			l.setLid(ef.getLaptops().get(i).getLid());
//			l.setLname(ef.getLaptops().get(i).getName());
//			l.getEmployee().add(e);
//			
//			e.getLaptop().add(l);
//			
//			
//			em.persist(l);
//			
//			
//		}
		em.persist(e);
		em.persist(l);
		
		
		return e;
	}

	public List<Employee> readMd(EntityManager em){
		@SuppressWarnings("unchecked")
		Query query = em.createQuery("select e1 from Employee e1 order by e1.id ");
//		List<Employee> ls = query.getResultList();
//		for(Employee e : ls) {
//			System.out.println(e);
//			System.out.println("ename: "+e.getName());
//			System.out.println("email : "+e.getEmail());
//			for(Laptop l : e.getLaptop()) {
//				System.out.println(l);
//				System.out.println("lid: "+l.getLid());
//				System.out.println("lname: "+l.getLname());
//			}
//		}
//		System.out.println("we are in");
//		return ls;
		return  query.getResultList();
	}
	
	public Employee updateDb( EntityManager em, int eid, String ename,  String email,  int lid,  String lname) {
		System.out.println(eid);
		Employee e = em.find(Employee.class,eid);
		e.setName(ename);
		e.setEmail(email);
		
		for(Laptop l : e.getLaptop()) {
			if(lid == l.getLid()) {
				l.setLname(lname);
			}
		}
		Laptop l = em.find(Laptop.class,lid );
		l.setLname(lname);
		e.getLaptop().add(l);
		em.merge(e);
		System.out.println(e);
		System.out.println(l);
		
		return e;
	}
	
	public Employee getEmployee(EntityManager em , int id) {
		Employee e = em.find(Employee.class, id);
		return e;
	}
	
	public void deleteDb(EntityManager em, int eid) {
		Employee e = em.find(Employee.class, eid);
		System.out.println(e);
		em.remove(e);
	}

}
