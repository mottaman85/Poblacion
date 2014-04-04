package com.curso.roles2.service;

import java.util.List;

import com.curso.roles.vo.Estatus;
import com.curso.roles.vo.RolVO;

public interface RolesService{

	public List<RolVO> getRoles();

	public void insertRoles(String clv, String newRol);
	public List<Estatus> getEstado();
	
	public void updateRoles(String cv, String dsRol);
	public List<RolVO> getRolesEstatus(String estado);
}
