package com.curso.login.view;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.curso.login.service.LoginService;
import com.curso.login.service.LoginServiceImpl;
import com.curso.login.vo.LoginVO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginView extends ActionSupport{
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
public List<LoginVO> listaVO=null;
private static final Logger log= Logger.getLogger(LoginView.class);
LoginService service;
private String user;
private String pass;

public String execute()
{
	return SUCCESS;
}

public String getUser() {
	return user;
}

public void setUser(String user) {
	this.user = user;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}

public String conectar(){
	log.debug("Dentro del método de conexión");
	service = new LoginServiceImpl();
	if(StringUtils.isNotEmpty(user)&&StringUtils.isNotEmpty(pass)){
		if(StringUtils.isAlpha(user) && StringUtils.isAlphanumeric(pass))
		   {
			listaVO = service.getLogin(user, pass);
			if(listaVO.size()!=0){
				log.debug("Datos correctos");
				log.debug("redireccionando a welcome");
				return "ok";
			}
			else{
				log.debug("no existe el usuario");
				return  "error";
			}
		   }
		else{
			log.debug("COntraseña o user contiene smbolos raros");
			return "error";
		}
	}
	else{
		log.debug("Contraseña o usuario en blanco");
		return "error";
	}
}
}
