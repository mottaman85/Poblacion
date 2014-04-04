package com.curso.roles3.service;

import java.util.List;

import com.curso.domain.LabelValueBean;
import com.curso.roles.vo.Estatus;
import com.curso.roles.vo.RolVO;


public interface RolesService {
	
	public List<RolVO> getRoles();

	public List<Estatus> getEstado();
	public List<RolVO> getRolesEstatus(String estado);
	public void insertRoles(String clv, String newRol, String newEst);
	public void updateRoles(String cv, String dsRol);
	
}
