package com.curso.password.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import com.curso.Bienvenida;
import com.curso.usuarios.vo.UsuarioVO;
import com.curso.utils.ConnectionFactory;

public class PasswordDaoImpl implements PasswordDao {
	Connection connection = null;
    PreparedStatement sentencia = null;
    ResultSet resultSet = null;
	private static final Logger log = Logger.getLogger(Bienvenida.class);

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

	public UsuarioVO getUsuario(String clave){
		 log.debug("Obteniendo el usuario");
		 UsuarioVO usuario=new UsuarioVO();
		 String query =CONSTANTES.SELUSUARIO;
         try {
			connection = getConnection();
			sentencia = connection.prepareStatement(query);
			sentencia.setString(1,clave);
	        resultSet = sentencia.executeQuery();
	         if(resultSet.next()){
					usuario.setClave(resultSet.getString("CVE_USUARIO"));
					usuario.setIp(resultSet.getString("IP_USUARIO"));
		            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            try {
                if (sentencia != null)
                	sentencia.close();
                if (connection != null)
                        connection.close();
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (Exception e) {
                e.printStackTrace();
        }
		}
         
		return usuario;
	}
	
	public void apdatePassword(String clave,String password){

        String query = CONSTANTES.UPDPASSWORD;
        try {
			connection = getConnection();
			sentencia = connection.prepareStatement(query);
			sentencia.setString(1,password);
			sentencia.setString(2,clave);
			sentencia.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            try {
                if (sentencia != null)
                	sentencia.close();
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
