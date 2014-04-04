package com.curso.usuarios.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.curso.roles.service.RolesService;
import com.curso.roles.service.RolesServiceImpl;
import com.curso.roles.vo.RolVO;
import com.curso.usuarios.vo.UsuarioVO;

/**
 * Servlet implementation class UsuarioServletCombo
 */
public class UsuarioServletCombo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RolesService service;    
    java.util.List<UsuarioVO> dao2; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServletCombo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession();
		
		service = new RolesServiceImpl();
		
		
		
		java.util.List<RolVO> listaRoles = service.getRoles();
							
	
		
		for (RolVO r: listaRoles)
		{
			System.out.println(r.getCve_rol());
			System.out.println(r.getDs_rol());
		}
		
		httpSession.setAttribute("lista", listaRoles);
		response.sendRedirect("Usuarios/Usuario.jsp");	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
