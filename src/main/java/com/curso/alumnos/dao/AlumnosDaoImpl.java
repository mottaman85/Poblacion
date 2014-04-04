package com.curso.alumnos.dao;

import java.util.ArrayList;
import java.util.List;

import com.curso.alumnos.vo.AlumnosVO;

public class AlumnosDaoImpl implements AlumnosDao{

	public List<AlumnosVO> buscaUsuarios() {

		List<AlumnosVO> res = new ArrayList<AlumnosVO>();
		
		for(int i=0; i<100; i++){
		
		AlumnosVO al = new AlumnosVO();
		al.setApellido("Mota"+i);
		al.setNombre("Paulino " + i);
		al.setCve("000"+i);
		al.setCurso("Papirrin"+i);
		
		res.add(al);
		}
		return res;
	}

}
