<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>   
 <title>AngularJS Item List</title>  
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular.js"></script>  
  <!-- script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular-resource.js"></script-->

 <script> 
       function MyFilter($scope,$http)
  {           
    	   $http.get('itemListJson')
    	    .success(function (response){
    	        $scope.lista = response;
    	        console.log($scope.lista);
    	    })
    	    .error(function (response){
    	        	        console.log(response); 
    	  }); 

	}
  
</script>
 </head>
<body ng-app ng-controller="MyFilter">
 Item List AngularJS
<table border="1">
<tr>
  <td>id</td>
  <td>name</td>
  <td>description</td>
  <td>price</td>

</tr>  
<tr ng-repeat="element in lista | orderBy:'name'">
  <td>{{element.id}}</td>
  <td>{{element.name}}</td>
  <td>{{element.description}}</td>
  <td>{{element.price}}</td>

</tr>
 
</table>

</body>
</html>
