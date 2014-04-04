package com.curso.usuario2.action;

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
import com.curso.usuarios.service.UsuariosService;
import com.curso.usuarios.service.UsuariosServiceImpl;
import com.curso.usuarios.vo.UsuarioVO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Results({
	@Result(name="success",location="/Usuario2/usuario2.jsp") 
	})
public class UsuarioAction extends SuperAction {
	/**
	 * 
	 */
	//Esta clase se utiliza para struts sólo que en la parte de @Results ya se ha mapeado toda la ruta
	//lo que se tenía en el archivo struts.xml en la que se declaraba la clase y el mapeo ruta de la aplicació para desplegarse en la url
	
	private static final long serialVersionUID = 8386671892780904548L;	
	private static final Logger log = Logger.getLogger(UsuarioAction.class);
	
	@Resource(name="UsuariosService")
	private UsuariosService service;
		
	
	public UsuariosService getService() {
		return service;
	}


	public void setService(UsuariosService service) {
		this.service = service;
	}

	private String claverol;
		
	private UsuarioVO usuario;	
	
	
	CombosDao combos = new CombosDaoImpl();	
	private List<LabelValueBean> roles;
	

	public String execute(){
		
		roles = combos.getRoles();		
		return SUCCESS;		
	}
	
	
	public String updateUsuarios(){
		service = new UsuariosServiceImpl();
		
		Gson gson = new Gson();
		JsonObject messages = new JsonObject();
		JsonArray divs = new JsonArray();
		boolean success = true;		
		try{
			Map<Object, Object> resultSet = new HashMap<Object, Object>();
			
			log.debug("Intentando Insertar usuario");
			if(StringUtils.isBlank(usuario.getPass())){
				divs.add(getDivYMensaje("divpass","Debe ingresar un dato"));				
			}else if(StringUtils.isBlank(usuario.getClave())){
				divs.add(getDivYMensaje("divclave","Debe ingresar un dato"));
			}else if("comboRol2".equals("Seleccione")){				
				divs.add(getDivYMensaje("divpesroles2","Seleccione un rol."));
			}else if("usuarioEstatus2".equals("Seleccione")){				
				divs.add(getDivYMensaje("divpestatus","Seleccione un estatus"));
			}
			else{
				//dao.ActualizaUsuario(usuario);
				service.ActualizaUsuario(usuario);
				divs.add(getDivYMensaje("divconfirma","Datos actualizado!"));	
			}				
			resultSet.put("Result", "");			
		}catch (Exception e){
			log.error("error", e);
			success = false;
		}finally{
			messages.addProperty(JSON_DIVS, "");
			messages.addProperty(JSON_ALERTS, "");
			messages.addProperty(JSON_SUCCESS, success);
			
			streamIt(messages);			
		}
		
		return JSON;
	}
	
	public String busca(){
		service = new UsuariosServiceImpl();
		
		Gson gson = new Gson();
		JsonObject messages = new JsonObject();
		
		boolean success = true;
		
		try {
			int totalregistros = 10;
			messages.addProperty("totalregistros", totalregistros);
			
			Map<Object, Object> resultSet = new HashMap<Object, Object>();
			
			List<Map<Object, Object>> mapResult = new ArrayList<Map<Object, Object>>();
			
			//List<UsuarioVO> lista = dao.GetUsuarios();
			List<UsuarioVO> lista = service.getUsuarios();
			
			for (UsuarioVO obj : lista) {
				Map<Object, Object> map = new HashMap<Object, Object>();
					
					map.put("cve", obj.getClave());
					map.put("rol", obj.getRol());
					map.put("pass", obj.getPass());
					map.put("estatus", obj.getEstatus());
					map.put("ip", obj.getIp());
					log.debug("Regitros cveUser: "+obj.getClave());
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

	public String guarda()
	{
		service = new UsuariosServiceImpl();
		JsonObject messages = new JsonObject();
		JsonArray divs = new JsonArray();
		boolean success = true;
		try {
			Map<Object, Object> resultSet = new HashMap<Object, Object>();
			
			if(StringUtils.isBlank(usuario.getClave()) )
			{
				success=false;
				log.debug("Clave vacía validando en action");
				divs.add(getDivYMensaje("divclave","Debe ingresar un dato"));
				divs.add(getDivYMensaje("divpass","Debe ingresar un dato"));
				divs.add(getDivYMensaje("divip","Debe ingresar un dato"));				
			}else if(StringUtils.isNumeric(usuario.getClave()))
			{
				success = false;
				log.debug("La clave es numerica en el action");
				divs.add(getDivYMensaje("divclave","Debe ingresar letras"));				  
					//dao.SetUsuarios(usuario);
			}else{
				log.debug("Intentando Insertar usuario");
				//dao.SetUsuarios(usuario);
				service.setUsuario(usuario);
				divs.add(getDivYMensaje("divconfirma","Datos guardados!"));
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
	
	public String busquedaPorRol(){
		service = new UsuariosServiceImpl();
		Gson gson = new Gson();
		JsonObject messages = new JsonObject();
		boolean success = true;
		try {			
			Map<Object, Object> resultSet = new HashMap<Object, Object>();
			
			List<Map<Object, Object>> mapResult = new ArrayList<Map<Object, Object>>();
			
			//List<UsuarioVO> lista = 	dao.GetUsuarios(claverol);
			List<UsuarioVO> lista = 	service.getUsuarios(claverol);
			for (UsuarioVO obj : lista) {
				Map<Object, Object> map = new HashMap<Object, Object>();					
					map.put("cve", obj.getClave());
					map.put("rol", obj.getRol());
					map.put("pass", obj.getPass());
					map.put("estatus", obj.getEstatus());
					map.put("ip", obj.getIp());
					log.debug("Regitros cveUser: "+obj.getClave());
				    mapResult.add(map);
			}
			resultSet.put("Result", mapResult);
			messages.add("ResultSet", gson.toJsonTree(resultSet));									
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

	public String getClaverol() {
		return claverol;
	}

	public void setClaverol(String claverol) {
		this.claverol = claverol;
	}
	
	
}	
