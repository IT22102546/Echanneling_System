<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>appoinment</title>
</head>
<body>
 <h1>Appointments</h1>
 
  <table border="1">
               <tr>
         		<td>Appointment ID</td>
         		<td>Patient name</td>
         		<td>email</td>
         		<td>mobile</td>
         		<td>date</td>
         		<td>department</td>
         		<td>Doctor name</td>
         	</tr>
                <%@ page import="java.sql.*" %>	
                <%
         	try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false","root","root");
    		Statement stmt = con.createStatement();
    		
    		
    		String sql = "select * from appointment";
    		ResultSet rs = stmt.executeQuery(sql);
         	
    		
    		while(rs.next())
    		{ %>
    		
    		<tr>
    		    
	    		<td><%=rs.getString("id")%></td>
	    		<td><%=rs.getString("pname")%></td>
	    		<td><%=rs.getString("email")%></td>
	    		<td><%=rs.getString("mobile")%></td>
	    		<td><%=rs.getString("date")%></td>
	    		<td><%=rs.getString("department")%></td>
	    		<td><%=rs.getString("dname")%></td>
	    		
	    		
	    		
	    	
    		
    		
    		</tr>
    		
    		
    			
    			
    			
    		<%}
    		
    		
         	 }catch(Exception e)
         	{
         		out.println(e);
         	}
         	
    		
    		
         	%>
         	
         	</table>
          
</body>
</html>