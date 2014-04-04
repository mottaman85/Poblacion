<%@ taglib prefix="s" uri="/struts-tags"%>
<style type="text/css">


.container {width: 960px; margin: 0 auto; overflow: hidden;}

#content {	float: left; width: 100%;}

.post { margin: 0 auto; padding-bottom: 50px; float: left; width: 960px; }


.login-popup{
	display:none;
	background: #333;
	padding: 10px; 	
	border: 2px solid #ddd;
	float: left;
	font-size: 1.2em;
	position: fixed;
	top: 50%; left: 50%;
	z-index: 99999;
	box-shadow: 0px 0px 20px #999;
	-moz-box-shadow: 0px 0px 20px #999; /* Firefox */
    -webkit-box-shadow: 0px 0px 20px #999; /* Safari, Chrome */
	border-radius:3px 3px 3px 3px;
    -moz-border-radius: 3px; /* Firefox */
    -webkit-border-radius: 3px; /* Safari, Chrome */
}

img.btn_close {
	float: right; 
	margin: -28px -28px 0 0;
}

fieldset { 
	border:none; 
}

form.signin .textbox label { 
	display:block; 
	padding-bottom:7px; 
}

form.signin .textbox span { 
	display:block;
}

form.signin p, form.signin span { 




.button:hover { background:#ddd; }

</style>




<script type="text/javascript">

	var URLEDITA = 'roles!EditarRegistro.action';

	$(document).ready(function(){
		console.log(URLBUSCA);
		
		$("#confedit").click(EditarRoles);
		
	
	});
	
	function EditarRoles(){
		
		
			console.log("Buscando...");
			var dataObj = new Object();
			dataObj.editReg = $("#clave").val();
			dataObj.editReg2 = $("#rol").val();
			
			$.ajax({
				url : URLEDITA,
				data : dataObj,
				type : "post"				
			}).done(function(){
				$("#resultadoTabla").html(result)
			})
			
		}
	
</script>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('a.edix').click(function() {
		document.edicion.clave.value=$("#rolSel").val();
		document.edicion.rol.value=$("#rolSel2").val();
		
		// Getting the variable's value from a link 
		var loginBox = $(this).attr('href');

		//Fade in the Popup and add close button
		$(loginBox).fadeIn(300);
		
		//Set the center alignment padding + border
		var popMargTop = ($(loginBox).height() + 24) / 2; 
		var popMargLeft = ($(loginBox).width() + 24) / 2; 
		
		$(loginBox).css({ 
			'margin-top' : -popMargTop,
			'margin-left' : -popMargLeft
		});
		
		// Add the mask to body
		$('body').append('<div id="mask"></div>');
		$('#mask').fadeIn(300);
		
		return false;
	});
	
	// When clicking on the button close or the mask layer the popup closed
	
});
</script>

<body>

	 
	
	<s:div id="resultadosRol">
		<fieldset>
		<legend class="subtitulo">
		Roles disponibles
		<br/>
		<br/>
		</legend>

			

<table>
				<tbody>
				<s:iterator value="roles" var="r">
					<tr>
						<th>${r.cve_rol}</th>
						<th>${r.ds_rol}</th>

						<th>
						<form>


								<input type="hidden" name="rolvo.cve_rol" id="rolSel"
									value="${r.cve_rol}">
								<input type="hidden" name="rolvo.ds_rol" id="rolSel2"
									value="${r.ds_rol}">
									<a href="#login-box" class="edix">Editar</a>
								
							</form>
							</th>

					</tr>
					</s:iterator>
				</tbody>

</table>



			

		</fieldset>
	</s:div>
	
	
	
	
	<div id="login-box" class="login-popup">
        
        
          <form name="edicion" method="post" class="signin" action="#">
                <fieldset class="textbox">
            	
                <input id="clave" name="clave"  type="text" >
               
                
                
               <input id="rol" name="rol"  type="text" >
         
                <button id="confedit"class="submit button" type="button">Confirmar</button>
                
                
                
                </fieldset>
          </form>
		</div>
    
    
    
		 
		 
	
	</body>
	