<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<s:div>
		<fieldset>
		<legend class="subtitulo">
		Iniciar Sesi&oacute;n
		<br/>
		<br/>
		</legend>
			<s:form action="login!conectar.action" method="post">
			<s:textfield name="user" id="user" label="Usuario"/>
			<s:textfield name="pass" id="pass" label="Password"/>
			<s:submit/>
			
			</s:form>
			<s:a href="/poblacion/password/recuperarpwd.action">olvidaste tu contraseņa</s:a>
		</fieldset>
	</s:div>
</body>
</html>