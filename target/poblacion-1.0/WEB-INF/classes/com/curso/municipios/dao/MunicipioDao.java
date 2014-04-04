package com.curso.municipios.dao;
import java.sql.SQLException;
import java.util.List;

import com.curso.municipios.vo.MunicipioVO;
public interface MunicipioDao {
	
	public List<MunicipioVO>getMuncipios();
	public List<MunicipioVO>getMuncipios(String clvEstado);
	public MunicipioVO getMuncicipio(String clvMunicipio) ;
	public void actualizaMunicipio(MunicipioVO municipio)throws SQLException;
	public void setMunnicipio(MunicipioVO municipio)throws SQLException;
	public boolean getClave(String clave)throws SQLException;
	
}
