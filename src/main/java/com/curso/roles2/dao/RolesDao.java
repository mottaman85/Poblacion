package com.curso.roles2.dao;

import java.sql.SQLException;
import java.util.List;

import com.curso.roles.vo.Estatus;
import com.curso.roles.vo.RolVO;

public interface RolesDao {
	
	public List<RolVO> getRoles();
	
	public void insertRoles(String clv, String newRol);
	public void SetRoles(RolVO Datos) throws SQLException;
	public List<Estatus> getEstado();
	
	public void updateRoles(String cv, String dsRol);
	
	public List<RolVO> getRolesEstatus(String estado);
	

}
