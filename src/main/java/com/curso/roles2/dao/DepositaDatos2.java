package com.curso.roles2.dao;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.curso.roles.vo.RolVO;
import com.curso.usuarios.dao.DBUtilities;
import com.curso.usuarios.dao.DepositaDatos;


public class DepositaDatos2 {
	
	private static final Logger log = Logger.getLogger(DepositaDatos.class);
	
	public void ListaRoles(java.util.List<RolVO> Rol) throws SQLException{
		
		
		RolVO U = Rol.get(0);
		
		String sw ="A";
		
	
		if(DBUtilities.Conect()){
				DBUtilities.Insertar("insert  into mts_curso_roles values ('"+U.getCve_rol()+"','"+U.getDs_rol()+"','"+sw+"')");			
				log.debug("insert  into mts_curso_roles values ('"+U.getCve_rol()+"','"+U.getDs_rol()+"')");
				//DBUtilities.cerrar();
		}else{			
			log.debug("error de conexión...");
		}				
	}	

}
