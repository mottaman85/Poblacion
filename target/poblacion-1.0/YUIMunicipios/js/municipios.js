function initDataTable(){
	
	YPLAD.TABLA = new YPLAD.Dtbl();
	YPLAD.TABLA.setUrl(YPLAD.Prueba.buscaURL);
	
	YPLAD.TABLA.setDtblContainer('dtbl.Cont.Usuarios');
	YPLAD.TABLA.setPgntContainer('PaginacionUsuarios');
	YPLAD.TABLA.setPgntTotalContainer('dtbl.Ttal.Usuarios');

	YPLAD.TABLA.setFields(["clave","nombre","seccion", "grupo","estado", "pais" ]);
	var columns = [{
		key : "clave",
		label : "CLAVE"
	},{
		key : "nombre",
		label : "NOMBRE"
	},{
		key : "seccion",
		label : "SECCION"
	},{
		key : "grupo",
		label : "GRUPO"
	},{
		key : "estado",
		label : "ESTADO"
	},{
		key : "pais",
		label : "PAIS"
	},	{
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
	
	YPLAD.TABLA.getPostData = function() {
		try {
			return "&clavestado=" + $("#comboEstados").val()
		} catch (e) {
			alert("getPostData:" + e.description);
		}
	};
	
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

}

YPLAD.EditarRegistro = function(record){
	var oData = record.getData();
	$("#usuarioClavefalsa").val(oData.clave);
	$("#usuarioCve1").val(oData.clave);
	$("#usuarioNombre1").val(oData.nombre);
	$("#comboSecciones1").val(oData.seccion);
	$("#comboGrupos1").val(oData.grupo);
	$("#comboEstados1").val(oData.estado);
	$("#municipioPais1").val(oData.pais);
	YPLAD.EditarMunicipiosDlg.show();
}


function limpiaErr(){
	$("#usuarioCve").val("");
	$("#usuarioNombre").val("");
	$("#div.cve").val("");
	$("#div.nombre").val("");
	$("#div.estado").val("");
	$(".errordiv").text('');
}



YPLAD.NuevoRegClick = function(){
	limpiaErr();
	YPLAD.MunicipiosDlg.show();
}

YPLAD.cancelClick = function(){
	limpiaErr();
	YPLAD.MunicipiosDlg.hide();
}


YPLAD.cancelEditaClick = function(){
	limpiaErr();
	YPLAD.EditarMunicipiosDlg.hide();
}


YPLAD.EditarClick = function(){
	try {
		
		//se obtiene el formularios
		var formulario = getForm("EditaMunicipioForm");
		
		//SE EJECUTA DEPUES DE HACER LA INVOCACION AJAX
		var callback = new YPLAD.AsyncCallBack();
		
		callback.processResult = function(messages) {
			if (messages.success) {

				YPLAD.EditarMunicipiosDlg.hide();
				YPLAD.TABLA.update();
				
			}else{
				YPLAD.EditarMunicipiosDlg.hide();
				alert("Ocurrio un error  " + exception);
			}
		};
		
		callback.processResultUnsuccess = function(messages) {}
			
		
		YPLAD.util.Connect.setForm(formulario);
		
		
		var request = YPLAD.util.Connect.asyncRequest(
					'POST', //TIPO DE PETICION
					YPLAD.Prueba.actualizaMuni, //URL QUE SE DEBE INVOCAR
					callback //FUNCIONALIDAD QUE SE EJECUTAR
					);


	} catch (x) {
		alert("Fallo al Aactualizar" + x.descripcion);
	}
}


YPLAD.guardarClick = function(){
	try {
		
		//se obtiene el formularios
		var formulario = getForm("municipioForm");
		
		//SE EJECUTA DEPUES DE HACER LA INVOCACION AJAX
		var callback = new YPLAD.AsyncCallBack();
		
		callback.processResult = function(messages) {
			if (messages.success) {

				YPLAD.MunicipiosDlg.hide();
				YPLAD.TABLA.update();
				
			}else{
				YPLAD.MunicipiosDlg.hide();
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


	} catch (x) {
		alert("Fallo al Guardar" + x.descripcion);
	}
}

YPLAD.BuscarRegClick=function(){

	YPLAD.TABLA.update();
	console.debug("buscando....");

}


function initElements(){
	
	YPLAD.BuscarReg = new YPLAD.widget.Button("buscarBtn", {
		onclick : {
			fn : YPLAD.BuscarRegClick
		}

	});
	
	
	YPLAD.NuevoReg = new YPLAD.widget.Button("NuevoBtn", {
		onclick : {
			fn : YPLAD.NuevoRegClick
			
		}

	});
	
	
	YPLAD.BotonGuardar = new YPLAD.widget.Button("guardarBoton", {
		onclick : {
			fn : YPLAD.guardarClick
		}
	
	});
	
	YPLAD.BotonEditar = new YPLAD.widget.Button("modificarBoton", {
		onclick : {
			fn : YPLAD.EditarClick
		}
	
	});
	
	
	YPLAD.BotonCancel = new YPLAD.widget.Button("cancelarBoton", {
		onclick : {
			fn : YPLAD.cancelClick
		}
	
	});
	
	
	YPLAD.BotonCancelar = new YPLAD.widget.Button("cancelaBoton", {
		onclick : {
			fn : YPLAD.cancelEditaClick
		}
	
	});
	
	
	
	YPLAD.MunicipiosDlg = new YPLAD.widget.Panel("UsuarioDlg", {
		width : "35em",
		fixedcenter : "contained",
		visible : false,
		constraintoviewport : true,
		modal : true
	});
	
	YPLAD.EditarMunicipiosDlg = new YPLAD.widget.Panel("MunicipioEdita", {
		width : "35em",
		fixedcenter : "contained",
		visible : false,
		constraintoviewport : true,
		modal : true
	});
	
	YPLAD.MunicipiosDlg.render();
	YPLAD.EditarMunicipiosDlg.render();
	
}