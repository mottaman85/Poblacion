
package com.curso.roles.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument.Iterator;

import com.curso.roles.dao.RolesDao;
import com.curso.roles.dao.RolesDaoImpl;
import com.curso.roles.service.RolesService;
import com.curso.roles.service.RolesServiceImpl;
import com.curso.roles.vo.*;

/**
 * Servlet implementation class RolServlet
 */
public class RolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public List<RolVO> listaRoles= null;
    
	public List<RolVO> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(List<RolVO> listaRoles) {
		this.listaRoles = listaRoles;
	}
	
	public RolVO  rol= null;

	
	

	public RolVO getRol() {
		return rol;
	}

	public void setRol(RolVO rol) {
		this.rol = rol;
	}

	RolesService service;
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RolServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession httpSession = request.getSession();
		
		//Valores A EDITAR
		
		
		
			String cvEd = request.getParameter("idupd2");
			
			if(cvEd!= null)
			{
			
			System.out.println("El valor a modificar"+cvEd);
			
			service = new RolesServiceImpl();
			
			rol = service.getRolSel(cvEd);
			

			
			
			}
		
		
		String ec = request.getParameter("editCve");
		String ec2 = request.getParameter("editDs");
		
		if(ec != null)
		{
			
			service = new RolesServiceImpl();
			
			service.updateRoles(ec, ec2);
			
			
		}
		
		
		
	
		
		
		

		
		
		
	   /* String newRol = request.getParameter("newRol");
	    String clv = request.getParameter("newClave");
	    
	    
	    if (newRol!=null)
	   {
	     System.out.println(newRol);
	     service = new RolesServiceImpl();
	     service.insertRoles(clv, newRol);
	    }
	     */
	    
		service = new RolesServiceImpl();
		listaRoles = service.getRoles();
		
		
		
	
		httpSession.setAttribute("lista", listaRoles);
		
		
		
		
		
		
		
		
		response.sendRedirect("Roles/MostrarRoles.jsp");
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
