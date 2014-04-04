<%@ include file="/taglibs.jsp"%>
<div id=Estadoslg style="font-size:12px;font-family:Tahoma;">
	<div id="bd" class="bd">
		<form action="" id="EstadoForm" class="pladform">
		<fieldset style="border: 1px solid #BDBDBD; margin: 10px 10px 10px 10px; width: 93%;">
        <legend align="left">Agregar Pa&iacute;s</legend>
		<table>
		
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Clave Estado: </label>
			</td>
			<td>
				<input type="text" name="estado.cveEstado" id="estadoCve">
				<div class="errordiv" id="div.cve" style="color:FF0000"></div>
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Nombre Estado: </label>
				
			</td>
			<td>
				<input type="text" name="estado.nombreEstado" id="estadoNombre">
				<div class="errordiv" id="div.nombre" style="color:FF0000"></div>
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Estatus: </label>
				<select name="estado.pais" isd="pais">
					<option value="1">Activo</option>
					<option value="2">Inactivo</option>
				</select>
			</td>
			
		</tr>
		<tr>
		</tr>
		</table>
		</fieldset>
		</form>
		<div style="float: right;">
		<button   type="button" id="guardaBoton" name="GuardarReg" value="ignorame" style="font-size:12px;">Guardar Cambios</button>
		<button  type="button" id="cancelBoton" name="CancelarReg" value="ignorame" style="font-size:12px;">Cancelar</button>
		</div>
	</div>
	
</div>
