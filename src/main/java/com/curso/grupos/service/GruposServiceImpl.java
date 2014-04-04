package com.curso.grupos.service;

import java.util.List;

import com.curso.grupos.dao.GruposDao;
import com.curso.grupos.dao.GruposDaoImpl;
import com.curso.grupos.vo.GruposVO;
import com.curso.secciones.dao.SeccionesDaoImpl;



public class GruposServiceImpl implements GruposService {

	GruposDao dao;
	
	public List<GruposVO> getGrupos() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertGrupos(GruposVO gruposVO) {
		dao = new GruposDaoImpl();
		dao.updateGrupos(gruposVO);
	}

	public void updateGrupos(GruposVO gruposVO) {
		// TODO Auto-generated method stub
		
	}

}
