package com.curso.Welcome.action;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.curso.domain.SuperAction;
@Results({
	@Result(name="success", location="Welcome/Welcome.jsp")
})
public class WelcomeAction extends SuperAction{
	public String execute(){
		return SUCCESS;
	}

}

