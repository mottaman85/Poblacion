package com.curso.secciones.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.curso.roles.vo.RolVO;
import com.curso.secciones.vo.*;
import com.curso.utils.ConnectionFactory;

public class SeccionesDaoImpl implements SeccionesDao {

	
	Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    
    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }
	
    
	public List<SeccionesVO> getSecciones() {
		// TODO Auto-generated method stub
		List<SeccionesVO> result = new ArrayList<SeccionesVO>();
		try {
            String queryString = "SELECT * FROM MTS_CURSO_SECCIONES";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while ( resultSet.next())
            {
            	SeccionesVO seccion = new SeccionesVO();
            	seccion.setCveGpo(resultSet.getString("CVE_GRUPO"));
            	seccion.setCveSecc(resultSet.getString("CVE_SECCION"));
            	seccion.setDsSecc(resultSet.getString("DS_SECCION"));
            	result.add(seccion);
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
	            } 
	
	    }
		return result;
	}

	public List<SeccionesVO> getSeccionesXC() {
		// TODO Auto-generated method stub
		List<SeccionesVO> result = new ArrayList<SeccionesVO>();
		try {
            String queryString = "SELECT * FROM MTS_CURSO_SECCIONES where ";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while ( resultSet.next())
            {
            	SeccionesVO seccion = new SeccionesVO();
            	seccion.setCveGpo(resultSet.getString("CVE_GRUPO"));
            	seccion.setCveSecc(resultSet.getString("CVE_SECCION"));
            	seccion.setDsSecc(resultSet.getString("DS_SECCION"));
            	result.add(seccion);
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
	            } 
	
	    }
		return result;
	}
	
	
	public void insertSecciones(SeccionesVO seccionesVO) {
		// TODO Auto-generated method stub
		try {
            String queryString = "INSERT INTO MTS_CURSO_SECCIONES(CVE_GRUPO,CVE_SECCION,DS_SECCION) VALUES('"+seccionesVO.getCveGpo()+"','"+seccionesVO.getCveSecc()+"','"+seccionesVO.getDsSecc()+"');";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.executeQuery();
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
	            } 
	
	    }
	}

	public void updateSecciones() {
		// TODO Auto-generated method stub
		
	}

	public void deleteSecciones() {
		// TODO Auto-generated method stub
		
	}




}
