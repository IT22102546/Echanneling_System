package laboratory;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






/**
 * Servlet implementation class updateUser
 */
@WebServlet("/updatelab")
public class updatelab extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("uid");
		String uname = request.getParameter("uname");
		String uemail = request.getParameter("uemail");
		String mob = request.getParameter("umob");
		String date = request.getParameter("date");
		String add = request.getParameter("address");
		String test= request.getParameter("test");
	
		
		boolean isTrue;
		
		isTrue = labdbUtil.updatelab(id,uname, uemail, mob, date, add, test);
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
