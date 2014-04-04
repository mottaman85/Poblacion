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
var URL ='/poblacion/Municipios/municipios!busca.action';



	
$(document).ready(function()
		{
			console.log(URL);
			
			$("#consultaBtn").click(buscaMunicipios);
			$("#comboEstados").on('change', buscaMunicipios);
			$("#modificar").click(implementapop);
		
		});
		
		function buscaMunicipios()
		{
			
			$("#resultadoTabla").html("<img alt='' src='/poblacion/images/loader.gif' title='Obteniendo datos'>");
				console.log("Buscando...");
				var dataObj = new Object();
				dataObj["estado"] = $("#comboEstados").val();
				console.log(URL);
				console.log(dataObj.estado);
				$.ajax({
					url : URL,
					data : dataObj,
					type : "post"				
				}).done(function(result){
					$("#resultadoTabla").html(result)
				})
				
		}
		
		
		function implementapop(){
		
			$('element_to_pop_up').bPopup();
		}
		



		
</script>
</head>
<body>

<!-- Sección de Búsqueda de Municipios por estado-->
	<div id="secPrincipala">
				
		<h2>Municipios</h2>		
		<hr>		
		<div id="MunicipioConsulta" class="prueba">		
			<fieldset>
				    <legend>Consultar Municipios por estadol</legend>						
					<div id="MostrarResulta">
                    <s:select id="comboEstados" label="Estados" list="estados"  name="muni.estado" listKey="value" listValue="label"  value="value" headerKey="-1" headerValue="Seleccione"/></td>
						<input type="button" value="consultar" id="consultaBtn">				 
						<br>					
   						<div id="resultadoTabla">
   								 
   						
						</div>				
					</div>
			</fieldset>																								
		</div>
	</div>	
	
	
	<div id ="ModificaMunicipio">
	<fieldset>
	<legend>Editar Municipios</legend>
	<br>
	<table>
			<s:form action="" method="post">							
				<tr>
					<td><label>Clave del municipio:</label> </td>
					<td><input type="text" name="municios2.clave" value="${munimodificar.clave}" disabled></td>				 
				</tr>
				<tr>
					<td><label>Nombre del municipio:</label> </td>
					<td><input type="text" name="municios2.nombre" value="${munimodificar.nombre}" ></td>				 
				</tr>
				<tr>
					<td><label>Secci&oacute;n:</label> </td>
					<td>
						<input type="text" name="municios2.seccion" value=" ${munimodificar.seccion}" />
					</td>				 
				</tr>
				<tr>
					<td><label>Grupo</label></td>
					<td>
					<input type="text" name="municios2.grupo" value="${munimodificar.grupo}"/>
					</td>				 
				</tr>
					<tr>
					<td><label>Estado</label></td>
					<td>
					<input type="text" name="municios2.estado" value="${munimodificar.estado}"/>
					</td>	
								 
				</tr>
				<tr>
					<td><label>Pais</label></td>
					<td>
					<input type="text" name="municios2.pais" value="${munimodificar.pais}"/>
					</td>
				<tr>
					<td></td>
					<td><s:submit value="Guardar Cambios"/></td>
				</tr>																											
			</s:form>
		</table>	
		</fieldset>
	</div>		


	
</body>
</html>















