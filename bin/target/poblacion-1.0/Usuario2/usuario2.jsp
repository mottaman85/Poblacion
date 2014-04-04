<%@ include file="/taglibs.jsp"%>
<%@ include file="/headerInclude.jsp"%>

<html>
<head>

	<script type="text/javascript" src="${ctx}/Usuario2/js/usuariojson.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>USUARIOS</title>
<script type="text/javascript">
YPLAD.namespace("Prueba");
YPLAD.util.Event.onDOMReady(function() {
	  YPLAD.Prueba.buscaURL = '<s:url action="prueba" method="busca" includeParams="none" />';
	  YPLAD.Prueba.guarda = '<s:url action="usuario" method="guarda" includeParams="none" />';
	  YPLAD.Prueba.busqueda='<s:url action="usuario" method="busquedaPorRol" includeParams="none" />';
	  YPLAD.Prueba.updateUser='<s:url action="usuario" method="updateUsuarios" includeParams="none" />';	  
	  initDataTable();
	  initElements();
	  YPLAD.RegistrosDtbl.update();
});
</script>
</head>

<body class="yui-skin-sam" id="yahoo-com">	
<h1 class="pladnavegacion">Usuarios</h1>
  <div id="" align="center">

	<s:form theme="simple" cssClass="pladform" id="formDemo">
	<fieldset style="border: 1px solid #BDBDBD; margin: 10px 10px 10px 0px; width: 70%;">
   	<legend align="left">Registro de usuarios</legend>
   					<br>
   					<br>
   					<div style="position: fixed; float: left;">
					<input type="button" id="nuevoBtn" value="Nuevo"/>
					</div>
					<br>
					<br>
	<div class="plad-dtbl-container">
  		<div class="pgnt-top-izquierda" style="font-size:12px;"></div>
  		<div class="pgnt-top-derecha">	  
    		<div id="PaginacionUsuarios"></div>    
	  	</div>
  		<div class="pgnt-clear"></div>
  		<div class="plad-dtbl" id="dtbl.Cont.Usuarios"></div>
  		<div class="pgnt-bottom-izquierda">
    		<div id="dtbl.Errr.Alumnos">&nbsp;</div>
  		</div>
  		<div class="pgnt-bottom-derecha">
	    	<div id="dtbl.Ttal.Usuarios">0</div>&nbsp;registro (s) encontrado(s)
	    </div>
	  	<div class="pgnt-clear"></div>
	</div>
	</fieldset>
	</s:form>
	</div>
</div>
	<div id="exceptiondiv"></div>	
  	<div id="">  	
  	<s:select id="comboRol" label="Rol" list="roles"  listKey="value" listValue="label"  value="value" headerKey="-1" headerValue="Seleccione"/>
  	<input type="button" id="BuscarBtn" value="Buscar"/>
  	</div>
</body>  
<jsp:include page="modal.jsp"></jsp:include>
<jsp:include page="modalmodificar.jsp"></jsp:include>	
</html>