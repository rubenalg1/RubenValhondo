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
	<table style="text-align:center">
		<tr>
			<th><spring:message code="asignacion.fecha"/></th>
			<th><spring:message code="asignacion.alumno"/></th>
			<th><spring:message code="asignacion.ejercicio"/></th>
			<th></th>
		</tr>
		<c:forEach items="${lista}" var="item">
			<tr>
		        <td>${item.fecha}</td>  
				<td>${item.alumno.nombre}</td>
				<td>${item.ejercicio}</td>
				<td><a href="borrarasignacion?id=${item.id}"><spring:message code="accion.eliminar"/></a></td>
				<td><a href="ejercicioasignacion?id=${item.id}"><spring:message code="accion.modificarasignacion"/></a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="profesormenu"><spring:message code="accion.menu"/></a>
</body>
</html>