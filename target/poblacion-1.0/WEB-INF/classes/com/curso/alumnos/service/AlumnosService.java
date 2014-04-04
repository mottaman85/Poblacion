package com.curso.alumnos.service;

import java.util.List;

import com.curso.alumnos.vo.AlumnosVO;

public interface AlumnosService {

	public List<AlumnosVO> buscaUsuarios();

	public boolean validaCve(String string);
	
}
