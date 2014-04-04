package com.curso.municipios.service;
import java.sql.SQLException;
import java.util.List;

import com.curso.domain.LabelValueBean;
import com.curso.municipios.vo.MunicipioVO;
public interface MunicipioService {	
	public List<MunicipioVO> getMunicipios(String clavestado);
	public List<MunicipioVO> getMunicipios();
	public List<LabelValueBean> getEstados();
	public List<LabelValueBean> getSecciones();
	public List<LabelValueBean> getGrupos();
	public void setMunnicipio(MunicipioVO municipio) throws SQLException;
	public void updateMunicipio(MunicipioVO municipio)throws SQLException;
	public boolean getClave(String clave)throws SQLException;
	
}
