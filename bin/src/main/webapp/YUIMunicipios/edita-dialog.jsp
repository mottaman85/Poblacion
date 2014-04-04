<%@ include file="/taglibs.jsp"%>
<div id="MunicipioEdita" style="font-size:12px;font-family:Tahoma;">
	
	<div id="bd" class="bd">
		<form action="" id="EditaMunicipioForm" class="pladform">
		<fieldset style="border: 1px solid #BDBDBD; margin: 10px 10px 10px 10px; width: 93%;">
        <legend align="left">Municipio</legend>
		<table>
		
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Clave: </label>
			</td>
			<td>
				<input disabled="disabled" type="text" name="municipio" id="usuarioClavefalsa">
		        <input  type="hidden" name="municipio.clave" id="usuarioCve1">
		        <div class= "errordiv" id="divE.cve" style="color:#FF0000;font-family:Georgia"></div>
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Nombre: </label>
			</td>
			<td>
				<input type="text" name="municipio.nombre" id="usuarioNombre1">
				<div class= "errordiv" id="divE.nombre" style="color:#FF0000;font-family:Georgia"></div>
			</td>
		</tr>
		<tr>
			<td>
 	   	 		<s:select id="comboSecciones1" name="municipio.seccion" label="Secciones" list="secciones"   listKey="value" listValue="label"  value="value" headerKey="-1" headerValue="Seleccione"/>
			</td>
		</tr>
		<tr>
			<td>
 	   	 		<s:select id="comboGrupos1" name="municipio.grupo" label="Grupos" list="grupos"   listKey="value" listValue="label"  value="value" headerKey="-1" headerValue="Seleccione"/>
			</td>
		</tr>
		<tr>
			<td>
 	   	 		<s:select id="comboEstados1" name="municipio.estado" label="Estados" list="estados"   listKey="value" listValue="label"  value="value" headerKey="-1" headerValue="Seleccione"/>
			</td>
		</tr>
		<tr>
		    <td>
		    </td>
			<td>
			<div class= "errordiv" id="divE.estado" style="color:#FF0000;font-family:Georgia"></div>
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Pais: </label>
			</td>
			<td>
				<select name="municipio.pais" id="municipioPais1">
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
		<button   type="button" id="modificarBoton" name="GuardarReg" value="ignorame" style="font-size:12px;">Guardar Modificaciones</button>
		<button  type="button" id="cancelaBoton" name="CancelarReg" value="ignorame" style="font-size:12px;">Cancelar</button>
		</div>
	</div>
	
</div>