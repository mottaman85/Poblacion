<%@ include file="/taglibs.jsp"%>
<div id="UsuarioDlg" style="font-size:12px;font-family:Tahoma;">
	<div id="bd" class="bd">
		<form action="" id="usuarioForm" class="pladform">
		<fieldset style="border: 1px solid #BDBDBD; margin: 10px 10px 10px 10px; width: 93%;">
        <legend align="left">Usuario</legend>
		<table>
		
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Cve: </label>
			</td>
			<td>
				<input type="text" name="usuario.clave" id="usuarioCve">
				<div class="errordiv" id="divclave" style='color:red'>Error</div>
			</td>
		</tr>
		<tr>
			<td>
				<s:select name="usuario.rol" id="comboRol" label="Rol" list="roles"  listKey="value" listValue="label"  value="value" headerKey="01" headerValue="Seleccione"/>
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Password: </label>
			</td>
			<td>
				<input type="password" name="usuario.pass" id="usuarioPass">
				<div class="errordiv" id="divpass" style='color:red'>Error</div>
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Estatus: </label>
			</td>
			<td>
				<select name="usuario.estatus" id="usuarioEstatus">
					<option value="a">Activo</option>
					<option value="i">Inactivo</option>
				</select>
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Ip: </label>
			</td>
			<td>
				<input type="text" name="usuario.ip" id="usuarioIP">
				<div class="errordiv" id="divip" style='color:red'></div>
			</td>
		</tr>		
		<tr>
			<td></td>
			<td><div class="errordiv" id="divconfirma" style='color:red'></div></td>
		</tr>
		</table>
		</fieldset>
		</form>
		<div style="float: right;">
		<button   type="button" id="guardaBoton" name="GuardarReg" value="ignorame" style="font-size:12px;">Registrar</button>
		<button  type="button" id="cancelBoton" name="CancelarReg" value="ignorame" style="font-size:12px;">Cancelar</button>
		</div>
	</div>
	
</div>
