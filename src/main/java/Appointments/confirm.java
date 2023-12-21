package Appointments;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class confirm
 */
@WebServlet("/confirm")
public class confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
try {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false","root","root");
	PreparedStatement pst = con.prepareStatement("select * from appointment where email = ?");
	
	pst.setString(1, email);
	
	
    ResultSet rs = pst.executeQuery();
	
    if(rs.next())
	{
    	

    	
    	String id = rs.getString(1);
    	String pname = rs.getString(2);
    	String mail = rs.getString(3);
    	String mobile = rs.getString(4);
    	
    	String date = rs.getString(5);
    	String department = rs.getString(6);
    	
    	String dname = rs.getString(7);
    	
    	
    	
    	session.setAttribute("aid",id);
		session.setAttribute("pname",pname);
		session.setAttribute("pemail",mail);
		session.setAttribute("pmobile",mobile);
		session.setAttribute("date",date);		
		session.setAttribute("depart",department);
		session.setAttribute("doc",dname);
		
		
		dispatcher = request.getRequestDispatcher("editappointment.jsp");
		
	}
	
	
	
	else
	{
		request.setAttribute("status", "failed");
		dispatcher = request.getRequestDispatcher("signin.jsp");
		
	}
	
	dispatcher.forward(request, response);
	
} catch (Exception e) {
	// TODO: handle exception
}
	}

}
