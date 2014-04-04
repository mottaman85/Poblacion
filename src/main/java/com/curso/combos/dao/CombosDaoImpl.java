package com.curso.combos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.curso.domain.CONSTANTESQRY;
import com.curso.domain.LabelValueBean;
import com.curso.municipios.dao.CONSTANTES;
import com.curso.municipios.vo.MunicipioVO;
import com.curso.utils.ConnectionFactory;

public class CombosDaoImpl implements CombosDao{

	Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
	
	  private Connection getConnection() throws SQLException {
          Connection conn;
          conn = ConnectionFactory.getInstance().getConnection();
          return conn;
  }
	
	public List<LabelValueBean> getRoles() {
		
		List<LabelValueBean> result = new ArrayList<LabelValueBean>();
		
		
		try {
            String queryString =CONSTANTESQRY.SEC;
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            
            while ( resultSet.next())
            {
            	LabelValueBean rol = new LabelValueBean();
            rol.setValue(resultSet.getString("CVE_ROL"));
            rol.setLabel(resultSet.getString("DS_ROL"));
            
            result.add(rol);
            
            
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

	public List<LabelValueBean> getMunicipios() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<LabelValueBean> getEstados() {
		
			List<LabelValueBean> result = new ArrayList<LabelValueBean>();
			try {
	            String query =CONSTANTES.SECESTADOS;
	            connection = getConnection();
	            ptmt = connection.prepareStatement(query);
	            resultSet = ptmt.executeQuery();
	            
	            while ( resultSet.next())
	            {
	            	LabelValueBean estado = new LabelValueBean();
	            	estado.setValue(resultSet.getString(1));
	            	estado.setLabel(resultSet.getString(2));
	            	result.add(estado);
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

	public List<LabelValueBean> getSecciones() {
		List<LabelValueBean> result = new ArrayList<LabelValueBean>();
		try {
            String queryString =CONSTANTESQRY.SECC;
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            
            while ( resultSet.next())
            {
            	LabelValueBean sec = new LabelValueBean();
	            sec.setValue(resultSet.getString("CVE_SECCION"));
	            sec.setLabel(resultSet.getString("DS_SECCION"));
	            result.add(sec);
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

	public List<LabelValueBean> getGrupos() {
		List<LabelValueBean> result = new ArrayList<LabelValueBean>();
		try {
            String queryString =CONSTANTESQRY.GPOS;
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            
            while ( resultSet.next())
            {
            	LabelValueBean gpo = new LabelValueBean();
	            gpo.setValue(resultSet.getString("CVE_GRUPO"));
	            gpo.setLabel(resultSet.getString("DS_GRUPO"));
	            result.add(gpo);
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
	
	public List<LabelValueBean> getEstatus() {
		
		List<LabelValueBean> result = new ArrayList<LabelValueBean>();
		try {
            String query =CONSTANTES.SESTATUS;
            connection = getConnection();
            ptmt = connection.prepareStatement(query);
            resultSet = ptmt.executeQuery();
            
            while ( resultSet.next())
            {
            	LabelValueBean estatus = new LabelValueBean();
            	estatus.setValue(resultSet.getString(1));
            	estatus.setLabel(resultSet.getString(1));
            	result.add(estatus);
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
	
	
	}}
