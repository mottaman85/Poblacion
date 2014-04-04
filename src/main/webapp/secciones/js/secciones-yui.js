function initDataTable(){
	YPLAD.TABLA = new YPLAD.Dtbl();
	YPLAD.TABLA.setUrl(YPLAD.seccionesyui.buscaURL);
	YPLAD.TABLA.setDtblContainer('CleanTablaContenido');
	YPLAD.TABLA.setPgntContainer('CleanPaginacion');
	YPLAD.TABLA.setPgntTotalContainer('CleanTotalRegistros');
	YPLAD.TABLA
			.setFields([ "cveGpo", "cveSec", "desSec" ]);
	
	var columns = [{
		key : "cveGpo",
		label : "CLAVE GRUPO"
	}, {
		key : "cveSec",
		label : "CLAVE SECCION"
	},{
		key : "desSec",
		label : "SECCION"
	},{
		key : "cve",
		label : "EDITAR",
		formatter : YPLAD.Dtbl.detalleFmt

	}];
	YPLAD.TABLA.setColumnsDefs(columns);
	// Indicamos el numero de registros por pagina
	YPLAD.TABLA.setPgntRecords(5);
	/**
	 * Se construye el objecto datatable interno con los parametros asignados
	 * previamente
	 */
	YPLAD.TABLA.construct();
	
	YPLAD.TABLA.myDataTable.subscribe("buttonClickEvent", function(
			oArgs) {
		var target = oArgs.target;
		var record = this.getRecord(target);
		if (target.value == "Detalle") {
			YPLAD.EditarRegistro(record);
		} else {
			alert("buttonClickEvent: " + target.value);
		}
	});
	
	YPLAD.TABLA.myDataTable.subscribe("dynamicDataChange", function(
			oArgs) {
		alert("dynamicDataChange");
	});
	
}



YPLAD.EditarRegistro = function(record){
	var oData = record.getData();
	console.log("editabdo..." + oData["cve"]);
	
	$("#seccionCveGpo").val(oData["cve"]);
	$("#seccionCveSec").val(oData["seccion"]);
	$("#seccionDes").val(oData["descripcion"]);
	
	YPLAD.SeccionesDlg.show();
}

YPLAD.NuevoRegClick = function() {
	console.log("nuevoClikc");
	YPLAD.SeccionesDlg.show();
}
YPLAD.guardaReg = function(record){
	
	try {
		var formulario = getForm("alumnoForm");

		var callback = new YPLAD.AsyncCallBack();
		callback.processResult = function(messages) {
			if (messages.success) {

				YPLAD.AlumnosDlg.hide();
				YPLAD.RegistrosDtbl.update();
				
			}
		};
		callback.processResultUnsuccess = function(messages) {

		}
			YPLAD.util.Connect.setForm(formulario);
			var request = YPLAD.util.Connect.asyncRequest('POST',
					YPLAD.Secciones.guarda, callback);


	} catch (x) {
		alert("Fallo al Guardar" + x.descripcion);
	}
	
}

YPLAD.cancelaReg = function() {
	YPLAD.SeccionesDlg.hide();
}

function initElements(){
	
	YPLAD.NuevoReg = new YPLAD.widget.Button("NuevoAlumno", {
		onclick : {
			fn : YPLAD.NuevoRegClick
		}

	});
	YPLAD.NuevoReg = new YPLAD.widget.Button("GuardarReg", {
		onclick : {
			fn : YPLAD.guardaReg
		},
		primary : true
	
	});
	YPLAD.NuevoReg = new YPLAD.widget.Button("CancelarReg", {
		onclick : {
			fn : YPLAD.cancelaReg
		}
	});
	
	
	YPLAD.SeccionesDlg = new YPLAD.widget.Panel("SeccionesDlg", {
		width : "35em",
		fixedcenter : "contained",
		visible : false,
		constraintoviewport : true,
		modal : true
	});
	
	YPLAD.SeccionesDlg.render();
	
}