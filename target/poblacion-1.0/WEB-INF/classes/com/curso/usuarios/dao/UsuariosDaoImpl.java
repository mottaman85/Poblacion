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
	
	public void SetUsuarios(UsuarioVO Datos) throws SQLException {
		// TODO Auto-generated method stub
		
		
		//System.out.println("Datos: "+ Datos .getClave()+ "| "+Datos.getRol()+ "| "+Datos.getPass()+ "| "+Datos.getPass()+ "| "+Datos.getIp());
		//hacer la lista de objetos segÃºn sea la peticiÃ³n del cliente
		List<UsuarioVO> result = new ArrayList<UsuarioVO>();
		
		result.add(Datos);

		//Una clase que reciba la lista y la inserte a la BD
		DepositaDatos D = new DepositaDatos();
		D.ListaUsuarios(result);
		
	}
	
	
	public List<UsuarioVO> SetUsuarios(String clave,String rol, String pass, String estatus, String ip) throws SQLException {
		// TODO Auto-generated method stub
		
		UsuarioVO Datos = new UsuarioVO(); 
		Datos.setClave(clave);
		Datos.setRol(rol);
		Datos.setPass(pass);
		Datos.setEstatus(estatus);
		Datos.setIp(ip);
		
		//System.out.println("Datos: "+ Datos .getClave()+ "| "+Datos.getRol()+ "| "+Datos.getPass()+ "| "+Datos.getPass()+ "| "+Datos.getIp());
		//hacer la lista de objetos segÃºn sea la peticiÃ³n del cliente
		List<UsuarioVO> result = new ArrayList<UsuarioVO>();
		
		result.add(Datos);

		//Una clase que reciba la lista y la inserte a la BD
		DepositaDatos D = new DepositaDatos();
		D.ListaUsuarios(result);
		
		return null;
	}
	
	public List<UsuarioVO> GetUsuarios(){
		List<UsuarioVO> result = new ArrayList<UsuarioVO>();
		if(DBUtilities.Conect()){
			try {
				
				//Class.forName("oracle.jdbc.OracleDriver");
				//conexion = DriverManager.getConnection(CONSTANTES.JDB_URL, CONSTANTES.USER_DB,CONSTANTES.PASSWORD);
				//Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@dev-admin.meltsan.com:1521:MTSDESA","MTS_CURSOS","MT5_CUR505");
				
	            //String queryString = "SELECT * FROM  MTS_CURSO_USUARIOS";
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
				//DBUtilities.cerrar();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error de select SQLExeption");
			}
			
		}else
		{
			System.out.println("Error de conexión");
		}
		
		return result;
	}
	
	public List<UsuarioVO> GetUsuarios(String cveRol) throws ArgumentosException, Exception{
		
		if(StringUtils.isBlank(cveRol)){
			throw new ArgumentosException();
		}
		
		List<UsuarioVO> result = new ArrayList<UsuarioVO>();
		if(DBUtilities.Conect()){
				
				//Class.forName("oracle.jdbc.OracleDriver");
				//conexion = DriverManager.getConnection(CONSTANTES.JDB_URL, CONSTANTES.USER_DB,CONSTANTES.PASSWORD);
				//Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@dev-admin.meltsan.com:1521:MTSDESA","MTS_CURSOS","MT5_CUR505");
				
	            String queryString = "SELECT * FROM  MTS_CURSO_USUARIOS WHERE CVE_ROL = " + cveRol;
	            connection = getConnection();
	            ptmt = connection.prepareStatement(queryString);
	            resultSet = ptmt.executeQuery();
					            
	            
				while(resultSet.next()){
		            	UsuarioVO U = new UsuarioVO();
		            	
		            	U.setClave(resultSet.getString(1));
		            	U.setRol(resultSet.getString(2));
		            	U.setPass(resultSet.getString(3));
		            	U.setEstatus(resultSet.getString(4));
		            	U.setIp(resultSet.getString(5));
		                result.add(U);		                
					}
				//DBUtilities.cerrar();
				// TODO: handle exception
				System.out.println("Error de select SQLExeption");
			
		}else
		{
			System.out.println("Error de conexión");
		}
		
		return result;
	}
	//Métodos de edición
	public UsuarioVO GetUsuario(String cveUsu) throws ArgumentosException, Exception{

		if(StringUtils.isBlank(cveUsu)){
		throw new ArgumentosException();
		}

		UsuarioVO result = new UsuarioVO();
		if(DBUtilities.Conect()){
		           String queryString = "SELECT * FROM  MTS_CURSO_USUARIOS WHERE CVE_USUARIO ='"+cveUsu+"'";		          		           
		           connection = getConnection();
		           ptmt = connection.prepareStatement(queryString);
		           resultSet = ptmt.executeQuery();		           		           
		           while(resultSet.next()){		           			           	
		           	result.setClave(resultSet.getString(1));
		            result.setRol(resultSet.getString(2));
		           	result.setPass(resultSet.getString(3));
		           	result.setEstatus(resultSet.getString(4));
		           	result.setIp(resultSet.getString(5));		           	            			              	                
		           }
		}else
			{				
				log.debug("Error de conexión");
			}
		return result;
		}
	
	public void ActualizaUsuario(UsuarioVO usu)
	{
	if(DBUtilities.Conect()){
	try {
	            String queryString = "UPDATE MTS_CURSO_USUARIOS SET CVE_ROL='"+usu.getRol()+"',PASSWORD='"+usu.getPass()+"', SW_ACTIVO='"+usu.getEstatus()+"', IP_USUARIO='"+usu.getIp()+"' where CVE_USUARIO ='"+usu.getClave()+"'";
	            System.out.println(queryString);
	            connection = getConnection();
	            
	            ptmt = connection.prepareStatement(queryString); 
	            
	            log.debug("Actualizado");
	            ptmt.executeUpdate(queryString);
	            log.debug("Update ejecutado");	            

			} catch (Exception e) {
				// TODO: handle exception				
				log.debug("Error de select SQLException");
			}
			}else
			{
				log.debug("Error de conexión");				
			}
	  }
}
