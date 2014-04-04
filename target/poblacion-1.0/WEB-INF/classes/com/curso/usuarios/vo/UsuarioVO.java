package com.curso.usuarios.vo;

public class UsuarioVO {
	private String clave;
	private String rol;
	private String pass;
	private String estatus;
	private String ip;
	
	public UsuarioVO(){}
	public UsuarioVO(String clave, String rol, String pass, String status, String ip){
		this.clave = clave;
		this.rol = rol;
		this.pass = pass;
		this.estatus = status;
		this.ip = ip;
	}
	
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}