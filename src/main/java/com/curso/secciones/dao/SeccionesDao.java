package com.curso.secciones.dao;
import java.util.List;

import com.curso.secciones.vo.SeccionesVO;


public interface SeccionesDao {

	/**
	 * @param args
	 */
	
	public List<SeccionesVO> getSecciones();
	public void insertSecciones(SeccionesVO seccionesVo);
	public void updateSecciones();
	public void deleteSecciones();

}
