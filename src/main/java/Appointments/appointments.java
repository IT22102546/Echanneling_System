package Appointments;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class appointments
 */
@WebServlet("/appointments")
public class appointments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("name");
		String email = request.getParameter("email");
	    String mob = request.getParameter("phone");
		String date = request.getParameter("date");
		String department = request.getParameter("department");
		String dname= request.getParameter("doctor");
		RequestDispatcher dispatcher = null;
		
		try {
			List<appointment>app = AppointmentDBUtil.appoint(uname,email,mob,date,department,dname);
			request.setAttribute("user", app);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		
			
			dispatcher = request.getRequestDispatcher("patientHome.jsp");
			dispatcher.forward(request,response);
			
	}

}
