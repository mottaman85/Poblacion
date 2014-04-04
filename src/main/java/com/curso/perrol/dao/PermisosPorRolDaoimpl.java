package com.curso.perrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.curso.domain.CONSTANTESQRY;
import com.curso.perrol.vo.PerRolVO;

import com.curso.utils.ConnectionFactory;

public class PermisosPorRolDaoimpl implements PermisosPorRolDao{
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	  private Connection getConnection() throws SQLException {
	      Connection conn;
	      conn = ConnectionFactory.getInstance().getConnection();
	      return conn;
	}


	public List<PerRolVO> getPermisosPorRol(String cveRol) {
		List<PerRolVO> result = new ArrayList<PerRolVO>();
		
		try {
	        String queryString = CONSTANTESQRY.SqlPerRol;
	        connection = getConnection();
	        ptmt = connection.prepareStatement(queryString);
	        ptmt.setString(1, cveRol);
	        resultSet = ptmt.executeQuery();
	        
	        while ( resultSet.next())
	        {
	        	PerRolVO PerRol = new PerRolVO();
	      	PerRol.setIdModulo(resultSet.getString("ID_MODULO"));
	        PerRol.setDsPantalla(resultSet.getString("DS_MODULO")); 
	        PerRol.setPath(resultSet.getString("ACTION"));
	      
	        
	        result.add(PerRol);
	        
	        
	        }
		} catch (SQLException e) {
	        e.printStackTrace();
	} finally {
	        try {
	                if (ptmt != null)
	                        ptmt.close();
	                if (connection != null)
	                        connection.close();
	        } catch (SQLException e) {
	                e.printStackTrace();
	        } catch (Exception e) {
	                e.printStackTrace();
	        }

	}
		
		
		return result;
	}
	
	public void insertarPermisosPorRol(String idModulo,String dsPantalla,String Path) {
		
		
		try {
	        String queryString = CONSTANTESQRY.InsPerRol;
	        connection = getConnection();
	        ptmt = connection.prepareStatement(queryString);
	        ptmt.setString(1, idModulo);
	        ptmt.setString(2, dsPantalla);
	        ptmt.setString(3, Path);
	        
	        
	       
	        resultSet = ptmt.executeQuery();
	        
	   
	        
	       		} catch (SQLException e) {
	        e.printStackTrace();
	} finally {
	        try {
	                if (ptmt != null)
	                        ptmt.close();
	                if (connection != null)
	                        connection.close();
	        } catch (SQLException e) {
	                e.printStackTrace();
	        } catch (Exception e) {
	                e.printStackTrace();
	        }

	}
		
		
		
	}
	
	

	
	
	
	}


	
        
        
        
        
