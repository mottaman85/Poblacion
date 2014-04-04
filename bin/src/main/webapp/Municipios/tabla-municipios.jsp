 <%@ taglib prefix="s" uri="/struts-tags"%>

 <table border="1">
						<thead>
							<tr>
								<th>Clave Municipio</th>
								<th>Nombre</th>
								<th>Secci&oacute;n</th>
								<th>Grupo</th>
								<th>Estado</th>
								<th>Pa&iacute;s</th>
								<th>Editar</th>
							</tr>
						</thead>
						<tbody>
						<s:iterator  value="municipios" var ="usr">
							<tr>														
								<td>${usr.clave}</td>
								<td>${usr.nombre}</td>
								<td>${usr.seccion}</td>
								<td>${usr.grupo}</td>
								<td>${usr.estado}</td>	
								<td>${usr.pais}</td>
								<td>
								<s:form action="" method="post">
									<input type="hidden" name="municio.clave" id="users.clave" value="${usr.clave}">	
									<input type="submit" value="Editar">
	 							</s:form>
	 							</td>
						</tr>							
					</s:iterator>												
				</tbody>	
</table>