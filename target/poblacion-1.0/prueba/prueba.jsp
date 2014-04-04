<%@ include file="/taglibs.jsp"%>
<%@ include file="/headerInclude.jsp"%>

<html>
<head>

	<script type="text/javascript" src="${ctx}/prueba/js/prueba.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PRUEBA</title>

<script type="text/javascript">
YPLAD.namespace("Prueba");

YPLAD.util.Event.onDOMReady(function() {
	  YPLAD.Prueba.buscaURL = '<s:url action="prueba" method="busca" includeParams="none" />';
	  YPLAD.Prueba.guarda = '<s:url action="prueba" method="guarda" includeParams="none" />';
	  initDataTable();
	  initElements();
});
</script>

</head>

<body class="yui-skin-sam" id="yahoo-com">	
<h1 class="pladnavegacion">Usuarios</h1>
 
<s:form theme="simple" cssClass="pladform" id="formDemo">
<fieldset style="border: 1px solid #BDBDBD; margin: 10px 10px 10px 0px; width: 70%;">
   <legend align="left">Registros</legend>
<div style="position: fixed; float: left;">
	<input type="button" id="nuevoBtn" value="Nuevo"/>
</div>
<div class="plad-dtbl-container">
  <div class="pgnt-top-izquierda" style="font-size:12px;">
  </div>



  <div class="pgnt-top-derecha">
  
    <div id="PaginacionUsuarios"></div>
    
  </div>
  <div class="pgnt-clear"></div>
  <div class="plad-dtbl" id="dtbl.Cont.Usuarios"></div>
  <div class="pgnt-bottom-izquierda">
    <div id="dtbl.Errr.Alumnos">&nbsp;</div>
  </div>
  	<div class="pgnt-bottom-derecha">
    	<div id="dtbl.Ttal.Usuarios">0</div>&nbsp;registro (s) encontrado(s)</div>
  	<div class="pgnt-clear"></div>
</div>
	</fieldset>

</s:form>

<div id="exceptiondiv"></div>

</body>  
<jsp:include page="prueba-modal.jsp"></jsp:include>

</html>