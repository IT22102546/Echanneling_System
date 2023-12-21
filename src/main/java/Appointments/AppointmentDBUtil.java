package Appointments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AppointmentDBUtil {
	
	private static boolean isSuccess;
	
	public static List<appointment>appoint(String name,String email,String mobile, String date, String dep,String dname)
	{
		ArrayList<appointment> app = new ArrayList<appointment>();
		
		
		
		try 
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false","root","root");
			
			PreparedStatement pst = con.prepareStatement("insert into appointment( pname,email,mobile,date,department,dname)values(?,?,?,?,?,?)");
			
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, mobile);
			pst.setString(4, date);
			pst.setString(5, dep);
			pst.setString(6, dname);
			
			pst.executeUpdate();

			appointment nwap = new appointment(name,email,mobile,date,dep,dname);
			
			app.add(nwap);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return app;
	}
	
	public static boolean updateAppoint( String id,String pname, String pemail, String pmob, String date,String dep,String dname)
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false","root","root");
		
			Statement stmt = con.createStatement();
			String sql = "update appointment set pname= '"+pname+"',email='"+pemail+"',mobile='"+pmob+"',date='"+date+"',department='"+dep+"',dname='"+dname+"'"+"where id='"+id+"'";
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
	
	public static boolean deleteAppoint(String id)
	{
		
		int cnvrtID = Integer.parseInt(id);
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false","root","root");
		
			Statement stmt = con.createStatement();
			String sql = "delete from appointment where id='"+cnvrtID+"'";
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

}
