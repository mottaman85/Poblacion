function clearSelectCombo(id){
	$(id)
    .find('option')
    .remove()
    .end();
    
	$(id).append('<option value="">Seleccione...</option>');
}


function llenaSelect(id, arrayOptions){
	clearSelect(id, true);
	if(arrayOptions){
	$.each(arrayOptions, function(i, item){
		 $(id).append($('<option>', { 
		        value: item.value,
		        text : item.label 
		    })
		    );
	});
	}
}