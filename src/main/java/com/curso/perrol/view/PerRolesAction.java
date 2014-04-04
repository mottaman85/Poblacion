package com.curso.perrol.view;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import com.curso.combos.dao.CombosDao;
import com.curso.combos.dao.CombosDaoImpl;
import com.curso.domain.LabelValueBean;
import com.curso.perrol.service.PerRolService;
import com.curso.perrol.service.PerRolServiceImpl;
import com.curso.perrol.vo.PerRolVO;
import com.curso.roles.vo.RolVO;
import com.curso.usuarios.vo.UsuarioVO;
import com.opensymphony.xwork2.ActionSupport;

public class PerRolesAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioVO usuario;
	private String nombre;
	public String cveRol;
	public List<PerRolVO> listaPermisos= null;
	private static final String TABLA_USUARIOS= "tablaUsuarios";
	

	private List<LabelValueBean> roles = new ArrayList<LabelValueBean>();
	private static final Logger log = Logger.getLogger(PerRolesAction.class);
	private CombosDao Combodao = new CombosDaoImpl();
	
	
	
	public String execute(){
		log.debug("Dentro de Action >>>");
        roles = Combodao.getRoles();
		return SUCCESS;
	}
	
	public String consultaPermisos(){
		log.debug("Dentro del " + cveRol);
		roles = Combodao.getRoles();
		PerRolService ServPerRol;
		ServPerRol = new PerRolServiceImpl();
		listaPermisos = ServPerRol.getPermisosPorRol(cveRol);
		return TABLA_USUARIOS;
	}
	
	public String person(){
		
		System.out.println("Si funciona");
		
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
	public String getCveRol() {
		
		return cveRol;
	}

	public void setCveRol(String cveRol) {
	
		this.cveRol = cveRol;
		
	}


}
