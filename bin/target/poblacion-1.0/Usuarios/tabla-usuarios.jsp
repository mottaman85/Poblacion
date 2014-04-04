 <%@ taglib prefix="s" uri="/struts-tags"%>

 <table border="1">
						<thead>
							<tr>
								<th>Clave Usuario</th>
								<th>Rol</th>
								<th>Password</th>
								<th>Estatus</th>
								<th>Direcci&oacute;n ip</th>
								<th>Edici&oacute;n</th>
							</tr>
						</thead>
						<tbody>
						<s:iterator  value="usuarios" var ="usr">
							<tr>														
								<td>${usr.clave}</td>
								<td>${usr.rol}</td>
								<td>${usr.pass}</td>
								<td>${usr.estatus}</td>
								<td>${usr.ip}</td>	
								<td>
								<s:form action="/Usuarios/usuario!recupera.action" method="post">
									<input type="hidden" name="users.clave" id="users.clave" value="${usr.clave}">	
									<input type="submit" value="EDITAR">
	 							</s:form>								
							</td>
						</tr>							
					</s:iterator>												
				</tbody>
</table>	