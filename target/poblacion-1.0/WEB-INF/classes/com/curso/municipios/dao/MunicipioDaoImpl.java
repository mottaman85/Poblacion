package com.curso.municipios.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.components.Debug;

import com.curso.domain.CONSTANTESQ;
import com.curso.municipios.vo.MunicipioVO;
import com.curso.usuarios.view.UsuariosStruts;
import com.curso.utils.ConnectionFactory;
public class MunicipioDaoImpl implements MunicipioDao{
	private static final Logger log = Logger.getLogger(UsuariosStruts.class);	
	Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
	
    private Connection getConnection() throws SQLException {
          Connection conn;
          conn = ConnectionFactory.getInstance().getConnection();
          return conn;
	}
	  
	public List<MunicipioVO> getMuncipios(String clavestado) {
		List<MunicipioVO> result = new ArrayList<MunicipioVO>();
		try {
            String query =CONSTANTES.SECMUNICIPIO;
            connection = getConnection();
            ptmt = connection.prepareStatement(query);
            ptmt.setString(1,clavestado);
            resultSet = ptmt.executeQuery();
            log.debug("Consulta de munipios realizada");
            while ( resultSet.next())
            {
            	MunicipioVO municipio = new MunicipioVO();
            	
            	municipio.setClave(resultSet.getString("CVE_MUNICIPIO"));
            	municipio.setSeccion(resultSet.getString("CVE_SECCION"));
            	municipio.setGrupo(resultSet.getString("CVE_GRUPO"));
            	municipio.setNombre(resultSet.getString("NOMBRE_MUN"));
            	municipio.setEstado(resultSet.getString("CVE_ESTADO"));
            	municipio.setPais(resultSet.getString("CVE_PAIS"));
            	result.add(municipio);

            }
            log.debug("ciclo terminado");
            
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
	log.debug("Regresando lista de municipios");
	
	return result;
}
	
	

	public MunicipioVO getMuncicipio(String clvMunicipio) {
		
			 log.debug("Obteniendo el municipio");
			 MunicipioVO municipio=new MunicipioVO();
			 String query =CONSTANTES.SECMUNICIPIO;
	         try {
				connection = getConnection();
				ptmt= connection.prepareStatement(query);
				ptmt.setString(1,clvMunicipio);
		        resultSet = ptmt.executeQuery();
		         if(resultSet.next()){
		        	    municipio.setClave(resultSet.getString("CVE_MUNICIPIO"));
		            	municipio.setSeccion(resultSet.getString("CVE_SECCION"));
		            	municipio.setGrupo(resultSet.getString("CVE_GRUPO"));
		            	municipio.setNombre(resultSet.getString("NOMBRE_MUN"));
		            	municipio.setEstado(resultSet.getString("CVE_ESTADO"));
		            	municipio.setPais(resultSet.getString("CVE_PAIS"));
			            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	            try {
	                if (ptmt!= null)
	                	ptmt.close();
	                if (connection != null)
	                        connection.close();
	        } catch (SQLException e) {
	                e.printStackTrace();
	        } catch (Exception e) {
	                e.printStackTrace();
	        }
			}
	         
			return municipio;
	
	}

	public void actualizaMunicipio(MunicipioVO municipio) throws SQLException{
			
			            connection = getConnection();
			            ptmt = connection.prepareStatement(CONSTANTES.UPDMUNICIPIOS);
			            ptmt.setString(1,municipio.getSeccion().trim());
			            ptmt.setString(2,municipio.getGrupo().trim());
			            ptmt.setString(3,municipio.getNombre());
			           // ptmt.setString(4,municipio.getEstado());
			            ptmt.setString(4,municipio.getPais());
			            ptmt.setString(5,municipio.getClave());
			            ptmt.executeUpdate();
			                    if (ptmt != null)
			                            ptmt.close();
			                    if (connection != null)
			                            connection.close();	
		
	}

	public List<MunicipioVO> getMuncipios()  {
		List<MunicipioVO> result = new ArrayList<MunicipioVO>();
		try {
            String query =CONSTANTES.SECMUNICIPIOS;
            connection = getConnection();
            ptmt = connection.prepareStatement(query);
            resultSet = ptmt.executeQuery();
            log.debug("Consulta de munipios realizada");
            while ( resultSet.next())
            {
            	MunicipioVO municipio = new MunicipioVO();
            	
            	municipio.setClave(resultSet.getString("CVE_MUNICIPIO"));
            	municipio.setSeccion(resultSet.getString("CVE_SECCION"));
            	municipio.setGrupo(resultSet.getString("CVE_GRUPO"));
            	municipio.setNombre(resultSet.getString("NOMBRE_MUN"));
            	municipio.setEstado(resultSet.getString("CVE_ESTADO"));
            	municipio.setPais(resultSet.getString("CVE_PAIS"));
            	result.add(municipio);

            }
            log.debug("ciclo terminado");
            
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
	log.debug("Regresando lista de municipios");
	
	return result;
	}

	public void setMunnicipio(MunicipioVO municipio)throws SQLException {
			
	            String queryString = CONSTANTES.INSERTMUNICIPIO;
	            connection = getConnection();
	            ptmt = connection.prepareStatement(queryString);
	            ptmt.setString(1,municipio.getClave());
	            ptmt.setString(2,municipio.getSeccion().trim());
	            ptmt.setString(3,municipio.getGrupo().trim());
	            ptmt.setString(4,municipio.getNombre());
	            ptmt.setString(5,municipio.getEstado().trim());
	            ptmt.setString(6,municipio.getPais());
	            ptmt.executeUpdate();
	            log.debug("Insert realizado en la base de datos");
	            if (ptmt != null)
	                     ptmt.close();
	            if (connection != null)
	                    connection.close();

	}
	
	public boolean getClave(String clave) throws SQLException {
		boolean existe;
		String query =CONSTANTES.SELECTMUNI;
		connection = getConnection();
		ptmt= connection.prepareStatement(query);
		ptmt.setString(1,clave);
        resultSet = ptmt.executeQuery();
         if(resultSet.next())
        	 existe=true;
         else
        	 existe=false;
         if (ptmt!= null)
            	ptmt.close();
          if (connection != null)
               connection.close();
        
    return existe;
	}
}
