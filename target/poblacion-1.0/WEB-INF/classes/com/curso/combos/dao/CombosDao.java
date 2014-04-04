package com.curso.combos.dao;

import java.util.List;

import com.curso.domain.LabelValueBean;

public interface CombosDao {

	List<LabelValueBean> getRoles();
	List<LabelValueBean> getMunicipios();
	List<LabelValueBean> getEstados();
	List<LabelValueBean> getSecciones();
	List<LabelValueBean> getGrupos();
	
}
