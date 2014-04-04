<%@ include file="/taglibs.jsp"%>
<div id=Estadosupd style="font-size:12px;font-family:Tahoma;">
	<div id="bd" class="bd">
		<form action="" id="EstadoFormUDP" class="pladform">
		<fieldset style="border: 1px solid #BDBDBD; margin: 10px 10px 10px 10px; width: 93%;">
        <legend align="left">Editar Estado</legend>
		<table>
		
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Clave Estado: </label>
			</td>
			<td>
				<input type="text" name="estado.cveEstado" id="estadoC">
				<div class="diverr" id="div.cveu" style="color:FF0000"></div>
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Nombre Estado: </label>
			</td>
			<td>
				<input type="text" name="estado.nombreEstado" id="estadoN">
				<div class="diverr" id="div.nombreu" style="color:FF0000"></div>
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Estatus: </label>
			</td>
			<td>
				<select name="estado.Pais" id="estatusE">
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
		<button   type="button" id="guardaBotonCambios" name="GuardarReg" value="ignorame" style="font-size:12px;">Guardar Cambios</button>
		<button  type="button" id="cancelBotonCambios" name="CancelarReg" value="ignorame" style="font-size:12px;">Cancelar</button>
		</div>
	</div>
	
</div>
