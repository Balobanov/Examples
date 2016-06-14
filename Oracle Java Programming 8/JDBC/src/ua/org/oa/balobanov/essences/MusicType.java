package ua.org.oa.balobanov.essences;

public class MusicType {
	int type_id;
	String type;
	/**
	 * @param type_id
	 * @param type
	 */
	public MusicType(int type_id, String type) {
		this.type_id = type_id;
		this.type = type;
	}
	
	public MusicType(String type) {
		this.type_id = -1;
		this.type = type;
	}



	/**
	 * @return the type_id
	 */
	public int getType_id() {
		return type_id;
	}
	/**
	 * @param type_id the type_id to set
	 */
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "MusicType [type_id=" + type_id + ", type=" + type + "]";
	}
	
}
