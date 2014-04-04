package com.curso.grupos.service;

import java.util.List;

import com.curso.grupos.vo.GruposVO;

public interface GruposService {
	
	public List<GruposVO> getGrupos();
	public void insertGrupos(GruposVO gruposVO);
	public void updateGrupos(GruposVO gruposVO);
	
}
