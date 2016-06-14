package diplom.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int address_id;
	
	@Size(min = 2, max = 30)
	private String address;

	public Address() {
		super();
	}

	public Address(int address_id, String address) {
		super();
		this.address_id = address_id;
		this.address = address;
	}

	public Address(String address) {
		super();
		this.address = address;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address: address id = " + address_id + ", address = " + address + ".";
	}
	
	
}
