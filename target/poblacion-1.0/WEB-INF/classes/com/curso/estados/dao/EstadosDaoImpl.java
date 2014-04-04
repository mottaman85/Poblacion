package com.curso.estados.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.curso.domain.CONSTANTESQ;
import com.curso.estados.vo.EstadosVO;
import com.curso.usuarios.view.UsuariosServlet;
import com.curso.utils.ConnectionFactory;

public class EstadosDaoImpl implements EstadosDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	private static final Logger log =  Logger.getLogger(UsuariosServlet.class);
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public List<EstadosVO> getEstados()throws SQLException{
		List<EstadosVO> result = new ArrayList<EstadosVO>();
			log.debug("Dentro de get stados");  
			String queryString =CONSTANTESQ.SELECTEST;
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while ( resultSet.next())
			{
				
				EstadosVO est = new EstadosVO();
				est.setCveEstado(resultSet.getString("CVE_ESTADO"));
				est.setNombreEstado(resultSet.getString("NOMBRE_EST"));
				est.setPais(resultSet.getString("CVE_PAIS"));
				result.add(est);
			}
		return result;
	}



	public void insertEstados(EstadosVO est) {
		try {
			String queryString = CONSTANTESQ.INSEST;
			connection = getConnection();
			log.debug("dentro de insertar");
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, est.getCveEstado());
			ptmt.setString(2, est.getNombreEstado());
			ptmt.setString(3, est.getPais());
			ptmt.executeUpdate();
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


	public void updateEstados(EstadosVO es)throws SQLException{
	
					log.debug("asdasd");
		            String queryString = CONSTANTESQ.UPDEST;
		            
		            log.debug("UPDATE MTS_CURSO_ESTADO SET NOMBRE_EST="+ es.getNombreEstado()+", CVE_PAIS="+es.getPais()+" WHERE CVE_ESTADO ="+es.getCveEstado());
		            log.debug(queryString);
		            connection = getConnection();
		            log.debug("connection");
		            ptmt = connection.prepareStatement(queryString);
		            log.debug("prepar");
                    ptmt.setString(1,es.getNombreEstado());
		            ptmt.setString(2,es.getPais());
		            ptmt.setString(3,es.getCveEstado());
		            ptmt.executeUpdate();
		            log.debug("execute");
		            
		    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public List<EstadosVO> getEstadoSel(String cveEst) {
		List<EstadosVO> est = new ArrayList<EstadosVO>();
		//EstadosVO es= new EstadosVO();
		try {
			String queryString =CONSTANTESQ.ESTSEL;
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1,cveEst);
			resultSet = ptmt.executeQuery();
			while ( resultSet.next())
			{
				EstadosVO es= new EstadosVO();
				log.debug("*************");
				log.debug(resultSet.getString(1));
				log.debug(resultSet.getString(2));
				log.debug(resultSet.getString(3));
				log.debug("*************");
				es.setCveEstado(resultSet.getString(1));
				es.setNombreEstado(resultSet.getString(2));
				es.setPais(resultSet.getString(3));
				est.add(es);
				
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
		return est;
	}



}
