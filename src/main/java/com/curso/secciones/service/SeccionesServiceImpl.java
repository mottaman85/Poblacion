package com.curso.secciones.service;

import java.util.List;

import com.curso.secciones.dao.SeccionesDao;
import com.curso.secciones.dao.SeccionesDaoImpl;
import com.curso.secciones.vo.SeccionesVO;

public class SeccionesServiceImpl implements SeccionesService {

	/**
	 * @param args
	 */
	
	SeccionesDao dao;
			
	public void updateSecciones(SeccionesVO seccionesVO) {
		// TODO Auto-generated method stub
		dao = new SeccionesDaoImpl();
		dao.updateSecciones();
	}
	
	public void insertSecciones(SeccionesVO seccionesVO) {
		// TODO Auto-generated method stub
		dao = new SeccionesDaoImpl();
		dao.insertSecciones(seccionesVO);
		
	}
	
	public List<SeccionesVO> getSecciones() {
		// TODO Auto-generated method stub
		dao = new SeccionesDaoImpl();
		return dao.getSecciones();
	}
	
	public void deleteSecciones() {
		// TODO Auto-generated method stub
		dao = new SeccionesDaoImpl();
		dao.deleteSecciones();
		
	}
}
