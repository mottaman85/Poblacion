package com.curso.usuario2.dao;
import java.util.List;
import com.curso.usuarios.vo.UsuarioVO;

public interface UsuariosDao {
	public void setUsuario(UsuarioVO usuario);//Insertar usuarios del tip UsuarioVo
	public UsuarioVO getUsuario(String cveUsu); //Devuele un objeto de tipo UsuarioVO seg�n sea la clave de usuario pasado
	
	public List<UsuarioVO> getUsuarios();//Devuelve una lista de usuarios tipo UsuarioVo una consulta general
	public List<UsuarioVO> getUsuarios(String cveRol);//M�todo para devolver una lista de usuarios con ciertos roles indicados
	public void actualizaUsuario(UsuarioVO usu);//M�todo para modificar un usuario
	
}
