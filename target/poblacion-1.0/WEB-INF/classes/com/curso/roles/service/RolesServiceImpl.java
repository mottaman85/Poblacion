package com.curso.roles.service;

import java.util.List;

import com.curso.roles.dao.RolesDao;
import com.curso.roles.dao.RolesDaoImpl;
import com.curso.roles.vo.Estatus;
import com.curso.roles.vo.RolVO;


public class RolesServiceImpl implements RolesService {

	RolesDao dao;
	
	public List<RolVO> getRoles() {
		
		dao = new RolesDaoImpl();
		
		

		return dao.getRoles();
	}


	public RolVO getRolSel(String cveRol) {
		
		
		dao = new RolesDaoImpl();
		
		return dao.getRolSel(cveRol);
	}


	public void insertRoles(String clv, String newRol, String newStatus) {
		
		dao = new RolesDaoImpl();
		dao.insertRoles(clv, newRol, newStatus);
		
		
	}


	public void updateRoles(String cv, String dsRol) {
		dao = new RolesDaoImpl();
		
		dao.updateRoles(cv, dsRol);
		
		
	}


	public List<Estatus> getEstado() {
		
		
		dao = new RolesDaoImpl();
		
		return dao.getEstado();
	}


	public List<RolVO> getRolesEstatus(String estado) {
		
		dao = new RolesDaoImpl();
		
		return dao.getRolesEstatus(estado);
	}


	
	
	

}
