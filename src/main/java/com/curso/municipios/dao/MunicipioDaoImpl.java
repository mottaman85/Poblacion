package com.curso.municipios.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.curso.domain.JdbcDao;
import com.curso.domain.LabelValueBean;
import com.curso.municipios.vo.MunicipioVO;
import com.curso.usuarios.view.UsuariosStruts;

public class MunicipioDaoImpl extends JdbcDao implements MunicipioDao{
	private static final Logger log = Logger.getLogger(UsuariosStruts.class);	
	private String qryEstados;
	private String qryMunicipios;
	private String qryMunicipiosFiltro;
	private String qrySecciones;
	private String qryGrupos;
	private String updMunicipios;
	private String insertMunicipio;
	private String selectClave;

	
	
	

	public void setQryEstados(String qryEstados) {
		this.qryEstados = qryEstados;
	}

	public void setQryMunicipios(String qryMunicipios) {
		this.qryMunicipios = qryMunicipios;
	}

	public void setQryMunicipiosFiltro(String qryMunicipiosFiltro) {
		this.qryMunicipiosFiltro = qryMunicipiosFiltro;
	}

	public void setQrySecciones(String qrySecciones) {
		this.qrySecciones = qrySecciones;
	}

	public void setQryGrupos(String qryGrupos) {
		this.qryGrupos = qryGrupos;
	}

	public void setUpdMunicipios(String updMunicipios) {
		this.updMunicipios = updMunicipios;
	}

	public void setInsertMunicipio(String insertMunicipio) {
		this.insertMunicipio = insertMunicipio;
	}

	public void setSelectClave(String selectClave) {
		this.selectClave = selectClave;
	}

	public void setMUNICIPIO_MAPPER(
			ParameterizedRowMapper<LabelValueBean> mUNICIPIO_MAPPER) {
		MUNICIPIO_MAPPER = mUNICIPIO_MAPPER;
	}

	public void setSECCIONES_MAPPER(
			ParameterizedRowMapper<LabelValueBean> sECCIONES_MAPPER) {
		SECCIONES_MAPPER = sECCIONES_MAPPER;
	}

	public void setMUNICIPIOS_MAPPER(
			ParameterizedRowMapper<MunicipioVO> mUNICIPIOS_MAPPER) {
		MUNICIPIOS_MAPPER = mUNICIPIOS_MAPPER;
	}

	private ParameterizedRowMapper<LabelValueBean> MUNICIPIO_MAPPER = new ParameterizedRowMapper<LabelValueBean>() {
		public LabelValueBean mapRow(ResultSet rs, int arg1) throws SQLException {
			LabelValueBean result = new LabelValueBean();
			result.setValue(rs.getString(1));
			result.setLabel(rs.getString(2));
			return result;
		}
	};
	private ParameterizedRowMapper<LabelValueBean> SECCIONES_MAPPER = new ParameterizedRowMapper<LabelValueBean>() {
		public LabelValueBean mapRow(ResultSet rs, int arg1) throws SQLException {
			LabelValueBean result = new LabelValueBean();
			result.setValue(rs.getString(1));
			result.setLabel(rs.getString(3));
			return result;
		}
	};
	
	
	
	private ParameterizedRowMapper<MunicipioVO> MUNICIPIOS_MAPPER = new ParameterizedRowMapper<MunicipioVO>() {
		public MunicipioVO mapRow(ResultSet rs, int arg1) throws SQLException {
			MunicipioVO result = new MunicipioVO();
			result.setClave(rs.getString(1));
			result.setSeccion(rs.getString(2));
			result.setGrupo(rs.getString(3));
			result.setNombre(rs.getString(4));
			result.setEstado(rs.getString(5));
			result.setPais(rs.getString(6));
			return result;
		}
	};
	
	
	
	

	
	
	
	public List<MunicipioVO> getMuncipios() {
		return this.jdbcTemplate.query(qryMunicipios, MUNICIPIOS_MAPPER);
	}

	public List<MunicipioVO> getMuncipios(String clvEstado) {
		return this.jdbcTemplate.query(
				qryMunicipiosFiltro, 
				new Object[]{clvEstado},
				MUNICIPIOS_MAPPER);
	}
	

	public void actualizaMunicipio(MunicipioVO municipio) throws SQLException {
		
		this.jdbcTemplate.update(updMunicipios,new Object[]{municipio.getSeccion(), municipio.getGrupo(),municipio.getNombre(),municipio.getPais(),municipio.getClave()} );
		
	}

	public void setMunnicipio(MunicipioVO municipio) throws SQLException {
		 this.jdbcTemplate.update(insertMunicipio, new Object[] {municipio.getClave(),municipio.getSeccion(), municipio.getGrupo(),municipio.getNombre(),municipio.getEstado().trim(),municipio.getPais()});
		}

		
	public boolean getClave(String clave) throws SQLException {
		Object claveMun = jdbcTemplate.queryForObject(selectClave,
				new Object[] {clave}, String.class);
		if (claveMun!=null)
			return true;
		
		return false;
	}

	public List<LabelValueBean> getEstados() {
		return this.jdbcTemplate.query(qryEstados, MUNICIPIO_MAPPER);
	}

	public List<LabelValueBean> getSecciones() {
		return this.jdbcTemplate.query(qrySecciones, SECCIONES_MAPPER);
	}

	public List<LabelValueBean> getGrupos() {
		return this.jdbcTemplate.query(qryGrupos, MUNICIPIO_MAPPER);
	}

}
