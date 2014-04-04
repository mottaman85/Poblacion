<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<div id="RecuperarPassword">
		<fieldset>
			<legend class="subtitulo">
				¿Has olvidado tu contraseña?
				<br/>
				<br/>
			</legend>			
	<s:form action="/password/password!recuperarPassword.action" method="post">
		
		<s:textfield name="username" id="username" label="Usuario"/>
		<s:password name="password" id="password" label="Nueva Contraseña"/>
		<s:password name="conpassword" id="conpassword" label="Confirmar Contraseña"/>
		<s:submit value="Enviar"/>
		
	</s:form>
	<s:a href="/poblacion/Logeo/regresalogin.action">Regresar</s:a>
  </fieldset>
  <font color="red"><s:property value="resultado"/> </font>
  
  </div>
  </body>
</html>