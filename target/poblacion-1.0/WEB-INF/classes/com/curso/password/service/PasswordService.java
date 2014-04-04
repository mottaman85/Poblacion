package com.curso.password.service;


import com.curso.usuarios.vo.UsuarioVO;

public interface PasswordService {

	public UsuarioVO getUsuario(String clave);
	public void updatePassword(String clave,String password);
}
