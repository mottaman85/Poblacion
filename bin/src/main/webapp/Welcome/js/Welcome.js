function initDataTable(){
	YPLAD.TABLA = new YPLAD.Dtbl();
	YPLAD.TABLA.setUrl(YPLAD.Welcome.buscaURL);
	YPLAD.TABLA.setDtblContainer('WelcomeTablaContenido');
	YPLAD.TABLA.setPgntContainer('WelcomePaginacion');
	YPLAD.TABLA.setPgntTotalContainer('WelcomeTotalRegistros');
	YPLAD.TABLA
			.setFields([ "cve", "dos", "tres","cuatro" ]);
	
	var columns = [{
		key : "cve",
		label : "CLAVE GRUPO"
	}, {
		key : "dos",
		label : "DESCRIPCION"
	},{
		key : "tres",
		label : "TRES"
	},{
		key : "cuatro",
		label : "CUATRO",
		
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