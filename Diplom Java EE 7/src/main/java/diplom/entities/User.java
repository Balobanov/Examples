package diplom.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	@NotNull
	private String user_name;
	
	@NotNull
	private String user_lastname;
	
	@NotNull
	@Size(min = 4, max = 64, message = "Login must be between {min} and {max} size")
	private String login;
	
	@NotNull
	@Size(min = 8, max = 64, message = "Password must be between {min} and {max} size")
	private String user_password;
	
	private float grade;
	
	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@OneToOne
	@JoinColumn(name = "group_id")
	private Groups group;

	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "diabet_id")
	private Diabet diabet;
	
	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "saturation_id")
	private Saturation saturation;
	
	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "cardiovascular_system_id")
	private CardiovascularSystem cardiovascularSystem;

	public User() {
		super();
	}

	public User(String user_name, String user_lastname, String login, String user_password, Address address,
			Groups group) {
		super();
		this.user_name = user_name;
		this.user_lastname = user_lastname;
		this.login = login;
		this.user_password = user_password;
		this.address = address;
		this.group = group;
	}
	
	public User(String user_name, String user_lastname, String login, String user_password, Address address,
			Groups group, Diabet diabet, Saturation saturation, CardiovascularSystem cardiovascularSystem, float grade) {
		super();
		this.user_name = user_name;
		this.user_lastname = user_lastname;
		this.login = login;
		this.user_password = user_password;
		this.address = address;
		this.group = group;
		this.diabet = diabet;
		this.saturation = saturation;
		this.cardiovascularSystem = cardiovascularSystem;
		this.grade = grade;
	}

	
	
	public User(int user_id, String user_name, String user_lastname, String login, String user_password,
			Address address, Groups group, Diabet diabet, Saturation saturation,
			CardiovascularSystem cardiovascularSystem) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_lastname = user_lastname;
		this.login = login;
		this.user_password = user_password;
		this.address = address;
		this.group = group;
		this.diabet = diabet;
		this.saturation = saturation;
		this.cardiovascularSystem = cardiovascularSystem;
	}
	
	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_lastname() {
		return user_lastname;
	}

	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Groups getGroup() {
		return group;
	}

	public void setGroup(Groups group) {
		this.group = group;
	}

	public Diabet getDiabet() {
		return diabet;
	}

	public void setDiabet(Diabet diabet) {
		this.diabet = diabet;
	}

	public Saturation getSaturation() {
		return saturation;
	}

	public void setSaturation(Saturation saturation) {
		this.saturation = saturation;
	}

	public CardiovascularSystem getCardiovascularSystem() {
		return cardiovascularSystem;
	}

	public void setCardiovascularSystem(CardiovascularSystem cardiovascularSystem) {
		this.cardiovascularSystem = cardiovascularSystem;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		str.append("User: ");
		str.append("id = " + user_id);
		str.append(", name = " + user_name);
		str.append(", last name = " + user_lastname);
		str.append(", login = " + login);
		str.append(", password = " + user_password + ". ");
		
		str.append(address.toString());
		str.append(" " + group.toString());
		
		if(cardiovascularSystem != null)
			str.append(" " + cardiovascularSystem.toString());
		
		if(diabet != null)
			str.append(" " + diabet.toString());
		
		if(saturation != null)
			str.append(" " + saturation.toString());
		
		return str.toString();
	}
}
