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
 * Servlet implementation class updatePassword
 */
@WebServlet("/updatePassword")
public class updatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("id");
		String pass = request.getParameter("pass");
		

		boolean isTrue;
		
		isTrue = RegDBUtil.Updatepassword(uid,pass);
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
