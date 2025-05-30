
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Alta city</title>
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    </head>
    <script type="text/javascript">
    function valida(f){
    	if (f.nom.value=="")  alert("Camp obligatori");
    	else{
    		
    		f.action="addcity?nom="+f.nom.value;
    		f.submit();
    		//$('#registro').submit(function(evento) {    });
    		//$('#mensaje').load('addcity',"nom="+$('#nom').val());
    		$('#clista').load('cityNomList');
    	}
    		
    }
    </script>
    <body>
        <h1>Alta city!</h1>

    <span id="cLista"></span>
    


<form id="registro" action="" accept-charset="utf-8">
    City Name:  <input type="text" name="nom" id="nom" />
    
     <!-- input type="text" name="nom" id="nom" required="nom"  oninvalid="setCustomValidity('Camp obligatori')"
     onchange="try{setCustomValidity('')}catch(e){}"/-->
     <span id="mensaje"></span> <br> 
    <input type="submit" onclick="valida(registro);" value="registrar"/>
</form>
      
 </body>
</html>
