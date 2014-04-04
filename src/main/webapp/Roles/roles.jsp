<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="/poblacion/js/core/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/poblacion/js/plugins/bpop.js"></script>


<title>Insert title here</title>

<script type="text/javascript">

	var URLBUSCA = 'roles!buscar.action';

	$(document).ready(function(){
		console.log(URLBUSCA);
		
		$("#consultaBtn").click(buscaRoles);
		$("#comboRol").on('change', buscaRoles);
	
	});
	
	function buscaRoles(){
		
		$("#resultadoTabla").html("<img alt='' src='/poblacion/images/loading.gif' title='Estoy cargando'>");
			console.log("Buscando...");
			var dataObj = new Object();
			dataObj.selEstado = $("#comboRol").val();
			
			$.ajax({
				url : URLBUSCA,
				data : dataObj,
				type : "post"				
			}).done(function(result){
				$("#resultadoTabla").html(result)
			})
			
		}
	
</script>

<script>
$(document).ready(function(){
  $("#abIns").click(function(){
    $("#formIns").show(1000);
  });
  $("#insertarRol").click(function(){
    $("#formIns").hide(1000);
  });

});
</script>


<script type="text/javascript">

	var URLINS = 'roles!insNewRol.action';

	$(document).ready(function(){
		console.log(URLINS);
		
		$("#insertarRol").click(insertaRoles);
		
	
	});
	
	function insertaRoles(){
		
		$("#resultadoTabla").html("<img alt='' src='/poblacion/images/loading.gif' title='Estoy cargando'>");
			console.log("Insertando...");
			var dataObj = new Object();
			
			dataObj.insCve = $("#ncve").val();
			dataObj.insDs = $("#nds").val();
			dataObj.insSta = $("#nsta").val();
			
			$.ajax({
				url : URLINS,
				data : dataObj,
				type : "post"				
			}).done(function(result){
				
				
				$("#resultadoTabla").html(result)
			})
			
		}
	
</script>




</head>
<body>


	<h2>Roles</h2>		
	<hr>		
		<div id="RolesConsulta" class="prueba">		
		<fieldset>
			<legend>Consultar Roles</legend>						
				<div id="MostrarResult">
                <s:select id="comboRol" label="Rol" list="listaEstatus"  name="users2.rol" listKey="estado" listValue="estado"  value="estado" headerKey="-1" headerValue="Seleccione"/></td>
                 <input type="button" value="consultar" id="consultaBtn">

				 
			 
				
					<div id="resultadoTabla">
					
					</div>				
				</div>
		</fieldset>																								
	</div>

					

		
		
		
		


<input type="button" value="Insertar Roles" id="abIns">

<div id="formIns" style='display:none;'>
           <fieldset>
			<legend class="subtitulo">
				Insertar roles <br /> <br />
			</legend>
			
			
			<form  >
            Clv Rol:<input id="ncve" type="text" value="" name="rolvo.cve_rol">
				<br>
            New Rol:<input id="nds"  type="text" value="" name="rolvo.ds_rol">
				<br>
				
			Status:<input id="nsta" type="text" value="" name="rolvo.st_rol">
			<br>
			
			<input type="button" value="confirmar" id="insertarRol">
			</form>
			
		 </fieldset>



	</div>
	
	
	
	
	
	



</body>
</html>