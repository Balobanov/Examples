package diplom.calculate.grade;

import javax.ejb.Stateless;

import diplom.entities.CardiovascularSystem;
import diplom.entities.Diabet;
import diplom.entities.Saturation;
import diplom.entities.User;

@Stateless
public class CalculateGrade {
	
	public float calculate(User u)
	{
		return 0.4086f * Lccc(u.getCardiovascularSystem()) + 1.6231f * Lsaturation(u.getSaturation()) + 0.482f * Ldiabet(u.getDiabet()) - 151.37f;
	}	
	
	private float Lsaturation(Saturation s)
	{
		return s.getOxygen();
	}
	
	private float Ldiabet (Diabet diabet)
	{
		float sugar = diabet.getSugar(); // Количество сахара в крови
		float dia = 0.f; // Оценка уровня сахара в крови в %.
		
		/*
		 * Перевод уровня сахара к процентной шкале.
		 */
		if(sugar >= 3.5f && sugar <= 5.5f)
		{
			dia = 100.f;
		}
		else
		if(sugar >= 5.6f && sugar <= 20.0f)
		{
			float x = sugar;
			float x2 = sugar * sugar;
			float x3 = sugar * sugar * sugar;
			
			dia = 203.858f - 25.061f * x + 1.06f + x2 - 0.015f * x3;
		}
		else
		dia = 0.f;
		
		return dia;
	}
	
	private float Lccc(CardiovascularSystem cs)
	{
		float grade = 0f;
		float AD = 0f; // Оценка давления в %
		float Ps = 0f; // Оценка пульса в %
		float t = 0f; // Оценка температуры в %
		
		/*
		 * Перевод артериального давления к 100% шкале.
		 */
		int dys = cs.getDiastolic();
		int sys = cs.getSystolic();
		
		int ksys;
		int kdys;
		
		if((sys >= 105 && sys <= 129) && dys > 85)
		{
			AD = 100.f - 3.2f * (dys - 85);
		}
		else
		if(sys > 129 && (dys >= 80 && dys <= 85))
		{
			AD = 100.f - 1.6f * (sys - 129);
		}
		else
		if(sys > 129 && dys > 85)
		{
			ksys = sys - 129;
			kdys = dys - 85;
			
			AD = 100.f - ( 1.6f * ksys + 3.f * kdys );
		}
		else
		if((sys >= 105 && sys <= 129) && dys <= 80)
		{
			AD = 100.f - 1.3f * (80 - dys);	
		}
		else
		if(sys < 105 && (dys >= 80 && dys <= 85))
		{
			AD = 100.f - 2.7f * (105 - sys);
		}
		else
		if(sys < 105 && dys < 80)
		{
			ksys = 105 - sys;
			kdys = 80 - dys;
			
			AD = 100.f - (2.7f * ksys + 1.3f * kdys);
		}
		else
		if(sys < 105 && dys > 85)
		{
			ksys = 105 - sys;
			kdys = dys - 85;
			
			AD = 100.f - (2.7f * ksys + 3.2f * kdys);
		}
		else
		if(sys > 129 && dys < 80)
		{
			ksys = sys - 129;
			kdys = 80 - dys;
			
			AD = 100.f - (1.6f * ksys + 1.3f * kdys);
		}
			
		
		/*
		 * Перевод давления
		 */
		int pulse = cs.getPulse();
		
		if(pulse >= 32 && pulse <= 59)
		{
			Ps = (100.f / 28.f) * (pulse - 32);
		}
		else
		if(pulse >= 60 && pulse <= 84)
		{
			Ps = 100.f;
		}
		else
		if(pulse >= 85 && pulse <= 118)
		{
			Ps = (-100.f / 34.f) * (pulse - 118);
		}
		else
		if(pulse < 32 || pulse > 118)
		{
			Ps = 0.f;
		}
		
		/*
		 * Перевод температуры
		 */
		float temp = cs.getTemperature();
		
		if(temp >= 36.f && temp <= 36.6f)
		{
			t = 100.f;
		}
		else
		if(temp >= 36.7f && temp <= 40.f)
		{
			t = -25.f * temp + 1025.f;
		}
		else
		if(temp > 40.f)
		{
			t = 0.0f;
		}
		else
		if(temp >= 34.0f && temp < 36.0f)
		{
			t = 50.f * temp - 1700.f;
		}
		else
		if(temp < 34.f)
		{
			t = 0.0f;
		}
		
		/*
		 * Общая оценка сердечно-сосудистой системы
		 */
		grade = 0.439f * AD + 0.277f * Ps + 0.284f * t;
		
		return grade;
	}
}
