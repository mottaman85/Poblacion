<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<script type="text/javascript" src="<%=request.getContextPath()%>/js/core/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
	
		$(document).ready(function(){
			$("#valid").click(function(){
				
				
				$.ajax({
					url : "test.json",
					dataType : "json"
				}).done(function(res){
					
					console.log(res.campoUno)				
					console.log(res.campoDos)				
					
				})
				
			})
		})
	
	</script>
</head>
<body>
<div>
	<fieldset>
	<legend>
	</legend>
    <form id="form" action="LOGIN" method="get"> 
    	<label>Usuario</label>
    	<br>
        <input type="text" name="usuario" id="usuario"/>
        <br>
        <label>Contraseña</label>
        <br>
        <input type="password" name="password" id="password">
        <br>
        <button type="submit"> Iniciar sesión </button>
        <br>
        <a href="/PASSWORD">Olvido su contraseña</a>
    </form>
    </fieldset>
    
    <input id="campoUno" type="text">
    <input id="campoDos" type="text">
    
    
    <input type="button" id="valida">
</div>
</body>
</html>