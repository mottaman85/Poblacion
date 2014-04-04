<div id="AlumnosDlg" style="font-size:12px;font-family:Tahoma;">
	
	<div id="bd" class="bd">
		<form action="" id="alumnoForm" class="pladform">
		<fieldset style="border: 1px solid #BDBDBD; margin: 10px 10px 10px 10px; width: 93%;">
        <legend align="left">Alumnos</legend>
		<table>
		
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Cve: </label>
			</td>
			<td>
				<input type="text" name="alumno.cve" id="alumnoCve">
				<div class="errordiv" id="div.cve" style="color: #FF0000"></div>
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Nombre: </label>
			</td>
			<td>
				<input type="text" name="alumno.nombre" id="alumnoNombre" >
				<div class="errordiv" id="div.nombre" style="color: #FF0000"></div>
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Curso: </label>
			</td>
			<td>
				<input type="text" name="alumno.curso" id="alumnoCurso">
				<div class="errordiv" id="div.curso" style="color: #FF0000"></div>
			</td>
		</tr>
		
		<tr>
		</tr>
		</table>
		</fieldset>
		</form>
		<div style="float: right;">
		<button   type="button" id="GuardarReg" name="GuardarReg" value="ignorame" style="font-size:12px;">Guardar Cambios</button>
		<button  type="button" id="CancelarReg" name="CancelarReg" value="ignorame" style="font-size:12px;">Cancelar</button>
		</div>
	</div>
	
</div>
