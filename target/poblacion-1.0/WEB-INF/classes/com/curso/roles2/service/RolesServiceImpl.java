package com.curso.roles2.service;

import java.util.List;

import com.curso.roles.vo.Estatus;
import com.curso.roles.vo.RolVO;
import com.curso.roles2.dao.RolesDao;
import com.curso.roles2.dao.RolesDaoImpl;

public class RolesServiceImpl implements RolesService{
	
	RolesDao dao;
	

	public List<RolVO> getRoles() {
		
		dao = new RolesDaoImpl();
		
		
		return dao.getRoles();
	}


	public void insertRoles(String clv, String newRol) {
		
		dao = new RolesDaoImpl();
		
		dao.insertRoles(clv, newRol);
		
		
	}


	public List<Estatus> getEstado() {
	dao = new RolesDaoImpl();
	
	
		return dao.getEstado();
	}


	public void updateRoles(String cv, String dsRol) {
		dao = new RolesDaoImpl();
		
		dao.updateRoles(cv, dsRol);
		
	}


	public List<RolVO> getRolesEstatus(String estado) {
		
		
		
		dao = new RolesDaoImpl();
		
		return dao.getRolesEstatus(estado);
	}

	
	
}
