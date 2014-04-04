package com.curso.secciones.service;

import java.util.List;

import com.curso.secciones.vo.*;

public interface SeccionesService {

	/**
	 * @param args
	 */
	public List<SeccionesVO> getSecciones();
	public void insertSecciones(SeccionesVO seccionesVO);
	public void updateSecciones(SeccionesVO seccionesVO);
	public void deleteSecciones();

}
