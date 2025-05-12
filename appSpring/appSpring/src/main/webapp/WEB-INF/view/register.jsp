<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Register</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
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
	text-align: left;
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
<script>
document.getElementById("city").refresh();
document.getElementById("gender").refresh();
</script>
<body>
	<div class="center">
		<br /> <br /> <br /> <b> Registration Form </b> <br />
		<br />
		<div>
			<form:form method="post" action="register" commandName="userForm">
				<table>
					<tr>
						<td>First Name :</td>
						<td><form:input path="firstName" /></td><td><span id="mensaje"></span></td>
                                                <td><form:errors path="firstName" /></td>
					</tr>
					<tr>
						<td>Last Name :</td>
						<td><form:input path="lastName"  /></td>
                        <td><form:errors path="lastName" /></td>
					</tr>
					<tr>
						<td>Gender :</td>
						<td><form:select id="gender" path="gender"	items="${map.genderList}" /></td>
						<td><form:errors path="gender" /></td>
					</tr>
					<tr>
						<td><form:input path="city.id"  /></td>
						<td>City :</td>
						<td><form:select id="city" path="city.nom" items="${map.cityList}" /></td>
						<td><form:errors path="city.nom" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Save" /></td>
					</tr>
					<tr>
						
						<td colspan="2"><a href="userList">Click Here to See User List</a></td>
					</tr>
				</table>
			</form:form>
                        <script type="text/javascript">
                        $('#firstName').blur(
                            function() {
                                $('#mensaje').load('existe',"firstname="+$('#firstName').val());
                             } )   
                         
                    </script>
		</div>
	</div>
</body>
</html>