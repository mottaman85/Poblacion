package com.curso.login.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


import com.curso.login.dao.LoginDao;
import com.curso.login.dao.LoginDaoImpl;
import com.curso.login.service.LoginService;
import com.curso.login.service.LoginServiceImpl;
import com.curso.login.vo.LoginVO;
import com.curso.roles.dao.RolesDao;
import com.curso.roles.dao.RolesDaoImpl;
import com.curso.roles.service.RolesService;

/**
 * Servlet implementation class LogiServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public List<LoginVO> listaVO=null;
	private  static final Logger log= Logger.getLogger(LoginServlet.class);
	
    public LoginServlet() {
        super();	
    }
    LoginService service;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("Entrando a Loggin");
		service= new LoginServiceImpl();
		boolean estado;
		String user= request.getParameter("usuario");
	 	String pas= request.getParameter("password");

	 	if(StringUtils.isNotEmpty(user) && StringUtils.isNotEmpty(pas))
		   {	
			 if(StringUtils.isAlpha(user) && StringUtils.isAlphanumeric(pas) && !StringUtils.isWhitespace(user) && !StringUtils.isWhitespace(pas))
			   {
				 listaVO = service.getLogin(user,pas);
				   if(listaVO.size()!=0){
		 				request.getSession().setAttribute("userVO", "listaVO"); 
		 				log.debug("Datos correctos");
		 				response.sendRedirect("WELCOME");   			   	
			   }
			   else
			   {
				   log.debug("Error Datos invalidos");
				   response.sendRedirect("LOGGER");  
			   }
		   }
			 else{
				 log.debug("Error Datos invalidos");
				 response.sendRedirect("LOGGER"); 
			 }
		   }
	 	else{
	 		log.debug("Error Datos invalidos");
			response.sendRedirect("LOGGER");
	 	}
	}
		   
	 	
	 	
	 	//*****************

	
	 	

	 
		
		
		/*
		 
		 if(StringUtils.isNotEmpty(datousuario) && StringUtils.isNotEmpty(password))
		   {	
			  
			   
			   if(StringUtils.isAlpha(datousuario) && StringUtils.isAlphanumeric(password) && !StringUtils.isWhitespace(datousuario) && !StringUtils.isWhitespace(password))
			   {
				    log.debug("Datos correctos");
				    estado=true;	   			   	
			   }
			   else
			   {
				   log.debug("Datos incorrectos");
				   estado=false;
			   }
		   
		   }
		   else
		   {
			   log.debug("Campos vac�os");
			   estado=false;
		   }
		 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
