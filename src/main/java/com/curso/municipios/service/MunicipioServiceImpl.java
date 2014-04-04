package com.curso.municipios.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.domain.LabelValueBean;
import com.curso.municipios.dao.MunicipioDao;
import com.curso.municipios.vo.MunicipioVO;

@Service(value="MunicipioService")

public class MunicipioServiceImpl implements MunicipioService {
	@Autowired
	
	MunicipioDao municipios;
	
	public List<MunicipioVO> getMunicipios(String clavestado) {
		return municipios.getMuncipios(clavestado);
	}

	public List<MunicipioVO> getMunicipios() {
		return municipios.getMuncipios();
	}

	public void setMunnicipio(MunicipioVO municipio) throws SQLException{
		municipios.setMunnicipio(municipio);
		
	}

	public void updateMunicipio(MunicipioVO municipio)throws SQLException {
       municipios.actualizaMunicipio(municipio);
	}

	public boolean getClave(String clave) throws SQLException {
		return municipios.getClave(clave);
	}

	public List<LabelValueBean> getEstados() {
		return municipios.getEstados();
	}

	public List<LabelValueBean> getSecciones() {
		return municipios.getSecciones();
	}

	public List<LabelValueBean> getGrupos() {
		return municipios.getGrupos();
	}

}
