package com.curso.prueba.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.curso.domain.JdbcDao;
import com.curso.roles.vo.RolVO;

public class PruebaDaoImpl extends JdbcDao implements PruebaDao{

	private String qryUno;
	
	public List<RolVO> getRoles() {
		return this.jdbcTemplate.query(qryUno, ROL_MAPPER);
	}
	
	private ParameterizedRowMapper<RolVO> ROL_MAPPER = new ParameterizedRowMapper<RolVO>() {
		public RolVO mapRow(ResultSet rs, int arg1) throws SQLException {
			RolVO result = new RolVO();
			
			result.setCve_rol(rs.getString(1));
			result.setDs_rol(rs.getString(2));
			
			return result;
		}
	};

	public String getQryUno() {
		return qryUno;
	}

	public void setQryUno(String qryUno) {
		this.qryUno = qryUno;
	}
	
}
