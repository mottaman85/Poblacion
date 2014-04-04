package com.curso.combos.service;

import java.util.List;

import com.curso.combos.dao.CombosDao;
import com.curso.combos.dao.CombosDaoImpl;
import com.curso.domain.LabelValueBean;

public class CombosServiceImpl implements CombosService{

	private CombosDao dao;
	
	public List<LabelValueBean> getRoles() {
		
		dao = new CombosDaoImpl();
		
		return dao.getRoles();
	}

	public List<LabelValueBean> getMunicipios() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<LabelValueBean> getEstados() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<LabelValueBean> getSecciones() {
		// TODO Auto-generated method stub
		return null;
	}

}
