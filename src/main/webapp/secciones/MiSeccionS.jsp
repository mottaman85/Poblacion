<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="/poblacion/js/core/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="/poblacion/js/plugins/bpop.js"></script>
	
	<style type="text/css">
		.prueba{
		
			background-color: black;
			color: white;
			
		}
	</style>
	<s:url action="secciones" method="buscaSecc"/>
	<script type="text/javascript">
	
		//var URLBUSCA = '/poblacion/secciones/secciones!buscaSecc.action';
		var URLBUSCA ='<s:url action="secciones" method="buscaSecc"/>';
		$(document).ready(function(){
			console.log(URLBUSCA);
			
			$("#consultaBtn").click(buscaSecciones);
			$("#comboRol").on('change', buscaSecciones);
		
		});
		
		function buscaSecciones(){
			
			$("#resultadoTabla").html("<img alt='' src='/poblacion/images/loading.gif' title='Estoy cargando'>");
				console.log("Buscando...");
				var dataObj = new Object();
				dataObj.cveGpo = $("#seleccioneGrupo").val();
				
				$.ajax({
					url : URLBUSCA,
					data : dataObj,
					type : "post"				
				}).done(function(result){
					$("#resultadoTabla").html(result)
				})
				
			}
		
	</script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Secciones Electorales</title>
</head>
<body>
	<h2>Secciones</h2>		
	<hr>		
		<div id="SeccionConsulta" class="prueba">		
		<fieldset>
			<legend>Consultar Secciones</legend>						
				<div id="MostrarResult">
						<select value="seleccioneGrupo">
							<option value="">Seleccione</option>
								<s:iterator  value="grupos" var="r">
									<option  value="<s:property value="#{r.value}"/>" >
									<s:property value="#r.value"/> - <s:property value="#r.label"/>
									</option>
								</s:iterator>
						</select>	
					<input type="button" value="consultar" id="consultaBtn">	
					<!--  			 
					<input type="button" value="consultar" class="prueba" id="pruebaClass">
					-->	
				<br>
				<label> Secciones</label>				
				<hr>
					<div id="resultadoTabla">
					</div>				
				</div>
		</fieldset>																								
	</div>
	<!-- 
	<div id="secciones">
		<fieldset>
			<s:form action="/secciones/secciones">
				<table>
					<thead>
						<tr>
							<th>
								Cve. Grupo
							</th>
							<th>
								Cve. Secci&oacute;n
							</th>
							<th>
								Descripici&oacute;n Secci&oacute;n
							</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="secciones" var="r">
							<tr>
								<s:textfield value="<s:property value='{#r.value}'/>" >
									<td>
									<s:property value="#r.value"/> - <s:property value="#r.label"/>
									</td>
								</s:textfield>
							</tr>
						</s:iterator>
								
						<c:forEach items="${listaDeSecciones}" var="item">
						<tr>
							<td>
								<input value="${item.cveGpo}" disabled="disabled">	
							</td>
							<td>
								<input value="${item.cveSecc}" disabled="disabled">	
							</td>
							<td>
								<input value="${item.dsSecc}">	
							</td>
							
							<td>
								<input type="hidden" name="desicion" id="desicion" value="actualiza">
								<input type="submit" value="Actualiza">
							</td>
						</tr>
						</c:forEach>
						
					</tbody>
				</table>
				
			</s:form>
		</fieldset>
	<div>
	-->

</body>
</html>