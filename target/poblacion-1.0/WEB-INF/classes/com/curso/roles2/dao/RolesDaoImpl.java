package com.curso.roles2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.curso.domain.CONSTANTESQ;
import com.curso.roles.vo.Estatus;
import com.curso.roles.vo.RolVO;
import com.curso.usuarios.dao.DepositaDatos;
import com.curso.usuarios.vo.UsuarioVO;
import com.curso.utils.ConnectionFactory;

public class RolesDaoImpl implements RolesDao {

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public List<RolVO> getRoles() {

		List<RolVO> result = new ArrayList<RolVO>();

		try {
			String queryString = CONSTANTESQ.SEC;
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();

			while (resultSet.next()) {
				RolVO rol = new RolVO();
				rol.setCve_rol(resultSet.getString("CVE_ROL"));
				rol.setDs_rol(resultSet.getString("DS_ROL"));

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

	public void insertRoles(String clv, String newRol) {
		
		
		try {
            String queryString = CONSTANTESQ.INS2;
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1,clv);
            ptmt.setString(2,newRol);
         
            
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
	
	public void SetRoles(RolVO Datos) throws SQLException {
		
		List<RolVO> result = new ArrayList<RolVO>();
		
		result.add(Datos);

		//Una clase que reciba la lista y la inserte a la BD
		DepositaDatos2 D = new DepositaDatos2();
		D.ListaRoles(result);
	}

	public List<Estatus> getEstado() {
List<Estatus> result = new ArrayList<Estatus>();
		
		
		try {
            String queryString =CONSTANTESQ.EST;
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            
            while ( resultSet.next())
            {
            	Estatus est = new Estatus();
            	est.setEstado(resultSet.getString("ESTATUS"));
            
            
            result.add(est);
            
            
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

	public void updateRoles(String cv, String dsRol) {
try {
			
            String queryString = CONSTANTESQ.UPD;
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            
            ptmt.setString(1, dsRol);
            ptmt.setString(2, cv);
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

	public List<RolVO> getRolesEstatus(String estado) {
		
		

List<RolVO> result = new ArrayList<RolVO>();
		
		
		try {
            String queryString =CONSTANTESQ.ROLEST;
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1,estado);
            resultSet = ptmt.executeQuery();
            
            while ( resultSet.next())
            {
            	RolVO rol = new RolVO();
            rol.setCve_rol(resultSet.getString("CVE_ROL"));
            rol.setDs_rol(resultSet.getString("DS_ROL"));
            
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
	
	
	

}
