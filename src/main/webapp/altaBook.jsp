 
    <%@ taglib uri="/struts-tags" prefix="s" %>  


    ${alta}
    <s:if test="hasActionErrors()">
	       <s:actionerror />
	</s:if>
	<s:if test="hasActionMessages()">
	       <s:actionmessage/>
	</s:if>
    <s:form action="altaBook">  
    <s:textfield name="id"  label="Id"></s:textfield>
    <s:textfield name="autor" label="Autor"></s:textfield>  
    <s:textfield name="titulo" label="Titulo"></s:textfield>
    <s:textfield name="precio" label="Precio"></s:textfield>
    <s:textfield name="fecha" label="Fecha" />

    
    <s:submit value="validar"></s:submit>  
	<s:if test="id!=null">
		<jsp:include page="/WEB-INF/view/bookListAngular.jsp"/>    
	</s:if>    
    </s:form> 
