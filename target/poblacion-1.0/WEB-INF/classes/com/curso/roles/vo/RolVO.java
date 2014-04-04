package com.curso.roles.vo;

public class RolVO implements Comparable<RolVO>{

	private String cve_rol;
	private String ds_rol;
	private String st_rol;
	
	public String getSt_rol() {
		return st_rol;
	}

	public void setSt_rol(String st_rol) {
		this.st_rol = st_rol;
	}

	private int count=1;
	
	public void add(){
		count++;
	}
	
	public RolVO(){}
	
	@Override
	public boolean equals(Object o){
		
		if(this.cve_rol.equals(
				((RolVO) o).getCve_rol()
				)){
			((RolVO) o).add();
			return true;
		}
		
		return false;
		
	}
	
	public RolVO(String cve, String ds)
	{
		this.cve_rol = cve;
		this.ds_rol = ds;
	}
	
	public String toString(){
		return this.cve_rol + " - " + this.ds_rol + this.count;
	}
	
	public String getCve_rol() {
		return cve_rol;
	}
	public void setCve_rol(String cve_rol) {
		this.cve_rol = cve_rol;
	}
	public String getDs_rol() {
		return ds_rol;
	}
	public void setDs_rol(String ds_rol) {
		this.ds_rol = ds_rol;
	}

	public int compareTo(RolVO o) {
		return this.cve_rol.compareTo(o.getCve_rol());
	}

	
	
}
