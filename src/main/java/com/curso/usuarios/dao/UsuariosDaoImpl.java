package com.curso.usuarios.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.curso.ArgumentosException;
import com.curso.roles.vo.RolVO;
import com.curso.usuarios.view.UsuariosStruts;
import com.curso.usuarios.vo.UsuarioVO;
import com.curso.utils.ConnectionFactory;

public class UsuariosDaoImpl implements UsuariosDao {
	
	ResultSet Res =null;
	Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    private static final Logger log = Logger.getLogger(UsuariosDaoImpl.class);	
       
	private Connection getConnection() throws SQLException {
          Connection conn;
          conn = ConnectionFactory.getInstance().getConnection();
          return conn;
	}
	
	public void setUsuario(UsuarioVO usuario) {
		// TODO Auto-generated method stub
			try {
				if( DBUtilities.Conect()){
					DBUtilities.Insertar("INSERT INTO MTS_CURSO_USUARIOS VALUES ('"+usuario.getClave()+"','"+usuario.getRol()+"','"+usuario.getPass()+"','"+usuario.getEstatus()+"','"+usuario.getIp()+"')");
					log.debug("INSERT INTO MTS_CURSO_USUARIOS VALUES ('"+usuario.getClave()+"','"+usuario.getRol()+"','"+usuario.getPass()+"','"+usuario.getEstatus()+"','"+usuario.getIp()+"')");
					DBUtilities.cerrar();
				}else{
					log.debug("No se ha podido realizar la conexión para insertar UsuarioVo");
				}								
			} catch (SQLException e) {
				log.debug("Se ha cachado un error con el método setUsuario");
				e.printStackTrace();
			}				
	}	
	
	
	public UsuarioVO getUsuario(String cveUsu){
		if(StringUtils.isBlank(cveUsu)){
		throw new ArgumentosException();
		}
		UsuarioVO result = new UsuarioVO();
		try{
			if(DBUtilities.Conect()){
				String queryString = "SELECT * FROM  MTS_CURSO_USUARIOS WHERE CVE_USUARIO ='"+cveUsu+"'";		          		           
		        connection = getConnection();
		        ptmt = connection.prepareStatement(queryString);
		      	resultSet = ptmt.executeQuery();
		           
		       	while(resultSet.next()){		           			           	
		       		result.setClave(resultSet.getString(1));
		       		result.setRol(resultSet.getString(2));
		       		result.setPass(resultSet.getString(3));
		       		if(resultSet.getString(4).equals("i"))		       		
		       			result.setEstatus("Inactivo");
		       		else
		       			result.setEstatus("Activo");		       		
		       		result.setIp(resultSet.getString(5));		           	            			              	                
		           	} 
		       	
		        DBUtilities.cerrar();
			}else{				
				log.debug("Error de conexión clave usuario");
			}			
		}catch(SQLException e){
			log.debug("Se ha cachado un error en el método getUsuarioVO");
			}
			return result;
		}	
	
	public List<UsuarioVO> getUsuarios(){
		List<UsuarioVO> result = new ArrayList<UsuarioVO>();
		try {
			if(DBUtilities.Conect()){
				String queryString = "SELECT CVE_USUARIO,DS_ROL, PASSWORD,SW_ACTIVO,IP_USUARIO  FROM MTS_CURSO_USUARIOS A ,MTS_CURSO_ROLES B WHERE A.CVE_ROL=B.CVE_ROL";
	            connection = getConnection();
	            ptmt = connection.prepareStatement(queryString);
	            resultSet = ptmt.executeQuery();
	            
				while(resultSet.next()){
		            	UsuarioVO U = new UsuarioVO();
		            	
		            	U.setClave(resultSet.getString(1));
		            	U.setRol(resultSet.getString(2));
		            	U.setPass(resultSet.getString(3));
		            	if(resultSet.getString(4).equals("i"))
		            		U.setEstatus("Inactivo");
		            	else
		            		U.setEstatus("Activo");		            	
		            	U.setIp(resultSet.getString(5));
		                result.add(U);		                
					}
				DBUtilities.cerrar();
				}else{
					log.debug("No se ha podido realizar la conexión en getUsuarios");
				}
			} catch (Exception e) {				
				log.debug("Se ha cachado un erro en el método getUsuarios");
			}
		return result;
	}
	
	public List<UsuarioVO> getUsuarios(String cveRol){		
		if(StringUtils.isBlank(cveRol)){
			throw new ArgumentosException();
		}
		
		List<UsuarioVO> result = new ArrayList<UsuarioVO>();
		try{
			if(DBUtilities.Conect()){
	            String queryString = "SELECT * FROM  MTS_CURSO_USUARIOS WHERE CVE_ROL = " + cveRol;
	            connection = getConnection();
	            ptmt = connection.prepareStatement(queryString);
	            resultSet = ptmt.executeQuery();					            	            
				while(resultSet.next()){
		            	UsuarioVO U = new UsuarioVO();
		            	
		            	U.setClave(resultSet.getString(1));
		            	U.setRol(resultSet.getString(2));
		            	U.setPass(resultSet.getString(3));
		            	if(resultSet.getString(4).equals("i") || resultSet.getString(4).equals("I")){
		            		U.setEstatus("Inactivo");
		            	}else{
		            		U.setEstatus("Activo");	
		            	}		            			            	
		            	U.setIp(resultSet.getString(5));		            			            	
		                result.add(U);		                
					}
					DBUtilities.cerrar();											
			}else{
				log.debug("No se ha podido realizar la conexión en el método getUsuarios(cveRol)");
			}			
		}catch(SQLException e){
			log.debug("Se ha cachado un error en el método getUsuarios(cveRol)");
			}
		return result;
	}

	//Métodos de edición
	public void actualizaUsuario(UsuarioVO usu){
	if(DBUtilities.Conect()){
	try {
	            String queryString = "UPDATE MTS_CURSO_USUARIOS SET CVE_ROL='"+usu.getRol()+"',PASSWORD='"+usu.getPass()+"', SW_ACTIVO='"+usu.getEstatus()+"', IP_USUARIO='"+usu.getIp()+"' where CVE_USUARIO ='"+usu.getClave()+"'";
	            System.out.println(queryString+"EJECUTANDO QUERY...");
	            connection = getConnection();	            
	            ptmt = connection.prepareStatement(queryString); 
	            
	            log.debug("ejecutar execute update...");
	            ptmt.executeUpdate();
	            log.debug("Update ejecutado");	            
	            DBUtilities.cerrar();
			} catch (Exception e) {
				// TODO: handle exception				
				log.debug("Error de select SQLException en actualizaUsuario()");
			}
			}else
			{
				log.debug("No se ha podido realizar la conexión en actualizaUsuario()");				
			}
	  }
}
