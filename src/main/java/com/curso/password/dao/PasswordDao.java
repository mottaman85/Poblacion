package com.curso.password.dao;

import com.curso.usuarios.vo.UsuarioVO;

public interface PasswordDao {

	public UsuarioVO getUsuario(String clave);
	public void apdatePassword(String clave,String password);

}
