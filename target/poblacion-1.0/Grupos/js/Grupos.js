function initDataTable(){
	YPLAD.TABLA = new YPLAD.Dtbl();
	YPLAD.TABLA.setUrl(YPLAD.Grupos.buscaURL);
	YPLAD.TABLA.setDtblContainer('GruposTablaContenido');
	YPLAD.TABLA.setPgntContainer('GruposPaginacion');
	YPLAD.TABLA.setPgntTotalContainer('GruposTotalRegistros');
	YPLAD.TABLA
			.setFields([ "cve", "des"]);
	
	var columns = [{
		key : "cve",
		label : "CLAVE GRUPO"
	}, {
		key : "des",
		label : "DESCRIPCION"
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
	
}

function limpiaErr() {
	$(".errordiv").text('');
	
}

YPLAD.EditarRegistro = function(record){
	
//	$("#usuarioCve").val(oData.cve);
//	$("#usuarioRol").val(oData.rol);
//	$("#usuarioPass").val(oData.pass);
//	$("#usuarioIP").val(oData.ip);
//	$("#usuarioEstatus").val(oData.estatus);
	
	
	YPLAD.GruoDlg.show()
	
}

YPLAD.guardaClick = function(){
	alert(1);
	limpiaErr();
}
YPLAD.cancelaClick = function(){
	YPLAD.GruoDlg.hide();
	limpiaErr();
}


function init(){
	
	YPLAD.BotonGuarda = new YPLAD.widget.Button("guardaBoton", {
		onclick : {
			fn : YPLAD.guardaClick
		}
	
	});
	
	YPLAD.BotonCancelar = new YPLAD.widget.Button("cancelBoton", {
		onclick : {
			fn : YPLAD.cancelaClick
		}
	
	});
	
	YPLAD.GruoDlg = new YPLAD.widget.Panel("dlgGrupo", {
		width : "35em",
		fixedcenter : "contained",
		visible : false,
		constraintoviewport : true,
		modal : true
	});
	
	YPLAD.GruoDlg.render();
	
	
	
	
}