package com.curso.grupos.action;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import com.curso.domain.SuperAction;
import com.curso.grupos.dao.GruposDao;
import com.curso.grupos.dao.GruposDaoImpl;
import com.curso.grupos.vo.GruposVO;
import com.curso.usuarios.dao.UsuariosDaoImpl;
import com.curso.usuarios.vo.UsuarioVO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Results({
	@Result(name="success", location="Grupos/Grupos.jsp")
})



public class GruposAction extends SuperAction{
	
	private GruposVO grupos;
	
	public static Logger log = Logger.getLogger(GruposAction.class);
	
	GruposDao dao;
	
	public String execute(){
		
		return SUCCESS;
	}
	
	public String busca(){
		dao = new GruposDaoImpl();
		
		Gson gson = new Gson();
		JsonObject messages = new JsonObject();
		boolean success = true;
		try {
			int totalregistros = 10;
			messages.addProperty("totalregistros", totalregistros);
			
			Map<Object, Object> resultSet = new HashMap<Object, Object>();
			
			List<Map<Object, Object>> mapResult = new ArrayList<Map<Object, Object>>();
			
			List<GruposVO> lista = dao.getGrupos();
			
			for (GruposVO obj : lista) {
				Map<Object, Object> map = new HashMap<Object, Object>();
					
					map.put("cve", obj.getClaveGrupo());
					map.put("des", obj.getDescripcionGrupo());
									
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
		dao = new GruposDaoImpl();
		JsonObject messages = new JsonObject();
		boolean success = true;
		
		JsonArray divs = new JsonArray();
		
		try {
			Map<Object, Object> resultSet = new HashMap<Object, Object>();
			
			if(true){
				success = false;
				divs.add(getDivYMensaje("div.cve","Debe ingresar Algo"));
				
			}
			
			dao.updateGrupos(grupos);
			
			resultSet.put("Result", "");
		} catch (Exception e) {
			log.error("error", e);
			messages.addProperty(JSON_EXCEPTION,e.getCause().toString());
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







