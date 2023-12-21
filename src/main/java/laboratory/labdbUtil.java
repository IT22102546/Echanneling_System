package laboratory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class labdbUtil {
	
	private static boolean isSuccess;
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static boolean insertlab(String name , String phone , String email , String date,String address , String test ) {  
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "Insert into laboratory values(0,'"+name+"','"+phone+"','"+email+"','"+date+"','"+address+"' , '"+test+"' )";  
			int rs = stmt.executeUpdate(sql); 
			
			if(rs>0) {
				isSuccess = true;
			}
			
			else {
				isSuccess = false;
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}

	public static laboratory getlastAddedAppoinment() {
		laboratory lastAddedAppoinment = null;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			
            String sql = "SELECT * FROM laboratory ORDER BY uid DESC LIMIT 1";

            rs = stmt.executeQuery(sql);

            if (rs.next()) {
            	String id = rs.getString("id");
            	String name = rs.getString("name");
            	String phone = rs.getString("phone");
                String email = rs.getString("email");
                String date = rs.getString("date");
                String address = rs.getString("address");
                String test = rs.getString("test");

                lastAddedAppoinment = new laboratory (id, name, phone, email, date,address,test);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lastAddedAppoinment;
		
	}
	
	
	public static boolean updatelab( String id,String name, String uemail, String umob, String date,String uadd,String test)
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false","root","root");
		
			Statement stmt = con.createStatement();
			String sql = "update laboratory set name= '"+name+"',umobile='"+umob+"',uemail='"+uemail+"',date='"+date+"',uaddress='"+uadd+"',test='"+test+"'"+"where uid='"+id+"'";
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
	
	
	public static boolean deletelab(String id)
	{
		
		int cnvrtID = Integer.parseInt(id);
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false","root","root");
		
			Statement stmt = con.createStatement();
			String sql = "delete from laboratory where uid='"+cnvrtID+"'";
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
