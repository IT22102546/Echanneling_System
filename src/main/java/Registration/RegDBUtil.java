package Registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class RegDBUtil {

	private static boolean isSuccess;
	public static List<user>register(String fname,String lname,String uname, String address, String email,String mobile,String password)
	{
		ArrayList<user> us = new ArrayList<user>();
		
		
		
		try 
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false","root","root");
			
			PreparedStatement pst = con.prepareStatement("insert into registration( fname,lname,uname,address,email,mobile,password)values(?,?,?,?,?,?,?)");
			
			pst.setString(1, fname);
			pst.setString(2, lname);
			pst.setString(3, uname);
			pst.setString(4, address);
			pst.setString(5, email);
			pst.setString(6, mobile);
			pst.setString(7, password);
			
			pst.executeUpdate();

			user usr = new user(fname,lname,uname,address,email,mobile,password);
			
			us.add(usr);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return us;
	}
	
	public static boolean updateUser(String id , String uname, String fname, String lname, String address,String email, String mobile,String password)
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false","root","root");
		
			Statement stmt = con.createStatement();
			String sql = "update registration set fname= '"+fname+"',lname='"+lname+"',uname='"+uname+"',address='"+address+"',email='"+email+"',mobile='"+mobile+"',password='"+password+"'"+"where id='"+id+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0)
			{
				isSuccess=true;
			}
			else
			{
				isSuccess=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}
	public static boolean Updatepassword(String id, String password)
	{
try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false","root","root");
		
			Statement stmt = con.createStatement();
			String sql = "update registration set password='"+password+"'"+"where id='"+id+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0)
			{
				isSuccess=true;
			}
			else
			{
				isSuccess=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}


public static boolean deleteUser(String id)
{
	
	int cnvrtID = Integer.parseInt(id);
	
	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false","root","root");
	
		Statement stmt = con.createStatement();
		String sql = "delete from registration where id='"+cnvrtID+"'";
		int rs = stmt.executeUpdate(sql);
		
		if(rs>0)
		{
			isSuccess=true;
		}
		else
		{
			isSuccess=false;
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	return isSuccess; 
}

public void getUserdetails()
{
	

	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false","root","root");
		Statement stmt = con.createStatement();
		
		
		
		String sql = "select * from registration ";
		ResultSet rs = stmt.executeQuery(sql);
		
		
		while(rs.next())
			{
				
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String uname = rs.getString("uname");
				String add = rs.getString("address");
				String email = rs.getString("email");
				String mob = rs.getString("mobile");
				String pass = rs.getString("password");
				
				
				
					
				
				
				
				
			}
		
	} catch (Exception e) {
		
		e.printStackTrace();
		
	}
	
	
	

	
}

}
