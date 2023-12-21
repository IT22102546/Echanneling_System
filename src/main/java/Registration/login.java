package Registration;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */

@WebServlet("/login") //form Action
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("your_email");
		String upass = request.getParameter("your_pass");
		
		 
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		if(email == null || email.equals(""))
		{
			request.setAttribute("status","Invalid email");
			dispatcher = request.getRequestDispatcher("signin.jsp");
			dispatcher.forward(request, response);
		}
		
		if(upass == null || upass.equals(""))
		{
			request.setAttribute("status","Invalidupass");
			dispatcher = request.getRequestDispatcher("signin.jsp");
			dispatcher.forward(request, response);
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false","root","root");
			PreparedStatement pst = con.prepareStatement("select * from registration where email = ? and password = ?");
			
			pst.setString(1, email);
			pst.setString(2, upass);
			
            ResultSet rs = pst.executeQuery();
			
            if(rs.next())
			{
            	
    
            	
            	String id = rs.getString(1);
            	String fname = rs.getString(2);
            	String lname = rs.getString(3);
            	String uname = rs.getString(4);
            	
            	String address = rs.getString(5);
            	
            	String mobile = rs.getString(7);
            	String password = rs.getString(8);
            	
            	
            	session.setAttribute("uid",id);
				session.setAttribute("name",uname);
				session.setAttribute("Fname",fname);
				session.setAttribute("Lname",lname);
				session.setAttribute("email",email);
				session.setAttribute("add",address);
				session.setAttribute("mob",mobile);
				session.setAttribute("pass",password);
				
				dispatcher = request.getRequestDispatcher("patientHome.jsp");
				
			}
			
			
			
			else
			{
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("signin.jsp");
				
			}
			
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
