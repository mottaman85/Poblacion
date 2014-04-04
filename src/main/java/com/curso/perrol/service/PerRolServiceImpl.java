package com.curso.perrol.service;

import java.util.List;

import com.curso.perrol.dao.PermisosPorRolDao;
import com.curso.perrol.dao.PermisosPorRolDaoimpl;
import com.curso.perrol.vo.PerRolVO;
import com.curso.roles.dao.RolesDao;
import com.curso.roles.dao.RolesDaoImpl;
import com.curso.roles.service.RolesService;
import com.curso.roles.vo.RolVO;

public class PerRolServiceImpl implements PerRolService{
	
	PermisosPorRolDao dao ;
	

	public List<PerRolVO> getPermisosPorRol(String cveRol) {
		dao = new PermisosPorRolDaoimpl();
		return dao.getPermisosPorRol(cveRol);
	}
	
	public void insertarPermisosPorRol(String idModulo,String dsPantalla,String Path) {
		dao = new PermisosPorRolDaoimpl();
		
	}
	
}


