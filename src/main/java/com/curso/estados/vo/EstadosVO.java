package com.curso.estados.vo;

public class EstadosVO {
	private String cveEstado;
	private String nombreEstado;
	private String pais;
	
	public EstadosVO(String cveEstado, String nombreEstado, String pais ){
		this.cveEstado = cveEstado;
		this.nombreEstado = nombreEstado;
		this.pais = pais;
	}
	
	public EstadosVO(){
		
	}
	
	public String getCveEstado() {
		return cveEstado;
	}
	public void setCveEstado(String cveEstado) {
		this.cveEstado = cveEstado;
	}
	public String getNombreEstado() {
		return nombreEstado;
	}
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}


}
