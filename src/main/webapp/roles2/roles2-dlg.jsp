 
 
 
 


<div id="AlumnosDlg" style="font-size:12px;font-family:Tahoma;">
	
	<div id="bd" class="bd">
		<form action="" id="alumnoForm" class="pladform">
		<fieldset style="border: 1px solid #BDBDBD; margin: 10px 10px 10px 10px; width: 93%;">
        <legend align="left">Roles</legend>
		<table>
		
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Cve: </label>
			</td>
			<td>
				<input type="text" name="rol.cve_rol" id="rolCve2">
				
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Nombre: </label>
			</td>
			<td>
				<input type="text" name="rol.ds_rol" id="rolDs2" >
				<div class= "errordiv" id="div.cve2" style="color:#FF0000"></div>
				<div class= "errordiv" id="div.cve" style="color:#FF0000"></div>
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


<div id="AlumnosEdit" style="font-size:12px;font-family:Tahoma; style='display:none;'">
	
	<div id="bd" class="bd">
		<form action="" id="rolForm" class="pladform">
		<fieldset style="border: 1px solid #BDBDBD; margin: 10px 10px 10px 10px; width: 93%;">
        <legend align="left">Editar Roles</legend>
		<table>
		
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Cve: </label>
			</td>
			<td>
				<input type="text" name="rol.cve_rol" id="rolCve" disabled>
				<input type="hidden" name="rol.cve_rol" id="rolCvb">
				
				
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Nombre: </label>
			</td>
			<td>
				<input type="text" name="rol.ds_rol" id="rolDs" >
				<div class= "errordiv" id="div.cve3" style="color:#FF0000"></div>
				
			</td>
		</tr>
		
		
		<tr>
		</tr>
		</table>
		</fieldset>
		</form>
		<div style="float: right;">
		<button   type="button" id="GuardarReg2" name="GuardarReg2" value="ignorame2" style="font-size:12px;">Guardar Cambios</button>
		<button  type="button" id="CancelarReg2" name="CancelarReg2" value="ignorame2" style="font-size:12px;">Cancelar</button>
		</div>
	</div>
	
	 
	
</div>




    


