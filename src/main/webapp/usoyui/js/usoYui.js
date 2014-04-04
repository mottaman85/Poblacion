function initDataTable(){
	YPLAD.TABLA = new YPLAD.Dtbl();
	YPLAD.TABLA.setUrl(YPLAD.usoyui.buscaURL);
	YPLAD.TABLA.setDtblContainer('CleanTablaContenido');
	YPLAD.TABLA.setPgntContainer('CleanPaginacion');
	YPLAD.TABLA.setPgntTotalContainer('CleanTotalRegistros');
	YPLAD.TABLA
			.setFields([ "cve", "dos", "tres" ]);
	
	var columns = [{
		key : "cve",
		label : "CLAVE GRUPO"
	}, {
		key : "dos",
		label : "CLAVE SECCION"
	},{
		key : "tres",
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
	
}