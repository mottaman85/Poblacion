package com.curso.prueba.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.curso.alumnos.service.AlumnosService;
import com.curso.alumnos.service.AlumnosServiceImpl;
import com.curso.alumnos.vo.AlumnosVO;
import com.curso.combos.dao.CombosDao;
import com.curso.combos.dao.CombosDaoImpl;
import com.curso.domain.LabelValueBean;
import com.curso.domain.SuperAction;
import com.curso.prueba.service.PruebaService;
import com.curso.usuarios.dao.UsuariosDao;
import com.curso.usuarios.dao.UsuariosDaoImpl;
import com.curso.usuarios.vo.UsuarioVO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@Results({
	@Result(name="success", location="/prueba/prueba.jsp")
})
public class PruebaAction extends SuperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1513565488400151698L;

	@Autowired
	private PruebaService service;
	
	private static final Logger log = Logger.getLogger(PruebaAction.class);
	
	UsuariosDao dao;
	private UsuarioVO usuario;
	
	CombosDao combos = new CombosDaoImpl();
	
	private List<LabelValueBean> roles;
	
	public String execute(){
		try{
		service.getRoles();
		roles = combos.getRoles();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String busca(){
		dao = new UsuariosDaoImpl();
		
		Gson gson = new Gson();
		JsonObject messages = new JsonObject();
		boolean success = true;
		try {
			int totalregistros = 10;
			messages.addProperty("totalregistros", totalregistros);
			
			Map<Object, Object> resultSet = new HashMap<Object, Object>();
			
			List<Map<Object, Object>> mapResult = new ArrayList<Map<Object, Object>>();
			
			List<UsuarioVO> lista = dao.GetUsuarios();
			
			for (UsuarioVO obj : lista) {
				Map<Object, Object> map = new HashMap<Object, Object>();
					
					map.put("cve", obj.getClave());
					map.put("rol", obj.getRol());
					map.put("pass", obj.getPass());
					map.put("estatus", obj.getEstatus());
					map.put("ip", obj.getIp());
					
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
		dao = new UsuariosDaoImpl();
		JsonObject messages = new JsonObject();
		JsonArray divs = new JsonArray();
		boolean success = true;
		try {
			Map<Object, Object> resultSet = new HashMap<Object, Object>();
			
			if(StringUtils.isBlank(usuario.getClave())){
				
				success = false;
				divs.add(getDivYMensaje("div.cve", "Debe ingresar algo"));
				
			}else if(StringUtils.isNumeric(usuario.getClave())){
				
				divs.add(getDivYMensaje("div.cve", "Deben ser letras"));
				success = false;
				
			}else{
				//dao.SetUsuarios(usuario);
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
		return JSON;
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

	public List<LabelValueBean> getRoles() {
		return roles;
	}

	public void setRoles(List<LabelValueBean> roles) {
		this.roles = roles;
	}
	
}