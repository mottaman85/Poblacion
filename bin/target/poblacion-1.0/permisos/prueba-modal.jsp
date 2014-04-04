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
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Rol: </label>
			</td>
			<td>
				<input type="text" name="usuario.rol" id="usuarioRol" >
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Password: </label>
			</td>
			<td>
				<input type="text" name="usuario.pass" id="usuarioPass">
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Estatus: </label>
			</td>
			<td>
				<input type="text" name="usuario.estatus" id="usuarioEstatus">
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Ip: </label>
			</td>
			<td>
				<input type="text" name="usuario.ip" id="usuarioIP">
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
