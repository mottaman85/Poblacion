package com.curso.alumnos.vo;

public class AlumnosVO {

	private String cve;
	private String nombre;
	private String apellido;
	private String curso;
	
	@Override
	public String toString(){
		return "[CVE] : " + cve + " [NOMBRE] : " + nombre + " [APELLIDO] : " + apellido + " [CURSO] : " + curso;
	}
	
	public String getCve() {
		return cve;
	}
	public void setCve(String cve) {
		this.cve = cve;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
}
