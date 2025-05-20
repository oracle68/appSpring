<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>    <title>AngularJSProductList</title>  
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular.js"></script>  
 </head>
<body ng-app ng-controller="MyFilter">
 AngularJSProductList

<table border="1">
<tr>
  <td>id</td>
  <td>nom</td>
</tr>  
<tr ng-repeat="elemento in lista track by $index">
   <td>{{elemento.id}}</td>
  <td>{{elemento.nom}}</td> 
</tr>	
</table>



 <script> 
       function MyFilter($scope,$http)
  {           
     
    	   $http.get('productList')
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