package com.curso.usuarios.dao;
import java.sql.SQLException;
import java.util.List;

import com.curso.ArgumentosException;
import com.curso.roles.vo.RolVO;
import com.curso.usuarios.vo.UsuarioVO;

public interface UsuariosDao {
	public List<UsuarioVO> SetUsuarios(String clave,String rol, String pass, String estatus, String ip) throws SQLException;
	public void SetUsuarios(UsuarioVO usr) throws SQLException;
	public List<UsuarioVO> GetUsuarios();
	
	/**
	 * @param cveRol
	 * @return
	 * @throws ArgumentosException Si no tiene un valor en cveRol
	 * @throws SQLException Si existe un error de acceso a base de datos
	 */
	public List<UsuarioVO> GetUsuarios(String cveRol) throws ArgumentosException, Exception;
	public UsuarioVO GetUsuario(String cveUsu) throws ArgumentosException, Exception;
	public void ActualizaUsuario(UsuarioVO usu);
}
