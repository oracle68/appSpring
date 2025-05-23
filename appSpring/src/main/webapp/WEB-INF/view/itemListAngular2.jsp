<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="App">
<head>    
<title>AngularJS Item List</title>  
  <!-- script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.21/angular.js"></script-->
 <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
 <script src="http://code.angularjs.org/1.2.16/angular.js"></script>
    <script src="http://code.angularjs.org/1.2.16/angular-resource.js"></script>
    <script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.11.0.js"></script>
<!-- May 2025 -->>
 </head>
<body>
 
 Item List AngularJS
	 <div class="container-fluid">
      <div ng-controller="mainCtrl">
      
		 <table class="table table-striped table-hover table-bordered">
			<tr>
			  <td>id</td>
			  <td>name</td>
			  <td>description</td>
			  <td>price</td>
			
			</tr>  
			<tr ng-repeat="element in objects | filter : paginate">
			  <td>{{element.id}}</td>
			  <td>{{element.name}}</td>
			  <td>{{element.description}}</td>
			  <td>{{element.price}}</td>
			
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

       App.controller('mainCtrl', ['$scope','$http', function($scope,$http) {

       $http.get('itemListJson')
 	    .success(function (response){
 	        $scope.objects = response;
 	        console.log($scope.objects);


         
         $scope.totalItems = $scope.objects.length;
         $scope.currentPage = 1;
         $scope.numPerPage = 15;
         
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
