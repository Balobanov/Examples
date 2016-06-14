package ua.org.oa.balobanov.DAOImplements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.org.oa.balobanov.DAOInterfaces.DAOUserMusicTypeInt;
import ua.org.oa.balobanov.essences.Role;

public class DAOUserMusicType implements DAOUserMusicTypeInt{

	private String dbConnect;
	private String user;
	private String pass;
	
	private static final String insertUserMT = "insert into usermusictype  value(?,?)" ;
	private static final String updateUserMT = "Update usermusictype set User_id = ?, Musictype_id = ? where User_id = ? and Musictype_id = ?";
	private static final String deleteByUser = "Delete from usermusictype where  User_id = ?";
	private static final String deleteByMusicType = "Delete from usermusictype where  Musictype_id = ?";
	private static final String delete = "Delete from usermusictype where  User_id = ? and Musictype_id = ?";
	
	private static final String selectByUserId = "select * from usermusictype where  User_id = ?";
	private static final String selectByMusicId = "select * from usermusictype where  Musictype_id = ?";
	
	public DAOUserMusicType(String dbConnect, String user, String pass) {
		super();
		this.dbConnect = dbConnect;
		this.user = user;
		this.pass = pass;
	}

	@Override
	public boolean insert(int user_id, int musicType_id) {
		PreparedStatement ps;
		
		try(Connection conn = DriverManager.getConnection(dbConnect, this.user, pass)) {
			
			ps = conn.prepareStatement(insertUserMT);
			ps.setInt(1, user_id);
			ps.setInt(2, musicType_id);
			ps.execute();
			
		} catch (Exception e ) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(int user_id_old, int musicType_id_old,
			int new_user_id, int new_music_id) 
	{
		PreparedStatement ps;
		
		try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
			
			ps = conn.prepareStatement(updateUserMT);
			
			ps.setInt(1, new_user_id);
			ps.setInt(2, new_music_id);
			
			ps.setInt(3, user_id_old);
			ps.setInt(4, musicType_id_old);
			
			ps.execute();
			
		} catch (Exception e ) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean deleteByUser(int user_id) {
		PreparedStatement ps;
		
		try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
			
			ps = conn.prepareStatement(deleteByUser);
			ps.setInt(1, user_id);
			ps.execute();
			
		} catch (Exception e ) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean deleteByMusicType(int musicType_id) {
		PreparedStatement ps;
		
		try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
			
			ps = conn.prepareStatement(deleteByMusicType);
			ps.setInt(1, musicType_id);
			ps.execute();
			
		} catch (Exception e ) {
			return false;
		}
		
		return true;
	}

	@Override
	public boolean delete(int user_id, int musicType_id) {
		PreparedStatement ps;
		
		try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
			
			ps = conn.prepareStatement(delete);
			ps.setInt(1, user_id);
			ps.setInt(2, musicType_id);
			ps.execute();
			
		} catch (Exception e ) {
			return false;
		}
		
		return true;
	}

	@Override
	public List<Integer[]> selectByUserId(int id) {

		PreparedStatement ps;
		ResultSet rs = null;
		List<Integer[]> adrList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
			
			ps = conn.prepareStatement(selectByUserId);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next())
			{	
				adrList.add( new Integer[]{rs.getInt("User_id"),rs.getInt("Musictype_id")} );
			}
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		return adrList;
	}

	@Override
	public List<Integer[]> selectByMusicId(int id) {
		
		PreparedStatement ps;
		ResultSet rs = null;
		List<Integer[]> adrList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
			
			ps = conn.prepareStatement(selectByMusicId);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next())
			{	
				adrList.add( new Integer[]{rs.getInt("User_id"),rs.getInt("Musictype_id")} );
			}
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		return adrList;
	}

}
