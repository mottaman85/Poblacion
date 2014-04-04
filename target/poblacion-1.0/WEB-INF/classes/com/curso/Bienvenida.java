package com.curso;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.curso.usuarios.vo.UsuarioVO;
import com.curso.combos.dao.CombosDao;
import com.curso.combos.dao.CombosDaoImpl;
import com.curso.domain.LabelValueBean;
import com.curso.usuarios.vo.UsuarioVO;
import com.opensymphony.xwork2.ActionSupport;

public class Bienvenida extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioVO usuario;
	
	
	

	private String nombre;
	
	private List<LabelValueBean> roles = new ArrayList<LabelValueBean>();
	
	private static final Logger log = Logger.getLogger(Bienvenida.class);
	private CombosDao Combodao = new CombosDaoImpl();
	
	public String execute(){
		log.debug("Denteo de Action");
		
		String result = SUCCESS;
		roles = Combodao.getRoles();
		
		if(false){
			result = ERROR;
		}
		return result;
	}
	
	public String metodo2(){
		
		log.debug("Dentro del metodo2");
		
		return SUCCESS;
	}
	
	public String person(){
		
		log.debug(usuario);
		
		return SUCCESS;
	}
	
	public String nombre(){
		
		log.debug("Nombre: " + nombre);
		
		return SUCCESS;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
