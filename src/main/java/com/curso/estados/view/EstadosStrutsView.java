package com.curso.estados.view;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.curso.ArgumentosException;
import com.curso.combos.dao.CombosDao;
import com.curso.combos.dao.CombosDaoImpl;
import com.curso.domain.LabelValueBean;
import com.curso.estados.dao.EstadosDao;
import com.curso.estados.dao.EstadosDaoImpl;
import com.curso.estados.service.EstadosStruts;
import com.curso.estados.service.EstadosStrutsImpl;
import com.curso.estados.vo.EstadosVO;
import com.curso.usuarios.dao.UsuariosDao;
import com.curso.usuarios.dao.UsuariosDaoImpl;
import com.curso.usuarios.vo.UsuarioVO;
import com.opensymphony.xwork2.ActionSupport;

public class EstadosStrutsView extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private static final Logger log= Logger.getLogger(EstadosStrutsView.class);
	private List<EstadosVO> estados = new ArrayList<EstadosVO>();
	private EstadosDao esta = new EstadosDaoImpl(); 
	private CombosDao Combodao = new CombosDaoImpl();
	private EstadosDao est = new EstadosDaoImpl(); 
	private static final String TABLA_ESTADOS= "tablaEstados";
	public EstadosVO estvo;
	private EstadosVO estvo2;
	public String clave_update;
	private  EstadosVO estados2 = new EstadosVO();
	public String clave_estado;
	private java.util.List<LabelValueBean> es = new ArrayList<LabelValueBean>();
	public String execute() {
	service = new EstadosStrutsImpl();
		try {
			estados=service.getEstados();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setEs(Combodao.getEstados());
		for(EstadosVO ob:estados){
			log.debug(ob.getNombreEstado());
		}
		return SUCCESS;
	}
	
	public EstadosVO getEstvo() {
		return estvo;
	}

	public void setEstvo(EstadosVO estvo) {
		this.estvo = estvo;
	}

	public EstadosVO getEstvo2() {
		return estvo2;
	}

	public void setEstvo2(EstadosVO estvo2) {
		this.estvo2 = estvo2;
	}

	public String getClave_update() {
		return clave_update;
	}

	public void setClave_update(String clave_update) {
		this.clave_update = clave_update;
	}
	public List<EstadosVO> getEstados() {
		return estados;
	}

	public void setEstados(List<EstadosVO> estados) {
		this.estados = estados;
	}
	public EstadosVO getUsers2() {
		return estados2;
	}

	public void setUsers2(EstadosVO estados2) {
		this.estados2 = estados2;
	}

	EstadosStruts service;

	

	public String insEstado() {
		clave_update = estvo.getCveEstado();
		service = new EstadosStrutsImpl();
		//estvo2 = service.getEstadoSel(clave_update.trim());
		execute();
		return SUCCESS;
	}

	public String busca() throws SQLException{
		log.debug("Dentro de busca");
		estados = est.getEstados();
		estados.add(new EstadosVO("01", "admin", "pass"));
		estados.add(new EstadosVO("02", "admin", "pass"));
		estados.add(new EstadosVO("03", "admin", "pass"));
		for(EstadosVO ob:estados){
			log.debug(ob.getNombreEstado());
		}
		return "tablaEstados";
	}
	
	public String insNewEstado(){
		if(StringUtils.isNotEmpty(estvo.getCveEstado())&&StringUtils.isNotEmpty(estvo.getNombreEstado()))
		{
			if(StringUtils.isAlpha(estvo.getCveEstado()) && StringUtils.isAlphanumeric(estvo.getNombreEstado()))
			   {
				service = new EstadosStrutsImpl();
				//service.insertEstados(estvo.getCveEstado(), estvo.getNombreEstado(), estvo.getPais());
				execute();
				return SUCCESS;
			   }
			else{
				log.debug("Clave de estado y nombre invalidos");
				execute();
				return ERROR;
			}
		}
		else{
			log.debug("Clave de estado y nombre invalidos2");
			execute();
			return ERROR;
		}
	}


	public String updEstado(){
		if(StringUtils.isNotEmpty(estvo2.getCveEstado()))
		{
			if(StringUtils.isAlpha(estvo2.getNombreEstado()) )
			{
				service = new EstadosStrutsImpl();
				//service.updateEstados(estvo2.getCveEstado(), estvo2.getNombreEstado(), estvo.getPais());
				execute();
				return SUCCESS;
			}
			else{
				log.debug("Descricpción no valida en update 1");
				execute();
				return ERROR;
			}
		}
		else{
			log.debug("El campo descripción está vacio en update 2");
			execute();
			return ERROR;
		}
	}

	public java.util.List<LabelValueBean> getEs() {
		return es;
	}

	public void setEs(java.util.List<LabelValueBean> es) {
		this.es = es;
	}
	
	public String recupera() throws ArgumentosException, Exception {
		clave_estado = estvo.getCveEstado();
		log.debug(clave_estado + ":)");
		//estvo = esta.getEstadoSel(clave_estado);
		execute();
		return SUCCESS;
		}
	
}
