package com.curso.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.curso.login.vo.LoginVO;
import com.curso.utils.ConnectionFactory;



public class LoginDaoImpl implements LoginDao{
	Connection connection = null;
	 PreparedStatement ptmt = null;
	ResultSet rs = null;
	

	  private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
}
	
	


	public List<LoginVO> getLogin(String user, String pass) {
		List<LoginVO> result = new ArrayList<LoginVO>();
		try {
			String qry="SELECT * FROM MTS_CURSO_USUARIOS WHERE CVE_USUARIO='"+user+"' AND PASSWORD='"+pass+"'";
			connection = getConnection();
			ptmt= connection.prepareStatement(qry);
			rs=ptmt.executeQuery();
			while(rs.next()){
				LoginVO log= new LoginVO();
				log.setCveUsuario(rs.getString("CVE_USUARIO"));
				log.setCveRol(rs.getString("CVE_ROL"));
				log.setPassword(rs.getString("PASSWORD"));
				log.setSwActivo(rs.getString("SW_ACTIVO"));
				log.setIp(rs.getString("IP_USUARIO"));
				result.add(log);
			}
			}catch (Exception e) {
				e.printStackTrace();
				
			}
		return result;
	}


}
