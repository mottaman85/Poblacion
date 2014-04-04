function initDtblParametros() {
	
	try{
	
	this.checkFmt = function (cell,row,col,data) {
		var checked = row.getData("asigPant");
		if (checked == true) {
			cell.innerHTML = '<input type="checkbox" name="ignorame" checked ></input>';
		} else {
			cell.innerHTML = '<input type="checkbox" name="ignorame" ></input>';
		}
	};		
		
	YPLAD.Dtbl.estatusFmt = function(cell, row, col, data) {
		
		var vigencia = row.getData("vigencia");
		if (vigencia == 'N') {
			cell.innerHTML = 'No';
		} else {
				cell.innerHTML = 'Si';
		}
		
	};
	
	
	YPLAD.Alumnos.VigenciaEditor = new YAHOO.widget.DropdownCellEditor( {
		dropdownOptions : PROTOTIPO.VigenciaCatalog,
		disableBtns : false,
		LABEL_SAVE : "Aceptar",
		LABEL_CANCEL : "Cancelar"
	});
	
	
	
	
	
	YPLAD.Alumnos.VigenciaFmt = function(cell, row, col, data) {
		var combo = PROTOTIPO.VigenciaCatalog;
		for ( var i = 0; i < combo.length; i++) {
			if (data == combo[i].value) {
				cell.innerHTML = combo[i].label;
				return;
			}
		}
	};
	
	YPLAD.RegistrosDtbl = new YPLAD.Dtbl();
	YPLAD.RegistrosDtbl.setUrl(YPLAD.Alumnos.buscaURL);
	YPLAD.RegistrosDtbl.setDtblContainer('dtbl.Cont.Alumnos');
	YPLAD.RegistrosDtbl.setPgntContainer('dtbl.Pgnt.Alumnos');
	YPLAD.RegistrosDtbl.setPgntTotalContainer('dtbl.Ttal.Alumnos');

	YPLAD.RegistrosDtbl
			.setFields([ "cve", "nombre", "curso", "vigencia" ]);
	var columns = [{
		key : "cve",
		label : "*",
		formatter : this.checkFmt
	}, {
		key : "cve",
		label : PROTOTIPO.CVE
	}, {
		key : "nombre",
		label : PROTOTIPO.NOMBRE
	},{
		key : "curso",
		label : PROTOTIPO.CURSO
	}, {
		key : "vigencia",
		label : PROTOTIPO.VIGENCIA,
		formatter : YPLAD.Alumnos.VigenciaFmt,
		editor : YPLAD.Alumnos.VigenciaEditor
	},{
		key : "estadoid",
		label : PROTOTIPO.EDITA,
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
	
	YPLAD.RegistrosDtbl.getPostData = function() {
		try {
			return "&cveRol=" + $("#cveAlumno").val() 
		} catch (e) {
			alert("getPostData:" + e.description);
		}
	};
	
	}catch(e){
		alert("Error en initDtblParametros: "+e)
	}
}

YPLAD.EditarRegistro = function(record){
	var oData = record.getData();
	console.log("editabdo..." + oData["cve"]);
	
	$("#alumnoCve").val(oData["cve"]);
	$("#alumnoNombre").val(oData["nombre"]);
	$("#alumnoCurso").val(oData["curso"]);
	
	YPLAD.AlumnosDlg.show();
}

YPLAD.NuevoRegClick = function() {
	console.log("nuevoClikc");
	YPLAD.AlumnosDlg.show();
}
YPLAD.guardaReg = function(record){
	console.log("Guardando Man...")
	try {
		var f = getForm("alumnoForm");
		
		var callback = new YPLAD.AsyncCallBack();
		callback.processResult = function(messages) {
			YPLAD.AlumnosDlg.hide();	
		};
		

		YPLAD.util.Connect.setForm(f);
		YPLAD.showWait();
		var request = YPLAD.util.Connect.asyncRequest('POST',
				YPLAD.Alumnos.guarda, callback);

	} catch (e) {
		alert("DetalleAceptarBtnClick: " + e.description);
	}
	
}

function clean(){
	$(".errordiv").text('');
}

YPLAD.cancelaReg = function() {
	clean();
	YPLAD.AlumnosDlg.hide();
}

YPLAD.buscarBtn = function(){
	YPLAD.RegistrosDtbl.update();
}

function initElements(){
	
	YPLAD.NuevoReg = new YPLAD.widget.Button("NuevoAlumno", {
		onclick : {
			fn : YPLAD.NuevoRegClick
		},
		label : PROTOTIPO.btnNuevo
	});

	YPLAD.NuevoReg = new YPLAD.widget.Button("btnGuardar", {
		onclick : {
		},
		type: 'primary',
		label : PROTOTIPO.btnGuarda
	
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

	YPLAD.NuevoReg = new YPLAD.widget.Button("btnBuscar", {
		onclick : {
			fn : YPLAD.buscarBtn
		},
		label : PROTOTIPO.btnBusca
	});
	
	
	YPLAD.AlumnosDlg = new YPLAD.widget.Panel("AlumnosDlg", {
		width : "35em",
		fixedcenter : "contained",
		visible : false,
		constraintoviewport : true,
		modal : true
	});
	
	YPLAD.AlumnosDlg.render();
	
}