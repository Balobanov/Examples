package ua.org.oa.balobanov.DAOImplements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import ua.org.oa.balobanov.DAOInterfaces.DAOUserInt;
import ua.org.oa.balobanov.essences.Address;
import ua.org.oa.balobanov.essences.MusicType;
import ua.org.oa.balobanov.essences.Role;
import ua.org.oa.balobanov.essences.User;

public class DAOUser implements DAOUserInt {

	private static final String insertUser = "insert into user (Name,Surname,Login,Password, Age, Role_id) value(?,?,?,?,?,?)" ;

	private static final String selectById = "select * from user where User_id = ?";
	private static final String selectByLogin = "select * from user where login = ?";

	private static final String deleteUserLogin = "Delete from user where login = ?";
	private static final String deleteUserId = "Delete from user where User_id = ?";

	private static final String updateUser = "Update user set Name = ?, Surname = ?, Login = ?, Password = ?, Age = ?, Role_id = ? where User_id = ?";
	private static final String selectAll = "select * from user";
	
	private String dbConnect;
	private String user;
	private String pass;
	private DAOAddress DAOAdr;
	private DAORole DAORole;
	private DAOMusicType DAOMT;
	private DAOUserMusicType DAOumt;
	
	public DAOUser(String dbConnect, String user, String pass) {
		this.dbConnect = dbConnect;
		this.user = user;
		this.pass = pass;
		
		this.DAOAdr = new DAOAddress(dbConnect, user, pass);
		this.DAORole = new DAORole(dbConnect, user, pass);
		this.DAOMT = new DAOMusicType(dbConnect, user, pass);
		this.DAOumt = new DAOUserMusicType(dbConnect, user, pass);
	}
	
	@Override
	public boolean insert(User user) {
		PreparedStatement ps;
		int userID = 0;
		Role role; int roleID;
		Address adr; int adrID;
		MusicType mt;
		ResultSet rs;
		
		try(Connection conn = DriverManager.getConnection(dbConnect, this.user, pass)) {
			
				ps = conn.prepareStatement(insertUser);
				ps.setString(1, user.getName());
				ps.setString(2, user.getSurname());
				ps.setString(3, user.getLogin());
				ps.setString(4, user.getPassword());
				ps.setInt(5, user.getAge());
				ps.setInt(6, user.getRole().getRole_id());
				ps.execute();
				
			
				ps = conn.prepareStatement("select User_id from user where login = ?");
				ps.setString(1, user.getLogin());
				rs = ps.executeQuery();
				if(rs.next())
				{
					userID = rs.getInt(1);
					DAOAdr.insert(new Address(userID, user.getAdr().getAddress()));
				}
			
				ps = conn.prepareStatement("select Musictype_id from musictype where Musictype_name = ?");
				ResultSet rs1; 
				for (MusicType mt2 : user.getMt()) 
				{
					ps.setString(1, mt2.getType());
					rs1 = ps.executeQuery();
					while(rs1.next())
					{
						DAOumt.insert(userID, rs1.getInt(1));
					}
				}
			
		} catch (Exception e ) {
			return false;
		}
		
		return true;
	}

	@Override
	public List<User> selectAll() {
		Statement ps;
		ResultSet rs = null;
		List<User> adrList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
			
			ps = conn.createStatement();
			
			rs = ps.executeQuery(selectAll);
			while(rs.next())
			{
				adrList.add(selectById(rs.getInt("User_id")));
			}
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		return adrList;
	}

	@Override
	public boolean update(User user) {
		PreparedStatement ps;
		
		try(Connection conn = DriverManager.getConnection(dbConnect, this.user, pass)) {
			
			ps = conn.prepareStatement(updateUser);
			ps.setString(1, user.getName());
			ps.setString(2, user.getSurname());
			ps.setString(3, user.getLogin());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getAge());
			ps.setInt(6, user.getRole().getRole_id());
			
			ps.setInt(7, user.getUser_id());
			ps.execute();
			
		} catch (Exception e ) {
			return false;
		}
		
		return true;
	}

	@Override
	public User selectById(int id) {
		PreparedStatement ps;
		ResultSet rs = null;
		User user = null;
		
		try(Connection conn = DriverManager.getConnection(dbConnect, this.user, pass)) {
			
			ps = conn.prepareStatement(selectById);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			if(rs.next())
				user = new User
				(rs.getInt("User_id"), 
				 rs.getString("Name"), 
				 rs.getString("Surname"), 
				 rs.getString("Login"), 
				 rs.getString("Password"), 
				 rs.getInt("Age"), 
				 DAORole.selectById(rs.getInt("User_id")), 
				 DAOAdr.selectById(rs.getInt("User_id")) , 
				 DAOMT.selectMusicTypeForUser(rs.getInt("User_id")));
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public boolean delete(int id) {
		PreparedStatement ps;
		
		try(Connection conn = DriverManager.getConnection(dbConnect, this.user, pass)) {
			
			ps = conn.prepareStatement(deleteUserId);
			
			ps.setInt(1, id);
			ps.execute();
			
		} catch (Exception e ) {
			return false;
		}
		
		return true;
	}


	
	@Override
	public boolean delete(String login) {
		PreparedStatement ps;
		
		try(Connection conn = DriverManager.getConnection(dbConnect, this.user, pass)) {
			
			ps = conn.prepareStatement(deleteUserLogin);
			
			ps.setString(1, login);
			ps.execute();
			
		} catch (Exception e ) {
			return false;
		}
		
		return true;
	}

	@Override
	public User selectByLogin(String login) {
		PreparedStatement ps;
		ResultSet rs = null;
		User user = null;
		
		try(Connection conn = DriverManager.getConnection(dbConnect, this.user, pass)) {
			
			ps = conn.prepareStatement(selectByLogin);
			ps.setString(1, login);
			
			rs = ps.executeQuery();
			if(rs.next())
				user = new User
				(rs.getInt("User_id"), 
				 rs.getString("Name"), 
				 rs.getString("Surname"), 
				 rs.getString("Login"), 
				 rs.getString("Password"), 
				 rs.getInt("Age"), 
				 DAORole.selectById(rs.getInt("User_id")), 
				 DAOAdr.selectById(rs.getInt("User_id")) , 
				 DAOMT.selectMusicTypeForUser(rs.getInt("User_id")));
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public boolean delete(User user) {
		return delete(user.getLogin());
	}

}
