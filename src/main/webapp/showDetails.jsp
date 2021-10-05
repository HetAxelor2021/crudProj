<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<base href="http://localhost:8080/CRUDProj/">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css" integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/fontawesome.min.css" integrity="sha512-Rcr1oG0XvqZI1yv1HIg9LgZVDEhf2AHjv+9AuD1JXWGLzlkoKDVvE925qySLcEywpMAYA/rkg296MkvqBF07Yw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="style.css" >
</head>
<body>
	<section id="first-section">
		
		
		
		<table class="main-table" id="read">
					<tr class="main-header">
						<th>Id</th>
						<th>Ename</th>
						<th>Email</th>
						<th>No. of Laptop</th>
						<th>update/delete</th>
							
					</tr>
				
					<c:forEach items="${list}" var="item">
			
						<tr>
							<td>${item.getId()}</td>
							<td>${item.getName()}</td>
							<td>${item.getEmail()}</td>
							<td class="no-laptop-${item.getId()}  allData">${item.getLaptop().size()}</td>
							
							
							<td class="hide-data" id="empLapBox" data-id="${item.getId() }">
										<i class="fas fa-times-circle close"></i>
										
										<table>
											<tr>
												<th>Laptop_id</th>
												<th>Laptop_name</th>
											</tr>
												<c:forEach items="${item.getLaptop() }" var="it">
											<tr>	
												<td>${it.getLid()}</td>
												<td>${it.getLname() }</td>
											</tr>
										
											</c:forEach>
										</table>
										
																				
							
							
							
							</td>							
							<td><a href="http://localhost:8080/CRUDProj/CRUDProj/hello/employee/${item.getId() }">UPDATE</a> | <a href="http://localhost:8080/CRUDProj/CRUDProj/hello/del/${item.getId() }" >DELETE</a></td>
							
						</tr>
					</c:forEach>
					
		</table>
		
	</section>
	<script src = "./main.js" ></script>
	
</body>
</html>
