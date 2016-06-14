<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	
	import="ua.org.oa.balobanov.DAOImplements.*,
			ua.org.oa.balobanov.essences.*,
			java.util.*,
			java.io.*,
			ua.org.oa.balobanov.data.base.props.*"    
%>
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
<title>Admin Add Page</title>
</head>
<body>

 <div class="parent">
 <center>
Add
</center>
        <div class="child">
     <center>
    <form name="add" action="http://localhost:8080/ServletsHW/AddHttpServletURL" method = "post">
    <p>Name * <input type = "textbox"  name= "name" value = ""></p> 
    <p> Surname * <input type = "textbox"  name= "surname" value = ""></p> 
    <p> Age * <input type = "textbox"  name= "age" value = ""></p> 
    <p> Address * <input type = "textbox"  name= "address" value = ""></p> 
    
	<p> Music Types *</p> 
	<p> <select size="10"  multiple name="musictypes">
    <option disabled>Music Type</option>
    <%
    	Class.forName("com.mysql.jdbc.Driver");
    	DAOMusicType m = new DAOMusicType(DataBaseProps.getDbConnect(), DataBaseProps.getUser(), DataBaseProps.getPass());
    	List<MusicType> types = m.selectAll();
    	
    	for(MusicType mt: types)
 		out.println("<option value=\""+ mt.getType() +"\">" + mt.getType() + "</option>");
    %>
    </select></p> 
    
    <p> Roles *</p> 
	<p> <select size="10"  name="role">
    <option disabled>Role</option>
    <%
    	DAORole r = new DAORole(DataBaseProps.getDbConnect(), DataBaseProps.getUser(), DataBaseProps.getPass());
    	List<Role> roles = r.selectAll();
    	
    	for(Role rl: roles)
 		out.println("<option value=\""+ rl.getRole() +"\">" + rl.getRole() + "</option>");
    %>
    </select></p> 
	   
    <p>Login * <input type = "textbox"  name= "login" value = ""> </p> 
    <p>Password * <input type = "password" name= "fpassword" value = ""> </p> 
    <p>Password * <input type = "password" name= "spassword" value = ""> </p> 
    
    <table cellspacing="5" cellpadding="10" border="1" width="100%">
    <tr>
<td> <center> <input type = "submit" value = "Submit"   name="submit"> </td>
<td> <center> <input type = "submit" value = "Back"     name="submit"></td>
   </tr>
        </table>
        	</form>
             </center>
   </div>
  </div>
  
</body>
</html>