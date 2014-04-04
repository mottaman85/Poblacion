package com.curso.usoyui.action;



import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.curso.domain.SuperAction;


@Results({
	@Result(name="success", location="/usoyui/usoyui.jsp")
})
public class UsoYuiAction extends SuperAction{

	public String execute(){
		return SUCCESS;
	}
	
}