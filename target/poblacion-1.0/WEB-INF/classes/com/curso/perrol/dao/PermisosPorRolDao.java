package com.curso.perrol.dao;

import java.util.List;

import com.curso.perrol.vo.PerRolVO;

public interface PermisosPorRolDao {

	public List<PerRolVO> getPermisosPorRol(String cveRol);
	public void insertarPermisosPorRol(String idModulo,String dsPantalla,String Path);
	
}
