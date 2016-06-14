package diplom.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "Cardiovascular_system")
@XmlRootElement
public class CardiovascularSystem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cardiovascular_system_id;
	
	@Min(value = 30, message = "Diastolic pressure must be greater than or equal to {value}")
	@Max(value = 250, message = "Diastolic pressure must be less than or equal to {value}")
	private int diastolic;
	
	@Min(value = 30, message = "Systolic pressure must be greater than or equal to {value}")
	@Max(value = 250, message = "Systolic pressure must be less than or equal to {value}")
	private int systolic;
	
	@DecimalMin(value = "30.0", message = "Temperature must be greater than or equal to {value}")
	@DecimalMax(value = "50.0", message = "Temperature must be less than or equal to {value}")
	private float temperature;
	
	@Min(value = 30, message = "Pulse must be greater than or equal to {value}")
	@Max(value = 300, message = "Pulse must be less than or equal to {value}")
	private int pulse;
	
	public CardiovascularSystem() {
		super();
	}

	public CardiovascularSystem(int diastolic, int systolic, float temperature, int pulse) {
		super();
		this.diastolic = diastolic;
		this.systolic = systolic;
		this.temperature = temperature;
		this.pulse = pulse;
	}

	public CardiovascularSystem(int cardiovascular_system_id, int diastolic, int systolic, float temperature,
			int pulse) {
		super();
		this.cardiovascular_system_id = cardiovascular_system_id;
		this.diastolic = diastolic;
		this.systolic = systolic;
		this.temperature = temperature;
		this.pulse = pulse;
	}

	public int getCardiovascular_system_id() {
		return cardiovascular_system_id;
	}

	public void setCardiovascular_system_id(int cardiovascular_system_id) {
		this.cardiovascular_system_id = cardiovascular_system_id;
	}

	public int getDiastolic() {
		return diastolic;
	}

	public void setDiastolic(int diastolic) {
		this.diastolic = diastolic;
	}

	public int getSystolic() {
		return systolic;
	}

	public void setSystolic(int systolic) {
		this.systolic = systolic;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public int getPulse() {
		return pulse;
	}

	public void setPulse(int pulse) {
		this.pulse = pulse;
	}

	@Override
	public String toString() {
		return "CardiovascularSystem: cardiovascular system_id = " + cardiovascular_system_id + ", diastolic = " + diastolic
				+ ", systolic = " + systolic + ", temperature = " + temperature + ", pulse = " + pulse + ".";
	}
	
	
}
