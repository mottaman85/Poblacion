package com.curso.perrol.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
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
import com.curso.combos.dao.CombosDao;
import com.curso.combos.dao.CombosDaoImpl;
import com.curso.domain.LabelValueBean;
import com.curso.domain.SuperAction;
import com.curso.usuarios.dao.UsuariosDao;
import com.curso.usuarios.dao.UsuariosDaoImpl;
import com.curso.usuarios.vo.UsuarioVO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;


@Results({
	@Result(name="success", location="permisos/permisos.jsp"),
	@Result(name = "stream", type = "stream", params = { "contentType",
			"application/json; charset=utf-8", "inputName", "inputStream" })
})
public class PermisosAction extends SuperAction{
	/**
	 * 
	 */

	private static final long serialVersionUID = 6744272887576011837L;
	private static final Logger log = Logger.getLogger(PermisosAction.class);
	
	UsuariosDao dao;
	private UsuarioVO usuario;
	CombosDao combos = new CombosDaoImpl();
	
	private List<LabelValueBean> roles;
	

	public String execute(){
		
		
		
		roles = combos.getRoles();
		return SUCCESS;
		
		
	}
	public String busca(){
		
		
		log.debug("Dentro del execute");
		log.debug("Dentro del execute");
		log.debug("Dentro del execute");
		log.debug("Dentro del execute");
		log.debug("Dentro del execute");
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
		boolean success = true;
		try {
			Map<Object, Object> resultSet = new HashMap<Object, Object>();
			
			dao.SetUsuarios(usuario);
			
			resultSet.put("Result", "");
		} catch (Exception e) {
			log.error("error", e);
			messages.addProperty(JSON_EXCEPTION, e.getCause().toString());
			e.printStackTrace();
			success = false;
		} finally {
			messages.addProperty(JSON_DIVS, "");
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
	
	
	

