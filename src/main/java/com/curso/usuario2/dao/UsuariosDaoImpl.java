package com.curso.usuario2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import com.curso.domain.JdbcDao;
import com.curso.usuarios.vo.UsuarioVO;
public class UsuariosDaoImpl extends JdbcDao implements UsuariosDao {

	
	private String qryUno;
	private String qryDos;
	private String qryTres;
	private String qryCuatro;
	private String qryCinco;
	
		
	
	
	public void setUsuario(UsuarioVO usuario) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update(qryCuatro, new Object[]{usuario.getClave(),usuario.getRol(),usuario.getPass(),usuario.getEstatus(),usuario.getIp()});
	}

	public UsuarioVO getUsuario(String cveUsu) {
		// TODO Auto-generated method stub
		return (UsuarioVO) this.jdbcTemplate.query(
				qryTres, 
				new Object[]{cveUsu},
				ROL_MAPPER);
	}

	public List<UsuarioVO> getUsuarios() {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.query(qryUno, ROL_MAPPER);
		
	}

	public List<UsuarioVO> getUsuarios(String cveRol) {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.query(
				qryDos, 
				new Object[]{cveRol},
				ROL_MAPPER);
	}

	public void actualizaUsuario(UsuarioVO usu) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update(qryCinco, new Object[]{usu.getRol(),usu.getPass(),usu.getEstatus(),usu.getIp(),usu.getClave()});
		
	}
	
	
	private ParameterizedRowMapper<UsuarioVO> ROL_MAPPER = new ParameterizedRowMapper<UsuarioVO>() {
		public UsuarioVO mapRow(ResultSet rs, int arg1) throws SQLException {
			UsuarioVO result = new UsuarioVO();
			
			result.setClave(rs.getString(1) );
			result.setRol(rs.getString(2));
			result.setPass(rs.getString(3));
			result.setEstatus(rs.getString(4));
			result.setIp(rs.getString(5));
						
			return result;
		}
	};





	public String getQryUno() {
		return qryUno;
	}

	public void setQryUno(String qryUno) {
		this.qryUno = qryUno;
	}

	public String getQryDos() {
		return qryDos;
	}

	public void setQryDos(String qryDos) {
		this.qryDos = qryDos;
	}

	public String getQryTres() {
		return qryTres;
	}

	public void setQryTres(String qryTres) {
		this.qryTres = qryTres;
	}

	public String getQryCuatro() {
		return qryCuatro;
	}

	public void setQryCuatro(String qryCuatro) {
		this.qryCuatro = qryCuatro;
	}

	public String getQryCinco() {
		return qryCinco;
	}

	public void setQryCinco(String qryCinco) {
		this.qryCinco = qryCinco;
	}
	
	
	
	
	
}
