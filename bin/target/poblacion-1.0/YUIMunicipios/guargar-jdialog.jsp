<%@ include file="/taglibs.jsp"%>
<div id="UsuarioDlg" style="font-size:12px;font-family:Tahoma;">
	
	<div id="bd" class="bd">
		<form action="" id="municipioForm" class="pladform">
		<fieldset style="border: 1px solid #BDBDBD; margin: 10px 10px 10px 10px; width: 93%;">
        <legend align="left">Municipio</legend>
		<table>
		
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Clave: </label>
			</td>
			<td>
				<input type="text" name="municipio.clave" id="usuarioCve">
				<div class= "errordiv" id="div.cve" style="color:#FF0000;font-family:Georgia"></div>
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Nombre: </label>
			</td>
			<td>
				<input type="text" name="municipio.nombre" id="usuarioNombre">
				<div class= "errordiv" id="div.nombre" style="color:#FF0000;font-family:Georgia"></div>
			</td>
		</tr>
		<tr>
			<td>
 	   	 		<s:select id="comboSecciones" name="municipio.seccion" label="Secciones" list="secciones"   listKey="value" listValue="label"  value="value" headerKey="-1" headerValue="Seleccione"/>
			</td>
		</tr>
		<tr>
			<td>
 	   	 		<s:select id="comboGrupos" name="municipio.grupo" label="Grupos" list="grupos"   listKey="value" listValue="label"  value="value" headerKey="-1" headerValue="Seleccione"/>
			</td>
		</tr>
		<tr>
			<td>
 	   	 		<s:select id="comboEstados" name="municipio.estado" label="Estados" list="estados"   listKey="value" listValue="label"  value="value" headerKey="-1" headerValue="Seleccione"/>
				
			</td>
		</tr>
		<tr>
		    <td>
		    </td>
			<td>
			<div class= "errordiv" id="div.estado" style="color:#FF0000;font-family:Georgia"></div>
			</td>
		</tr>
			
		
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Pais: </label>
			</td>
			<td>
				<select name="municipio.pais" id="municipioPais">
					<option value="1">México</option>
				</select>
			</td>
		</tr>
		<tr>
		</tr>
		</table>
		</fieldset>	
		</form>
		<div style="float: right;">
		<button   type="button" id="guardarBoton" name="GuardarRegistros" value="ignorame" style="font-size:12px;">Guardar Cambios</button>
		<button  type="button" id="cancelarBoton" name="CancelarRegitros" value="ignorame" style="font-size:12px;">Cancelar</button>
		</div>
	</div>
	
</div>