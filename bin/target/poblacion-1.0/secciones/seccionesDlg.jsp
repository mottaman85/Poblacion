<div id="SeccionesDlg" style="font-size:12px;font-family:Tahoma;">
	
	<div id="bd" class="bd">
		<form action="" id="alumnoForm" class="pladform">
		<fieldset style="border: 1px solid #BDBDBD; margin: 10px 10px 10px 10px; width: 93%;">
        <legend align="left">Secciones</legend>
		<table>
		
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Cve Grupo: </label>
			</td>
			<td>
				<select value="seleccioneGrupo">
					<option value="">Seleccione</option>
						<s:iterator  value="grupos" var="r">
							<option  value="<s:property value="#{r.value}"/>" >
							<s:property value="#r.value"/> - <s:property value="#r.label"/>
							</option>
						</s:iterator>
				</select>
				<!-- <input type="text" name="seccion.cveGpo" id="seccionCveGpo"> -->
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Cve Secci&oacute;n: </label>
			</td>
			<td>
				<input type="text" name="seccion.cveSec" id="seccionCveSec" >
			</td>
		</tr>
		<tr>
			<td style="padding: 0px;width:173px;">
				<label>Descripci&oacute;n Secci&oacute;n: </label>
			</td>
			<td>
				<input type="text" name="seccion.desSec" id="seccionDes">
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
