<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
       <style>
   body { 
    margin: 0; 
   }
   .parent {
    margin: 20%; 
    
    padding: 10px; 
   } 
   .child {
    border: 3px solid #666;
    padding: 10px; 
    margin: 10px; 
   }
  </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
 <div class="parent">
                     <div class="child">
<form action = "http://localhost:8080/ServletsHW/LoginHttpServletURL" method = "post">
   <p>Login * <input type="textbox" name="login" value=""> </input> </p>
   <p>Password * <input type="password" name="password" value=""></input> </p> 
    
    <input type="submit" value="Sign in" name="submit"></input> <br><br>
	<input type="submit" value="Register" name="submit"> </input>
</form>
       </div>
        </div>
</body>
</html>