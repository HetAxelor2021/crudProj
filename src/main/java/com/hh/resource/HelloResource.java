package com.hh.resource;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Form;
import org.jboss.resteasy.annotations.jaxrs.FormParam;
import org.jboss.resteasy.plugins.providers.html.Redirect;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpResponse;

//import com.google.common.net.MediaType;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;
import com.hh.model.Employee;
import com.hh.model.Laptop;
import com.hh.service.UserService;

@Path("/hello")
public class HelloResource {
	
	@Inject
	private EntityManager em;
//	
	@Context
	private HttpRequest request;
	
	@Context
	private HttpResponse response;
	
//	@Context
//	private HttpSession session;
	
	@Inject
	private UserService userService;
	
//	@Context
//	private Response res;
//	
	@POST
	@PermitAll
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/create")
	@Transactional
	public void createMd(@FormParam("ename") String ename, @FormParam("email") String email, @FormParam("lid") int id, @FormParam("lname") String lname) {

	
		Employee e = userService.createMd(em, ename, email, id, lname);
		request.setAttribute("employee", e);
		request.forward("/success.jsp");
		
	}
	
	
	@GET
	@PermitAll
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/read")
	
	public List<Employee> readMd() {
		System.out.println("hello");
		try {
			
			List<Employee> ls = userService.readMd(em);
			
//			HttpSession session = request.getSession();
//			session.setAttribute("list", ls);
//			response.("index.jsp");
//			res.seeOther("index.jsp");
//			Response.seeOther("/CRUDProj");
			request.setAttribute("list", ls);
			request.forward("/showDetails.jsp");
			return ls;
		} 
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return null;
		
	}
	
	@GET
	@PermitAll
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/employee/{id}")
	public void getEmpData(@PathParam("id") int id) {
		Employee e = userService.getEmployee(em, id);
		request.setAttribute("emp", e);
		request.forward("/update.jsp");
		
	}

	@POST
	@PermitAll

	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	@Path("/updateDb")
	public void updateDb(@FormParam("eid") int eid,@FormParam("ename") String ename, @FormParam("email") String email, @FormParam("lid") int lid, @FormParam("lname") String lname) {
	
		Employee emp = userService.updateDb( em, eid, ename,  email, lid, lname);
		request.setAttribute("employee", emp);
		request.setAttribute("update", "update-data");
		request.forward("/success.jsp");

	}
	
	
	@GET
	@Transactional
	@PermitAll
	@Path("/del/{eid}")
	public void deleteMd(@PathParam("eid") int eid) {
		userService.deleteDb(em, eid);
		request.setAttribute("msg", "deleted successfully.");
		request.forward("/delete.jsp");
		
		
	}
	
	
//	public void createMd(@Form EmployeeForm e) {
//		Employee e1 = userService.createMd(em,e);
//		request.setAttribute("employee", e1);
//		request.forward("/success.jsp");
//	}
}
