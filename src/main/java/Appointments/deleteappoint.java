package Appointments;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class deleteappoint
 */
@WebServlet("/deleteappoint")
public class deleteappoint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aid = request.getParameter("aid");
		
		boolean isTrue;
		
		isTrue = AppointmentDBUtil.deleteAppoint(aid);
		RequestDispatcher dispatcher = null;
		
		if(isTrue == true)
		{
			
			dispatcher = request.getRequestDispatcher("mainall.jsp");
			
			
		}
		else
		{
			dispatcher = request.getRequestDispatcher("DeleteAppoint.jsp");
		}
		
		dispatcher.forward(request, response);

	}

}
