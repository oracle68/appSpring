<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
    <html ng-app="app">
      <head>
      <title>User List Grid</title>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.7.0/angular.js"></script>
        <!-- script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.7.0/angular-touch.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.7.0/angular-animate.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.7.0/angular-aria.js"></script>
        <script src="http://ui-grid.info/docs/grunt-scripts/csv.js"></script>
        <script src="http://ui-grid.info/docs/grunt-scripts/pdfmake.js"></script>
        <script src="http://ui-grid.info/docs/grunt-scripts/vfs_fonts.js"></script>
        <script src="http://ui-grid.info/docs/grunt-scripts/lodash.min.js"></script>
        <script src="http://ui-grid.info/docs/grunt-scripts/jszip.min.js"></script>
        <script src="http://ui-grid.info/docs/grunt-scripts/excel-builder.dist.js"></script-->
  <script src="http://ui-grid.info/release/ui-grid.js"></script>
  <script src="http://ui-grid.info/release/i18n/ui-grid.language.es.js"></script>
        <link rel="stylesheet" href="http://ui-grid.info/release/ui-grid.css" type="text/css">
  <spring:url value="/resources/js/app-users.js" var="usersJs" />
  <script src="${usersJs}"></script>     
  <style type="text/css">
	.grid {
	width: 700px;
	height: 700px;
	text-align: center;
	font-size: 12px;
	}

</style>   
      </head>
      <body>
       <h2>User List Grid</h2>
		<br>        
		<br>
		<div ui-i18n="es-ct">
        <div ng-controller="MainCtrl">
        <div id="i18nGrid" ui-grid="gridOptions" ui-grid-pagination class="grid"></div>
        </div>
        </div>
      </body>
    </html>