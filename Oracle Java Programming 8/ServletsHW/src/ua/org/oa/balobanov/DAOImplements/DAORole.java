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

import ua.org.oa.balobanov.DAOInterfaces.DAORoleInt;
import ua.org.oa.balobanov.essences.Role;

public class DAORole implements DAORoleInt{
		private static final String selectById = "select * from role where Role_id = ?";
		
		private static final String selectAll = "select * from role";
		
		private static final String insertRole = "Insert into role(Title) values (?)";
		
		private static final String deleteRole = "Delete from role where  Role_id = ? and Title = ?";
		
		private static final String updateRole = "Update role set Title = ? where Role_id = ?";
		
		
		private String dbConnect;
		private String user;
		private String pass;
		
		public DAORole(String dbConnect, String user, String pass) {
			this.dbConnect = dbConnect;
			this.user = user;
			this.pass = pass;
		}

		@Override
		public boolean insert(Role role) {
			PreparedStatement ps;
			
			try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
				
				ps = conn.prepareStatement(insertRole);
				ps.setString(1, role.getRole());
				
				ps.execute();
				
			} catch (Exception e ) {
				return false;
			}
			
			return true;
		}

		@Override
		public List<Role> selectAll() {

			Statement ps;
			ResultSet rs = null;
			List<Role> adrList = new ArrayList<>();
			
			try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
				
				ps = conn.createStatement();
				
				rs = ps.executeQuery(selectAll);
				while(rs.next())
				{
					adrList.add( new Role(rs.getInt("Role_id"), rs.getString("Title")) );
				}
				
			} catch (Exception e ) {
				e.printStackTrace();
			}
			
			return adrList;
		}

		@Override
		public boolean update(Role role) {
			PreparedStatement ps;
			
			try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
				
				ps = conn.prepareStatement(updateRole);
				
				ps.setString(1, role.getRole());
				ps.setInt(2, role.getRole_id());
				
				ps.execute();
				
			} catch (Exception e ) {
				return false;
			}
			
			return true;
		}

		@Override
		public Role selectById(int id) {
			PreparedStatement ps;
			ResultSet rs = null;
			Role mt = null;
			try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
				
				ps = conn.prepareStatement(selectById);
				ps.setInt(1, id);
				
				rs = ps.executeQuery();
				if(rs.next())
					mt = new Role(rs.getInt("Role_id"), rs.getString("Title"));
				
			} catch (Exception e ) {
				e.printStackTrace();
			}
			
			return mt;
		}

		@Override
		public boolean delete(Role role) {
			PreparedStatement ps;
			
			try(Connection conn = DriverManager.getConnection(dbConnect, user, pass)) {
				
				ps = conn.prepareStatement(deleteRole);
				
				ps.setInt(1, role.getRole_id());
				ps.setString(2, role.getRole());
				
				ps.execute();
				
			} catch (Exception e ) {
				return false;
			}
			
			return true;
		}		
}

