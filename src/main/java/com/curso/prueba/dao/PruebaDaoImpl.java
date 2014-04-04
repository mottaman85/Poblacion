package com.curso.prueba.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.curso.domain.JdbcDao;
import com.curso.domain.LabelValueBean;

public class PruebaDaoImpl extends JdbcDao implements PruebaDao{

	private String qryUno;
	private String qryFILTRO;
	private String qryValidaCve;
	private String qryValidaCveCount;
	
	public List<LabelValueBean> getRoles() {
		return this.jdbcTemplate.query(qryUno, ROL_MAPPER);
	}
	
	public List<LabelValueBean> getRoles(String cveRol) {
		return this.jdbcTemplate.query(
				qryFILTRO, 
				new Object[]{cveRol},
				ROL_MAPPER);
	}
	
	public List<LabelValueBean> getRoles(String cveRol, String status) {
		StringBuilder sb = new StringBuilder(qryUno);
		ArrayList<String> parameters = new ArrayList<String>();
		
		if(StringUtils.isNotBlank(cveRol)){
			sb.append(" AND CVE_ROL = ? ");
			parameters.add(cveRol);
			
		}else if(StringUtils.isNotBlank(status)){
			
			sb.append(" AND ESTATUS = ? ");
			parameters.add(status);
			
		}
		
		
		return this.jdbcTemplate.query(sb.toString(), parameters.toArray(), ROL_MAPPER);
	}

	
	public boolean validaClave(String cve) {
		boolean result = false;
		try{
			
			ArrayList<String> a = new ArrayList<String>();
			this.jdbcTemplate.queryForObject(qryValidaCve, a.toArray(), String.class);
			return this.jdbcTemplate.queryForInt(qryValidaCveCount, a.toArray()) >0;
		
		}catch (IncorrectResultSizeDataAccessException e) {
			result = true;
		}
			
		return result;
	}

	
	private ParameterizedRowMapper<LabelValueBean> ROL_MAPPER = new ParameterizedRowMapper<LabelValueBean>() {
		public LabelValueBean mapRow(ResultSet rs, int arg1) throws SQLException {
			LabelValueBean result = new LabelValueBean();
			
			result.setLabel(rs.getString(1));
			result.setValue(rs.getString(2));
			
			return result;
		}
	};

	public String getQryUno() {
		return qryUno;
	}

	public void setQryUno(String qryUno) {
		this.qryUno = qryUno;
	}

	public void setQryFILTRO(String qryFILTRO) {
		this.qryFILTRO = qryFILTRO;
	}

	public String getQryValidaCve() {
		return qryValidaCve;
	}

	public void setQryValidaCve(String qryValidaCve) {
		this.qryValidaCve = qryValidaCve;
	}


	public void setQryValidaCveCount(String qryValidaCveCount) {
		this.qryValidaCveCount = qryValidaCveCount;
	}

}
