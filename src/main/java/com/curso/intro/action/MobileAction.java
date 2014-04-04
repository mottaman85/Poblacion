package com.curso.intro.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.curso.domain.LabelValueBean;
import com.curso.domain.SuperAction;
import com.curso.prueba.service.PruebaService;
import com.curso.roles.vo.RolVO;

@Results({
	@Result(name="success", location="mobile/loguin.jsp")
})
public class MobileAction extends SuperAction{

	@Resource(name="PruebaService")
	private PruebaService service;
	
	List<LabelValueBean> roles;
	
	public String execute(){
		
		
		
		roles = service.getRoles();
		
		return "success";
		
	}

	public List<LabelValueBean> getRoles() {
		return roles;
	}

	public void setRoles(List<LabelValueBean> roles) {
		this.roles = roles;
	}
	
}
