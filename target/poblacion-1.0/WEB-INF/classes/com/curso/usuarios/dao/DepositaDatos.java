package com.curso.usuarios.dao;

import java.awt.List;

import com.curso.usuarios.view.UsuariosStruts;
import com.curso.usuarios.vo.UsuarioVO;

import java.sql.*;

import org.apache.log4j.Logger;
public class DepositaDatos {
	private static final Logger log = Logger.getLogger(DepositaDatos.class);
	public void ListaUsuarios(java.util.List<UsuarioVO> Usuario) throws SQLException{
		//conecto a bases de datos
		//establecer conexion
		//insertar datos
		//cerrar conexion
		
		UsuarioVO U = Usuario.get(0);
	
		if(DBUtilities.Conect()){
				DBUtilities.Insertar("insert  into mts_curso_usuarios values ('"+U.getClave()+"','"+U.getRol()+"','"+U.getPass()+"','"+U.getEstatus()+"','"+U.getIp()+"')");			
				log.debug("insert  into mts_curso_usuarios values ('"+U.getClave()+"','"+U.getRol()+"','"+U.getPass()+"','"+U.getEstatus()+"','"+U.getIp()+"')");
				//DBUtilities.cerrar();
		}else{			
			log.debug("error de conexión...");
		}				
	}	
}
