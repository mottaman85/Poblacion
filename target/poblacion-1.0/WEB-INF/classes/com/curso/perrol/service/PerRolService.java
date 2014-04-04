package com.curso.perrol.service;

import java.util.List;

import com.curso.perrol.vo.PerRolVO;

public interface PerRolService {
	public List<PerRolVO> getPermisosPorRol(String cveRol );
	public void insertarPermisosPorRol(String idModulo,String dsPantalla,String Path);
}
