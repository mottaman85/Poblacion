function initDataTable(){
	YPLAD.RegistrosDtbl = new YPLAD.Dtbl();
	YPLAD.RegistrosDtbl.setUrl(YPLAD.Permisos.buscaURL);
	
	YPLAD.RegistrosDtbl.setDtblContainer('PermisosTablaContenido');
	YPLAD.RegistrosDtbl.setPgntContainer('PermisosPaginacion');
	YPLAD.RegistrosDtbl.setPgntTotalContainer('PermisosTotalRegistros');
	YPLAD.RegistrosDtbl.setFields([ "cve", "rol", "pass", "estatus", "ip" ]);

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
YPLAD.RegistrosDtbl.setPgntRecords(10);
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
YPLAD.AlumnosDlg.show();
}

YPLAD.cancelClick = function(){
YPLAD.AlumnosDlg.hide();
}

YPLAD.guardaClick = function(){
try {

var formulario = getForm("usuarioForm");

var callback = new YPLAD.AsyncCallBack();

callback.processResult = function(messages) {
	if (messages.success) {

		YPLAD.AlumnosDlg.hide();
		YPLAD.RegistrosDtbl.update();
		
	}
};

callback.processResultUnsuccess = function(messages) {

}
	YPLAD.util.Connect.setForm(formulario);
	var request = YPLAD.util.Connect.asyncRequest(
			'POST', //TIPO DE PETICION
			YPLAD.permisos.guarda, //URL QUE SE DEBE INVOCAR
			callback //FUNCIONALIDAD QUE SE EJECUTARç DESPUES DE LA INVOCACION
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

YPLAD.AlumnosDlg = new YPLAD.widget.Panel("UsuarioDlg", {
width : "35em",
fixedcenter : "contained",
visible : false,
constraintoviewport : true,
modal : true
});

YPLAD.AlumnosDlg.render();
