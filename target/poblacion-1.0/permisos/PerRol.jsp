					
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="/poblacion/js/core/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/poblacion/js/plugins/bpop.js"></script>


<script type="text/javascript">

var URLBUSCA = '/poblacion/PerRol/Permisos!consultaPermisos.action';


$(document).ready(function(){
 
	
	$("#comboRol").on('change', buscaUsuarios);

});

function buscaUsuarios(){
	   
	
	$("#resultadoTabla").html("<img alt='' src='/poblacion/images/Pacman.gif' title='Estoy cargando'>");

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
</head>

<body>

		<H2 class="Titulo"> Adminstración de Permisos por Rol </H2>
<br>
	<div id="resultadosRol">
	
		<fieldset style="border:6px groove #ccc;">
	<legend class="subtitulo" style="font-weight:bold; color:#61380B;">Asignacion de Roles Struts 2</legend>

			<br>
				<s:select list="roles" id="comboRol" listKey="value" listValue="label" label="Lista de Roles" value="label" headerKey="-1" headerValue="Seleccione..."></s:select>
				<br>
					<br>
	</fieldset>	
	
      
      		
		

</div>
<br>
	<div id="resultadoTabla">
	</div>
</body>
</html>
						
