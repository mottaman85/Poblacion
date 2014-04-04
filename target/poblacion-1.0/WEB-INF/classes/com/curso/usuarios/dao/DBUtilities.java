package com.curso.usuarios.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtilities {
	static Connection conexion = null;
	static Statement sentencia = null;
	static ResultSet rs = null;
	
	public static boolean  Conect(){				
			try{
				Class.forName("oracle.jdbc.OracleDriver");
				//conexion = DriverManager.getConnection(CONSTANTES.JDB_URL, CONSTANTES.USER_DB,CONSTANTES.PASSWORD);
				conexion = DriverManager.getConnection("jdbc:oracle:thin:@dev-admin.meltsan.com:1521:MTSDESA","MTS_CURSOS","MT5_CUR505");
				return true;
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}		
	}	
	
	
	public static void Insertar(String SQL)throws SQLException {
		sentencia = conexion.createStatement();
		sentencia.execute(SQL);

	}
	
	
	public static ResultSet qry(String qry) throws SQLException{
		
		sentencia = conexion.createStatement(); //2
		String consultaSQL = qry;
		rs = sentencia.executeQuery(consultaSQL); //
		
		return rs;
		
	}
	public void cerrar() throws SQLException{
		conexion.close();
	}
}
