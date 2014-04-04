<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="/poblacion/js/core/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="/poblacion/js/plugins/bpop.js"></script>
	<title>Usuarios jquery</title>
		
<script type="text/javascript">
var URLBUSCA = '/poblacion/Usuarios/usuario!busca.action';
var URLBUSCAUNUSUARIO ='/poblacion/Usuarios/usuario!recuperausuario.action';


	
$(document).ready(function()
		{
			console.log(URLBUSCA);
			
			$("#consultaBtn").click(buscaUsuarios);
			//$("#comboRol").on('change', buscaUsuarios);
		
		});
		
		function buscaUsuarios()
		{
			
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
		
		
$(document).ready(function()
{
	
});


		
</script>
</head>
<body>

<!-- Sección de Búsqueda de Usuarios por Roles -->
	<div id="secPrincipal">
				
		<h2>Usuarios</h2>		
		<hr>		
		<div id="UsuarioConsulta" class="prueba">		
			<fieldset>
				    <legend>Consultar Usuarios por Rol</legend>						
					<div id="MostrarResult">
						<s:select id="comboRol" label="Rol" list="roles"  name="users.rol" listKey="value" listValue="label"  value="value" headerKey="-1" headerValue="Seleccione"/>
						<input type="button" value="consultar" id="consultaBtn">				 
						<br>					
   						<hr>
   						<div id="resultadoTabla">
						</div>				
					</div>
			</fieldset>																								
		</div>
	</div>	
	
	

<!-- Sección de Editar -->

	<div id="muestraunusuario">
	</div>
	


	
</body>
</html>