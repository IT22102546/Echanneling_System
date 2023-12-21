package laboratory;

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
@WebServlet("/deleteLab")
public class deleteLab extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aid = request.getParameter("lid");
		
		boolean isTrue;
		
		isTrue = labdbUtil.deletelab(aid);
		RequestDispatcher dispatcher = null;
		
		if(isTrue == true)
		{
			
			dispatcher = request.getRequestDispatcher("mainall.jsp");
			
			
		}
		else
		{
			dispatcher = request.getRequestDispatcher("");
		}
		
		dispatcher.forward(request, response);

	}

}
