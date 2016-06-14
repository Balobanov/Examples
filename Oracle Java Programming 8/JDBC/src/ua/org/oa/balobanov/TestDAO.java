package ua.org.oa.balobanov;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import ua.org.oa.balobanov.DAOImplements.DAOAddress;
import ua.org.oa.balobanov.DAOImplements.DAOMusicType;
import ua.org.oa.balobanov.DAOImplements.DAORole;
import ua.org.oa.balobanov.DAOImplements.DAOUser;
import ua.org.oa.balobanov.DAOImplements.DAOUserMusicType;
import ua.org.oa.balobanov.essences.Address;
import ua.org.oa.balobanov.essences.MusicType;
import ua.org.oa.balobanov.essences.Role;
import ua.org.oa.balobanov.essences.User;

public class TestDAO {
	private static String dbConnect = "jdbc:mysql://localhost:3306/balobanov";
	private static String user = "root";
	private static String pass = "1234";
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
