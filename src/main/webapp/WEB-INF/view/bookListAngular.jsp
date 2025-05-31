<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="App">
<head>   
 <title>AngularJS Book List</title>  
   <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
   <script src="http://code.angularjs.org/1.2.16/angular.js"></script>
   <script src="http://code.angularjs.org/1.2.16/angular-resource.js"></script>
   <script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.11.0.js"></script>
    <link rel="icon" href="data:;base64,iVBORw0KGgo=">
 </head>
<body>
 Book List AngularJS
 
	 <div class="container-fluid">
      <div ng-controller="mainCtrl2">
      
		 <table class="table table-striped table-hover table-bordered">
		<tr>
		  <td>id</td>
		  <td>autor</td>
		  <td>titulo</td>
		  <td>precio</td>
		  <td>fecha</td>
		
		</tr>  
		
		<tr ng-repeat="element in objects | filter : paginate| orderBy : 'autor'">
		
		  <td>{{element.id}}</td>
		  <td>{{element.autor}}</td>
		  <td>{{element.titulo}}</td>
		  <td>{{element.precio}}</td>
		  <td>{{element.fecha}}</td>
		</tr>
		 
		</table>
 
        <pagination total-items="totalItems" ng-model="currentPage"
          max-size="5" boundary-links="true"
          items-per-page="numPerPage" class="pagination-sm">
        </pagination>
        </div> 
    </div> 
 <script> 

       window.App = angular.module('App', ['ui.bootstrap']);

       App.controller('mainCtrl2', ['$scope','$http', function($scope,$http) {

       $http.get('bookListJson')
 	    .success(function (response){
 	        $scope.objects = response;
 	        //console.log($scope.objects);
         
         $scope.totalItems = $scope.objects.length;
         $scope.currentPage = 1;
         $scope.numPerPage = 5;
         
         $scope.paginate = function(value) {
           var begin, end, index;
           begin = ($scope.currentPage - 1) * $scope.numPerPage;
           end = begin + $scope.numPerPage;
           index = $scope.objects.indexOf(value);
           return (begin <= index && index < end);
         };
         
 	    })
 	    
       }]);
</script>
</body>
</html>
