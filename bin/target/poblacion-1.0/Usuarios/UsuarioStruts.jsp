<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="/poblacion/js/core/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/poblacion/js/plugins/bpop.js"></script>

<style type="text/css">
	.prueba{
	
		background-color: black;
		color: white;
		
	}
</style>

<script type="text/javascript">

	var URLBUSCA = 'usuarios!busca.action';

	$(document).ready(function(){
		console.log(URLBUSCA);
		 alert("hola");
		
		$("#consultaBtn").click(buscaUsuarios);
		$("#comboRol").on('change', buscaUsuarios);
	
	});
	
	function buscaUsuarios(){
		   
		
		$("#resultadoTabla").html("<img alt='' src='/poblacion/images/loading.gif' title='Estoy cargando'>");
			console.log("Buscando...");
			var dataObj = new Object();
			dataObj.cveRol = $("#comboRol").val();
			
			$.ajax({
				url : URLBUSCA,
				data : dataObj,
				type : "post"				
			}).done(function(result){
				$("#resultadoTabla").html(result)
			})
			
		}
	
</script>

<title>Usuarios</title>
</head>
<body>
	<h2>Usuarios</h2>		
	<hr>		
		<div id="UsuarioConsulta" class="prueba">		
		<fieldset>
			<legend>Consultar Usuarios</legend>						
				<div id="MostrarResult">
<s:select id="comboRol" label="Rol" list="roles"  listKey="value" listValue="label"  value="value" headerKey="-1" headerValue="Seleccione"/></td>
<input type="button" value="consultar" id="consultaBtn">				 
<input type="button" value="consultar" class="prueba" id="pruebaClass">				 
				<br>
				<label>Registros de usuarios</label>				
				<hr>
					<div id="resultadoTabla">
					</div>				
				</div>
		</fieldset>																								
	</div>
	<div id ="ModificaUsuario">
	<fieldset>
	<legend>Editar Usuarios</legend>
	<br>
	<table>
			<s:form action="/Usuarios/usuario!actualizaUsers.action" method="post">							
				<tr>
					<td><label>Usuario:</label> </td>
					<td><input type="text" name="users2.clave" value="${users.clave}" disabled></td>				 
				</tr>
				<tr>
					<td><label></label> </td>
					<td>
					<s:select label="Rol" list="roles"  name="users2.rol" listKey="value" listValue="label"  value="value" headerKey="-1" headerValue="Seleccione"/></td>				 
				</tr>
				<tr>
					<td><label>Contrase&ntilde;a:</label> </td>
					<td>
						<input type="text" name="users2.pass" value=" ${users.pass}" />
					</td>				 
				</tr>
				<tr>
					<td><label></label> </td>
					<td><s:select label="Estatus"  name="users2.estatus" headerKey="-1" headerValue="Seleccione" list="#{'a':'Activo','i':'Inactivo'}" value="users.estatus" required="true"/></td>				 
				</tr>
				<tr>
					<td><label>Ip: </label></td>
					<td>
					<input type="text" name="users2.ip" value="${users.ip}"/>
					</td>				 
				</tr>	
				<tr>
					<td></td>
					<td><s:submit value="Guardar Cambios"/></td>
				</tr>																											
			</s:form>
		</table>	
		</fieldset>
	</div>		
	<div id ="RegistroUser">
		<fieldset>
			<legend>Registrar Usuarios</legend>
			<br>
			<label>Ingrese sus datos</label>
			<s:form action="/Usuarios/usuario!setUsers.action" method="post">		
				<s:textfield name="users.clave" id="users.clave" label="Clave"/>	
				<s:select label="Rol" list="roles"  name="users.rol" listKey="value" listValue="label"  value="value" headerKey="-1" headerValue="Seleccione" />												
				<s:password name="users.pass" id="users.pass" label="Contraseña"/>
				<s:select label="Estatus"  name="users.estatus" headerKey="-1" headerValue="Seleccione" list="#{'a':'Activo','i':'Inactivo'}" value="users.estatus" required="true"/>											
				<s:textfield name="users.ip" id="users.ip" label="IP"/>						
				<s:submit value="Registrar"/>	
			</s:form>			
		</fieldset>
	</div>
	
</body>
</html>