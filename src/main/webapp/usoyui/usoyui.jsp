<%@ include file="/taglibs.jsp"%>
<%@ include file="/headerInclude.jsp"%>

<html>
	<head>
	
		<script type="text/javascript" src="${ctx}/usoyui/js/usoYui.js"></script>
	
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>PRUEBA</title>
			
			<script type="text/javascript">
			YPLAD.namespace("usoyui");
			
			YPLAD.util.Event.onDOMReady(function() {
				  YPLAD.usoyui.buscaURL = '<s:url action="prueba" method="busca" includeParams="none" />';
				  initDataTable();
				YPLAD.TABLA.update();  
			});
		</script>
	
	</head>

<body class="yui-skin-sam" id="yahoo-com">	
<h1 class="pladnavegacion">Usuarios</h1>
 
<s:form theme="simple" cssClass="pladform" id="formDemo">
<fieldset style="border: 1px solid #BDBDBD; margin: 10px 10px 10px 0px; width: 70%;">
   <legend align="left">Registros</legend>
<div style="position: fixed; float: left;">

</div>
<div class="plad-dtbl-container">
  <div class="pgnt-top-izquierda" style="font-size:12px;">
  </div>



  <div class="pgnt-top-derecha">
  
    <div id="CleanPaginacion"></div>
    
  </div>
  <div class="pgnt-clear"></div>
  <div class="plad-dtbl" id="CleanTablaContenido"></div>
  <div class="pgnt-bottom-izquierda">
    <div id="dtbl.Errr.Alumnos">&nbsp;</div>
  </div>
  	<div class="pgnt-bottom-derecha">
    	<div id="CleanTotalRegistros">0</div>&nbsp;registro (s) encontrado(s)</div>
  	<div class="pgnt-clear"></div>
</div>
	</fieldset>

</s:form>

<div id="exceptiondiv"></div>

</body>  

</html>