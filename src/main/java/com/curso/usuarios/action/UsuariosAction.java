package com.curso.usuarios.action;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.curso.ArgumentosException;
import com.curso.combos.dao.CombosDao;
import com.curso.combos.dao.CombosDaoImpl;
import com.curso.domain.LabelValueBean;
import com.curso.domain.SuperAction;
import com.curso.usuarios.dao.UsuariosDao;
import com.curso.usuarios.dao.UsuariosDaoImpl;
import com.curso.usuarios.service.UsuariosService;
import com.curso.usuarios.service.UsuariosServiceImpl;
import com.curso.usuarios.view.UsuariosStruts;
import com.curso.usuarios.vo.UsuarioVO;

@Results({
	@Result(name="success", location="Usuarios/UsuarioStruts.jsp"),
	@Result(name="tablaUsuarios", location="Usuarios/tabla-usuarios.jsp")
})

public class UsuariosAction extends SuperAction{

	private static final long serialVersionUID = 1L;
	
	private static final String TABLA_USUARIOS= "tablaUsuarios";
	 
	private static final Logger log = Logger.getLogger(UsuariosStruts.class);	

	private UsuariosService   user = new UsuariosServiceImpl(); 
	
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
		
		//usuarios = user.GetUsuarios();
		usuarios = user.getUsuarios();
		
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

	public String setUsers() {				
		log.debug("metodo insert");
				
			//user.SetUsuarios(users.getClave(),users.getRol(),users.getPass(),users.getEstatus(),users.getIp());
			UsuarioVO usuario = new UsuarioVO();
			
			usuario.setClave(users.getClave());
			usuario.setRol(users.getRol());
			usuario.setPass(users.getPass());
			usuario.setEstatus(users.getEstatus());
			usuario.setIp(users.getIp());
					
			user.setUsuario(usuario);			

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
	
	//users = user.GetUsuario(clave_usuario);
	users = user.getUsuario(clave_usuario);
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
