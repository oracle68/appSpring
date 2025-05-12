var app = angular.module('app', ['ui.grid', 'ui.grid.pagination']);
     
    app.controller('MainCtrl', ['$scope','$http','i18nService', function ($scope,$http,i18nService) {
    i18nService.setCurrentLang('es-ct');
    $http
    .get("userListJson")
    .then(function(response) {
    $scope.data = response.data;

    });
       
         $scope.gridOptions = {
         enableFiltering: true,
         data: 'data',
         paginationPageSizes: [5, 10, 20,25],
         paginationPageSize: 5,
         columnDefs: [
           {name: 'id'},        	 
           {name: 'firstName'},
           {name: 'lastName'},
           {name: 'gender'},
           {name: 'city.nom'}
         ]
        }
     }]);