function initDataTable(){
	
	YPLAD.RegistrosDtbl = new YPLAD.Dtbl();
	YPLAD.RegistrosDtbl.setUrl(YPLAD.Prueba.buscaURL);
	
	YPLAD.RegistrosDtbl.setDtblContainer('dtbl.Cont.Usuarios');
	YPLAD.RegistrosDtbl.setPgntContainer('PaginacionUsuarios');
	YPLAD.RegistrosDtbl.setPgntTotalContainer('dtbl.Ttal.Usuarios');

	YPLAD.RegistrosDtbl
			.setFields([ "cve", "rol", "pass", "estatus", "ip" ]);
	
	var columns = [{
		key : "cve",
		label : "CLAVE"
	}, {
		key : "rol",
		label : "ROL"
	},{
		key : "pass",
		label : "PASWORD"
	}, {
		key : "estatus",
		label : "ESTATUS"
	}, {
		key : "ip",
		label : "IP"
	},	{
		key : "cve",
		label : "EDITAR",
		formatter : YPLAD.Dtbl.detalleFmt

	}];

	YPLAD.RegistrosDtbl.setColumnsDefs(columns);
	// Indicamos el numero de registros por pagina
	YPLAD.RegistrosDtbl.setPgntRecords(5);
	/**
	 * Se construye el objecto datatable interno con los parametros asignados
	 * previamente
	 */
	YPLAD.RegistrosDtbl.construct();
	
	YPLAD.RegistrosDtbl.getPostData = function() {
		try {
			return "&cveRol=" + $("#cveBusca").val() + "&estatus=" + $("#estatusBusca").val() 
		} catch (e) {
			alert("getPostData:" + e.description);
		}
	};
	
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

}

function limpiaErr(){
	$("#usuarioCve").val("");
	$("#usuarioCve").val("");
	$("#usuarioCve").val("");
	$(".errordiv").text('');
	
}

YPLAD.buscaClick = function(){
	
	YPLAD.RegistrosDtbl.update();
	
}

YPLAD.EditarRegistro = function(record){
	var oData = record.getData();
	
	
	$("#usuarioCve").val(oData.cve);
	$("#usuarioRol").val(oData.rol);
	$("#usuarioPass").val(oData.pass);
	$("#usuarioIP").val(oData.ip);
	$("#usuarioEstatus").val(oData.estatus);
	
	YPLAD.AlumnosDlg.show();
}

YPLAD.NuevoRegClick = function(){
	limpiaErr();
	YPLAD.AlumnosDlg.show();
}

YPLAD.cancelClick = function(){
	limpiaErr();
	YPLAD.AlumnosDlg.hide();
}

YPLAD.guardaClick = function(){
	
	console.log("Guardando...")
	try {
		var f = getForm("alumnoForm");
		var callback = new YPLAD.AsyncCallBack();

		callback.processResult = function(messages) {
			YPLAD.Roles.DetalleDlg.hide();
		};

		YPLAD.util.Connect.setForm(f);
		YPLAD.showWait();
		var request = YPLAD.util.Connect.asyncRequest('POST',
				YPLAD.Alumnos.guarda, callback);

	} catch (e) {
		alert("DetalleAceptarBtnClick: " + e.description);
	}
}

function initElements(){
	
	YPLAD.NuevoReg = new YPLAD.widget.Button("nuevoBtn", {
		onclick : {
			fn : YPLAD.NuevoRegClick
		}

	});
	YPLAD.BotonCancel = new YPLAD.widget.Button("cancelBoton", {
		onclick : {
			fn : YPLAD.cancelClick
		}
	
	});
	YPLAD.BotonGuarda = new YPLAD.widget.Button("guardaBoton", {
		onclick : {
			fn : YPLAD.guardaClick
		}
	
	});

	YPLAD.BotonBusca = new YPLAD.widget.Button("buscaBtn", {
		onclick : {
			fn : YPLAD.buscaClick
		},
		label : PROTOTIPO.btnBusca
	
	});
	
	YPLAD.AlumnosDlg = new YPLAD.widget.Panel("UsuarioDlg", {
		width : "35em",
		fixedcenter : "contained",
		visible : false,
		constraintoviewport : true,
		modal : true
	});
	
	YPLAD.AlumnosDlg.render();
	
}