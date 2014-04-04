package com.curso.prueba.dao;

import java.util.List;

import com.curso.domain.LabelValueBean;
import com.curso.roles.vo.RolVO;

public interface PruebaDao {

	public List<LabelValueBean> getRoles();
	public List<LabelValueBean> getRoles(String cveRol);
	public List<LabelValueBean> getRoles(String cveRol, String status);
	public boolean validaClave(String cve);
	
}
