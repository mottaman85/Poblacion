package com.curso.secciones.view;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.curso.ArgumentosException;
import com.curso.secciones.dao.SeccionesDao;
import com.curso.secciones.dao.SeccionesDaoImpl;
import com.curso.secciones.vo.SeccionesVO;
import com.curso.combos.dao.CombosDao;
import com.curso.combos.dao.CombosDaoImpl;
import com.curso.domain.LabelValueBean;
import com.curso.grupos.dao.GruposDao;
import com.curso.grupos.dao.GruposDaoImpl;
import com.curso.grupos.vo.GruposVO;
import com.curso.usuarios.vo.UsuarioVO;
import com.opensymphony.xwork2.ActionSupport;

public class SeccionesStruts extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	
	private GruposVO grupoCombo;
	private List<LabelValueBean> grupos = new ArrayList<LabelValueBean>();
	
	private GruposDao gpoDao = new GruposDaoImpl();
	
	private static final Logger log = Logger.getLogger(SeccionesStruts.class);
	private CombosDao comboDao = new CombosDaoImpl();
	
	private SeccionesVO seccion = new SeccionesVO();
	private List<LabelValueBean> seccionesLV = new ArrayList<LabelValueBean>();
	
	private SeccionesDao secDao = new SeccionesDaoImpl();
	
	private java.util.List<SeccionesVO> seccionesL= new ArrayList<SeccionesVO>();
	private static final String TABLA_SECCIONES= "tablaSecciones";
	
	public String buscaSecc(){
		seccionesL = secDao.getSecciones();
		
		
		return TABLA_SECCIONES;
	}
	
	public String execute(){
		log.debug("Dentro de Secciones Action");
		
		String result = SUCCESS;
		grupos = comboDao.getGrupos();
		
		if(false){
			result = ERROR;
		}
		return result;
	}


	public GruposVO getGrupoCombo() {
		return grupoCombo;
	}


	public void setGrupoCombo(GruposVO grupoCombo) {
		this.grupoCombo = grupoCombo;
	}


	public List<LabelValueBean> getGrupos() {
		log.debug("Dentro de grupos get");
		return grupos;
	}


	public String setGrupos(List<LabelValueBean> grupos) {
		
		log.debug("metodo insert");
		gpoDao.getGrupos();
		execute();
		return SUCCESS;
	}
	
	GruposVO gpos = new GruposVO();
	
	public String recupera() throws ArgumentosException, Exception {
		

		log.debug(seccionesL + ":)");
		
		execute();
		return SUCCESS;
		}

	public SeccionesVO getSecciones() {
		return (SeccionesVO) seccionesL;
	}

	public void setSecciones(SeccionesVO secciones) {
		this.seccionesL = (List<SeccionesVO>) secciones;
	}
	
}
