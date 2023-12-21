package userAccount;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Registration.RegDBUtil;




/**
 * Servlet implementation class updateUser
 */
@WebServlet("/updateUser")
public class updateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("uid");
		String uname = request.getParameter("uname");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String address = request.getParameter("add");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mob");
		String password = request.getParameter("pass");
		
		boolean isTrue;
		
		isTrue = RegDBUtil.updateUser(id, uname, fname, lname, address, email, mobile,password);
		RequestDispatcher dispatcher = null;
		
		if(isTrue == true)
		{
				
					
					
			request.setAttribute("status", "success");
			dispatcher = request.getRequestDispatcher("signin.jsp");
			
			
		}
		else
		{
			dispatcher = request.getRequestDispatcher("useracc.jsp");
		}
		
		dispatcher.forward(request, response);
		
	}

}
