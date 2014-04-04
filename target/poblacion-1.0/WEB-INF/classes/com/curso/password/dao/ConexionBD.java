package com.curso.password.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.sql.Statement;

import com.curso.password.vo.PasswordVO;

public class ConexionBD {
	Connection conexion;
	Statement sentencia = null;
	ResultSet rs = null;
	
	public void Conexion(){
		String url="jdbc:oracle:thin:@dev-admin.meltsan.com:1521:MTSDESA"; 
		
		try 
	    {
	     Class.forName("oracle.jdbc.OracleDriver");
	    } 
	    catch (ClassNotFoundException e) 
	    {
	     e.printStackTrace();
	    }
	    try {
	    	conexion= DriverManager.getConnection (url,"MTS_CURSOS","MT5_CUR505");
	    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			  System.out.print("ERROR conexion"); 
			
		}
	}
	
	  public void cerrarConexion()
	  {
		  try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			  System.out.print("Error al cerrar la conexión"); 
		}
	  }
	 public PasswordVO usuario(String sql) { 
	      
	        PasswordVO pwd=new PasswordVO();
	        try {
				ResultSet rs=qry(sql);	
				
				if(rs.next()){
					pwd.setCveUsuario(rs.getString("CVE_USUARIO"));
					pwd.setDirIP(rs.getString("IP_USUARIO"));
		            }
	        
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	          //  if(resultado.next()){
				//	 pwd.setCveUsuario(resultado.getString("CVE_USUARIO"));
					// pwd.setDirIP(resultado.getString("IP_USUARIO"));
	            //}
	           // System.out.println(pwd.getCveUsuario());
	       return pwd; 
	    }
	 
	 
	 private ResultSet qry(String qry) throws SQLException{
		 sentencia = conexion.createStatement(); //2
		 String consultaSQL = qry;
		 rs = sentencia.executeQuery(consultaSQL); //
		 return rs;

		 }

	 
	 public boolean upd(String sql)
	 {
		 try { 
	            Statement sentencia; 
	            sentencia = conexion.createStatement(); 
	            sentencia.executeUpdate(sql); 
	            
	           
	        } catch (SQLException e) { 
	            e.printStackTrace(); 
	            System.out.print("ERROR UPDATE"); 
	            return false; 
	        } 
		 
		 return true;
	 }
	
	
	
          
}