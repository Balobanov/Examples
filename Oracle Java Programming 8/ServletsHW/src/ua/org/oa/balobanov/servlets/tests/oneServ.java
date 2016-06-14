package ua.org.oa.balobanov.servlets.tests;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class oneServ
 */
@WebServlet("/oneServ")
public class oneServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	 {
		PrintWriter pw = resp.getWriter();
		pw.println("hello this is servlet 1.");
		pw.println("Send redirect to servlet 2");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("name", "lol");
		resp.sendRedirect("twoServ");
	}

}
