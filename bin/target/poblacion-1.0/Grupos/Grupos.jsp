<%@ include file="/taglibs.jsp"%>
<%@ include file="/headerInclude.jsp"%>

<html>
<head>

	<script type="text/javascript" src="${ctx}/Grupos/js/Grupos.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GRUPOS</title>

<script type="text/javascript">
YPLAD.namespace("Grupos");

YPLAD.util.Event.onDOMReady(function() {
	  YPLAD.Grupos.buscaURL = '<s:url action="grupos" method="busca" includeParams="none" />';
	  initDataTable();
	  init();
	  
	  //YPLAD.TABLA.update();
	  
});
</script>

</head>

<body class="yui-skin-sam" id="yahoo-com">	
<br>
<h1 class="pladnavegacion">G R U P O S</h1>
 
<s:form theme="simple" cssClass="pladform" id="formDemo">

		<fieldset style="border: 1px solid #BDBDBD; margin: 10px 10px 10px 200px; width: 70%;">
			<legend align="left">G R U P O S</legend>
			<div style="position: float; float: left;">
				<input type="button" id="nuevoBtn" value="Nuevo" />
			</div>
			
			<div style="position: fixed; float: left;"></div>
			<div class="plad-dtbl-container">
				<div class="pgnt-top-izquierda" style="font-size: 12px;"></div>

				<div class="pgnt-top-derecha">

				<div id="GruposPaginacion"></div>
			</div>
				<div class="pgnt-clear"></div>
				<div class="plad-dtbl" id="GruposTablaContenido"></div>
				<div class="pgnt-bottom-izquierda">
				<div id="dtbl.Errr.Alumnos">&nbsp;</div>
				</div>
				<div class="pgnt-bottom-derecha">
					<div id="GruposTotalRegistros">0</div>
					&nbsp;registro (s) encontrado(s)
				</div>
				<div class="pgnt-clear"></div>
			</div>
			
		</fieldset>

	</s:form>


<div id="exceptiondiv"></div>

<jsp:include page="grupoDlg.jsp"></jsp:include>
</body>  

</html>