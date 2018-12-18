<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="app.name"/></title>
</head>
<body>
	<table>
		<tr>
			<th><spring:message code="profesor.nombre"/></th>
			<th><spring:message code="profesor.materia"/></th>
			<th><spring:message code="profesor.curso"/></th>
			<th></th>
		</tr>
		<c:forEach items="${lista}" var="item">
			<tr>
		        <td>${item.nombre}</td>  
				<td>${item.materia}</td>
				<td>${item.curso}</td>
				<td><a href="quedar?id=${item.id}"><spring:message code="accion.quedar"/></a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="alumnomenu"><spring:message code="accion.menu"/></a>
</body>
</html>