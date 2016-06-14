package ua.org.oa.balobanov.essences;

public class Address {
	int adr_id;
	String address;
	/**
	 * @param adr_id
	 * @param address
	 */
	public Address(int adr_id, String address) {
		this.adr_id = adr_id;
		this.address = address;
	}
	
	
	public Address(String address) {
		this.address = address;
		adr_id = -1;
	}


	/**
	 * @return the adr_id
	 */
	public int getAdr_id() {
		return adr_id;
	}
	/**
	 * @param adr_id the adr_id to set
	 */
	public void setAdr_id(int adr_id) {
		this.adr_id = adr_id;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Address [adr_id=" + adr_id + ", address=" + address + "]";
	}
	
	
	
}
