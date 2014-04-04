package com.curso.estados.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.curso.estados.dao.EstadosDao;
import com.curso.estados.dao.EstadosDaoImpl;
import com.curso.estados.vo.EstadosVO;
import com.curso.prueba.action.PruebaAction;

public class EstadosStrutsImpl implements EstadosStruts {
	EstadosDao dao;
	private static final Logger log = Logger.getLogger(PruebaAction.class);
	public List<EstadosVO> getEstados() throws SQLException {
		// TODO Auto-generated method stub
		dao= new EstadosDaoImpl();
		return dao.getEstados();
	}

	public void insertEstados(EstadosVO est) {
		dao = new EstadosDaoImpl();
		dao.insertEstados(est);
	}

	public void updateEstados(EstadosVO est) throws SQLException {
		log.debug("EstadosStruts");
		dao = new EstadosDaoImpl();
		dao.updateEstados(est);

	}
	/*public EstadosVO getEstadoSel(String cveEst) {
		
	}*/

	public List<EstadosVO> getEstadoSel(String cveEst) {
		dao = new EstadosDaoImpl();
		return dao.getEstadoSel(cveEst);
	}
}