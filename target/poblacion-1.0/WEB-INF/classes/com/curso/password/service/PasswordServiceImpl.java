package com.curso.password.service;

import com.curso.password.dao.PasswordDaoImpl;
import com.curso.password.vo.PasswordVO;
import com.curso.usuarios.vo.UsuarioVO;

public class PasswordServiceImpl implements PasswordService{
	
	PasswordDaoImpl dao;
		
	public UsuarioVO getUsuario(String clave)
	{
		dao=new PasswordDaoImpl();
		return dao.getUsuario(clave);
	}

	public void updatePassword(String clave,String password)
	{
		dao=new PasswordDaoImpl();
		dao.apdatePassword(clave, password);
	}
}
