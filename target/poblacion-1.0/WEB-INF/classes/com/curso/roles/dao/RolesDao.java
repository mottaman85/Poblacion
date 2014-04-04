package com.curso.roles.dao;

import java.util.List;

import com.curso.roles.vo.Estatus;
import com.curso.roles.vo.RolVO;



public interface RolesDao {
	
	public List<RolVO> getRoles();
	
	public RolVO getRolSel(String cveRol);
	public void insertRoles(String clv, String newRol, String newStatus);
	public void updateRoles(String cv, String dsRol);
	
	public List<Estatus> getEstado();
	
	public List<RolVO> getRolesEstatus(String estado);
	
	

}
