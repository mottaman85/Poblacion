<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<% 	
	String user= request.getParameter("user");
	session.setAttribute("datosusuario",user);
	%>
	<div id="resultadosRol">
		<h2>Sesion iniciada</h2>
	</div>
</body>
</html>