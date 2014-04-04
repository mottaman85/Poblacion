package com.curso.estados.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.curso.combos.dao.CombosDaoImpl;
import com.curso.domain.LabelValueBean;
import com.curso.domain.SuperAction;
import com.curso.estados.dao.EstadosDao;
import com.curso.estados.dao.EstadosDaoImpl;
import com.curso.estados.service.EstadosStruts;
import com.curso.estados.service.EstadosStrutsImpl;
import com.curso.estados.vo.EstadosVO;
import com.curso.municipios.service.MunicipioServiceImpl;
import com.curso.municipios.vo.MunicipioVO;
import com.curso.prueba.action.PruebaAction;
import com.curso.usuarios.dao.UsuariosDaoImpl;
import com.curso.usuarios.vo.UsuarioVO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Results({
	@Result(name="success", location="Estados/estados-yui.jsp"),
	@Result(name="encontrado", location="Estados/estados-yui.jsp"),
	@Result(name="stream",location="Estados/estados-yui.jsp")
})
public class EstadosAction extends SuperAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(PruebaAction.class);
	private EstadosVO estado;
	List<LabelValueBean> es = new ArrayList<LabelValueBean>();
	private CombosDaoImpl combo= new CombosDaoImpl();
	private List<EstadosVO> estados = new ArrayList<EstadosVO>();
	protected static final String STREAM = "stream";
	//private java.util.List<LabelValueBean> estados = new ArrayList<LabelValueBean>();
	CombosDaoImpl cestados=new CombosDaoImpl();
	EstadosStruts service;
	String cveEstado;


	public List<EstadosVO> getEstados() {
		return estados;
	}

	public void setEstados(List<EstadosVO> estados) {
		this.estados = estados;
	}

	public String getCveEstado() {
		return cveEstado;
	}

	public void setCveEstado(String cveEstado) {
		this.cveEstado = cveEstado;
	}

	public java.util.List<LabelValueBean> getEs() {
		return es;
	}

	public void setEs(java.util.List<LabelValueBean> es) {
		this.es = es;
	}

	public String execute(){
		service = new EstadosStrutsImpl();
		es = new ArrayList<LabelValueBean>();
		//es=combo.getEstados();
		es=combo.getEstatus();
		
		
		try {
			estados=service.getEstados();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public EstadosVO getEstado() {
		return estado;
	}
	public void setEstado(EstadosVO estado) {
		this.estado = estado;
	}


	EstadosDao dao;
	public String busca(){
		dao = new EstadosDaoImpl();
		Gson gson = new Gson();
		JsonObject messages = new JsonObject();
		boolean success = true;
		try {
			int totalregistros = 10;
			messages.addProperty("totalregistros", totalregistros);
			Map<Object, Object> resultSet = new HashMap<Object, Object>();
			List<Map<Object, Object>> mapResult = new ArrayList<Map<Object, Object>>();
			log.debug("El valor de clave estado es"+ cveEstado);
			List<EstadosVO> lista = dao.getEstadoSel(cveEstado.trim());
			for (EstadosVO obj : lista) {
				log.debug(obj.getCveEstado());
				log.debug(obj.getNombreEstado());
				log.debug(obj.getPais());
				Map<Object, Object> map = new HashMap<Object, Object>();
				map.put("cveEstado", obj.getCveEstado());
				map.put("nombreEstado", obj.getNombreEstado());
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
		dao = new EstadosDaoImpl();
		JsonObject messages = new JsonObject();
		JsonArray divs= new JsonArray();
		boolean success = true;
		try {
			Map<Object, Object> resultSet = new HashMap<Object, Object>();
			log.debug(estado.getCveEstado());
			if(StringUtils.isBlank(estado.getCveEstado())){
				success=false;
				divs.add(getDivYMensaje("div.cve","Debe ingresar algo"));
				divs.add(getDivYMensaje("div.nombre","Debe ingresar algo"));
				
			}
			else if (!StringUtils.isNumeric(estado.getCveEstado())){
				divs.add(getDivYMensaje("div.cve", "Deben ser letras"));
				
			}
			else{
				dao.insertEstados(estado);
			}
			
			resultSet.put("Result", "");
		} catch (Exception e) {
			log.error("error", e);
			messages.addProperty(JSON_EXCEPTION, e.getCause().toString());
			e.printStackTrace();
			success = false;
		} finally {
			messages.add(JSON_DIVS, divs);
			messages.addProperty(JSON_ALERTS, "");
			messages.addProperty(JSON_SUCCESS, success);

			streamIt(messages);
		}
		log.debug(JSON);
		return JSON;
	}


	public String update(){
		//dao = new EstadosDaoImpl();
		service=new EstadosStrutsImpl();
		JsonObject messages = new JsonObject();
		JsonArray divs= new JsonArray();
		log.debug("Clave estado"+estado.getCveEstado().trim());
		boolean success = true;
		try {
			Map<Object, Object> resultSet = new HashMap<Object, Object>();
			if(StringUtils.isBlank(estado.getCveEstado())){
				success=false;
				divs.add(getDivYMensaje("div.cveu","Debe ingresar algo"));
				
			}
			else if (!StringUtils.isNumeric(estado.getCveEstado().trim())){
				log.debug("No es numero");
				divs.add(getDivYMensaje("div.cveu", "Deben ser Números"));
				
			}
			
			else{
			
			service.updateEstados(estado);
			log.debug("Update");
			}
			
			resultSet.put("Result", "");
		} catch (Exception e) {
			log.error("error", e);
			messages.addProperty(JSON_EXCEPTION, e.getCause().toString());
			e.printStackTrace();
			success = false;
		} finally {
			messages.add(JSON_DIVS, divs);
			messages.addProperty(JSON_ALERTS, "");
			messages.addProperty(JSON_SUCCESS, success);

			streamIt(messages);
		}
		log.debug(JSON);
		return JSON;
	}


	EstadosStruts esd;
	public String buscar(){
		
		esd= new EstadosStrutsImpl();
		
		Gson gson = new Gson();
		JsonObject messages = new JsonObject();
		boolean success = true;
		try {
			int totalregistros = 10;
			messages.addProperty("totalregistros", totalregistros);
			
			Map<Object, Object> resultSet = new HashMap<Object, Object>();
			
			List<Map<Object, Object>> mapResult = new ArrayList<Map<Object, Object>>();
			 estados =esd.getEstadoSel(cveEstado.trim());
			for (EstadosVO obj : estados) {
				Map<Object, Object> map = new HashMap<Object, Object>();
					map.put("cveEstado", obj.getCveEstado());
					map.put("nombreEstado", obj.getNombreEstado());
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


	

}
