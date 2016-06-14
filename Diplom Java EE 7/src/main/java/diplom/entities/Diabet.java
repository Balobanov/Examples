package diplom.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import diplom.constraints.SugarSize;

@Entity
@XmlRootElement
public class Diabet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int diabet_id;
	
	@SugarSize
	private float sugar;

	public Diabet() {
		super();
	}

	public Diabet(float sugar) {
		super();
		this.sugar = sugar;
	}

	public Diabet(int diabet_id, float sugar) {
		super();
		this.diabet_id = diabet_id;
		this.sugar = sugar;
	}

	public int getDiabet_id() {
		return diabet_id;
	}

	public void setDiabet_id(int diabet_id) {
		this.diabet_id = diabet_id;
	}

	public float getSugar() {
		return sugar;
	}

	public void setSugar(float sugar) {
		this.sugar = sugar;
	}

	@Override
	public String toString() {
		return "Diabet: diabet id = " + diabet_id + ", sugar = " + sugar + ".";
	}
	
	
}
