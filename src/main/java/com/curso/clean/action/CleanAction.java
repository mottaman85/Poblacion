package com.curso.clean.action;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.curso.domain.SuperAction;

@Results({
	@Result(name="success", location="clean/clean.jsp")
})
public class CleanAction extends SuperAction{

	public String execute(){
		return SUCCESS;
	}
	
}
