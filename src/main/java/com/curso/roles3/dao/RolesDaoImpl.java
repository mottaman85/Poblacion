package com.curso.roles3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import com.curso.domain.JdbcDao;
import com.curso.domain.LabelValueBean;
import com.curso.roles.vo.Estatus;
import com.curso.roles.vo.RolVO;


public class RolesDaoImpl extends JdbcDao implements RolesDao {
	
	private String qryRoles;
	private String qryStatus;
	
	private String qryRolEst;
	
	private String qryIns;
	private String qryUpd;
	

	

	public String getQryUpd() {
		return qryUpd;
	}

	public void setQryUpd(String qryUpd) {
		this.qryUpd = qryUpd;
	}

	public String getQryIns() {
		return qryIns;
	}

	public void setQryIns(String qryIns) {
		this.qryIns = qryIns;
	}

	public String getQryRolEst() {
		return qryRolEst;
	}

	public void setQryRolEst(String qryRolEst) {
		this.qryRolEst = qryRolEst;
	}

	public String getQryStatus() {
		return qryStatus;
	}

	public void setQryStatus(String qryStatus) {
		this.qryStatus = qryStatus;
	}

	public List<RolVO> getRoles() {

		return this.jdbcTemplate.query(qryRoles, ROL_MAPPER);
	}

	private ParameterizedRowMapper<RolVO> ROL_MAPPER = new ParameterizedRowMapper<RolVO>() {
		public RolVO mapRow(ResultSet rs, int arg1)
				throws SQLException {
			RolVO result = new RolVO();

			result.setCve_rol(rs.getString("CVE_ROL"));
			result.setDs_rol(rs.getString("DS_ROL"));
			result.setSt_rol(rs.getString("ESTATUS"));

			return result;
		}
	};

	
	public String getQryRoles() {
		return qryRoles;
	}

	public void setQryRoles(String qryRoles) {
		this.qryRoles = qryRoles;
	}

	public List<Estatus> getEstado() {
		
		
		
		
		return this.jdbcTemplate.query(qryStatus, ROL_MAPPER2);
	}
	
	
	private ParameterizedRowMapper<Estatus> ROL_MAPPER2 = new ParameterizedRowMapper<Estatus>() {
		public Estatus mapRow(ResultSet rs, int arg1)
				throws SQLException {
			Estatus result = new Estatus();
           
			
			result.setEstado(rs.getString("ESTATUS"));
        	
			
			return result;
		}
	};



	public List<RolVO> getRolesEstatus(String estado) {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.query(qryRolEst, ROL_MAPPER,new Object[] {estado});
	}

	

	public void updateRoles(String dsRol, String cv) {
		this.jdbcTemplate.update(qryUpd, new Object[] { dsRol, cv});
		
	}

	public void insertRoles(String clv, String newRol, String newEst) {
		
		this.jdbcTemplate.update(qryIns, new Object[] { clv, newRol, newEst });
		
	}
}
