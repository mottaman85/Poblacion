package com.curso.combos.service;

import java.util.List;

import com.curso.domain.LabelValueBean;

public interface CombosService {

	List<LabelValueBean> getRoles();
	List<LabelValueBean> getMunicipios();
	List<LabelValueBean> getEstados();
	List<LabelValueBean> getSecciones();
	
}
