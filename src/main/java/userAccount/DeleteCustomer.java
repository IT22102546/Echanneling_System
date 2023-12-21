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
 * Servlet implementation class DeleteCustomer
 */
@WebServlet("/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("uid");
		
		boolean isTrue;
		
		isTrue = RegDBUtil.deleteUser(id);
		RequestDispatcher dispatcher = null;
		
		if(isTrue == true)
		{
			
			dispatcher = request.getRequestDispatcher("mainall.jsp");
			
			
		}
		else
		{
			dispatcher = request.getRequestDispatcher("DeleteAcc.jsp");
		}
		
		dispatcher.forward(request, response);

		
	}

}
