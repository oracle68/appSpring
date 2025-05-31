<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>    <title>AngularJS City List</title>  
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular.js"></script>  
  <!-- script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular-resource.js"></script-->
 </head>
<body ng-app ng-controller="MyFilter">
 City List AngularJS
<table border="1">
<tr>
  <td>id</td>
  <td>nom</td>

</tr>  
<label>Search: <input ng-model="nom"></label>
<tr ng-repeat="element in lista |filter:nom |orderBy:'nom'">
  <td>{{element.id}}</td>
  <td>{{element.nom}}</td>

</tr>
 
</table>
 <script> 
       function MyFilter($scope,$http)
  {           
    	   $http.get('cityListJson')
    	    .success(function (response){
    	        $scope.lista = response;
    	        console.log($scope.lista);
    	    })
    	    .error(function (response){
    	        	        console.log(response); 
    	  }); 

	}
  
</script>
</body>
</html>
</html>