package diplom.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Saturation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int saturation_id;
	
	@DecimalMin(value = "80.0", message = "Сатурация должна быть больше или равна {value}")
	@DecimalMax(value = "100.0", message = "Сатурация должна быть меньше или равна {value}")
	private float oxygen;

	public Saturation() {
		super();
	}

	public Saturation(float oxygen) {
		super();
		this.oxygen = oxygen;
	}

	public Saturation(int saturation_id, float oxygen) {
		super();
		this.saturation_id = saturation_id;
		this.oxygen = oxygen;
	}

	public int getSaturation_id() {
		return saturation_id;
	}

	public void setSaturation_id(int saturation_id) {
		this.saturation_id = saturation_id;
	}

	public float getOxygen() {
		return oxygen;
	}

	public void setOxygen(float oxygen) {
		this.oxygen = oxygen;
	}

	@Override
	public String toString() {
		return "Saturation: saturation id = " + saturation_id + ", oxygen = " + oxygen + ".";
	}
	
	
}
