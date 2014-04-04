package com.curso.usuarios.view;

import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.curso.ArgumentosException;
import com.curso.Bienvenida;
import com.curso.combos.dao.CombosDao;
import com.curso.combos.dao.CombosDaoImpl;
import com.curso.domain.LabelValueBean;
import com.curso.usuarios.dao.UsuariosDao;
import com.curso.usuarios.dao.UsuariosDaoImpl;
import com.curso.usuarios.vo.UsuarioVO;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.utility.Execute;

public class UsuariosStruts extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private static final String TABLA_USUARIOS= "tablaUsuarios";
	 
	private static final Logger log = Logger.getLogger(UsuariosStruts.class);	

	private UsuariosDao user = new UsuariosDaoImpl(); 
	
	private java.util.List<UsuarioVO> usuarios= new ArrayList<UsuarioVO>();
	
	private CombosDao Combodao = new CombosDaoImpl();
	
	private  UsuarioVO users = new UsuarioVO();
	
	private  UsuarioVO users2 = new UsuarioVO();	
	
	
	private String cveRol;

	private java.util.List<LabelValueBean> roles = new ArrayList<LabelValueBean>();
	
	//Variables para la edición de usuarios
	
	public String clave_usuario;	

	public String busca(){
		
		//
		
		usuarios = user.GetUsuarios();
		
		usuarios.add(new UsuarioVO("01", "admin", "pass", "1", "1992929292"));
		usuarios.add(new UsuarioVO("02", "admin", "pass", "1", "1992929292"));
		usuarios.add(new UsuarioVO("03", "admin", "pass", "1", "1992929292"));
		
		return TABLA_USUARIOS;
	}
	
	public String execute(){
		String result = SUCCESS;
		
		roles = Combodao.getRoles();
		//roles = Combodao.getRoles();		
		if(false){
			return SUCCESS;
		}
		return result;
	}

	public java.util.List<LabelValueBean> getRoles() {
		return roles;
	}

	public void setRoles(java.util.List<LabelValueBean> roles) {
		this.roles = roles;
		
	}

	public java.util.List<UsuarioVO> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(java.util.List<UsuarioVO> usuarios) {
		this.usuarios = usuarios;
	}
	
	public UsuarioVO getUsers() {
		return users;
	}

	public String setUsers() throws SQLException {				
		log.debug("metodo insert");
		user.SetUsuarios(users.getClave(),users.getRol(),users.getPass(),users.getEstatus(),users.getIp());
		execute();
		return SUCCESS;
	}
	public String getClave_usuario() {
		return clave_usuario;
	}

	public UsuarioVO getUsers2() {
		return users2;
	}

	public void setUsers2() {
		this.users2 = users2;
	}

	public void setClave_usuario(String clave_usuario) {
		this.clave_usuario = clave_usuario;
	}	
	
	public String actualizaUsers()
	{
	setUsers2();
	user.ActualizaUsuario(users2);
	execute();
	return SUCCESS;
	}
	
	public String recupera() throws ArgumentosException, Exception {
	clave_usuario = users.getClave();

	log.debug(clave_usuario + ":)");
	
	users = user.GetUsuario(clave_usuario);
	execute();
	return SUCCESS;
	}

	public String getCveRol() {
		return cveRol;
	}

	public void setCveRol(String cveRol) {
		this.cveRol = cveRol;
	}
	
}
