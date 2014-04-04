 <%@ taglib prefix="s" uri="/struts-tags"%>

 <table border="1">
						<thead>
							<tr>
								<th>Clave Grupo</th>
								<th>Clave Secci&oacute;n</th>
								<th>Descripci&oacute;n Secci&oacute;n</th>
								<th>Edici&oacute;n</th>
							</tr>
						</thead>
						<tbody>
						<s:iterator  value="secciones" var ="secc">
							<tr>														
								<td>${secc.cveGpo}</td>
								<td>${secc.cveSec}</td>
								<td>${secc.desSecc}</td>
								<td>
								<s:form action="/secciones/secciones!recupera.action" method="post">
									<input type="hidden" name="users.clave" id="seccion.clave" value="${secc.clave}">	
									<input type="submit" value="EDITAR">
	 							</s:form>								
							</td>
						</tr>							
					</s:iterator>												
				</tbody>
</table>