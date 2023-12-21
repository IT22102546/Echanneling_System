package Contactus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;



public class contDBUtil {
	
	public static List<contact>sub(String uname,String email,String subject, String message)
	{
		ArrayList<contact> cn = new ArrayList<contact>();
		
		
		
		try 
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false","root","root");
			
			PreparedStatement pst = con.prepareStatement("insert into contactUs(uname,email,subject,message)values(?,?,?,?)");
			pst.setString(1, uname);
			pst.setString(2, email);
			pst.setString(3, subject);
			pst.setString(4, message);

			
			pst.executeUpdate();

			contact cont = new contact(uname,email,subject,message);
			
			cn.add(cont);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return cn;
	}
}


