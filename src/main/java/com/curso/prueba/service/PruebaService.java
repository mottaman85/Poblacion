package com.curso.prueba.service;

import java.util.List;

import com.curso.domain.LabelValueBean;
import com.curso.roles.vo.RolVO;

public interface PruebaService {

	public List<LabelValueBean> getRoles();
	public List<LabelValueBean> getRoles(String cveRol);
	public List<LabelValueBean> getRoles(String cveRol, String estatus);
}
