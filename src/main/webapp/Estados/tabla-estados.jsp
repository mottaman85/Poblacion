<%@ taglib prefix="s" uri="/struts-tags"%>
<table border="1">
	<thead>
		<tr>
			<td>Clave Estado</td>
			<td>Nombre Estado</td>
			<td>Edición</td>
		</tr>
	</thead>
	<tbody>
		<s:iterator value="estados" var="est">
			<tr>
				<td>${est.cveEstado}</td>
				<td>${est.nombreEstado}</td>
				<td><s:form action="estado!insEstado.action" method="post">
						<input type="hidden" name="rolvo.cve_rol" id="rolvo.cve_rol"
							value=" <s:property value='#r.cve_rol'/>">
						<input id="edix" type="submit" value="EDITA">
					</s:form></td>
			</tr>
		</s:iterator>
	</tbody>
</table>



