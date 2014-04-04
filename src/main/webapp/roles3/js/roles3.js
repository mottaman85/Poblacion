function initDtblParametros() {
	
	
	
	YPLAD.RegistrosDtbl = new YPLAD.Dtbl();
	YPLAD.RegistrosDtbl.setUrl(YPLAD.Alumnos.buscaURL);
	YPLAD.RegistrosDtbl.setDtblContainer('dtbl.Cont.Alumnos');
	YPLAD.RegistrosDtbl.setPgntContainer('dtbl.Pgnt.Alumnos');
	YPLAD.RegistrosDtbl.setPgntTotalContainer('dtbl.Ttal.Alumnos');

	YPLAD.RegistrosDtbl
			.setFields([ "cve_rol", "ds_rol", "st_rol"]);
	var columns = [{
		key : "cve_rol",
		label : "CLAVE"
	}, {
		key : "ds_rol",
		label : "Descripcion"
	}, {
		key : "st_rol",
		label : "Descripcion"
	},{
		key : "estadoid",
		label : "EDITAR",
		formatter : YPLAD.Dtbl.detalleFmt

	}];

	YPLAD.RegistrosDtbl.setColumnsDefs(columns);
	// Indicamos el numero de registros por pagina
	YPLAD.RegistrosDtbl.setPgntRecords(10);

	// Indicamos que las columnas del datatable tienen un editor relacionado
	YPLAD.RegistrosDtbl.setEditor(true);

	/**
	 * Se construye el objecto datatable interno con los parametros asignados
	 * previamente
	 */
	YPLAD.RegistrosDtbl.construct();
	
	
	/////////Nuevos cambios por paulino
	
	
	YPLAD.RegistrosDtbl.getPostData = function() {
		try {
			return "&estado=" + $("#comboEstados").val() 
			
		} catch (e) {
			alert("getPostData:" + e.description);
		}
	};
	
	////////////
	
	
	
	
	
	
	YPLAD.RegistrosDtbl.myDataTable.subscribe("buttonClickEvent", function(
			oArgs) {
		var target = oArgs.target;
		var record = this.getRecord(target);
		if (target.value == "Detalle") {
			YPLAD.EditarRegistro(record);
		} else {
			alert("buttonClickEvent: " + target.value);
		}
	});
	
	YPLAD.RegistrosDtbl.myDataTable.subscribe("dynamicDataChange", function(
			oArgs) {
		alert("dynamicDataChange");
	});

}


function limpiaErr(){
	
	$("#rolCve2").val("");
	$("#rolDs2").val("");
	
	$(".errordiv").text('');
	
}

YPLAD.EditarRegistro = function(record){
	var oData = record.getData();
	
    
	
	
	console.log("editabdo..." + oData["cve_rol"]);
	$("#rolCve").val(oData["cve_rol"]);
	$("#rolCvb").val(oData["cve_rol"]);
	$("#rolDs").val(oData["ds_rol"]);
	
	
	//YPLAD.AlumnosDlg.show();
	///	Cambios nieblas
	YPLAD.AlumnosEdit.show();
	
}

YPLAD.NuevoRegClick = function() {
	
	limpiaErr();
	YPLAD.AlumnosDlg.show();
	
	
}



///////++++++++++++++++ cambios por el mayor de los nieblas

YPLAD.guardaReg2 = function(record){
	
	try {
		var formulario = getForm("rolForm");

		var callback = new YPLAD.AsyncCallBack();
		
		callback.processResult = function(messages) {
			if (messages.success) {

				YPLAD.AlumnosEdit.hide();
				YPLAD.RegistrosDtbl.update();
				
			}
		};
		callback.processResultUnsuccess = function(messages) {

		}
			YPLAD.util.Connect.setForm(formulario);
			var request = YPLAD.util.Connect.asyncRequest('POST',
					YPLAD.Alumnos.modifica, callback);


	} catch (x) {
		alert("Fallo al Guardar" + x.descripcion);
	}
	
}



///////////*********************


YPLAD.guardaReg = function(record){
	
	try {
		var formulario = getForm("alumnoForm");

		var callback = new YPLAD.AsyncCallBack();
		callback.processResult = function(messages) {
			if (messages.success) {
                   
				
				YPLAD.AlumnosDlg.hide();error
				
				
			}
		};
		callback.processResultUnsuccess = function(messages) {

		}
		
			YPLAD.util.Connect.setForm(formulario);
			var request = YPLAD.util.Connect.asyncRequest('POST',
					YPLAD.Alumnos.guarda, callback);


	} catch (x) {
		alert("Fallo al Guardar" + x.descripcion);
	}
	
}

YPLAD.cancelaReg = function() {
	limpiaErr();
	YPLAD.AlumnosDlg.hide();
}

YPLAD.cancelaReg2 = function() {
	limpiaErr();
	YPLAD.AlumnosEdit.hide();
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
	
	
	YPLAD.AlumnosDlg = new YPLAD.widget.Panel("AlumnosDlg", {
		width : "35em",
		fixedcenter : "contained",
		visible : false,
		constraintoviewport : true,
		modal : true
	});
	
	limpiaErr();
	YPLAD.AlumnosDlg.render();
	
	
	
	//////////////////nUEVO
	YPLAD.NuevoReg = new YPLAD.widget.Button("GuardarReg2", {
		onclick : {
			fn : YPLAD.guardaReg2
		},
		primary : true
	
	});
	
	
	
	YPLAD.AlumnosEdit = new YPLAD.widget.Panel("AlumnosEdit", {
		width : "35em",
		fixedcenter : "contained",
		visible : false,
		constraintoviewport : true,
		modal : true
	});
	
	YPLAD.AlumnosEdit.render();
	
	
	YPLAD.NuevoEst = new YPLAD.widget.Button("consultarEst", {
		onclick : {
			fn : YPLAD.NuevoEstado
		}

	});
	
	YPLAD.NuevoReg = new YPLAD.widget.Button("CancelarReg2", {
		onclick : {
			fn : YPLAD.cancelaReg2
		}
	});
	
	
}

///////Importante aquí observar como el update() hace su jale

YPLAD.NuevoEstado = function() {
	
	
	YPLAD.RegistrosDtbl.update(); //Revisar aca al pedo que rayos sucede
	
	
	
	
}

