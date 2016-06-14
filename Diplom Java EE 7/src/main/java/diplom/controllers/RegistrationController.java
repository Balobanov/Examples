package diplom.controllers;

import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Size;

import diplom.ejbs.UserEjb;
import diplom.entities.Address;
import diplom.entities.Groups;
import diplom.entities.User;
import diplom.hash.password.HashPassword;

@Named
@RequestScoped
public class RegistrationController {
	
	@Inject
	private UserEjb uEjb;
	
	private Address adr = new Address();
	private Groups group = new Groups(2, "Patient");
	private User user = new User();
	
	@Size(min = 8, max = 64)
	private String SHAPassword = "";
	
	
	public Address getAdr() {
		return adr;
	}
	public void setAdr(Address adr) {
		this.adr = adr;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getSHAPassword() {
		return SHAPassword;
	}
	public void setSHAPassword(String sHAPassword) {
		SHAPassword = sHAPassword;
	}
	public void register(ActionEvent e)
	{
		boolean reg = true;
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		user.setAddress(adr);
		user.setGroup(group);
		
		user.setUser_password(HashPassword.hashPass(SHAPassword));
		
		try
		{
			uEjb.insertOrUpdate(user);
		}
		catch(EJBException ee)
		{
			reg = false;
		}
		
		if(!reg)
		ctx.addMessage(null, new FacesMessage("Ошибка ввода данных."));
		else
		ctx.addMessage(null, new FacesMessage("Регистрация прошла успешно."));
		
	}

}
