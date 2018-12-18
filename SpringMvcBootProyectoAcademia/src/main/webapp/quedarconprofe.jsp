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
	<form:form modelAttribute="asignacion" method="POST" action="guardar">
		<table>
		<tr>
			<td><spring:message code="asignacion.fecha"/></td>
			<td>
							
				<%-- Formato de fecha --%>
				<fmt:formatDate value="${asignacion.fecha}" pattern="dd/MM/yyyy" var="fecha"/>
				<form:input type ="date" path="fecha" value="${fecha}"/>
			</td>
		<td><form:errors path="fecha" cssClass="error" /></td></tr>
		
		  <tr><td><spring:message code="profesor.nombre"/></td><td> ${profesor.nombre}
          <form:hidden path="profesor.id" value = "${profesor.id}"/>
          <form:hidden path="alumno.id" value = "${alumno.id}"/>

		<tr><td><input type="submit" value="<spring:message code="accion.guardar"/>"/></td>
		</table>
		<form:errors path="*" cssClass="errorblock" element="div" />
	</form:form>
</body>
</html>