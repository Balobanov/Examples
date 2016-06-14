package ua.org.oa.balobanov.essences;

public class Role {
	int Role_id;
	String role;
	/**
	 * @param role_id
	 * @param role
	 */
	public Role(int role_id, String role) {
		Role_id = role_id;
		this.role = role;
	}
	
	
	public Role(String role) {
		this.Role_id = -1;
		this.role = role;
	}


	/**
	 * @return the role_id
	 */
	public int getRole_id() {
		return Role_id;
	}
	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(int role_id) {
		Role_id = role_id;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Role [Role_id=" + Role_id + ", role=" + role + "]";
	}
	
	
}
