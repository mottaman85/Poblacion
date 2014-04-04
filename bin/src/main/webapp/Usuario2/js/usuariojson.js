function initDataTable(){
	
	YPLAD.RegistrosDtbl = new YPLAD.Dtbl();
	YPLAD.RegistrosDtbl.setUrl(YPLAD.Prueba.busqueda);
	
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

	YPLAD.RegistrosDtbl.getPostData = function() {
		try {
			return "&claverol=" + $("#comboRol").val()
		} catch (e) {
			alert("getPostData:" + e.description);
		}
	};
	
	
}

function limpiaErr()
{
	$(".errordiv").text('');
}

YPLAD.EditarRegistro = function(record){
	var oData = record.getData();
	
	limpiaErr();
	$("#usuarioCve2").val(oData.cve);
	$("#usuarioRol2").val(oData.rol);
	$("#usuarioPass2").val(oData.pass);
	$("#usuarioIP2").val(oData.ip);
	$("#usuarioEstatus2").val(oData.estatus);
	YPLAD.EditarUsuario.show();
}

YPLAD.NuevoRegClick = function(){
	limpiaErr();
	YPLAD.AlumnosDlg.show();
}

YPLAD.cancelClick = function(){
	limpiaErr();
	YPLAD.AlumnosDlg.hide();		
}
//boton de cancelación para la edición de usuarios
YPLAD.cancelEdicionClick = function(){
	limpiaErr();		
	YPLAD.EditarUsuario.hide();
}

YPLAD.guardaClick = function(){
	try {
		
		//se obtiene el formulario
		var formulario = getForm("usuarioForm");
		
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
		
			var request = YPLAD.util.Connect.asyncRequest(
					'POST', //TIPO DE PETICION
					YPLAD.Prueba.guarda, //URL QUE SE DEBE INVOCAR
					callback //FUNCIONALIDAD QUE SE EJECUTAR
					);
			$("#usuarioCve").val("");
			$("#usuarioRol").val("");
			$("#usuarioPass").val("");
			$("#usuarioIP").val("");
			$("#usuarioEstatus").val("");	
			limpiaErr();
	} catch (x) {
		alert("Fallo al Guardar..." + x.descripcion);
	}		
}

YPLAD.Buscar = function()
{
	
	YPLAD.RegistrosDtbl.update();

}

//Pop up de editar
YPLAD.guardaCambiosClick = function(){
	try {
		
		//se obtiene el formulario
		var formulario = getForm("usuarioForm2");
		
		//SE EJECUTA DEPUES DE HACER LA INVOCACION AJAX
		var callback = new YPLAD.AsyncCallBack();
		callback.processResult = function(messages) {
			if (messages.success) {

				YPLAD.EditarUsuario.hide();
				YPLAD.RegistrosDtbl.update();
				
			}else{
				YPLAD.EditarUsuario.hide();
				alert("Ocurrio un error  " + exception);
			}
		};
		
		callback.processResultUnsuccess = function(messages) {}
			
		
		YPLAD.util.Connect.setForm(formulario);
		
			var request = YPLAD.util.Connect.asyncRequest(
					'POST', //TIPO DE PETICION
					YPLAD.Prueba.updateUser, //URL QUE SE DEBE INVOCAR
					callback //FUNCIONALIDAD QUE SE EJECUTAR
					);
			$("#usuarioCve2").val("");
			$("#usuarioRol2").val("");
			$("#usuarioPass2").val("");
			$("#usuarioIP2").val("");
			$("#usuarioEstatus2").val("");	
			limpiaErr();
	} catch (x) {
		alert("Fallo al guardar editar..." + x.descripcion);
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
	
	YPLAD.BotonCancel2 = new YPLAD.widget.Button("cancelBoton2", {
		onclick : {
			fn : YPLAD.cancelEdicionClick
		}
	
	});
	
	YPLAD.BotonGuarda = new YPLAD.widget.Button("guardaBoton", {
		onclick : {
			fn : YPLAD.guardaClick
		}
	
	});
	
	YPLAD.BotonBusca = new YPLAD.widget.Button("BuscarBtn", {
		onclick : {
			fn : YPLAD.Buscar
		}
	
	});
	
	YPLAD.AlumnosDlg = new YPLAD.widget.Panel("UsuarioDlg", {
		width : "35em",
		fixedcenter : "contained",
		visible : false,
		constraintoviewport : true,
		modal : true
	});

	
	YPLAD.BotonGuardaCambios = new YPLAD.widget.Button("CambiosBoton", {
		onclick : {
			fn : YPLAD.guardaCambiosClick
		}
	
	});
	
	
	YPLAD.EditarUsuario = new YPLAD.widget.Panel("ModificaUsuario", {
		width : "35em",
		fixedcenter : "contained",
		visible : false,
		constraintoviewport : true,
		modal : true
	});
	
	YPLAD.AlumnosDlg.render();
	YPLAD.EditarUsuario.render();	
}