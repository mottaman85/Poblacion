package com.curso.estados.service;

import java.sql.SQLException;
import java.util.List;

import com.curso.estados.vo.EstadosVO;
import com.curso.login.vo.LoginVO;

public interface EstadosStruts {
	public List<EstadosVO> getEstados() throws SQLException;
	public void insertEstados(EstadosVO est);
	public void updateEstados(EstadosVO est) throws SQLException;
	public List<EstadosVO> getEstadoSel(String cveEst);

	
}
