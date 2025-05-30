<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Contacts List</title>
	<style type="text/css">
		body {
			font-family: sans-serif;
		}
		.data, .data td {
			border-collapse: collapse;
			width: 80%;
			border: 1px solid #aaa;
			margin: 2px;
			padding: 2px;
		}
		.data th {
			font-weight: bold;
			background-color: #5C82FF;
			color: white;
		}
	</style>
</head>
<body>

<h3>Contacts List</h3>

<jsp:include page="/index.jsp"/>
<br/>
<form:form method="post" action="anadir" commandName="contact">

	<table>
	<tr>
		<td><form:label path="nom"><spring:message code="label.nom"/></form:label></td>
		<td><form:input path="nom" required="required"/></td> 
	</tr>
	<tr>
		<td><form:label path="cognom"><spring:message code="label.cognom"/></form:label></td>
		<td><form:input path="cognom" required="required"/></td>
	</tr>
	<tr>
		<td><form:label path="mail"><spring:message code="label.mail"/></form:label></td>
		<td><form:input path="mail" /></td>
	</tr>
	<tr>
		<td><form:label path="telefon"><spring:message code="label.telefon"/></form:label></td>
		<td><form:input path="telefon" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="<spring:message code="label.addcontact"/>"/>
		</td>
	</tr>
</table>	
</form:form>

	
<h3>Contactos</h3>
<c:if  test="${!empty contactList}">
<table border="0">
<tr>
	<td><spring:message code="label.nom"/></td>
        <td><spring:message code="label.cognom"/></td>
	<td><spring:message code="label.mail"/></td>
	<td><spring:message code="label.telefon"/></td>
</tr>
<c:forEach items="${contactList}" var="contact">
	<tr>
		<td>${contact.nom} </td>
                <td>${contact.cognom} </td>
		<td>${contact.mail}</td>
		<td>${contact.telefon}</td>
               <td><a href="borrar/${contact.cId}">Eliminar</a></td>
	</tr>
</c:forEach>
</table>
</c:if>


</body>
</html>
