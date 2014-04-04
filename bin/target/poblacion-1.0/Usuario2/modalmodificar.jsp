<%@ include file="/taglibs.jsp"%>
<div id="ModificaUsuario" style="font-size:12px;font-family:Tahoma;">
	<div id="bd" class="bd">
		<form action="" id="usuarioForm2" class="pladform">
		<fieldset style="border: 1px solid #BDBDBD; margin: 10px 10px 10px 10px; width: 93%;">
        <legend align="left">Modificar Usuario</legend>
		<table>
		
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Cve: </label>
			</td>
			<td>
				<input type="text" name="usuario.clave" id="usuarioCve2" >
				<div class="errordiv" id="divclave" style='color:red'></div>
			</td>
		</tr>
		<tr>
			<td>
				<s:select name="usuario.rol" id="comboRol2" label="Rol" list="roles"  listKey="value" listValue="label"  value="value" headerKey="01" headerValue="Seleccione"/>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<div class="errordiv" id="divpesroles2" style='color:red'></div>
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Password: </label>
			</td>
			<td>
				<input type="text" name="usuario.pass" id="usuarioPass2">
				<div class="errordiv" id="divpass" style='color:red'></div>
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Estatus: </label>
			</td>
			<td>
				<select name="usuario.estatus" id="usuarioEstatus2">
					<option value="-1">Seleccione</option>
					<option value="a">Activo</option>
					<option value="i">Inactivo</option>
				</select>
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<div class="errordiv" id="divpestatus" style='color:red'></div>
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Ip: </label>
			</td>
			<td>
				<input type="text" name="usuario.ip" id="usuarioIP2">
				<div class="errordiv" id="divip" style='color:red'></div>
			</td>
		</tr>		
		<tr>
			<td></td>
			<td><div class="errordiv" id="divconfirma2" style='color:red'></div></td>
		</tr>
		</table>
		</fieldset>
		</form>
		<div style="float: right;">
		<button   type="button" id="CambiosBoton" name="GuardarReg" value="ignorame" style="font-size:12px;">Guardar Cambios</button>
		<button  type="button" id="cancelBoton2" name="CancelarReg" value="ignorame" style="font-size:12px;">Cancelar</button>
		</div>
	</div>
	
</div>
