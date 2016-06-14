package diplom.controllers;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class LogoutController {
	public String logout() {
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		ExternalContext externalContext = facesContext.getExternalContext();
		
		HttpSession session = (HttpSession)
				
		externalContext.getSession(true);
		
		session.invalidate();
		
		return "login.xhtml";
	}
	
	public String userIndex()
	{
		return "index.xhtml";
	}
}