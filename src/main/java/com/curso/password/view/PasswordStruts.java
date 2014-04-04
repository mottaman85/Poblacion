package com.curso.password.view;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.curso.Bienvenida;
import com.curso.password.service.PasswordServiceImpl;
import com.curso.usuarios.vo.UsuarioVO;
import com.opensymphony.xwork2.ActionSupport;


public class PasswordStruts extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Bienvenida.class);
    private String password;
    private String conpassword;
    private String username;
    private String ip;
    private String resultado;
    private HttpServletRequest request;
   
    
    public String execute()
    {
    	
    	return SUCCESS;
    }
    
    public String getConpassword() {
		return conpassword;
	}

	public void setConpassword(String conpassword) {
		this.conpassword = conpassword;
	}

	public HttpServletRequest getServletRequest(){
    	  return request;
    	  }
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
    
	public String recuperarPassword()
	{
		
      UsuarioVO user=new UsuarioVO();
      if(StringUtils.isNotEmpty(username)){
    	if(StringUtils.isAlpha(username)){
        if(!StringUtils.isWhitespace(password)){
        	if(!StringUtils.isWhitespace(conpassword))
        	{
        		if(password.length()<8)
        			resultado="La contraseña debe ser mayor a ocho dígitos";
        		else{
        			if(password.equals(conpassword))
        			{
        				PasswordServiceImpl dao=new PasswordServiceImpl();
        				user=dao.getUsuario(username);
        				ip=getServletRequest().getRemoteAddr();

        				log.debug("la ip del cleinte es:" +ip);
        				if(user.getClave()!=null) 
        				{
        					if(ip.equals(user.getIp()))
        				         {
        				        	dao.updatePassword(username, password);
        				        	resultado="Su contraseña ha sido modificada";
        				         }
        				        else
        				        	resultado="No tienes permiso de modificar la contraseña";
        				}else{
        					resultado="El nombre del usuario no existe";
        				}
        			}else
        				resultado="Las contraseñas no coinciden";
        		}
        	}else
        		resultado="No se aceptan espacios en blanco";
        }else
        	resultado="No se aceptan espacios en blanco";
    	
      }else
    	  resultado="El usuario tiene simbolos raros";
      
      }else
        	resultado="El nombre del usuario es obligatorio";
      
		return "error";
		
	}
	
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	

}













