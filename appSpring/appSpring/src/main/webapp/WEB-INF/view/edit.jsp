<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>appSring Update</title>
<style>
body {
	font-size: 20px;
	color: teal;
	font-family: Calibri;
}

td {
	font-size: 15px;
	color: black;
	width: 100px;
	height: 22px;
	text-align: center;
}

.heading {
	font-size: 18px;
	color: white;
	font: bold;
	background-color: orange;
	border: thick;
}
.center {
  text-align:center
}

</style>
</head>
<body>
	<div class="center">
		<br /> <br /> <br /> <b>Edit User Details </b><br /> <br />
		<div>
			<c:url var="post_url" value="/update" />
			<form:form method="post" action="${post_url}" commandName="user"> <!-- modelAttribute="user"-->
				<table>
					<tr>
						<td>First Name :</td>
						<td><form:input path="firstName"
								value="${map.user.firstName}" /></td>
					</tr>
					<tr>
						<td>Last Name :</td>
						<td><form:input path="lastName" value="${map.user.lastName}" />
						</td>
					</tr>
					<tr>
						<td>Gender :</td>
						<td><form:input path="gender" value="${map.user.gender}"/>
										
                     </td>
					</tr>
					<tr>
						<td><form:input path="city.id" value="${map.user.city.id}"/>
						<td>City :</td>
						<td><spring:bind path="city.nom">
								<select name="city.nom">
									<c:forEach items='${map.cityList}' var='cityName'>
										<c:choose>
											<c:when test="${cityName eq map.user.city.nom}">
												<option value="${cityName}" selected="true">${cityName}</option>
											</c:when>
											<c:otherwise>
												<option value="${cityName}">${cityName}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
						</spring:bind></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Save" /></td>
					</tr>
				</table>
				<form:hidden path="id" value="${map.user.id}" />

			</form:form>
		</div>
	</div>
</body>
</html>