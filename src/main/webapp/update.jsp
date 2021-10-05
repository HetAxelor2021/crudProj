<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 
</head>
<body>
<form method="post" action="/CRUDProj/CRUDProj/hello/updateDb">
		<label for="eid">eid</label>
		<input type="text" name="eid" id="eid" value= "${emp.getId() }">
		<label for="ename">ename</label>
		<input type="text" name="ename" id="ename" value="${emp.getName() }">
		<label for="email">email</label>
		<input type="text" name="email" id="email" value="${emp.getEmail() }">
		<c:forEach items="${ emp.getLaptop()}" var="l">
			<label for="lid">lid</label>
			<input type="text" name="lid" id="lid" value="${l.getLid()}">
			<label for="lname">lname</label>
			<input type="text" name="lname" id="lname" value="${l.getLname() }">
		</c:forEach>
		<input type="submit">
		
		
	</form>
</body>
</html>