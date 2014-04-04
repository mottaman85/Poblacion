package com.curso.roles3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.domain.LabelValueBean;
import com.curso.roles.vo.Estatus;
import com.curso.roles.vo.RolVO;
import com.curso.roles3.dao.RolesDao;

@Service(value="RolesService")
public class RolesServiceImpl implements RolesService{
	
	
	@Autowired
	RolesDao rolesDao;

	public List<RolVO> getRoles() {
		// TODO Auto-generated method stub
		return rolesDao.getRoles();
	}

	public List<Estatus> getEstado() {
		// TODO Auto-generated method stub
		return rolesDao.getEstado();
	}

	public List<RolVO> getRolesEstatus(String estado) {
		// TODO Auto-generated method stub
		return rolesDao.getRolesEstatus(estado);
	}



	public void updateRoles(String cv, String dsRol) {
		rolesDao.updateRoles(cv, dsRol);
		
		
	}

	public void insertRoles(String clv, String newRol, String newEst) {
		rolesDao.insertRoles(clv, newRol, newEst);
		
	}

}
