package com.curso.usuario2.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.usuario2.dao.UsuariosDao;
import com.curso.usuarios.vo.UsuarioVO;

@Service(value="UsuariosService")
public class UsuariosServiceImpl implements UsuariosService{
	
	@Resource(name="UsuariosDao")
	UsuariosDao dao;
	
	List<UsuarioVO> result = new ArrayList<UsuarioVO>();

	public void setUsuario(UsuarioVO usuario) {
		// TODO Auto-generated method stub
		dao.setUsuario(usuario);
		
	}

	public UsuarioVO getUsuario(String cveUsu) {
		// TODO Auto-generated method stub
		return dao.getUsuario(cveUsu);
	}

	public List<UsuarioVO> getUsuarios() {
		// TODO Auto-generated method stub
		return dao.getUsuarios();
	}

	public List<UsuarioVO> getUsuarios(String cveRol) {
		// TODO Auto-generated method stub
		return dao.getUsuarios(cveRol);
	}

	public void ActualizaUsuario(UsuarioVO usu) {
		// TODO Auto-generated method stub
		dao.actualizaUsuario(usu);
		
	}
	
		
}
