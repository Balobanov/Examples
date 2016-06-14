package diplom.controllers;


import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import diplom.calculate.grade.CalculateGrade;
import diplom.constraints.SugarSize;
import diplom.ejbs.UserEjb;
import diplom.entities.CardiovascularSystem;
import diplom.entities.Diabet;
import diplom.entities.Saturation;
import diplom.entities.User;

@Named
@RequestScoped
public class UserController {

	@Inject
	private UserEjb userEjb;
	
	@Inject
	private CalculateGrade calc;
	
	private User user;
	private String login;
	
	

	/*
	 * Для оценки здоровья
	 */

	private Saturation satur = new Saturation();
	private CardiovascularSystem cs = new CardiovascularSystem();
	private Diabet diabet =  new Diabet();
	
	@PostConstruct
	public void init() {
	    login = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
	    user = userEjb.findByLogin(login);
	    
	    if(user.getCardiovascularSystem() != null)
	    {
	    	cs.setDiastolic(user.getCardiovascularSystem().getDiastolic());
	    	cs.setSystolic(user.getCardiovascularSystem().getSystolic());
	    	cs.setPulse(user.getCardiovascularSystem().getPulse());
	    	cs.setTemperature(user.getCardiovascularSystem().getTemperature());
	    }
	    
	    if(user.getDiabet() != null)
	    {
	    	diabet.setSugar(user.getDiabet().getSugar());
	    }
	    
	    if(user.getSaturation() != null)
	    {
	    	satur.setOxygen(user.getSaturation().getOxygen());
	    }
	    
	}
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}

	public Saturation getSatur() {
		return satur;
	}

	public void setSatur(Saturation satur) {
		this.satur = satur;
	}

	public CardiovascularSystem getCs() {
		return cs;
	}

	public void setCs(CardiovascularSystem cs) {
		this.cs = cs;
	}

	public Diabet getDiabet() {
		return diabet;
	}

	public void setDiabet(Diabet diabet) {
		this.diabet = diabet;
	}

	/***************************************************/


	public void calculateGrade(ActionEvent e)
	{	
		user.setCardiovascularSystem(cs);
		user.setDiabet(diabet);
		user.setSaturation(satur);
		
		user.setGrade(calc.calculate(user));
		user = userEjb.insertOrUpdate(user);
		
		gradeInfo(user);
		//return "index.xhtml";
	}
	
	private void gradeInfo(User user)
	{
		karnofskyInfo(user.getGrade());
		saturationInfo(user.getSaturation());
		diabetInfo(user.getDiabet());
		CardiovascularSystemInfo(user.getCardiovascularSystem());
	}
	
	private void karnofskyInfo(float grade)
	{
		FacesContext ctx = FacesContext.getCurrentInstance();
		if(grade > 90.f)
			ctx.addMessage(null, new FacesMessage("Оценка = " + grade + ". Состояние нормальное."));
	}
	
	private void saturationInfo(Saturation s)
	{
		FacesContext ctx = FacesContext.getCurrentInstance();
		if(s.getOxygen() <= 94.0f)
		ctx.addMessage(null, new FacesMessage("Сатурация: гипоксия, срочно обратитесь к врачу."));
		else
		if(s.getOxygen() >= 95.0f)
			ctx.addMessage(null, new FacesMessage("Сатурация: в норме"));
	}
	
	private void diabetInfo(Diabet d)
	{
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		if(d.getSugar() >= 3.5f && d.getSugar() <= 5.5f)
		{
			ctx.addMessage(null, new FacesMessage("Диабет: уровень сахара в норме."));
		}
		else
		if(d.getSugar() >= 5.6f && d.getSugar() <= 6.0f)
		{
			ctx.addMessage(null, new FacesMessage("Диабет: преддиабетное состояние."));
		}
		else
		if(d.getSugar() >= 6.1f && d.getSugar() <= 20.0f)
		{
			ctx.addMessage(null, new FacesMessage("Диабет: у вас диабет."));
		}
		else
		if(d.getSugar() > 20.0f)
		{
			ctx.addMessage(null, new FacesMessage("Диабет: диабетическая кома. Как вы вообще прошли тест?"));
		}
	}
	
	private void CardiovascularSystemInfo(CardiovascularSystem cs)
	{
		FacesContext ctx = FacesContext.getCurrentInstance();
		int pulse = cs.getPulse();
		/*
		 * Пульс
		 */
		if(pulse >= 32 && pulse <= 48)
		{
			ctx.addMessage(null, new FacesMessage("Пульс: выраженная брадикардия"));
		}
		else
		if(pulse >= 49 && pulse <= 59)
		{
			ctx.addMessage(null, new FacesMessage("Пульс: умеренная брадикардия"));
		}
		else
		if(pulse >= 60 && pulse <= 84)
		{
			ctx.addMessage(null, new FacesMessage("Пульс: физиологическая норма"));
		}
		else
		if(pulse >= 85 && pulse <= 95)
		{
			ctx.addMessage(null, new FacesMessage("Пульс: тахикардия"));	
		}
		else
		if(pulse >= 96 && pulse <= 118)
		{
			ctx.addMessage(null, new FacesMessage("Пульс: выраженная тахикардия"));	
		}
		else
		if(pulse < 32 || pulse > 118)
		{
			ctx.addMessage(null, new FacesMessage("Пульс: СРОЧНО К ВРАЧУ!"));	
		}
			
		
		
		/*
		 * Давление
		 */
		int dys = cs.getDiastolic();
		int sys = cs.getSystolic();
		
		if((sys >= 106 && sys <= 129) && (dys >= 80 && dys <= 85))
			ctx.addMessage(null, new FacesMessage("Давление: нормальное давление."));
		else
		if((sys >= 100 && sys <= 105) && (dys >= 55 && dys <= 80))
			ctx.addMessage(null, new FacesMessage("Давление: склонность к гипотонии."));
		else
		if((sys >= 130 && sys <= 139) && (dys >= 85 && dys <= 89))
			ctx.addMessage(null, new FacesMessage("Давление: повышенное давление."));
		else
		if((sys >= 140 && sys <= 159) && (dys >= 90 && dys <= 99))
			ctx.addMessage(null, new FacesMessage("Давление: умеренная гипертония."));
		else
		if((sys >= 90 && sys <= 99) && (dys >= 45 && dys <= 54))
			ctx.addMessage(null, new FacesMessage("Давление: гипотония."));
		else
		if((sys >= 160 && sys <= 179) && (dys >= 100 && dys <= 109))
			ctx.addMessage(null, new FacesMessage("Давление: гипертония средней тяжести."));
		else
		if(sys > 180 && dys > 110)
			ctx.addMessage(null, new FacesMessage("Давление: тяжелая гипертония."));
		else
		if((sys >= 75 && sys <= 89) && (dys >= 20 && dys <= 44))
			ctx.addMessage(null, new FacesMessage("Давление: выраженная гипотония."));
		/*
		 * Температура
		 */
		float temp = cs.getTemperature();
		
		if(temp >= 36.0f && temp <= 36.6f)
			ctx.addMessage(null, new FacesMessage("Температура: нормальная."));
		else
		if(temp >= 36.7f && temp <= 38.0f)
			ctx.addMessage(null, new FacesMessage("Температура: повышенная"));
		else
		if(temp > 38.0f && temp <= 40.0f)
			ctx.addMessage(null, new FacesMessage("Температура: высокая температура"));
		else
		if(temp > 40.0f)
			ctx.addMessage(null, new FacesMessage("Температура: чрезмерно высокая"));
		else
		if(temp >= 34.0f && temp < 36.0f)
			ctx.addMessage(null, new FacesMessage("Температура: пониженная"));
		else
		if(temp < 34.0f)
			ctx.addMessage(null, new FacesMessage("Температура: низкая"));
	}
}
