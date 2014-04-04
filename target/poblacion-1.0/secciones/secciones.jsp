<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<s:url action="secciones/secciones" />

<!-- 
	<div id="formulario">
		<fieldset>
			<form action="/poblacion/SeccionesElectorales" method="get">
				<table>
					<tbody>
						<tr>
							<td>
								<label>Clave Grupo:</label>
							</td>
							<td>
								<input type="text" name="grupo">
							</td>
						</tr>
						<tr>
							<td>
								<label>Clave Secci&oacute;n:</label>
							</td>
							<td>
								<input type="text" name="seccion">
							</td>
						</tr>
						<tr>
							<td>
								<label>Descripci&oacute;n Secci&oacute;n:</label>
							</td>
							<td>
								<input type="text" name="descripcion" >
							</td>
						</tr>
						<tr>
							<td>
								<input type="hidden"  name="desicion" id="desicion" value="inserta">
								<input type="submit" value="Insertar">
							</td>
							<td>
								<input type="reset" value="Limpiar">
							</td>
							<td>
								
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</fieldset>
	</div>

	<div id="secciones">
		<fieldset>
			<form action="/poblacion/SeccionesElectorales">
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
				
			</form>
		</fieldset>
	</div>
-->
</body>
</html>