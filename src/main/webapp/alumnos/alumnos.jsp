<%@ include file="/taglibs.jsp"%>
<%@ include file="/headerInclude.jsp"%>

<html>
	<head>
	

<script type="text/javascript">
YPLAD.namespace("Alumnos");


YPLAD.util.Event.onDOMReady(function() {
	  YPLAD.Alumnos.buscaURL = '<s:url action="alumnos" method="buscaUsuarios" includeParams="none" />';
	  YPLAD.Alumnos.guarda = '<s:url action="alumnos" method="guarda" includeParams="none" />';
	  initDtblParametros();
	  initElements();
	  YPLAD.RegistrosDtbl.update();
	  
});
</script>

<script type="text/javascript" src="${ctx}/alumnos/js/alumnos.js?version=${version}"></script>
	</head>
<body class="yui-skin-sam" id="yahoo-com">	
<h1 class="pladnavegacion">CAT&Aacute;LOGO ESTADO</h1>
<s:form theme="simple" cssClass="pladform" id="formEstado" name="formEstado">
 <br/> 
 </s:form>

<form action="" class="pladform">
	<fieldset style="border: 1px solid #BDBDBD; margin: 10px 10px 10px 0px; width: 70%;">
		<legend align="left">Criterios de Busqueda</legend>
 <table>
 	<tr>
 		<td>Cve Alumno:</td>
 		<td><input type="text" id="cveAlumno"></td> 
 	</tr>
	<tr>
		<td>
			Curso:
		</td>
		<td>
			<select id="idCurso">
				<option value="jw">JAVA WEB</option>
				<option value="pl">PL/SQL</option>
			</select>
		</td>
	</tr> 	
 </table>	
<div style="float: left;">
	<button  type="button" id="btnBuscar" name="ignorame" value="ignorame" style="font-size:12px;">Buscar</button>
</div> 
</fieldset>
	
</form> 
 
<s:form theme="simple" cssClass="pladform" id="formDemo">
<fieldset style="border: 1px solid #BDBDBD; margin: 10px 10px 10px 0px; width: 70%;">
   <legend align="left">Registros</legend>

<div style="float: left; position: relative;"> 
<button  type="button" id="NuevoAlumno" name="ignorame" value="ignorame" style="font-size:12px;">Nuevo Alumno</button>
<button  type="button" id="btnGuardar" name="ignorame" value="ignorame" style="font-size:12px;">Guardar</button>
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

<jsp:include page="alumno-dlg.jsp"></jsp:include>
</html>