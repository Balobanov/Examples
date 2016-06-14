package ua.org.oa.balobanov.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.org.oa.balobanov.data.base.props.*;

@WebServlet("/LoginHttpServletURL")
public class LoginHttpServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter pw = resp.getWriter();
	
		if(req.getParameter("submit").equals("Sign in"))
		{
			try 
				{
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try(Connection conn = DriverManager.getConnection(DataBaseProps.getDbConnect(), DataBaseProps.getUser(), DataBaseProps.getPass())) 
				{
					PreparedStatement state = conn.prepareStatement("Select * from user where login = ? and password = ?");
					String login = req.getParameter("login");
					String pass = req.getParameter("password");
					state.setString(1, login);
					state.setString(2, pass);
					ResultSet rs = state.executeQuery();
					
					if(rs.next())
					{
						if(rs.getInt("Role_id") == 1)
							admin(req, resp);
						else
						if(rs.getInt("Role_id") == 2)
							moderator(req, resp, rs);
						else
							if(rs.getInt("Role_id") == 3)
								user(req, resp, rs);
					}
					else
					{
						pw.println("User not found!");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			
			}
		else
			resp.sendRedirect("Register.jsp");
	
	}

	private void user(HttpServletRequest req, HttpServletResponse resp, ResultSet rs) throws ServletException, IOException, SQLException 
	{
		PrintWriter pw = resp.getWriter();
		pw.println("<B>Hello</B>");
		pw.println(rs.getString("Name"));
		pw.println(rs.getString("Surname"));
	}
	
	private void moderator(HttpServletRequest req, HttpServletResponse resp, ResultSet rss) throws ServletException, IOException, SQLException 
	{
		PrintWriter pw = resp.getWriter();
		pw.println("<B>Hello</B>");
		pw.println(rss.getString("Name"));
		pw.println(rss.getString("Surname"));
		
		resp.setContentType("text/html");
		pw.print("<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "<title>Servlet!</title>"
				+ " </head>"
				+ "<body>"
				+ "<center>"
				+ "<h1>Users</h1>"
				+ "<table cellspacing=\"5\" cellpadding=\"10\" border=\"1\" width=\"100%\">"
						+ "<tr>"
						+ "<td>ID</td>"
						+ "<td>Name</td>"
						+ "<td>Surname</td> "
						+ "<td>Login</td> "
						+ "<td>Password</td>"
						+ "<td>Age</td>"
						+ "<td>Group</td>"
						+ "</tr>");
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(Connection conn = DriverManager.getConnection(DataBaseProps.getDbConnect(), DataBaseProps.getUser(), DataBaseProps.getPass())) {
			Statement state = conn.createStatement();
		 ResultSet rs = state.executeQuery("Select * from user");
			
			while(rs.next())
			{
				pw.print("<tr>");
				pw.print("<td>" + rs.getString("User_id") + "</td>");
				pw.print("<td>" + rs.getString("Name") + "</td>");
				pw.print("<td>" + rs.getString("Surname") + "</td>");
				pw.print("<td>" + rs.getString("Login") + "</td>");
				pw.print("<td>" + rs.getString("Password") + "</td>");
				pw.print("<td>" + rs.getString("Age") + "</td>");
				pw.print("<td>" + rs.getString("Role_id") + "</td>");
				pw.print("</tr>");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		pw.print("</table></body></html>");
	}
	
	private void admin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException 
	{
		PrintWriter pw = resp.getWriter();
		pw.println("<B>Hello</B>");
		
		resp.setContentType("text/html");
		pw.print("<!DOCTYPE HTML>"
				+ "<html>"
				+ "<head>"
				+ "<meta charset=\"utf-8\">"
						+ "<title>Тег SELECT</title>"
						+ "</head>"
						+ "<body>  "
						+ "<center>"
						+ "<table cellspacing=\"1\" cellpadding=\"10\" border=\"1\" width=\"100%\">"
								+ "<tr>"
								+ "<tr> "
								+ "<td>id</td> "
								+ "<td>name</td> "
								+ "<td>surname</td>"
								+ "<td>login</td>"
								+ "<td>pass</td> "
								+ "<td>age</td> "
								+ "<td>gropu</td>"
								+ "<td>address</td>"
								+ "<td>music types</td>"
								+ "</tr>");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(Connection conn = DriverManager.getConnection(DataBaseProps.getDbConnect(), DataBaseProps.getUser(), DataBaseProps.getPass())) {
			Statement state = conn.createStatement();
			PreparedStatement stateMt = conn.prepareStatement("select Musictype_name from user, musictype, usermusictype where user.User_id=usermusictype.User_id  and musictype.Musictype_id=usermusictype.Musictype_id and user.User_id = ?");
					
			ResultSet rsmt;
			ResultSet rs = state.executeQuery("Select User_id, Name, Surname, Login, Password, Age, Role_id, Address "
					+ "from user, address "
					+ "where User_id=Address_id");
			
			String types="";
			
		 	int count = 1;
		 	
			while(rs.next())
			{
				stateMt.setInt(1, rs.getInt("User_id"));
				rsmt = stateMt.executeQuery();
				
				while(rsmt.next())
					types+=rsmt.getString(1)+ ";" ;
				
				pw.print("<form action=\"http://localhost:8080/ServletsHW/AdminHttpServletURL\" method=\"post\" name="+ count++ +">");				
				pw.print("<tr>"); 
				pw.print("<td><input type=\"textbox\" name=\"user_id\" size=\"5\"   value=" + rs.getString("User_id") + "> </td>");
				pw.print("<td><input type=\"textbox\" name=\"name\" size=\"15\"   value=" + rs.getString("Name") + "> </td>"); 
				pw.print("<td><input type=\"textbox\" name=\"surname\" size=\"15\"value=" + rs.getString("Surname") + ">  </td>");
				pw.print("<td><input type=\"textbox\" name=\"login\"  size=\"15\" value=" + rs.getString("Login") + ">   </td>");
				pw.print("<td><input type=\"textbox\" name=\"password\"   size=\"15\" value=" + rs.getString("Password") + "> </td> ");
				pw.print("<td><input type=\"textbox\" name=\"age\"   size=\"5\"  value=" + rs.getString("Age") + "> </td> ");
				pw.print("<td><input type=\"textbox\" name=\"group\" size=\"3\"  value=" + rs.getString("Role_id") + "> </td> ");
				pw.print("<td><input type=\"textbox\" name=\"address\" size=\"3\"  value=" + rs.getString("Address") + "> </td> ");
				pw.print("<td><input type=\"textbox\" name=\"musictypes\" size=\"15\"  value=" + types + "> </td> ");
				pw.print("<td><input type=\"submit\" name=\"1\" value=\"Delete\"></td>");
				pw.print("<td><input type=\"submit\" name=\"1\" value=\"Update\"></td>");
				pw.print("</tr>");
				pw.print("</form>");
				types="";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		pw.print("</tr></table>"
				+"<form action=\"http://localhost:8080/ServletsHW/AdminHttpServletURL\" method=\"post\" name=add>"
				+"<input type=\"submit\" name=\"1\" value=\"Add\">"
				+"</form>"
				+ "</body></html>");
	}
}