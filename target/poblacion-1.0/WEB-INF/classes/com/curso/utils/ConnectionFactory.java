package com.curso.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.curso.domain.CONSTANTES;

public class ConnectionFactory {
	
	String driverClassName = "oracle.jdbc.OracleDriver";

    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {
            try {
                    Class.forName(driverClassName);
            } catch (ClassNotFoundException e) {
                    e.printStackTrace();
            }
    }

    public Connection getConnection() throws SQLException {
            Connection conn = null;
            conn = DriverManager.getConnection(CONSTANTES.JDB_URL,CONSTANTES.USER_DB,CONSTANTES.PASSWORD);
            return conn;
    }

    public static ConnectionFactory getInstance() {
            if (connectionFactory == null) {
                    connectionFactory = new ConnectionFactory();
            }
            return connectionFactory;
    }

}
