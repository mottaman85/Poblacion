package com.curso.perrol.vo;

public class PerRolVO {
	private String idModulo;
	private String dsPantalla;
	private String Path;
	
	
	public PerRolVO(){
	
	}
	
	
	public PerRolVO(String idModulo,String dsPantalla, String path){
		this.idModulo =  idModulo;
		this.dsPantalla = dsPantalla;
		this.Path = path;
	}
	public String getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(String idModulo) {
		this.idModulo = idModulo;
	}
	public String getDsPantalla() {
		return dsPantalla;
	}
	public void setDsPantalla(String dsPantalla) {
		this.dsPantalla = dsPantalla;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}

}
