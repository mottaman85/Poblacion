package com.curso.municipios.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.curso.combos.dao.CombosDao;
import com.curso.combos.dao.CombosDaoImpl;
import com.curso.domain.LabelValueBean;
import com.curso.domain.SuperAction;
import com.curso.municipios.service.MunicipioService;
import com.curso.municipios.service.MunicipioServiceImpl;
import com.curso.municipios.vo.MunicipioVO;
import com.curso.usuarios.dao.UsuariosDaoImpl;
import com.curso.usuarios.view.UsuariosStruts;
import com.curso.usuarios.vo.UsuarioVO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
@Results({
	@Result(name="success", location="/YUIMunicipios/municipios.jsp")
	
})


public class MunicipiosAction extends SuperAction{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 188474669620137492L;
	private static final Logger log = Logger.getLogger(UsuariosStruts.class);
	@Resource(name="MunicipioService")
	
	private MunicipioService municipios;
	private List<LabelValueBean> secciones;
	private List<LabelValueBean> grupos;
	
	private String clavestado;
	
	private MunicipioVO municipio;
	private List<LabelValueBean> estados;	
	
	public String execute(){
		estados=municipios.getEstados();
		secciones=municipios.getSecciones();
		grupos=municipios.getGrupos();
		return SUCCESS;
	}
	

	public List<LabelValueBean> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<LabelValueBean> grupos) {
		this.grupos = grupos;
	}



	public MunicipioVO getMunicipio() {
		return municipio;
	}

	public void setMunicipio(MunicipioVO municipio) {
		this.municipio = municipio;
	}

	public String getClavestado() {
		return clavestado;
	}

	public void setClavestado(String clavestado) {
		this.clavestado = clavestado;
	}

	public List<LabelValueBean> getEstados() {
		return estados;
	}

	public List<LabelValueBean> getSecciones() {
		return secciones;
	}

	public void setSecciones(List<LabelValueBean> secciones) {
		this.secciones = secciones;
	}

	public void setEstados(List<LabelValueBean> estados) {
		this.estados = estados;
	}


public String busca(){
	
	Gson gson = new Gson();
	JsonObject messages = new JsonObject();
	boolean success = true;
	try {
		int totalregistros = 10;
		messages.addProperty("totalregistros", totalregistros);
		
		Map<Object, Object> resultSet = new HashMap<Object, Object>();
		
		List<Map<Object, Object>> mapResult = new ArrayList<Map<Object, Object>>();
		
		log.debug("El valor de la clave edel estado es"+clavestado);
		List<MunicipioVO> lista = municipios.getMunicipios(clavestado.trim());
		
		for (MunicipioVO obj : lista) {
			Map<Object, Object> map = new HashMap<Object, Object>();
				map.put("clave", obj.getClave());
				map.put("nombre", obj.getNombre());
				map.put("seccion", obj.getSeccion());
				map.put("grupo", obj.getGrupo());
				map.put("estado", obj.getEstado());
				map.put("pais", obj.getPais());
			mapResult.add(map);
		}

		resultSet.put("Result", mapResult);
		messages.add("ResultSet", gson.toJsonTree(resultSet));
	} catch (Exception e) {
		log.error("error", e);
		success = false;
	} finally {
		messages.addProperty(JSON_DIVS, "");
		messages.addProperty(JSON_ALERTS, "");
		messages.addProperty(JSON_SUCCESS, success);
		
		streamIt(messages);
	}
	return JSON;
	}
 

public String guarda(){
	JsonObject messages = new JsonObject();
	JsonArray divs=new JsonArray();
	boolean success = true;
	try {
		
		Map<Object, Object> resultSet = new HashMap<Object, Object>();
	
	//if(municipios.getClave(municipio.getClave()))
	//{success=false;
	//divs.add(getDivYMensaje("div.cve","Clave duplicada!...Ingrese otra clave"));	
	//}else 
	if(StringUtils.isBlank(municipio.getClave())){
		success=false;
		divs.add(getDivYMensaje("div.cve","La clave es obligatoria!"));
	}else if(!StringUtils.isNumeric(municipio.getClave()))
	{
		divs.add(getDivYMensaje("div.cve","La clave debe ser un número!"));
		success=false;
	}
	
	if(StringUtils.isBlank(municipio.getNombre())){
		success=false;
		divs.add(getDivYMensaje("div.nombre","El nombre es obligatorio!"));
	}else if(StringUtils.isNumeric(municipio.getNombre()))
	{
		divs.add(getDivYMensaje("div.nombre","No se permiten números!"));
		success=false;
	}
	
	if(municipio.getEstado().equals("-1")){
		divs.add(getDivYMensaje("div.estado","Seleciona un estado!"));
		success=false;
	}
	if(municipio.getSeccion().equals("-1"))
		municipio.setSeccion("");
    if(municipio.getGrupo().equals("-1"))
       municipio.setGrupo("");
	
    if(success){
		municipios.setMunnicipio(municipio); 
		log.debug("municipio guardado");
	}
	
		resultSet.put("Result", "");
		
	} catch (Exception e) {
		log.error("error", e);
		messages.addProperty(JSON_EXCEPTION, e.getCause().toString());
		e.printStackTrace();
		success = false;
	} finally {
		messages.add(JSON_DIVS,divs);
		messages.addProperty(JSON_ALERTS, "");
		messages.addProperty(JSON_SUCCESS, success);
		streamIt(messages);
	}
	return JSON;
}


public String actualiza(){
	JsonObject messages = new JsonObject();
	JsonArray divs=new JsonArray();
	boolean success = true;
     
	try {
		
		Map<Object, Object> resultSet = new HashMap<Object, Object>();
		
		if(StringUtils.isBlank(municipio.getClave())){
			success=false;
			divs.add(getDivYMensaje("divE.cve","La clave es obligatoria!"));
		}else if(!StringUtils.isNumeric(municipio.getClave()))
		{
			divs.add(getDivYMensaje("divE.cve","La clave debe ser un número!"));
			success=false;
		}
		
		if(StringUtils.isBlank(municipio.getNombre())){
			success=false;
			divs.add(getDivYMensaje("divE.nombre","El nombre es obligatorio!"));
		}else if(StringUtils.isNumeric(municipio.getNombre()))
		{
			divs.add(getDivYMensaje("divE.nombre","No se permiten números!"));
			success=false;
		}
		
		if(municipio.getEstado().equals("-1")){
			divs.add(getDivYMensaje("divE.estado","Seleciona un estado!"));
			success=false;
		}
		if(municipio.getSeccion().equals("-1"))
			municipio.setSeccion("");
	    if(municipio.getGrupo().equals("-1"))
	       municipio.setGrupo("");
	    if(success){
	        log.debug("Dastos modificados");
			municipios.updateMunicipio(municipio); 
		}
		
		
		
		resultSet.put("Result", "");
		
	} catch (Exception e) {
		log.error("error", e);
		messages.addProperty(JSON_EXCEPTION, e.getCause().toString());
		e.printStackTrace();
		success = false;
	} finally {
		messages.add(JSON_DIVS,divs);
		messages.addProperty(JSON_ALERTS, "");
		messages.addProperty(JSON_SUCCESS,success);
		streamIt(messages);
	}
	return JSON;
}


	
}
