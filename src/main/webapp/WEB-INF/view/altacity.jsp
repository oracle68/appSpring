
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Alta city</title>
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    </head>

    <body>
        <h3>Alta city!</h3>

		<jsp:include page="/index.jsp"/>
		<br/> 
		<br/> <b> Registration Form </b> <br />
		<br />
		<div>
		<c:url var="post_url" value="/addcity" />
			<form method="post" action="${post_url}"> <!--  modelAttribute="city" -->
				<table>
					<tr>
						<td>Nom :</td>
						<td><input type="text"  id="nom" name="nom"/><span id="mensaje"><c:out value="${map.mensaje}"></c:out></span></td>
					</tr>

					<tr>
						<td>City List:</td>
						<td><c:out value="${map.cityNomList}"></c:out></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Save" /></td>
					</tr>

				</table>
			</form>
		</div>

      
 </body>
</html>
