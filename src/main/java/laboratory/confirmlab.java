package laboratory;

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
@WebServlet("/confirmlab")
public class confirmlab extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
try {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false","root","root");
	PreparedStatement pst = con.prepareStatement("select * from laboratory where uemail = ?");
	
	pst.setString(1, email);
	
	
    ResultSet rs = pst.executeQuery();
	
    if(rs.next())
	{
    	

    	
    	String id = rs.getString(1);
    	String name = rs.getString(2);
    	String umobile = rs.getString(3);
    	String uemail = rs.getString(4);
    	
    	String dateL = rs.getString(5);
    	String uaddress = rs.getString(6);
    	
    	String test = rs.getString(7);
    	
    	
    	
    	session.setAttribute("lid",id);
		session.setAttribute("uname",name);
		session.setAttribute("umobile",umobile);
		session.setAttribute("uemail",uemail);
		session.setAttribute("date",dateL);		
		session.setAttribute("uaddress",uaddress);
		session.setAttribute("test",test);
		
		
		dispatcher = request.getRequestDispatcher("editlab.jsp");
		
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
