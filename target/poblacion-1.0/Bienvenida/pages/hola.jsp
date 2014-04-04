<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Bienvenido <s:property value="nombre"/> </h1>
</body>

	<s:url action="/Bienvenida/bienvenida" method="person"></s:url>

	<s:select list="roles" listKey="value" listValue="label" key="value" value="label" headerKey="" headerValue="Seleccione"></s:select>

						
						<select>
							<option value="">Seleccione</option>
							<s:iterator value="roles" var="r">
								
								<option value="<s:property value="#{r.value}"/>">
									<s:property value="#r.value"/> - <s:property value="#r.label"/>
								</option>
									
							</s:iterator>
						</select>	
						
	<s:form action="/Bienvenida/bienvenida!person.action" method="post">
		
		<s:textfield  name="usuario.clave" id="usuario.clave" label="Cve"/>
		<s:textfield name="usuario.rol" id="usuario.rol" label="Rol"/>
		<s:textfield name="usuario.ip" id="usuario.ip" label="IP"/>
		
		<s:submit value="Enviar"/>
		
	</s:form>

</html>