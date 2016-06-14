package ua.org.oa.balobanov.servlets.tests;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class twoServ
 */
@WebServlet("/twoServ")
public class twoServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
   	{
	   	PrintWriter pw = resp.getWriter();
		pw.println("hello this is servlet 2." + req.getParameter("name"));
		me(req, resp);
   	}

   private void me(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
   {
	   	PrintWriter pw = resp.getWriter();
		pw.println("hello this is servlet 2. method m");
   }
}
