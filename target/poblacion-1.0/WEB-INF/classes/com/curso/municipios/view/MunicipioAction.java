package com.curso.municipios.view;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.curso.combos.dao.CombosDao;
import com.curso.combos.dao.CombosDaoImpl;
import com.curso.domain.LabelValueBean;
import com.curso.municipios.dao.MunicipioDaoImpl;
import com.curso.municipios.service.MunicipioServiceImpl;
import com.curso.municipios.vo.MunicipioVO;
import com.curso.usuarios.view.UsuariosStruts;
import com.opensymphony.xwork2.ActionSupport;
@Results({
	@Result(name="success", location="Municipios/municipios.jsp"),
	@Result(name="tablaMunicipios", location="Municipios/tabla-municipios.jsp")
})
public class MunicipioAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String TABLA_MUNICIPIOS="tablaMunipios";
	private static final Logger log = Logger.getLogger(UsuariosStruts.class);	
	private MunicipioServiceImpl municipio = new MunicipioServiceImpl(); 
	private CombosDao Combodao = new CombosDaoImpl();
	private List<LabelValueBean> estados = new ArrayList<LabelValueBean>();
	private List<MunicipioVO> municipios= new ArrayList<MunicipioVO>();
    private MunicipioVO muni=new MunicipioVO();
    private String estado;
    private String numero;
	
    public MunicipioVO getMuni() {
		return muni;
	}

	public void setMuni(MunicipioVO muni) {
		this.muni = muni;
	}

	public String busca(){
		
		municipios =municipio.getMunicipios(estado.trim());
		//municipios =municipio.getMunicipios();

		return TABLA_MUNICIPIOS;
	}
    
	

	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public MunicipioServiceImpl getMunicipio() {
		return municipio;
	}

	public void setMunicipio(MunicipioServiceImpl municipio) {
		this.municipio = municipio;
	}

	

	
	
	public String execute(){
		String result = SUCCESS;
		estados = Combodao.getEstados();	
		if(false){
			return SUCCESS;
		}
		return result;
	}
    
	public List<LabelValueBean> getEstados() {
		return estados;
	}

	public void setEstados(List<LabelValueBean> estados) {
		this.estados = estados;
	}

	public List<MunicipioVO> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<MunicipioVO> municipios) {
		this.municipios = municipios;
	}
	
	

}
