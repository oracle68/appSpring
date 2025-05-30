<!-- %@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%-->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!Doctype html>
<html class="ng-scope" ng-app="plunker">

<head>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.10/angular.js"></script>
  <script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.11.0.js"></script>
  <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
  <link rel="icon" href="data:;base64,iVBORw0KGgo=">
  <spring:url value="/resources/js/users2.js" var="usersJs" />
  <script src="${usersJs}"></script>
   
</head>


<body>

  <div ng-controller="PaginationDemoCtrl">
    <table class="table">
     <tr><td>FirstName</td><td>LastName</td><td>Id</td></tr>	
      <tr class="ng-scope" ng-repeat="row in data.slice(((currentPage-1)*itemsPerPage), ((currentPage)*itemsPerPage))">
        <td>{{row.firstName}}</td>
        <td>{{row.lastName}}</td>
        <td>{{row.id}}</td>
      </tr>
    </table>
View <select ng-model="viewby" ng-change="setItemsPerPage(viewby)">
<option>3</option><option>5</option><option>10</option><option>20</option><option>30</option><option>40</option><option>50</option></select> 
records at a time.

<ul class="pagination-sm pagination ng-isolate-scope ng-pristine ng-valid" total-items="totalItems" ng-model="currentPage" ng-change="pageChanged()" items-per-page="itemsPerPage">
  <!-- ngIf: boundaryLinks -->
  <!-- ngIf: directionLinks -->
  <li ng-if="directionLinks" ng-class="{disabled: noPrevious()}" class="ng-scope">
    <a href="" ng-click="selectPage(page - 1)" class="ng-binding">Previous</a></li><!-- end ngIf: directionLinks -->
  <!-- ngRepeat: page in pages track by $index -->
    <li ng-repeat="page in pages track by $index" ng-class="{active: page.active}" class="ng-scope">
       <a href="" ng-click="selectPage(page.number)" class="ng-binding">1</a></li>
       <!-- end ngRepeat: page in pages track by $index -->
       <li ng-repeat="page in pages track by $index" ng-class="{active: page.active}" class="ng-scope">
          <a href="" ng-click="selectPage(page.number)" class="ng-binding">2</a></li>
          <!-- end ngRepeat: page in pages track by $index -->
          <li ng-repeat="page in pages track by $index" ng-class="{active: page.active}" class="ng-scope active">
          <a href="" ng-click="selectPage(page.number)" class="ng-binding">3</a></li>
          <!-- end ngRepeat: page in pages track by $index -->
           <li ng-repeat="page in pages track by $index" ng-class="{active: page.active}" class="ng-scope"><a href="" ng-click="selectPage(page.number)" class="ng-binding">4</a></li><!-- end ngRepeat: page in pages track by $index --><li ng-repeat="page in pages track by $index" ng-class="{active: page.active}" class="ng-scope"><a href="" ng-click="selectPage(page.number)" class="ng-binding">5</a></li><!-- end ngRepeat: page in pages track by $index --><li ng-repeat="page in pages track by $index" ng-class="{active: page.active}" class="ng-scope"><a href="" ng-click="selectPage(page.number)" class="ng-binding">6</a></li><!-- end ngRepeat: page in pages track by $index --><li ng-repeat="page in pages track by $index" ng-class="{active: page.active}" class="ng-scope"><a href="" ng-click="selectPage(page.number)" class="ng-binding">7</a></li><!-- end ngRepeat: page in pages track by $index --><li ng-repeat="page in pages track by $index" ng-class="{active: page.active}" class="ng-scope"><a href="" ng-click="selectPage(page.number)" class="ng-binding">8</a></li><!-- end ngRepeat: page in pages track by $index --><li ng-repeat="page in pages track by $index" ng-class="{active: page.active}" class="ng-scope"><a href="" ng-click="selectPage(page.number)" class="ng-binding">9</a></li><!-- end ngRepeat: page in pages track by $index --><li ng-repeat="page in pages track by $index" ng-class="{active: page.active}" class="ng-scope"><a href="" ng-click="selectPage(page.number)" class="ng-binding">10</a></li><!-- end ngRepeat: page in pages track by $index -->
  <!-- ngIf: directionLinks --><li ng-if="directionLinks" ng-class="{disabled: noNext()}" class="ng-scope">
     <a href="" ng-click="selectPage(page + 1)" class="ng-binding">Next</a></li><!-- end ngIf: directionLinks -->
  <!-- ngIf: boundaryLinks -->
</ul>

    <pagination total-items="totalItems" ng-model="currentPage" ng-change="pageChanged()" class="pagination-sm" items-per-page="itemsPerPage"></pagination>
    <pre>The selected page no: {{currentPage}}</pre>
    <button class="btn btn-info" ng-click="setPage(currentPage)">Set current page to:{{currentPage}}</button>

    <hr />
    <h4>Pager</h4>
    <pager total-items="totalItems" ng-model="currentPage" items-per-page="itemsPerPage"></pager>

    <hr />
    <h4>Limit the maximum visible buttons</h4>
    <pagination total-items="totalItems" ng-model="currentPage" max-size="maxSize" class="pagination-sm" boundary-links="true" items-per-page="itemsPerPage"></pagination>
    <pagination total-items="totalItems" ng-model="currentPage" max-size="maxSize" class="pagination-sm" boundary-links="true" rotate="false" num-pages="numPages" items-per-page="itemsPerPage"></pagination>
    <pre>Page: {{currentPage}} / {{numPages}}</pre>
  </div>
</body>

</html>