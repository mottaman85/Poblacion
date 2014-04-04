<%@ include file="/taglibs.jsp"%>
<%@ include file="/headerInclude.jsp"%>

<html>
<head>

	<script type="text/javascript" src="${ctx}/YUIMunicipios/js/municipios.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MUNICIPIOS</title>

<script type="text/javascript">
YPLAD.namespace("Prueba");

YPLAD.util.Event.onDOMReady(function() {
	  YPLAD.Prueba.buscaURL = '<s:url action="municipios" method="busca" includeParams="none" />';
	  YPLAD.Prueba.busca = '<s:url action="municipios" method="buscar" includeParams="none" />';
	  YPLAD.Prueba.guarda ='<s:url action="municipios" method="guarda" includeParams="none" />';
	  YPLAD.Prueba.actualizaMuni ='<s:url action="municipios" method="actualiza" includeParams="none" />';
	  initDataTable();
	  initElements();
	  YPLAD.TABLA.update();
	  
});
</script>

</head>

<body class="yui-skin-sam" id="yahoo-com">	
<h1 class="pladnavegacion">Municipios</h1>
 
<s:form theme="simple" cssClass="pladform" id="formDemo">
<fieldset style="border: 1px solid #BDBDBD; margin: 10px 10px 10px 0px; width: 70%;">
   <legend align="left">Registros</legend>
 <div style="position: relative; float: left;">
 	   	 <s:select id="comboEstados" name="clavestado" label="Estados" list="estados"   listKey="value" listValue="label"  value="value" headerKey="-1" headerValue="Seleccione"/>
 </div>
<div style="position:relative; float: left;">
	<input type="button" id="buscarBtn" value="Buscar">
</div>

<div style="position:relative; float: left;">
	<input type="button" id="NuevoBtn" value="Nuevo">
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
<jsp:include page="guargar-jdialog.jsp"></jsp:include>
<jsp:include page="edita-dialog.jsp"></jsp:include>
</html>