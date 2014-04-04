<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<script type="text/javascript">
function validar() {
//obteniendo el valor que se puso en el campo text del formulario
   var pwd1=document.getElementById("contrasena").value;
   var pwd2=document.getElementById("confcontrasena").value;
var usuario=document.getElementById("usuario").value;

//la condición
if (usuario.length == 0) {
 	 alert('El campo usuario es obligatorio!');
 return false;
}else if(pwd1.length == 0){
	 alert('La contraseña es obligatoria!');
return false;
}else if(pwd2.length == 0){
	 alert('Es obligatorio confirmar la contraseña!');
return false;
}else if(pwd1!=pwd2){
	 alert("Las contraseñas no coinciden");
		 return false;
}else if(!espacios()){
	alert ("La contraseña no puede contener campos en blanco");
} 
return true;
}

function espacios()
{
	 var pwd1=document.getElementById("contrasena").value;
	 var espacios=false;
	 var i=0;
	 while (!espacios && (i<pwd1.length)) {
		  if (pwd1.charAt(i) == " ")
		      campos = true;
		  cont++;
		}
		 
		if (espacios) {
		  return false;
		}
	return true;
}


</script>

</head>
<body>
	<div id="RecuperarPassword">
		<fieldset>
			<legend class="subtitulo">
				¿Has olvidado tu contraseña?
				<br/>
				<br/>
			</legend>
			
			<form method="POST" action="forgotpassword" onsubmit="return validar()">
				<table> 
					<tr> 
						<td>Usuario:</td> 
						<td><input type="text" id="usuario" name="username" size="25"><td> 
					</tr> 
					<tr> 
						<td>Nueva Contraseña:</td> 
						<td><input type="password" id="contrasena" name="password" size="25"><td> 
					</tr> 
					<tr> 
						<td>Confirmar Contraseña:</td> 
						<td><input type="password" id="confcontrasena" name="confpassword" size="25"><td> 
					</tr>
					<tr><td></td> 
						<td><input type="submit" value="Submit"><td> 
					</tr>
				</table>
			</form>
			
		</fieldset>
		<font color="red">${resultado}</font>
	</div>

</body>
</html>