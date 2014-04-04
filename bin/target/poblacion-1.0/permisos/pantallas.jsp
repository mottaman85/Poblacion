 <%@ taglib prefix="s" uri="/struts-tags"%>
			<fieldset style="border:6px groove #ccc;">
				<legend style="font-weight:bold; color:#61380B;">Administración de Privilegios</legend>
						<br>
			<br>	
					<table width="60%" border="1" "left" cellspacing="0" bordercolor="#000000">
						<thead>
							<tr>
							    <th>Activar</th>
								<th>Pantalla</th>
								<th>Tarea</th>
								
							</tr>
						</thead>
						<tbody>
						
						<s:iterator value="listaPermisos">
   										
 								<P>
 								<tr>
 								    <td align="center"> <input type="checkbox" name="Per"> </td>
								    <td> <s:property value="dsPantalla"/> </td>
								    <td align="center"><select>
								   		 
 										 <option value="I">Insertar</option>
										  <option value="E">Editar</option>
 										 <option value="C" selected>Eliminar</option>
								    
								    </select> </td>
								 
								</tr> 
								 
         						</s:iterator>
						</tbody>
					</table>
						
 								
			<br>
			<br>	
			<br>
		
				
			<button type="submit">Guardar Configuración</button>
</fieldset>
