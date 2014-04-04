package com.curso.login.vo;

public class LoginVO {
	private String cveUsuario;
	private String cveRol;
	private String password;
	private String swActivo;
	private String ip;
	
	
	public String getCveUsuario() {
		return cveUsuario;
	}
	public void setCveUsuario(String cveUsuario) {
		this.cveUsuario = cveUsuario;
	}
	public String getCveRol() {
		return cveRol;
	}
	public void setCveRol(String cveRol) {
		this.cveRol = cveRol;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSwActivo() {
		return swActivo;
	}
	public void setSwActivo(String swActivo) {
		this.swActivo = swActivo;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	
}
