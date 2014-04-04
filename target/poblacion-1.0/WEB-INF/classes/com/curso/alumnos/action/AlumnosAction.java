package com.curso.alumnos.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.curso.alumnos.service.AlumnosService;
import com.curso.alumnos.service.AlumnosServiceImpl;
import com.curso.alumnos.vo.AlumnosVO;
import com.curso.domain.SuperAction;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Results({
	@Result(name="success", location="alumnos/alumnos.jsp"),
	@Result(name = "stream", type = "stream", params = { "contentType",
			"application/json; charset=utf-8", "inputName", "inputStream" })
})
public class AlumnosAction extends SuperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8106195352385474645L;

	private static final String CVE_DIV = "div.cve";
	private static final String CVE_NOMBRE = "div.nombre";
	private static final String CVE_CURSO = "div.curso";
	protected static final String STREAM = "stream";

	private AlumnosVO alumno;
	
	private AlumnosService service;
	
	
	Logger log = Logger.getLogger(AlumnosAction.class);
	
	public String execute(){
		log.debug("dentro de exce");
		
		return SUCCESS;
	}
	
	public String guarda(){
		JsonArray div = new JsonArray();
		JsonObject messages = new JsonObject();
		boolean success = true;
		try {
			
			log.debug(alumno);
			
			
			if(false){
				success = false;
				div.add(getDivYMensaje(CVE_DIV, "cve valida"));
				div.add(getDivYMensaje(CVE_NOMBRE, "nombre mensaje"));
				div.add(getDivYMensaje(CVE_CURSO, "Curso invalido"));
			}
			
		} catch (Exception e) {
			log.error("error", e);
			success = false;
		} finally {
			messages.add(JSON_DIVS, div);
			messages.addProperty(JSON_ALERTS, "");
			messages.addProperty(JSON_SUCCESS, success);
			
			streamIt(messages);
		}
		return STREAM;
		
	}
	
	public String buscaUsuarios(){
		Gson gson = new Gson();
		JsonObject messages = new JsonObject();
		boolean success = true;
		try {
			int totalregistros = 10;
			messages.addProperty("totalregistros", totalregistros);
			
			Map<Object, Object> resultSet = new HashMap<Object, Object>();
			
			List<Map<Object, Object>> mapResult = new ArrayList<Map<Object, Object>>();
			service = new AlumnosServiceImpl();
			List<AlumnosVO> lista = service.buscaUsuarios();
			
			for (AlumnosVO obj : lista) {
				Map<Object, Object> map = new HashMap<Object, Object>();
					
					map.put("cve", obj.getCve());
					map.put("nombre", obj.getNombre() + " " + obj.getApellido());
					map.put("curso", obj.getCurso());
					map.put("vigencia", "S");
					
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
		return STREAM;
	}

	public AlumnosVO getAlumno() {
		return alumno;
	}

	public void setAlumno(AlumnosVO alumno) {
		this.alumno = alumno;
	}

}
