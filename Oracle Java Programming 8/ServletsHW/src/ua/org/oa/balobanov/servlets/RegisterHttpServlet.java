package ua.org.oa.balobanov.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.org.oa.balobanov.*;
import ua.org.oa.balobanov.DAOImplements.DAOUser;
import ua.org.oa.balobanov.data.base.props.DataBaseProps;
import ua.org.oa.balobanov.essences.Address;
import ua.org.oa.balobanov.essences.MusicType;
import ua.org.oa.balobanov.essences.Role;
import ua.org.oa.balobanov.essences.User;

@WebServlet("/RegisterHttpServletURL")
public class RegisterHttpServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		if(req.getParameter("submit").equals("Submit"))
		{
			register(req, resp);
		}
		else
		{
			resp.sendRedirect("Login.jsp");
		}
	}

	private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter pw = resp.getWriter();
		if(req.getParameter("name").equals(""))
			pw.println("All fields must be set.");
		else
		if(req.getParameter("surname").equals(""))
			pw.println("All fields must be set.");
		else
		if(req.getParameter("age").equals(""))
			pw.println("All fields must be set.");
		else
		if(req.getParameter("address").equals(""))
			pw.println("All fields must be set.");
		else
		if(req.getParameterValues("musictypes") == null)
				pw.println("All fields must be set.");
		else
		if(req.getParameter("login").equals(""))
				pw.println("All fields must be set.");
		else
		if(req.getParameter("fpassword").equals(""))
				pw.println("All fields must be set.");
		else
		if(req.getParameter("spassword").equals(""))
				pw.println("All fields must be set.");
		else
		if(!checkString(req.getParameter("age")))
			pw.println("Bad age.");
		else
			if(!req.getParameter("fpassword").equals(req.getParameter("spassword")))
				pw.println("The passwords must be same.");
		else
		if(!req.getParameter("login").equals(""))
		{
			try(Connection conn = DriverManager.getConnection(DataBaseProps.getDbConnect(), DataBaseProps.getUser(), DataBaseProps.getPass())) 
			{
				PreparedStatement state = conn.prepareStatement("Select * from user where login = ?");
				String login = req.getParameter("login");
				state.setString(1, login);
				ResultSet rs = state.executeQuery();
				
				if(rs.next())
					pw.println("user with this login already exists.");
				else
				{
					insertNewUser(req, resp);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	private boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
	
	private void insertNewUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter pw = resp.getWriter();
		HashSet<MusicType> types = new HashSet<>();
		DAOUser uDAO = new DAOUser(DataBaseProps.getDbConnect(), DataBaseProps.getUser(), DataBaseProps.getPass());
		for (String s : req.getParameterValues("musictypes")) {
			types.add(new MusicType(s));
		}
		
		User newuser = new User(
				-1, 
				req.getParameter("name"), 
				req.getParameter("surname"), 
				req.getParameter("login"), 
				req.getParameter("fpassword"), 
				Integer.parseInt(req.getParameter("age")), 
				new Role(3), 
				new Address(req.getParameter("address")), 
				types);
		
		if(uDAO.insert(newuser))
			pw.println("Inserted");
		else
			pw.println("Error");
	}
}
