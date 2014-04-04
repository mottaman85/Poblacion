<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>



<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<




<script>
$(document).ready(function(){
  $("#show").click(function(){
    $("#texto").show(1000);
  });
  $("#env").click(function(){
    $("#texto").hide(1000);
  });

});
</script>








</head>
<body>



Hola revolverianos



<div id="resultadosRol">
		<fieldset>
			<legend class="subtitulo">Roles Disponibles</legend>

<table>
											<thead>
												<tr>
													<th>
														Clave rol
													</th>
													<th>
														Descripción rol
													</th>
											    <tr>	
											</thead>
											<c:forEach items="${lista}" var="item">
											<tbody>
												<tr>
												<th>
												 ${item.cve_rol}	
													</th>
													 <th >
												  ${item.ds_rol}	
													</th>
													
													
													<th>
													<a href="http://localhost:8080/poblacion/ROLES?id=${item.cve_rol}">Elimina</a>
													</th>
													
													<th>
													<form action="http://localhost:8080/poblacion/ROLES" method="GET">
										<input type="hidden" name="consultaRol" id="consultaRol" value="2">				 
										<input type="hidden" name="idupd2" id="cveUsr" value="${item.cve_rol}">				 
										<input id="edix" type="submit" value="EDITA">
									</form>
													</th>
													
												</tr>
											</tbody>
											</c:forEach>
										</table>
			
</fieldset>
	</div>
	
	
	
	<div>
	<button id="show">Add</button>
	
	
	     <div id="texto" style="display:none;">
	     <fieldset>

  <form action="http://localhost:8080/poblacion/ROLES" method="GET">
  Clv Rol:<input type="text" name="newClave"><br>
  New Rol:<input type="text" name="newRol"><br>
  <input type="submit" id="env" value="Confirmar">
  </fieldset>
         </div>
         
	</div>
	
	
	
	
	
		
			
			<div id="EditarRol" >
			<fieldset>
			<form action ="http://localhost:8080/poblacion/ROLES" method="GET">
				<hr>
				<input type="text" name="editCve" value="${rolEdit.cve_rol}" disabled><br>
				<input type="text" name="editDs" value="${rolEdit.ds_rol}">
				
			
				<input id="ediy" type="submit" value="Guardar">
				
			</form>
			
				</fieldset>	
			
	</div>


	
</body>
</html>