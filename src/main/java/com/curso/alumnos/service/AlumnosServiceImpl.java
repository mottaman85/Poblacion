package com.curso.alumnos.service;

import java.util.List;

import com.curso.alumnos.dao.AlumnosDao;
import com.curso.alumnos.dao.AlumnosDaoImpl;
import com.curso.alumnos.vo.AlumnosVO;

public class AlumnosServiceImpl implements AlumnosService{

	AlumnosDao dao;
	
	public List<AlumnosVO> buscaUsuarios() {
		dao = new AlumnosDaoImpl();
		return dao.buscaUsuarios();
	}

	public boolean validaCve(String string) {
		// TODO Auto-generated method stub
		return false;
	}

}
