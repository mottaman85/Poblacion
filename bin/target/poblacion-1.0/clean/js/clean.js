function initDataTable(){
	
	YPLAD.TABLA = new YPLAD.Dtbl();
	YPLAD.TABLA.setUrl(YPLAD.Clean.buscaURL);
	YPLAD.TABLA.setDtblContainer('CleanTablaContenido');
	YPLAD.TABLA.setPgntContainer('CleanPaginacion');
	YPLAD.TABLA.setPgntTotalContainer('CleanTotalRegistros');
	YPLAD.TABLA
			.setFields([ "cve", "dos", "tres" ]);
	
	var columns = [{
		key : "cve",
		label : "UNO"
	}, {
		key : "dos",
		label : "DOS"
	},{
		key : "tres",
		label : "TRES"
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
			
		} else {
			alert("buttonClickEvent: " + target.value);
		}
	});
	
}