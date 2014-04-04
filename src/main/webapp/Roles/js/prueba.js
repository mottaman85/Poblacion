function initDataTable(){
	YPLAD.RegistrosDtbl = new YPLAD.Dtbl();
	YPLAD.RegistrosDtbl.setUrl(YPLAD.Clean.buscaURL);
	YPLAD.RegistrosDtbl.setDtblContainer('CleanTablaContenido');
	YPLAD.RegistrosDtbl.setPgntContainer('CleanPaginacion');
	YPLAD.RegistrosDtbl.setPgntTotalContainer('CleanTotalRegistros');
	YPLAD.RegistrosDtbl
			.setFields([ "ClaveRol", "DsRol", "Estatus" ]);
	
	var columns = [{
		key : "uno",
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
	YPLAD.RegistrosDtbl.setColumnsDefs(columns);
	// Indicamos el numero de registros por pagina
	YPLAD.RegistrosDtbl.setPgntRecords(5);
	/**
	 * Se construye el objecto datatable interno con los parametros asignados
	 * previamente
	 */
	YPLAD.RegistrosDtbl.construct();
	
}