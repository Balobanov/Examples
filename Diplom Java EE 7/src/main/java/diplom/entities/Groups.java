package diplom.entities;

import javax.annotation.security.RolesAllowed;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Groups {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int group_id;
	
	private String group_name;
	
	public Groups(int group_id) {
		super();
		this.group_id = group_id;
	}

	public Groups() {
		super();
	}
	
	public Groups(String group_name) {
		super();
		this.group_name = group_name;
	}
	
	public Groups(int group_id, String group_name) {
		super();
		this.group_id = group_id;
		this.group_name = group_name;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	@Override
	public String toString() {
		return "Group: group id = " + group_id + ", group name = " + group_name + ".";
	}
	
	
}
