package com.curso.municipios.service;
import java.sql.SQLException;
import java.util.List;

import com.curso.municipios.vo.MunicipioVO;
public interface MunicipioService {	
	public List<MunicipioVO> getMunicipios();
	public MunicipioVO getMunicipio(String clvMunicipio);
	public void setMunnicipio(MunicipioVO municipio) throws SQLException;
	public void updateMunicipio(MunicipioVO municipio)throws SQLException;
	public boolean getClave(String clave)throws SQLException;
	
}
