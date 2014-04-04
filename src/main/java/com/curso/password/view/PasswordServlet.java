package com.curso.password.view;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Debug;

import com.curso.password.service.PasswordServiceImpl;
import com.curso.password.vo.PasswordVO;
import com.curso.usuarios.vo.UsuarioVO;

/**
 * Servlet implementation class PasswordServlet
 */
public class PasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//PasswordVO usuario=new PasswordVO();
		
		String resultado;
		String ip;
		String clave;
		String password;
		
        ip=request.getRemoteAddr();
        clave=request.getParameter("username");
        password=request.getParameter("password");
        
        UsuarioVO user=new UsuarioVO();
        PasswordServiceImpl dao=new PasswordServiceImpl();
        
        user=dao.getUsuario(clave);
        
       if(user.getClave()!=null) 
		{
        	if(ip.equals(user.getIp()))
		         {
	            	dao.updatePassword(clave, password);
	            	resultado="Su contraseña ha sido modificada";
		         }
	            else
	            	resultado="No tienes permiso de modificar la contraseña";
		}else{
			resultado="El nombre del usuario no existe";
		}
        
        request.getSession().setAttribute("resultado",resultado);
        response.sendRedirect("PASSWORD");
	}
	
	
	
     

}
