package Appointments;

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
@WebServlet("/updateAppoint")
public class updateAppoint extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("aid");
		String pname = request.getParameter("pname");
		String pmail = request.getParameter("pemail");
		String mob = request.getParameter("pmob");
		String date = request.getParameter("date");
		String dept = request.getParameter("dept");
		String dname= request.getParameter("dname");
	
		
		boolean isTrue;
		
		isTrue = AppointmentDBUtil.updateAppoint(id,pname, pmail, mob, date, dept, dname);
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
