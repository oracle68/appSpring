<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="com.myapp.entity.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<!doctype html>
    <html>
      <head>
      <title>User Tree List</title>
        <!-- script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.7.0/angular.js"></script-->
 
      
  <style type="text/css">
	.grid {
	width: 700px;
	height: 700px;
	text-align: center;
	font-size: 12px;
	}

.tree {
  --spacing: 1.5rem;
  --radius: 10px;
}
tree li {
  display: block;
  position: relative;
  padding-left: calc(2 * var(--spacing) - var(--radius) - 2px);
}

.tree ul {
  margin-left: calc(var(--radius) - var(--spacing));
  padding-left: 0;
}
</style>

<script> 
var toggler = document.getElementsByClassName("caret");
var i;

for (i = 0; i < toggler.length; i++) {
  toggler[i].addEventListener("click", function() {
    this.parentElement.querySelector(".nested").classList.toggle("active");
    this.classList.toggle("caret-down");
  });
} 
</script>  
      </head>
      <body>
       <h2>User Tree List</h2>
		<br>        
		<br>


<c:forEach var="u" items="${map.userlist}">
<ul class="tree">

<li>
    <details>
<summary> ${u.id}</summary> 
      <ul>
        <li>
          <details>
            <summary>
${u.firstName}  ${u.lastName}  </summary>
  
 
</details>
</li>
 </ul>
 </details>
</li>
 </ul>
 </details>
</li>
 </ul>
</c:forEach>


<!--jsp:include page="node.jsp"/-->
      </body>
    </html>