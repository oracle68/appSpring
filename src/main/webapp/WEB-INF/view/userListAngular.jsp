<!-- ?xml version="1.0" encoding="UTF-8" ?-->
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html ng-app="App">
<head> 
   <title>AngularJS User List</title>
   <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
   <script src="http://code.angularjs.org/1.2.16/angular.js"></script>
   <script src="http://code.angularjs.org/1.2.16/angular-resource.js"></script>
   <script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.11.0.js"></script>
    <link rel="icon" href="data:;base64,iVBORw0KGgo=">

  
 <link rel="icon" href="data:;base64,iVBORw0KGgo=">
 <spring:url value="/resources/js/users.js" var="usersJs" />

    <script src="${usersJs}"></script>
 
 
</head>

<body>
 User List AngularJS
 
	 <div class="container-fluid">
      <div ng-controller="ListController"> 
      
		 <table class="table thead-dark table-striped table-hover table-bordered">
			<tr>
			  <td>id</td>
			  <td>firstName</td>
			  <td>lastName</td>
			  <td>gender</td>
			  <td>city</td>
			
			</tr>  
			
			<tr ng-repeat="item in objects| filter: paginate">
			  <td>{{item.id}}</td>
			  <td>{{item.firstName}}</td>
			  <td>{{item.lastName}}</td>
			  <td>{{item.gender}}</td>
			  <td>{{item.city.nom}}</td>
			</tr>
			</table>
	        <pagination total-items="totalItems" ng-model="currentPage"
	          max-size="5" boundary-links="true"
	          items-per-page="numPerPage" class="pagination-sm">
	        </pagination>			

			<br>

		</div>
		</div>  	
</body>
</html>
