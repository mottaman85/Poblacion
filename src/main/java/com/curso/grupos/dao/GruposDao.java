package com.curso.grupos.dao;

import java.util.List;

import com.curso.grupos.vo.GruposVO;

public interface GruposDao {
	
	public List<GruposVO> getGrupos();
	public void insertGrupos(GruposVO gruposVO);
	public void updateGrupos(GruposVO gruposVO);

}
