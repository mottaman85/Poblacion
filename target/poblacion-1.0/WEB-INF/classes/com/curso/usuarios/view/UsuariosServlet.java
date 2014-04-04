package com.curso.usuarios.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.curso.ArgumentosException;
import com.curso.roles.service.RolesService;
import com.curso.roles.service.RolesServiceImpl;
import com.curso.roles.vo.RolVO;
import com.curso.usuarios.dao.UsuariosDao;
import com.curso.usuarios.dao.UsuariosDaoImpl;
import com.curso.usuarios.vo.UsuarioVO;

/**
 * Servlet implementation class UsuariosServlet
 */
public class UsuariosServlet extends HttpServlet {

	private static final String SALIR = "1";
	private static final String CONSULTAROL = "0";
	private static final String EDITAR = "2";
	
	private static final String USUARIOS = "USUARIOS";
	private static final String WELCOME = "WELCOME";

	private static final long serialVersionUID = 1L;

	UsuariosDao dao; 
    java.util.List<UsuarioVO> dao2;
    RolesService service;
    public List<RolVO> listaRoles= null;
    RolesService rolService;
    
    private static final Logger log =  Logger.getLogger(UsuariosServlet.class);
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuariosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		log.debug("dentro del servlet Usuarios...");
		
		// TODO Auto-generated method stub
		String clave = request.getParameter("clave");
		String rol = request.getParameter("rol");
		String pass  = request.getParameter("pass");
		String estatus = request.getParameter("estatus");
		String  ip = request.getParameter("ip");
		rolService = new RolesServiceImpl();
		
		HttpSession httpSession = request.getSession();
		
		
		dao = new UsuariosDaoImpl();
		

		service = new RolesServiceImpl();
		listaRoles = rolService.getRoles();
		
		
		
		try {
			dao.SetUsuarios(clave, rol, pass, estatus, ip);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dao2 = dao.GetUsuarios();
		
		if(log.isDebugEnabled()){
		for (UsuarioVO r: dao2)
		{
			log.debug(r.getClave() +" "+ r.getRol()+" "+r.getPass() +" "+r.getEstatus() +" "+r.getIp() );
			
		}			
		}
		
		httpSession.setAttribute("UsuarioR", dao2);
		httpSession.setAttribute("lista", listaRoles);

		System.out.println("redirect");
		response.sendRedirect(USUARIOS);
		System.out.println("redirect fin");
						 
		
		
		
		//response.sendRedirect("localhost:8080/poblacion/Usuario.jsp");		 
		
		//System.out.println("Datos: "+ clave+ "| "+rol+ "| "+pass+ "| "+estatus+ "| "+ip);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession httpSession = request.getSession();
		String cveRol = request.getParameter("cveRol");
		String cveAccion = request.getParameter("consultaRol");
		String cveUsr = request.getParameter("cveUsr");
		
		dao = new UsuariosDaoImpl();
		
		log.debug("[CVE ROL ] " + cveRol);
		log.debug("[CVE USR ] " + cveUsr);
		log.debug("[CVE ACCION ] " + cveAccion);
		
		rolService = new RolesServiceImpl();
		listaRoles = rolService.getRoles();
		httpSession.setAttribute("lista", listaRoles);
		
		if(CONSULTAROL.equals(cveAccion)){

			try {
				log.debug("Dentro de CONSULTAROL");
				dao2 = dao.GetUsuarios(cveRol);
			
			} catch (ArgumentosException e) {
				log.debug("ERROR DE ARGUMENTOS...");
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			} catch (Exception e) {
				log.debug("Dentro de sql exception.....");
				httpSession.setAttribute("msj", e.getCause());
				response.sendRedirect("ERROR");
			
			}
			httpSession.setAttribute("UsuarioR", dao2);
			response.sendRedirect(USUARIOS);

		}else if(SALIR.equals(cveAccion)){
			
			response.sendRedirect(WELCOME);
			
		}else if(EDITAR.equals(cveAccion)){
			
			UsuarioVO usr = new UsuarioVO();
			usr.setClave(cveUsr);
			usr.setRol("Uno");
			
			httpSession.setAttribute("usrEdit", usr);
			response.sendRedirect(USUARIOS);
			
		}
		
	}

}
