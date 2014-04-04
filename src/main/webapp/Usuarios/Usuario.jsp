<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script languaje="Javascript">   
<!--  
document.write('<style type="text/css">div.cp_oculta{display: none;}</style>');  
function MostrarOcultar(capa,enlace)  
{  
}     
//-->  
</script>
<style type="text/css">  
.BTN_TRANS 
	{ 
		background:transparent; 
	} 
</style>
</head>


<body>

	<h2>Usuarios</h2>
	
	<hr>		
		<div id="UsuarioConsulta">		
		<fieldset>
			<legend>Consultar Usuarios</legend>
			<a href="UsuariosServlet">CONSULTAR</a>
			
			<br>				
				<form action="UsuariosServlet" method="post">
				
					 <select name="cveRol" id="cveRol">
						 <c:forEach items="${lista}" var="item">
							<option value='${item.cve_rol}'>${item.ds_rol}</option>
					 	</c:forEach>
					</select>
				<input type="hidden" name="consultaRol" id="consultaRol" value="0">				 
				<input type="submit">
								
				</form>
				<br>
				<div id="MostrarResult" class="">
				<label>Resultados de b&uacute;squeda</label>
				
				<hr>
					<table border="1">
						<thead>
							<tr>
								<th>Clave Usuario</th>
								<th>Clave Relo</th>
								<th>Password</th>
								<th>Estatus</th>
								<th>Direcci&oacute;n ip</th>
								<th>EDITAR</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${UsuarioR}" var="item">
							<tr>
								<td>${item.clave}</td>
								<td>${item.rol}</td>
								<td>${item.pass}</td>
								<td>${item.estatus}</td>
								<td>${item.ip}</td>
								<td>
									<form action="UsuariosServlet" method="post">
										<input type="hidden" name="consultaRol" id="consultaRol" value="2">				 
										<input type="hidden" name="cveUsr" id="cveUsr" value="${item.clave}">				 
										<input type="submit" value="EDITA">
									</form>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
		</fieldset>		
	</div>
	<div>
		<fieldset>
			<legend>
				Registrar Usuarios
			</legend>
			<br>
			<form action="UsuarioServletCombo" method="get">				
			 <input type="submit" onclick="javascript:MostrarOcultar('Register');" name="Transparencia" class="BTN_TRANS" value=".     REGISTRAR      .">
			</form>
			<br>
			<div id ="Register" class="">
			<hr>							
			<form action="UsuariosServlet" method="GET">
				<table>
					<thead>
						<tr>
						<th></th>
						<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Clave User:</td>
							<td>
								<input type="text" name="clave">
							</td>
						</tr>					
						<tr>
							<td>Clave Rol:</td>							 
							<td>							
								 <select>
								 <c:forEach items="${lista}" var="item">
									<option value='${item.cve_rol}'>${item.ds_rol}</option>
								 </c:forEach>
								</select>  
							</td>								
						</tr>
						<tr>
						</tr>
						<tr>
							<td>Contrase&ntilde;a:</td>
							<td> <input type="password" name="pass" style="width:200px;" ></td>
						</tr>
						<tr>
						</tr>	
						<tr>
							<td>Estatus:</td>
							<td>
								<select name="estatus" style="width:200px;"> 
									<option id="A" value="a">Activo</option>
									<option id="I" value="i">Inactivo</option>									
								</select>
							</td>
						</tr>
						<tr>
						</tr>
						<tr>							
							<td>Ip:</td>
							<td><input type="text" name="ip" style="width:200px;" value='<%= request.getRemoteAddr() %>'> </td>
						</tr>												
					</tbody>
				</table>
				<br>
				<input type="submit" value="Guardar">
			</form>
			</div>
		</fieldset>	
	</div>
	
	<div id="EditarUsuario">		
		<fieldset>
			<legend>Editar Usuarios</legend>
			<br>			
			<br>
			<div id="EditarUser" class="" >
			<label>Edici&oacute;n de usuarios</label>
			<form>
				<hr>
				<input type="text" value="${usrEdit.clave} }">
				
					<div id="MostrarResult" style="display: none;">
					Datos a modificar
				</div>
				<input type="submit" value="Guardar">
			</form>
			<br>
			</div>
		</fieldset>		
	</div>
	
	<form action="UsuariosServlet" method="post">
				
		<input type="hidden" name="consultaRol" id="consultaRol" value="1">				 
		<input type="submit" value="SALIR">
								
	</form>
	
	
</body>
</html>