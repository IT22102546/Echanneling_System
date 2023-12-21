<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action = "" method="post" >
		Name <input type="text" name="name" value=""><br>
		Phone <input type="text" name="phone" value=""><br>
		Email <input type="text" name="email" value=""><br>
		Date <input type="text" name="date" value=""><br>
		Lab Test <select name="test"><br>
  						<option value="option1">Option 1</option>
  						<option value="option2">Option 2</option>
 						<option value="option3">Option 3</option>
				</select>	<br>
		<input type="submit" name="submit" value="Update my data"><br>		
    </form>
</body>
</html>