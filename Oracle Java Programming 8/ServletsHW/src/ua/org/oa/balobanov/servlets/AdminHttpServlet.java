package ua.org.oa.balobanov.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.org.oa.balobanov.*;
import ua.org.oa.balobanov.DAOImplements.DAOAddress;
import ua.org.oa.balobanov.DAOImplements.DAOUser;
import ua.org.oa.balobanov.data.base.props.DataBaseProps;
import ua.org.oa.balobanov.essences.Address;
import ua.org.oa.balobanov.essences.MusicType;
import ua.org.oa.balobanov.essences.Role;
import ua.org.oa.balobanov.essences.User;

@WebServlet("/AdminHttpServletURL")
public class AdminHttpServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		if(req.getParameter("1").equals("Add"))
			resp.sendRedirect("AddPage.jsp");
		else
		if(req.getParameter("1").equals("Update"))
			update(req, resp);
		else
			if(req.getParameter("1").equals("Delete"))
				delete(req, resp);
	}

private void update	(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter pw = resp.getWriter();
		DAOUser uDAO = new DAOUser(DataBaseProps.getDbConnect(), DataBaseProps.getUser(), DataBaseProps.getPass());
		DAOAddress adrDAO = new DAOAddress(DataBaseProps.getDbConnect(), DataBaseProps.getUser(), DataBaseProps.getPass());
		
		User newuser = new User(
				Integer.parseInt(req.getParameter("user_id")), 
				req.getParameter("name"), 
				req.getParameter("surname"), 
				req.getParameter("login"), 
				req.getParameter("password"), 
				Integer.parseInt(req.getParameter("age")), 
				new Role(Integer.parseInt(req.getParameter("group"))));
		
		
		adrDAO.update(new Address(Integer.parseInt(req.getParameter("user_id")), req.getParameter("address")));
		
		if(uDAO.update(newuser))
			pw.println("User updated");
		
	}

private void delete	(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{
	PrintWriter pw = resp.getWriter();
	
	DAOUser userd = new DAOUser(DataBaseProps.getDbConnect(), DataBaseProps.getUser(), DataBaseProps.getPass());
	if(userd.delete(Integer.valueOf(req.getParameter("user_id"))))
		pw.println("User deleted");
	
}
}
