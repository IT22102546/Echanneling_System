package laboratory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/LabInsert")

public class LabInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String phone = request.getParameter ("phone");
		String email = request.getParameter ("email");
		String date = request.getParameter ("date");
		String address = request.getParameter ("address");
		String test = request.getParameter ("test");
		
		boolean isTrue;
		
		isTrue = labdbUtil.insertlab(name, phone, email, date, address , test );   
		if (isTrue == true) {
			laboratory lastAddedAppoinment = labdbUtil.getlastAddedAppoinment();
			request.setAttribute("lastAddedAppoinment",lastAddedAppoinment);
			
			RequestDispatcher dis = request.getRequestDispatcher("laboratorylist.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
