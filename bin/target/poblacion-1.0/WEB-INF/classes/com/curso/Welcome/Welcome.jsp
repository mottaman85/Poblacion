<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<script type="text/javascript">
function Roles(){
	alert ("ok");
	//location.href ="/poblacion/index.jsp"

}
</script>
<body bgcolor="#3CB371">

<center>
<h2 class="titulo">W E L C O M E</h2>
<hr>
	
		<div>
			<fieldset>
				<legend class="subtitulo"> MENU </legend>

				<table>
					<tr>
						<td><input type="button" value="SEGURIDAD"></input></td>
						<td><input type="button" value="USUARIOS"></input></td>
						<td><input type="button" value="ROLES" onclick="Roles();"></input></td>
						<td><input type="button" value="PERMISOS"></input></td>
						<td><input type="button" value="MODULOS"></input></td>
					</tr>
				</table>

			</fieldset>

		</div>

		<div>
			<fieldset>
				<legend>Menu 2</legend>

				<table>
					<td><a href="/poblacion/">SEGURIDAD</a></td>
					<th></th>
					<td><a href="/poblacion/index.jsp">USUARIOS</a></td>
					<th></th>
					<td><a href="/poblacion/ROLES">ROLES</a></td>
					<th></th>
					<td><a href="/poblacion/index.jsp">PERMISOS</a></td>
					<th></th>
					<td><a href="/poblacion/index.jsp">MODULOS</a></td>

				</table>

			</fieldset>
		</div>
		
			<div>
			<fieldset>
				<legend>Menu 3</legend>

				<table>
					<td><select>
							<option>
								<a href="/poblacion/index.jsp">SEGURIDAD</a>
							</option>
							<option>
							<a href="/poblacion/index.jsp">USUARIOS</a>
							<option>
							<a href="/poblacion/index.jsp">ROLES</a>
							</option>
							<option>
							<a href="/poblacion/index.jsp">PERMISOS</a>
							</option>
					</select></td>

				</table>

			</fieldset>
		</div>

	</center>
	
	

</body>
</html>