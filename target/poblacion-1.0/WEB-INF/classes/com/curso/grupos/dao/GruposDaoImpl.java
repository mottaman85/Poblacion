package com.curso.grupos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.curso.grupos.vo.*;
import com.curso.secciones.vo.SeccionesVO;
import com.curso.utils.ConnectionFactory;

import com.curso.grupos.vo.GruposVO;

public class GruposDaoImpl implements GruposDao{
	
	Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    
    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

	public List<GruposVO> getGrupos() {
		// TODO Auto-generated method stub
		List<GruposVO> result = new ArrayList<GruposVO>();
		try {
            String queryString = "SELECT * FROM MTS_CURSO_GRUPOS";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while ( resultSet.next())
            {
            	GruposVO grupo = new GruposVO();
            	grupo.setClaveGrupo(resultSet.getString("CVE_GRUPO"));
            	grupo.setDescripcionGrupo(resultSet.getString("DS_GRUPO"));
            	result.add(grupo);
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

	public void insertGrupos(GruposVO gruposVO) {
		// TODO Auto-generated method stub
		
	}

	public void updateGrupos(GruposVO gruposVO) {
		// TODO Auto-generated method stub
		
	}

}
