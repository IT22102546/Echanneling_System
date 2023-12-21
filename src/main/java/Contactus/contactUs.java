package Contactus;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class contactUs
 */
@WebServlet("/contactUs")
public class contactUs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("name");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		RequestDispatcher dispatcher = null;
		dispatcher = request.getRequestDispatcher("patientHome.jsp");
		request.setAttribute("status", "success");
		
		
		try {
			List<contact>cont = contDBUtil.sub(uname,email,subject,message);
			request.setAttribute("user", cont);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
		dispatcher.forward(request,response);
	}

}
