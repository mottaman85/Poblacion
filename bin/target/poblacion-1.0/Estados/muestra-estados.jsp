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

</style>



<script type="text/javascript">

	var URLBUSCA = '/poblacion/Estados/estado!busca.action';

	$(document).ready(function(){
		console.log(URLBUSCA);
		
		$("#consultaBtn").click(buscaUsuarios);
		$("#comboEstado").on('change', buscaUsuarios);
	
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

<title>Estados</title>
</head>
<body>
	<h2>Estados</h2>		
	<hr>		
		<div id="UsuarioConsulta" class="prueba">		
		<fieldset>
			<legend>Consultar Estados</legend>						
				<div id="MostrarResult">
					<s:select id="comboEstado" label="Estados" list="es" name="estados2.cveEstado" listKey="value" listValue="label" value="value" headerKey="-1" headerValue="Seleccione" />
					<input type="button" value="consultar" id="consultaBtn">				 				 
				<br>
				<label>Resultado de la Busqueda</label>				
				<hr>
					<div id="resultadoTabla">
					</div>				
				</div>
		</fieldset>																								
	</div>
	<div id ="ModificaUsuario">
	<fieldset>
	<legend>Editar Estados</legend>
	<br>
	<table>
			<s:form action="/poblacion/Estados/estado!updEstado.action" method="post">							
				<tr>
					<td><label>Clave Estado:</label> </td>
					<td><input type="text" name="estados2.cveEstado" value="${users.cveEstado}" disabled></td>				 
				</tr>
				<tr>
					<td><label>Nombre del Estado</label> </td>
					<td>
						<input type="text" name="estados2.nombreEstado" value=" ${users.nombreEstado}" />
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
			<legend>Registrar Estados</legend>
			<br>
			<label>Ingrese sus datos</label>
			<s:form action="/Usuarios/usuario!setUsers.action" method="post">		
				<s:textfield name="estvo.clave" id="estvo.clave" label="Clave Estado"/>
				<s:textfield name="estvo.clave" id="estvo.clave" label="Clave Nombre Estado"/>	
										
				<s:submit value="Registrar"/>	
			</s:form>			
		</fieldset>
	</div>
	
</body>
</html>