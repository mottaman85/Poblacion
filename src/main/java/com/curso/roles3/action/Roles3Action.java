package com.curso.roles3.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.curso.domain.LabelValueBean;
import com.curso.domain.SuperAction;
import com.curso.roles.vo.Estatus;
import com.curso.roles.vo.RolVO;
import com.curso.roles2.action.Roles2Action;

import com.curso.roles3.service.RolesService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Results({
		@Result(name = "success", location = "/roles3/roles3.jsp"),
		@Result(name = "stream", type = "stream", params = { "contentType",
				"application/json; charset=utf-8", "inputName", "inputStream" }) })
public class Roles3Action extends SuperAction {

	@Resource(name = "RolesService")
	private RolesService service;
	/**
	 * 
	 */
	private static final long serialVersionUID = 8271710441608883759L;
	private List<RolVO> roles;
	private List<Estatus> listaEstatus = new ArrayList<Estatus>();
	Logger log = Logger.getLogger(Roles2Action.class);
	protected static final String STREAM = "stream";
	private String estado;
	
	private RolVO rol;
	
	

	public RolVO getRol() {
		return rol;
	}

	public void setRol(RolVO rol) {
		this.rol = rol;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Estatus> getListaEstatus() {
		return listaEstatus;
	}

	public void setListaEstatus(List<Estatus> listaEstatus) {
		this.listaEstatus = listaEstatus;
	}

	public List<RolVO> getRoles() {
		return roles;
	}

	public void setRoles(List<RolVO> roles) {
		this.roles = roles;
	}

	public String execute() {
		try {
			roles = service.getRoles();

			for (RolVO l : roles) {
				System.out
						.println("+++++++++++++++++Aqui vienen los datos++++++++++++++");
				System.out.println(l.getCve_rol());
				System.out.println(l.getDs_rol());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		listaEstatus = service.getEstado();

		return SUCCESS;

	}

	public String buscaRoles() {

		Gson gson = new Gson();
		JsonObject messages = new JsonObject();
		boolean success = true;
		try {
			int totalregistros = 10;
			messages.addProperty("totalregistros", totalregistros);

			Map<Object, Object> resultSet = new HashMap<Object, Object>();

			List<Map<Object, Object>> mapResult = new ArrayList<Map<Object, Object>>();
			// service = new RolesServiceImpl();
			// List<RolVO> lista = service.getRoles();

			roles = service.getRolesEstatus(estado);

			for (RolVO obj : roles) {
				Map<Object, Object> map = new HashMap<Object, Object>();

				map.put("cve_rol", obj.getCve_rol());
				map.put("ds_rol", obj.getDs_rol());
				map.put("st_rol", obj.getSt_rol());

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

	public String guarda() {

		JsonArray divs = new JsonArray();

		

		System.out.println("Insertando datos************");

		System.out.println(rol.getCve_rol());
		System.out.println(rol.getDs_rol());
		
		String fijo = "A";

		Gson gson = new Gson();
		JsonObject messages = new JsonObject();
		boolean success = true;

		try {
			Map<Object, Object> resultSet = new HashMap<Object, Object>();

			if (StringUtils.isBlank(rol.getCve_rol())
					|| StringUtils.isBlank(rol.getDs_rol())) {
				success = false;
				divs.add(getDivYMensaje("div.cve",
						"Alguno de los campos es vacio"));
			} else if (StringUtils.isNumeric(rol.getDs_rol())) {
				divs.add(getDivYMensaje("div.cve2", "Debe ser letras"));
				success = false;

			} else {
				service.insertRoles(rol.getCve_rol(), rol.getDs_rol(), fijo);
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
		return STREAM;

	}
	
	
	public String modifica()
	{
		JsonArray divs = new JsonArray();
		
		System.out.println("**********************************Aui van los datos a modificar***************************");
		System.out.println(rol.getCve_rol());
		System.out.println(rol.getDs_rol());
		
		
		
		
		
		
		Gson gson = new Gson();
		JsonObject messages = new JsonObject();
		boolean success = true;
		try {
			Map<Object, Object> resultSet = new HashMap<Object, Object>();
			
			if(StringUtils.isBlank(rol.getDs_rol())){
				success=false;
				divs.add(getDivYMensaje("div.cve3", "Debe ingresar algo"));
			}else if(StringUtils.isNumeric(rol.getDs_rol()))
			{
				divs.add(getDivYMensaje("div.cve3", "Debe ser letras"));
				success=false;
				
				
				
			}else
			{
				
				service.updateRoles(rol.getDs_rol(), rol.getCve_rol());
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
		return STREAM;
	}

}
