function initDataTable(){
	
	YPLAD.RegistrosDtbl = new YPLAD.Dtbl();
	YPLAD.RegistrosDtbl.setUrl(YPLAD.Prueba.buscaURL);
	
	YPLAD.RegistrosDtbl.setDtblContainer('dtbl.Cont.Usuarios');
	YPLAD.RegistrosDtbl.setPgntContainer('PaginacionUsuarios');
	YPLAD.RegistrosDtbl.setPgntTotalContainer('dtbl.Ttal.Usuarios');

	YPLAD.RegistrosDtbl
			.setFields([ "cveEstado", "nombreEstado", "pais" ]);
	
	var columns = [{
		key : "cveEstado",
		label : "Clave Estado"
	}, {
		key : "nombreEstado",
		label : "Nombre Estado"
	},{
		key : "pais",
		label : "Estatus"
	}, 	{
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
			return "&cveEstado=" + $("#usuarioEstatus").val()
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


YPLAD.EditarRegistro = function(record){
	var oData = record.getData();
	$("#estadoC").val(oData.cveEstado);
	$("#estadoN").val(oData.nombreEstado);
	$("#estatusE").val(oData.pais);
	
	YPLAD.AlumnosCon.show();
}

function limpiarErr(){
	$("#estadoCve").val(" ");
	$("#estadoNombre").val(" ");
	$(".errordiv").val(" ");
}

function limpiarErr2(){
	$("#estadoC").val(" ");
	$("#estadoN").val(" ");
	$(".diverr").val(" ");
}


YPLAD.NuevoRegClick = function(){
	limpiarErr();
	YPLAD.AlumnosDlg.show();
}

YPLAD.Buscar= function(){
	YPLAD.RegistrosDtbl.update();
}
YPLAD.cancelClick = function(){
	limpiarErr();
	YPLAD.AlumnosDlg.hide();
}

YPLAD.cancelClickUpd = function(){
	limpiarErr2()
	YPLAD.AlumnosCon.hide();
}


YPLAD.guardaClick = function(){
	try {
		
		//se obtiene el formulario
		var formulario = getForm("EstadoForm");
		
		//SE EJECUTA DEPUES DE HACER LA INVOCACION AJAX
		var callback = new YPLAD.AsyncCallBack();
		callback.processResult = function(messages) {
			if (messages.success) {
				YPLAD.AlumnosDlg.hide();
				YPLAD.RegistrosDtbl.update();
				
			}else{
				YPLAD.AlumnosDlg.hide();
				alert("Ocurrio un error  " + exception);
			}
		};
		
		callback.processResultUnsuccess = function(messages) {}
			
		
		YPLAD.util.Connect.setForm(formulario);
		limpiarErr();
			var request = YPLAD.util.Connect.asyncRequest(
					'POST', //TIPO DE PETICION
					YPLAD.Prueba.guarda, //URL QUE SE DEBE INVOCAR
					callback //FUNCIONALIDAD QUE SE EJECUTAR
					);


	} catch (x) {
		alert("Fallo al Guardar" + x.descripcion);
	}
}

YPLAD.guardaCambClick = function(){
	try {
		//se obtiene el formulario
		var formulario = getForm("EstadoFormUDP");
		//SE EJECUTA DEPUES DE HACER LA INVOCACION AJAX
		var callback = new YPLAD.AsyncCallBack();
		callback.processResult = function(messages) {
			if (messages.success) {
				YPLAD.AlumnosDlg.hide();
				YPLAD.RegistrosDtbl.update();
			}else{
				YPLAD.AlumnosDlg.hide();
				alert("Ocurrio un error  " + exception);
			}
		};
		callback.processResultUnsuccess = function(messages) {}
		YPLAD.util.Connect.setForm(formulario);
		limpiarErr2();
		var request = YPLAD.util.Connect.asyncRequest(
					'POST', //TIPO DE PETICION
					YPLAD.Prueba.update, //URL QUE SE DEBE INVOCAR
					callback //FUNCIONALIDAD QUE SE EJECUTAR
					);


	} catch (x) {
		alert("Fallo al Guardar" + x.descripcion);
	}
}




function initElements(){
	
	YPLAD.NuevoReg = new YPLAD.widget.Button("nuevoBtn", {
		onclick : {
			fn : YPLAD.NuevoRegClick
		}

	});
	YPLAD.NuevoReg = new YPLAD.widget.Button("buscar", {
		onclick : {
			fn : YPLAD.Buscar
		}

	});
	
	YPLAD.BotonCancel = new YPLAD.widget.Button("cancelBoton", {
		onclick : {
			fn : YPLAD.cancelClick
		}
	
	});
	YPLAD.BotonCancelUpd = new YPLAD.widget.Button("cancelBotonCambios", {
		onclick : {
			fn : YPLAD.cancelClick
		}
	
	});
	YPLAD.BotonGuarda = new YPLAD.widget.Button("guardaBoton", {
		onclick : {
			fn : YPLAD.guardaClick
		}
	
	});
	YPLAD.BotonGuardaCamb = new YPLAD.widget.Button("guardaBotonCambios", {
		onclick : {
			fn : YPLAD.guardaCambClick
		}
	
	});
	YPLAD.AlumnosDlg = new YPLAD.widget.Panel("Estadoslg", {
		width : "35em",
		fixedcenter : "contained",
		visible : false,
		constraintoviewport : true,
		modal : true
	});
	
	YPLAD.AlumnosCon = new YPLAD.widget.Panel("Estadosupd", {
		width : "35em",
		fixedcenter : "contained",
		visible : false,
		constraintoviewport : true,
		modal : true
	});
	
	YPLAD.AlumnosDlg.render();
	YPLAD.AlumnosCon.render();
	
}