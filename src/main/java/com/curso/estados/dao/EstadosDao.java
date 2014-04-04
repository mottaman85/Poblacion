package com.curso.estados.dao;

import java.sql.SQLException;
import java.util.List;

import com.curso.estados.vo.EstadosVO;



public interface EstadosDao {

	public List<EstadosVO> getEstados() throws SQLException;
	//public void insertEstados(String cve_estado, String nombre,String pais);
	public void insertEstados(EstadosVO est); 
	public void updateEstados(EstadosVO est) throws SQLException;
	public List<EstadosVO> getEstadoSel(String cveEst);
	
}
