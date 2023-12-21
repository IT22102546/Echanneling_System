<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Last added appoinment</title>
</head>
<body>
 <h1>Last Added Lab Appointments</h1>
 
 <%@ page import="java.sql.*" %>
                <table border="2">
                
                    
                    <tr class="header">
                        <th>Id</th>
                        <th>Name</th>
                        <th>Mobile Number</th>
                        <th>Email</th>
                        <th>Appoinment Date</th>
                        <th>Address</th>
                        <th>Lab Test</th>
                    </tr>
                    
                    <%
         	try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false","root","root");
    		Statement stmt = con.createStatement();
    		
    		
    		String sql = "select * from laboratory";
    		ResultSet rs = stmt.executeQuery(sql);
         	
    		
    		while(rs.next())
    		{ %>
                    
                   <tr>
    		    
	    		<td><%=rs.getString("uid")%></td>
	    		<td><%=rs.getString("name")%></td>
	    		<td><%=rs.getString("umobile")%></td>
	    		<td><%=rs.getString("uemail")%></td>
	    		<td><%=rs.getString("date")%></td>
	    		<td><%=rs.getString("uaddress")%></td>
	    		<td><%=rs.getString("test")%></td>
    		
    		</tr>
    			
    			
    			
    		<%}
    		
    		
         	 }catch(Exception e)
         	{
         		out.println(e);
         	}
         	
    		
    		
         	%> 
                 
                </table>
          <a href="validatelab.jsp">
                        <button class="btn btn-primary" type="button">Edit and Complete My Appointments</button>  
   
          
</body>
</html>