var YPLADREG = {};
YPLADREG.dtbl = new Object();
YPLADREG.dtbl.detalleInuPep = function(cell, row, col, data) {
	var auxObj = eval(row)._oData;
  if((auxObj.tipoAnalisis == Const.inusuales) || auxObj.confirmado){
  cell.innerHTML = '<input type="image" src="' + YPLAD.ctx + '/yplad/images/edit.gif" value="Detalle" size="21,21" border="0" title = "Detalle" alt="Detalle" onClick="return false;" />';
  }
};

YPLADREG.dtbl.ConfirmaPep = function(cell, row, col, data) {
	if(data == Const.peps){
	  cell.innerHTML = '<input type="image" src="' + YPLAD.ctx + '/yplad/images/edit.gif" value="ConfirmaPEP" size="21,21" border="0" title = "Confirma PEP" alt="Detalle" onClick="return false;" />';
	}
};

YPLADREG.setValId = function(id, value, block){
	try{
		var obj = document.getElementById(id);
			obj.value = undefined == value?'':value;
			
			if(block){
			obj.disabled = true;
			}
	}catch(e){
		alert(id + " : " + e)
	}
};

YPLADREG.cleanForm = function(ids, val){
	for(var i=0; i<ids.length; i++){
		YPLADREG.setValId(ids[i],val);
	}
}

YPLADREG.getDom = function(id){
	return document.getElementById(id);
}

//Constantes para Inusuales
var Const = {};
Const.inusuales = "INU";
Const.peps = "PEP";


YPLADREG.confirmaFns = function(){
	
	try{
		var y =  new YAHOO.widget.SimpleDialog("simpledialog1",  
				             { width: "300px", 
				               fixedcenter: true, 
				               visible: false, 
				               draggable: false, 
				               close: true, 
				               text: "Do you want to continue?", 
				               icon: YAHOO.widget.SimpleDialog.ICON_HELP, 
				               constraintoviewport: true, 
				               buttons: [ { 
				            	   		text:"Yes", 
				            	   		handler:function(){}, 
				            	   		isDefault:true 
				            	   },{ 
				            		    text:"No",
				            		    handler:function(){} 
				            		 	} ] 
				             } ); 
	//result.setHeader("Confirmaci&oacute;n");
    //result.setBody("&iquest;Esta seguro de Guardar los cambios?");
    //result.cfg.setProperty("icon", YPLAD.widget.SimpleDialog.ICON_INFO);
    
    y.show();
    
   
	}catch(e){
		alert(e);
	}
};