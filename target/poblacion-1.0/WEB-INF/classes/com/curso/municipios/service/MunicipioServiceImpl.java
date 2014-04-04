package com.curso.municipios.service;

import java.sql.SQLException;
import java.util.List;

import com.curso.municipios.dao.MunicipioDaoImpl;
import com.curso.municipios.vo.MunicipioVO;

public class MunicipioServiceImpl implements MunicipioService {
	
	MunicipioDaoImpl municipios;
	public List<MunicipioVO> getMunicipios(String clavestado) {
		municipios= new MunicipioDaoImpl();
		return municipios.getMuncipios(clavestado);
	}

	public MunicipioVO getMunicipio(String clvMunicipio) {
		municipios= new MunicipioDaoImpl();
		return municipios.getMuncicipio(clvMunicipio);
	}


	public List<MunicipioVO> getMunicipios() {
		municipios= new MunicipioDaoImpl();
		return municipios.getMuncipios();
	}

	public void setMunnicipio(MunicipioVO municipio) throws SQLException{
		municipios=new MunicipioDaoImpl();
		municipios.setMunnicipio(municipio);
		
	}

	public void updateMunicipio(MunicipioVO municipio)throws SQLException {
       municipios=new MunicipioDaoImpl();
       municipios.actualizaMunicipio(municipio);
	}

	public boolean getClave(String clave) throws SQLException {
		municipios= new MunicipioDaoImpl();
		return municipios.getClave(clave);
	}

}
