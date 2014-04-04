<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Secciones</title>
</head>
<body>
	<s:div id="insertar">	
		<fieldset>
		<legend class="subtitulo">
			Insertar Secci&oacute;n
		</legend>
			<s:form action="secciones!secciones.action" method="get">
				<table>
					<tbody>
						<tr>
							<s:textfield name="sec.grupo" id="sec.grupo" label="Clave del Grupo"/>
						<tr>
						<tr>
							<s:textfield name="sec.seccion" id="sec.seccion" label="Clave Seccion"/>
						<tr>
						<tr>
							<s:textfield name="sec.descripcion" id="sec.descripcion" label="Descripcion"/>
						<tr>
						<tr>
							<td>
								<s:submit type="submit" value="Insertar"/>
							<td>
							<td>
								<s:reset type="reset" value="Limpiar"/>
							<td>
							<td>
								<input type="hidden" name="desicion" value="inserta">
							<td>
						<tr>
					</tbody>
				</table>
				</s:form>
		</fieldset>
	</s:div>
	<br/>
	<br/>
		<s:div id="secciones">
		<fieldset>
		<legend class="subtitulo">
			Secciones actuales
		</legend>
			<s:form action="secciones!secciones.action" method="get">
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
								<input type="submit" value="Actualiza">
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<input type="hidden" name="desicion" value="actualiza">
			</s:form>
		</fieldset>
	</s:div>

</body>
</html>