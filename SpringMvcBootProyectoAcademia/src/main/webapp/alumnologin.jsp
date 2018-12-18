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
	<form:form modelAttribute="alumno" method="POST" action="alumnologin">

		<table>
		<tr>
		<tr><td><spring:message code="alumno.user"/></td><td><form:input path="user" required= "required" /></td>
		  <tr><td><spring:message code="alumno.pass"/></td><td><form:input path="pass" required= "required" /></td>

		<tr><td><input type="submit" value="<spring:message code="accion.loginalumno"/>"/></td>
		</table>
		<form:errors path="id" cssClass="errorblock" element="div" />
	</form:form>
	<br>
</body>
</html>