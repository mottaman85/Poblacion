package com.curso.usuario2.service;

import java.util.List;

import com.curso.usuarios.vo.UsuarioVO;

public interface UsuariosService {
	public void setUsuario(UsuarioVO usuario);//Insertar usuarios del tip UsuarioVo
	public UsuarioVO getUsuario(String cveUsu); //Devuele un objeto de tipo UsuarioVO seg�n sea la clave de usuario pasado
	
	public List<UsuarioVO> getUsuarios();//Devuelve una lista de usuarios tipo UsuarioVo una consulta general
	public List<UsuarioVO> getUsuarios(String cveRol);//Devuelve una lista de usuarios que est�n con un determinado rol
	public void ActualizaUsuario(UsuarioVO usu);//M�todo para modificar un usuario
}
