package com.curso.roles.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.curso.domain.SuperAction;
import com.curso.login.view.LoginView;
import com.curso.roles.service.RolesService;
import com.curso.roles.service.RolesServiceImpl;
import com.curso.roles.vo.Estatus;
import com.curso.roles.vo.RolVO;

@Results({
	@Result(name="success", location="Roles/roles.jsp"),
	@Result(name="tablaRoles", location="Roles/tabla-roles.jsp")
})

public class RolesAction extends SuperAction
{
	
	
	private static final Logger log= Logger.getLogger(LoginView.class);
	private List<RolVO> roles = new ArrayList<RolVO>();
	public List<RolVO> getRoles() {
		return roles;
	}

	public void setRoles(List<RolVO> roles) {
		this.roles = roles;
	}


	private List<Estatus> listaEstatus = new ArrayList<Estatus>();
	
	private String selEstado;
	
    private String editReg;
    
    private String editReg2;
    
    private String insCve;
    private String insDs;
    private String insSta;
    
    

	
	public String getInsCve() {
		return insCve;
	}

	public void setInsCve(String insCve) {
		this.insCve = insCve;
	}

	public String getInsDs() {
		return insDs;
	}

	public void setInsDs(String insDs) {
		this.insDs = insDs;
	}

	public String getInsSta() {
		return insSta;
	}

	public void setInsSta(String insSta) {
		this.insSta = insSta;
	}

	public String getEditReg2() {
		return editReg2;
	}

	public void setEditReg2(String editReg2) {
		this.editReg2 = editReg2;
	}

	public String getEditReg() {
		return editReg;
	}

	public void setEditReg(String editReg) {
		this.editReg = editReg;
	}

	public String getSelEstado() {
		return selEstado;
	}

	public void setSelEstado(String selEstado) {
		this.selEstado = selEstado;
	}

	public List<Estatus> getListaEstatus() {
		return listaEstatus;
	}

	public void setListaEstatus(List<Estatus> listaEstatus) {
		this.listaEstatus = listaEstatus;
	}


	private static final String TABLA_ROLES="tablaRoles";

	public RolVO rolvo;
	private RolVO rolvo2;
	public String clave_update;
	
	public String getClave_update() {
		return clave_update;
	}

	public void setClave_update(String clave_update) {
		this.clave_update = clave_update;
	}

	
	RolesService service;

	public String execute() {
		
		
		
		service = new RolesServiceImpl();
	    listaEstatus = service.getEstado();
		
	    
	   for (Estatus e : listaEstatus)
	   {
		   System.out.println(e.getEstado());
		   
	   }

		service = new RolesServiceImpl();
		roles = service.getRoles();

		

		return SUCCESS;

	}
	
	
	
	public String  statusDisp()
	{
		service = new RolesServiceImpl();
	    listaEstatus = service.getEstado();
		
	    
	   for (Estatus e : listaEstatus)
	   {
		   System.out.println(e.getEstado());
		   
	   }
	   
	   
		return SUCCESS;
	}
	
	
	////Metodo para editar
	
	public String EditarRegistro()
	{
		
		System.out.println("aqui va el registro que hay que editar"+editReg);
		System.out.println("aqui va el registro2 que hay que editar"+editReg2);
		
		

				service = new RolesServiceImpl();
				service.updateRoles(editReg.trim(),editReg2);
				
				
				
				return TABLA_ROLES;
				
			  
		
	}
	
	
	public String buscar() {
		
		
		System.out.println("++++++++++++++++++ Aqui vamos"+selEstado);
		
		
		
		service = new RolesServiceImpl();
		roles = service.getRolesEstatus(selEstado);
		
		for (RolVO r: roles)
		{
			System.out.println(r.getCve_rol());
			System.out.println(r.getDs_rol());
		}
		

		
		System.out.println("+++++++++++++++fin++++++++++");
		
	    
		return TABLA_ROLES;
	}

	public String insRol() {
		
		
	 clave_update = rolvo.getCve_rol();
	 
		

		service = new RolesServiceImpl();

		rolvo2 = service.getRolSel(clave_update.trim());

		
		execute();
		return SUCCESS;
	}


	public String insNewRol(){
		
		System.out.println("Aqui van los valores +++++++++++++++++++++++++++++++++++++++++");
		System.out.println(insCve);
		System.out.println(insDs);
		System.out.println(insSta);
		
		service = new RolesServiceImpl();
		service.insertRoles(insCve, insDs, insSta);
		
		
		return TABLA_ROLES;
		
		/*if(StringUtils.isNotEmpty(rolvo.getCve_rol())&&StringUtils.isNotEmpty(rolvo.getDs_rol())&&StringUtils.isNotEmpty(rolvo.getSt_rol())){
			if(StringUtils.isAlpha(rolvo.getDs_rol()) && StringUtils.isAlphanumeric(rolvo.getCve_rol())&&StringUtils.isNotEmpty(rolvo.getSt_rol()))
			   {
				
				service = new RolesServiceImpl();
				System.out.println("Aqui van los valores +++++++++++++++++++++++++++++++++++++++++");
				System.out.println(rolvo.getCve_rol());
				System.out.println(rolvo.getDs_rol());
				System.out.println(rolvo.getSt_rol());
				
				service.insertRoles(rolvo.getCve_rol(), rolvo.getDs_rol(),rolvo.getSt_rol());
				
			
				return SUCCESS;
				
			   }
			else{
				log.debug("Rol y descripicón no validos");
				execute();
				return ERROR;
			}
		}
		else{
			log.debug("Campor Rol o descripcion vacios");
			execute();
			return ERROR;
		}
		*/
		

	}
	
	
	public String updRol(){
		
		if(StringUtils.isNotEmpty(rolvo2.getDs_rol())){
			
			if(StringUtils.isAlpha(rolvo2.getDs_rol()) )
			   {
				

				service = new RolesServiceImpl();
				service.updateRoles(rolvo2.getCve_rol(), rolvo2.getDs_rol());
				execute();
				return SUCCESS;
				
			   }
			else{
				log.debug("Descricpción no valida");
				execute();
				return ERROR;
			}
		}
		else{
			log.debug("El campo descripción está vacio");
			execute();
			return ERROR;
		}
		
		
		
		

	}
	
	public RolVO getRolvo2() {
		return rolvo2;
	}

	public void setRolvo2(RolVO rolvo2) {
		this.rolvo2 = rolvo2;
	}

	public RolVO getRolvo() {
		return rolvo;
	
	


}
}
