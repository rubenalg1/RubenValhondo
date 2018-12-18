<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="app.name"/></title>
</head>
<body>
	<form:form modelAttribute="asignacion" method="POST" action="modificarasignacion">

		<table>
		<tr>
		<tr><td><spring:message code="asignacion.ejercicio"/></td><td><form:input path="ejercicio" /></td>
        <form:hidden path="id" value = "${id}"/>
		<tr><td><input type="submit" value="<spring:message code="accion.modificarejercicio"/>"/></td>
		</table>
		<form:errors path="*" cssClass="errorblock" element="div" />
	</form:form>
	<br>
	${msg}
	<br>
	<a href="listar"><spring:message code="accion.listar"/></a>
</body>
</html>