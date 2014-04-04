package com.curso.password.dao;

public interface CONSTANTES {
	String UPDPASSWORD = "UPDATE MTS_CURSO_USUARIOS set PASSWORD=? WHERE CVE_USUARIO=?";
	String SELUSUARIO="SELECT * FROM MTS_CURSO_USUARIOS WHERE CVE_USUARIO=?";
	
	 
}
