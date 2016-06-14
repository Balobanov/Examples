package ua.org.oa.balobanov.DAOImplements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ua.org.oa.balobanov.DAOInterfaces.DAOMusicTypeInt;
import ua.org.oa.balobanov.essences.Address;
import ua.org.oa.balobanov.essences.MusicType;
import ua.org.oa.balobanov.essences.User;

public class DAOMusicType implements DAOMusicTypeInt {
	private static final String selectById = "select * from musictype where Musictype_id = ?";
	
	private static final String selectAll = "select * from musictype";
	
	private static final String insertMT = "Insert into musictype(Musictype_name) values (?)";
	
	private static final String deleteMT = "Delete from musictype where  Musictype_id = ? and Musictype_name = ?";
	
	private static final String updateMT = "Update musictype set Musictype_name = ? where Musictype_id = ?";
	
	private static final String selectMusicTypeForUser = 
	"select musictype.Musictype_id, musictype.Musictype_name from user, musictype, usermusictype where user.User_id = usermusictype.User_id and musictype.Musictype_id = usermusictype.Musictype_id and user.User_id = ?";
	
	private String dbConnect;
	private String user;
	private String pass;
	
	public DAOMusicType(String dbConnect, String user, String pass) {
		this.dbConnect = dbConnect;
		this.user = user;
		this.pass = pass;
	}

	@Override
	public boolean insert(MusicType mt) {
		PreparedStatement ps;
		
		try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
			
			ps = conn.prepareStatement(insertMT);
			ps.setString(1, mt.getType());
			
			ps.execute();
			
		} catch (Exception e ) {
			return false;
		}
		
		return true;
	}

	@Override
	public List<MusicType> selectAll() {

		Statement ps;
		ResultSet rs = null;
		List<MusicType> adrList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
			
			ps = conn.createStatement();
			
			rs = ps.executeQuery(selectAll);
			while(rs.next())
			{
				adrList.add( new MusicType(rs.getInt("Musictype_id"), rs.getString("Musictype_name")) );
			}
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		return adrList;
	}

	@Override
	public boolean update(MusicType mt) {
		PreparedStatement ps;
		
		try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
			
			ps = conn.prepareStatement(updateMT);
			
			ps.setString(1, mt.getType());
			ps.setInt(2, mt.getType_id());
			
			ps.execute();
			
		} catch (Exception e ) {
			return false;
		}
		
		return true;
	}

	@Override
	public MusicType selectById(int id) {
		PreparedStatement ps;
		ResultSet rs = null;
		MusicType mt = null;
		try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
			
			ps = conn.prepareStatement(selectById);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			if(rs.next())
				mt = new MusicType(rs.getInt("Musictype_id"), rs.getString("Musictype_name"));
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		return mt;
	}

	@Override
	public boolean delete(MusicType mt) {
		PreparedStatement ps;
		
		try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
			
			ps = conn.prepareStatement(deleteMT);
			
			ps.setInt(1, mt.getType_id());
			ps.setString(2, mt.getType());
			
			ps.execute();
			
		} catch (Exception e ) {
			return false;
		}
		
		return true;
	}

	@Override
	public Set<MusicType> selectMusicTypeForUser(int userID) {
		PreparedStatement ps;
		ResultSet rs = null;
		Set<MusicType> mtList = new HashSet<MusicType>();
		
		try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
			
			ps = conn.prepareStatement(selectMusicTypeForUser);
			ps.setInt(1, userID);
			
			rs = ps.executeQuery();
			while(rs.next())
			{
				mtList.add( new MusicType(rs.getInt("Musictype_id"), rs.getString("Musictype_name")) );
			}
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		return mtList;
	}
	
	
}