package ua.org.oa.balobanov.data.base.props;

public class DataBaseProps {
	private static String dbConnect = "jdbc:mysql://localhost:3306/balobanov";
	private static String user = "root";
	private static String pass = "1234";
	
	public static String getDbConnect() {
		return dbConnect;
	}
	public static String getUser() {
		return user;
	}
	public static String getPass() {
		return pass;
	}
}
