package com.curso.perrol.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.curso.perrol.dao.PermisosPorRolDaoimpl;
import com.curso.perrol.service.PerRolService;
import com.curso.perrol.service.PerRolServiceImpl;
import com.curso.perrol.vo.PerRolVO;
import com.curso.roles.service.RolesService;
import com.curso.roles.service.RolesServiceImpl;
import com.curso.roles.vo.RolVO;
import com.curso.usuarios.dao.UsuariosDaoImpl;
import com.curso.usuarios.vo.UsuarioVO;

/**
 * Servlet implementation class PerRolServ
 */
public class PerRolServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public List<RolVO> listaRoles= null;
	public List<RolVO> getListaRoles() {
	return listaRoles;
	}
	RolesService service;
	
	
    public List<PerRolVO> listaPermisos= null;
    
	public List<PerRolVO> getPermisosPorRol() {
		return listaPermisos;
	}

	PerRolService ServPerRol;
	
	
	

	
	
	
	
	


    /**
     * Default constructor. 
     */
    public PerRolServ() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession = request.getSession();
		service = new RolesServiceImpl();
		   
		listaRoles = service.getRoles();

		httpSession.setAttribute("lista", listaRoles);
		response.sendRedirect("PerRol/PerRol.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Rol = request.getParameter("consultaRol");
		System.out.println(Rol);
		HttpSession httpSession = request.getSession();
		
		System.out.println(Rol);
		ServPerRol = new PerRolServiceImpl();
		listaPermisos = ServPerRol.getPermisosPorRol(Rol);
		
		httpSession.setAttribute("Permisos", listaPermisos);
		response.sendRedirect("PerRol/PerRol.jsp");
		
		

		
		
		
		
		
		
		
		
		
		
		
	}
	

	}


