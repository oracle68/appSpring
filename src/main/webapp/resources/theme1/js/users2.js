angular.module('plunker', ['ui.bootstrap']);
var PaginationDemoCtrl = function ($scope,$http) {

	
   $http.get('userListJson')
   .success(function (response){
       $scope.data = response;
       $scope.size = response.length;
       console.log('total:'+$scope.size);
   })
   .error(function (response){
       	        console.log(response); 
  	}); 	
	
	
  $scope.viewby = 10;
  $scope.totalItems = $scope.size;
  $scope.currentPage = 1;
  $scope.itemsPerPage = $scope.viewby;
  $scope.maxSize = 5; //Number of pager buttons to show
  console.log('scope.currentPage ' + $scope.currentPage);
  $scope.setPage = function (pageNo) {
    $scope.currentPage = pageNo;
  };

  $scope.selectPage = function (pageNo) {
	    $scope.currentPage = pageNo;
	  };
	  
  $scope.pageChanged = function() {
    console.log('Page changed to: ' + $scope.currentPage);
  };

$scope.setItemsPerPage = function(num) {
  $scope.itemsPerPage = num;
  $scope.currentPage = 1; //reset to first page
}
};	  