package com.curso.usuarios.service;

import java.util.ArrayList;
import java.util.List;

import com.curso.usuarios.dao.UsuariosDao;
import com.curso.usuarios.dao.UsuariosDaoImpl;
import com.curso.usuarios.vo.UsuarioVO;


public class UsuariosServiceImpl implements UsuariosService{
	UsuarioVO Usuario = new UsuarioVO();
	UsuariosDao dao = new UsuariosDaoImpl();
	
	List<UsuarioVO> result = new ArrayList<UsuarioVO>();
	
	public void setUsuario(UsuarioVO usuario) {
		dao.setUsuario(usuario);		
	}
	
	public UsuarioVO getUsuario(String cveUsu) { 
		Usuario = dao.getUsuario(cveUsu);
		return Usuario;		
	}
	
	public List<UsuarioVO> getUsuarios(){
		 result = dao.getUsuarios();
		return result;
	}

	public void ActualizaUsuario(UsuarioVO usu) {	
		dao.actualizaUsuario(usu);
	}

	public List<UsuarioVO> getUsuarios(String cveRol) {
		 result = dao.getUsuarios(cveRol);
		return result;
	}	
}
