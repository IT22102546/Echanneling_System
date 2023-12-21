package Registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registrationServelet
 */

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String uname = request.getParameter("user_name");
		String address = request.getParameter("add");
		String uemail = request.getParameter("email");
		String umobile = request.getParameter("mobile");
		String upass = request.getParameter("pass");
		RequestDispatcher dispatcher = null;
		
	
		try {
		List<user>ur = RegDBUtil.register(fname, lname, uname, address, uemail, umobile, upass);
		request.setAttribute("user", ur);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		dispatcher = request.getRequestDispatcher("signup.jsp");
		request.setAttribute("status", "success");
		
		
		if(fname == null || fname.equals(""))
		{
			request.setAttribute("status","Invalidfname");
			dispatcher = request.getRequestDispatcher("signup.jsp");
			dispatcher.forward(request, response);
		}
		
		if(lname == null || lname.equals(""))
		{
			request.setAttribute("status","Invalidlname");
			dispatcher = request.getRequestDispatcher("signup.jsp");
			dispatcher.forward(request, response);
		}
		if(uname == null || uname.equals(""))
		{
			request.setAttribute("status","Invaliduname");
			dispatcher = request.getRequestDispatcher("signup.jsp");
			dispatcher.forward(request, response);
		}
		if(address == null || address.equals(""))
		{
			request.setAttribute("status","Invalidadd");
			dispatcher = request.getRequestDispatcher("signup.jsp");
			dispatcher.forward(request, response);
		}
		if(uemail == null || uemail.equals(""))
		{
			request.setAttribute("status","Invalidemail");
			dispatcher = request.getRequestDispatcher("signup.jsp");
			dispatcher.forward(request, response);
		}
		if(umobile == null || umobile.equals(""))
		{
			request.setAttribute("status","Invalidmobile");
			dispatcher = request.getRequestDispatcher("signup.jsp");
			dispatcher.forward(request, response);
		}
		if(upass == null || upass.equals(""))
		{
			request.setAttribute("status","Invalidpass");
			dispatcher = request.getRequestDispatcher("signup.jsp");
			dispatcher.forward(request, response);
		}
		
		dispatcher.forward(request,response);
	
	}
		
		
	} 
	
		
	


