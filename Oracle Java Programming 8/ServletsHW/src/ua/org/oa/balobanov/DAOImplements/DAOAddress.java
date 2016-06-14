package ua.org.oa.balobanov.DAOImplements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import ua.org.oa.balobanov.DAOInterfaces.DAOAddressInt;
import ua.org.oa.balobanov.essences.Address;

public class DAOAddress implements DAOAddressInt{
	private static final String selectById = "select * from address where Address_id = ?";
	private static final String selectAll = "select * from address";
	private static final String insertAdr = "Insert into address values (?, ?)";
	private static final String deleteAdr = "Delete from address where  Address_id = ? and Address = ?";
	private static final String updateAdr = "Update address set Address = ? where Address_id = ?";
	
	private String dbConnect;
	private String user;
	private String pass;
	


	public DAOAddress(String dbConnect, String user, String pass) {
		this.dbConnect = dbConnect;
		this.user = user;
		this.pass = pass;
	}

	@Override
	public boolean insert(Address adr) {
		PreparedStatement ps;
		
		try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
			
			ps = conn.prepareStatement(insertAdr);
			ps.setInt(1, adr.getAdr_id());
			ps.setString(2, adr.getAddress());
			
			ps.execute();
			
		} catch (Exception e ) {
			return false;
		}
		
		return true;
	}

	@Override
	public List<Address> selectAll() {

		Statement ps;
		ResultSet rs = null;
		List<Address> adrList = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
			
			ps = conn.createStatement();
			
			rs = ps.executeQuery(selectAll);
			while(rs.next())
			{
				adrList.add(new Address(rs.getInt("Address_id"), rs.getString("Address")));
			}
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		return adrList;
	}

	@Override
	public boolean update(Address adr) {
		PreparedStatement ps;
		
		try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
			
			ps = conn.prepareStatement(updateAdr);
			
			ps.setString(1, adr.getAddress());
			ps.setInt(2, adr.getAdr_id());
			
			ps.execute();
			
		} catch (Exception e ) {
			return false;
		}
		
		return true;
	}

	@Override
	public Address selectById(int id) {
		
		PreparedStatement ps;
		ResultSet rs = null;
		Address adr = null;
		try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
			
			ps = conn.prepareStatement(selectById);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			if(rs.next())
				adr = new Address(rs.getInt("Address_id"), rs.getString("Address"));
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		return adr;
	}

	@Override
	public boolean delete(Address adr) {
		PreparedStatement ps;
		
		try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
			
			ps = conn.prepareStatement(deleteAdr);
			
			ps.setInt(1, adr.getAdr_id());
			ps.setString(2, adr.getAddress());
			
			ps.execute();
			
		} catch (Exception e ) {
			return false;
		}
		
		return true;
	}

}
