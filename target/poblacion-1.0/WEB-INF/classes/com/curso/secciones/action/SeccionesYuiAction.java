package com.curso.secciones.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.curso.domain.SuperAction;
import com.curso.prueba.action.PruebaAction;
import com.curso.secciones.dao.SeccionesDao;
import com.curso.secciones.dao.SeccionesDaoImpl;
import com.curso.secciones.vo.SeccionesVO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Results({
	@Result(name="success", location="/secciones/seccionesyui.jsp")
})
public class SeccionesYuiAction extends SuperAction{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7716634711077812447L;

	//UsuariosDao dao;
	SeccionesDao dao;
	
	private static final Logger log = Logger.getLogger(PruebaAction.class);
	
	public String execute(){
		return SUCCESS;
	}
	
	public String busca(){
		dao = new SeccionesDaoImpl();
		Gson gson = new Gson();
		JsonObject messages = new JsonObject();
		boolean success = true;
		try {
			int totalregistros = 10;
			messages.addProperty("totalregistros", totalregistros);
			
			Map<Object, Object> resultSet = new HashMap<Object, Object>();
			
			List<Map<Object, Object>> mapResult = new ArrayList<Map<Object, Object>>();
			
			List<SeccionesVO> lista = dao.getSecciones();
			
			for (SeccionesVO obj : lista) {
				Map<Object, Object> map = new HashMap<Object, Object>();
					
					map.put("cveGpo", obj.getCveGpo());
					map.put("cveSec", obj.getCveSecc());
					map.put("desSec", obj.getDsSecc());
					
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
		boolean success = true;
		try {
			Map<Object, Object> resultSet = new HashMap<Object, Object>();
			
			
			
			resultSet.put("Result", "");
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
