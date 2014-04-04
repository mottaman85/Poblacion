package com.curso.secciones.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.curso.roles.service.RolesService;
import com.curso.roles.service.RolesServiceImpl;
import com.curso.roles.vo.RolVO;
import com.curso.secciones.dao.SeccionesDao;
import com.curso.secciones.dao.SeccionesDaoImpl;
import com.curso.secciones.service.SeccionesService;
import com.curso.secciones.service.SeccionesServiceImpl;
import com.curso.secciones.vo.SeccionesVO;



public class SeccionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SeccionesDao dao;
	public List<SeccionesVO> listaSecciones= null;
    
	public List<SeccionesVO> getListaSecciones() {
		return listaSecciones;
	}

	public void setListaSecciones(List<SeccionesVO> listaSecciones) {
		this.listaSecciones = listaSecciones;
	}

	SeccionesService service;
    public SeccionesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession();
		
		String eleccion = request.getParameter("desicion");
		if(eleccion!=null){
			System.out.println(eleccion);
			if(eleccion.equals("inserta")){
				insertSecciones(request, response);
			}else if(eleccion.equals("actualiza"))  {
				updateSecciones(request,response);
			}
		}else{
			service = new SeccionesServiceImpl();
			listaSecciones = service.getSecciones();
			httpSession.setAttribute("listaDeSecciones", listaSecciones);
			//if(log.){
				System.out.println("carga inicial");
				for (SeccionesVO r: listaSecciones)
				{
					System.out.println(r.getCveGpo());
					System.out.println(r.getCveSecc());
					System.out.println(r.getDsSecc());
				}
			//}
		}
		response.sendRedirect("secciones/secciones.jsp");
	}
	
	public void updateSecciones(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		String cveGrupo=request.getParameter("grupo");
		String claveSeccion=request.getParameter("seccion");
		String descripcion = request.getParameter("descripcion");
		
		SeccionesServiceImpl impl= new SeccionesServiceImpl();
		
		SeccionesVO seccionesVO = new SeccionesVO();
		seccionesVO.setCveGpo(cveGrupo);
		seccionesVO.setCveSecc(claveSeccion);
		seccionesVO.setDsSecc(descripcion);
		
		impl.updateSecciones(seccionesVO);
	}
	
	public void insertSecciones(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		String cveGrupo=request.getParameter("grupo");
		String claveSeccion=request.getParameter("seccion");
		String descripcion = request.getParameter("descripcion");
		
		SeccionesServiceImpl impl= new SeccionesServiceImpl();
		
		SeccionesVO seccionesVO = new SeccionesVO();
		seccionesVO.setCveGpo(cveGrupo);
		seccionesVO.setCveSecc(claveSeccion);
		seccionesVO.setDsSecc(descripcion);
		
		impl.insertSecciones(seccionesVO);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


}
