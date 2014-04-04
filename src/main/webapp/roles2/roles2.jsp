<%@ include file="/taglibs.jsp"%>
<%@ include file="/headerInclude.jsp"%>

<html>
	<head>
	

<script type="text/javascript">
YPLAD.namespace("Alumnos");

YPLAD.util.Event.onDOMReady(function() {
	  YPLAD.Alumnos.buscaURL = '<s:url action="roles2" method="buscaRoles" includeParams="none" />';
	  YPLAD.Alumnos.guarda = '<s:url action="roles2" method="guarda" includeParams="none" />';
	  YPLAD.Alumnos.modifica = '<s:url action="roles2" method="modifica" includeParams="none" />';
	  YPLAD.Alumnos.mostrarRE = '<s:url action="roles2" method="mostrarRE" includeParams="none" />';
	  initDtblParametros();
	  initElements();
	  YPLAD.RegistrosDtbl.update();
	  
});
</script>

<script type="text/javascript" src="${ctx}/roles2/js/roles2.js?version=${version}"></script>
	</head>
<body class="yui-skin-sam" id="yahoo-com">	
<h1 class="pladnavegacion">CAT&Aacute;LOGO ROLES</h1>
<s:form theme="simple" cssClass="pladform" id="formEstado" name="formEstado">
 <br/> 
 </s:form>
 
 
 <div style="position: relative; float: left;">
 	<form action="" id="formCombo">
 	   	 <s:select id="comboEstados" name="clavestado" label="Rol" list="listaEstatus"   listKey="estado" listValue="estado"  value="estado" headerKey="-1" headerValue="Seleccione"/>
 	   	 
 	   	 <button  type="button" id="consultarEst" name="ignorame" value="ignorame" style="font-size:12px;">Consultar</button>
 	</form>
 </div>
 
 
<s:form theme="simple" cssClass="pladform" id="formDemo">
<fieldset style="border: 1px solid #BDBDBD; margin: 10px 10px 10px 0px; width: 70%;">
   <legend align="left">Registros</legend>
   
   
  
 

<div style="float: left; position: relative;"> 
<button  type="button" id="NuevoAlumno" name="ignorame" value="ignorame" style="font-size:12px;">Nuevo Rol</button>
</div>

<div class="plad-dtbl-container">
  <div class="pgnt-top-izquierda" style="font-size:12px;">
  </div>
  <div class="pgnt-top-derecha">
    <div id="dtbl.Pgnt.Alumnos"></div>
  </div>
  <div class="pgnt-clear"></div>
  <div class="plad-dtbl" id="dtbl.Cont.Alumnos"></div>
  <div class="pgnt-bottom-izquierda">
    <div id="dtbl.Errr.Alumnos">&nbsp;</div>
  </div>
  <div class="pgnt-bottom-derecha">
    <div id="dtbl.Ttal.Alumnos">0</div>&nbsp;registro (s) encontrado(s)</div>
  <div class="pgnt-clear"></div>
</div>
</fieldset>
</s:form>

<div id="exceptiondiv"></div>

</body>    

<jsp:include page="roles2-dlg.jsp"></jsp:include>
</html>