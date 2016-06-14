package ua.org.oa.balobanov.essences;

import java.util.Set;

public class User {
	private int User_id; 
	private int Role_id;
	private String Name; 
	private String Surname; 
	private String Login; 
	private String Password; 
	private int Age;
	private Role role;
	private Address adr;
	private Set<MusicType> mt;
	/**
	 * @param user_id
	 * @param name
	 * @param surname
	 * @param login
	 * @param password
	 * @param age
	 * @param role
	 * @param adr
	 * @param mt
	 */
	public User(int user_id, String name, String surname, String login,
			String password, int age, Role role, Address adr, Set<MusicType> mt) 
	{
		User_id = user_id;
		Name = name;
		Surname = surname;
		Login = login;
		Password = password;
		Age = age;
		this.role = role;
		this.adr = adr;
		this.mt = mt;
	}
	
	
	public User(String name, String surname, String login, String password,
			int age, int Role_id) {
		super();
		Name = name;
		Surname = surname;
		Login = login;
		Password = password;
		Age = age;
		this.Role_id = Role_id;
	}





	public User(int user_id, String name, String surname, String login, String password, int age, Role role) {
		User_id = user_id;
		Name = name;
		Surname = surname;
		Login = login;
		Password = password;
		Age = age;
		this.role = role;
	}


	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return User_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		User_id = user_id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return Surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		Surname = surname;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return Login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		Login = login;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return Age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		Age = age;
	}
	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	/**
	 * @return the adr
	 */
	public Address getAdr() {
		return adr;
	}
	/**
	 * @param adr the adr to set
	 */
	public void setAdr(Address adr) {
		this.adr = adr;
	}
	/**
	 * @return the mt
	 */
	public Set<MusicType> getMt() {
		return mt;
	}
	/**
	 * @param mt the mt to set
	 */
	public void setMt(Set<MusicType> mt) {
		this.mt = mt;
	}
	@Override
	public String toString() {
		return "User [User_id=" + User_id + ", Name=" + Name + ", Surname="
				+ Surname + ", Login=" + Login + ", Password=" + Password
				+ ", Age=" + Age + ", role=" + role + ", adr=" + adr + ", mt="
				+ mt + "]";
	}


	public int getRole_id() {
		return Role_id;
	}


	public void setRole_id(int role_id) {
		Role_id = role_id;
	}
	
	
}
