<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function formValidation()
	{
		var userEmailCheck = document.loginForm.email.value;
		var passwordCheck = document.loginForm.password.value;
		var flag=0;
		if(!userEmailCheck)
		{
			alert("Invalid Email and Password");
			return false;
		}
		if(!passwordCheck)
		{
			alert("Invalid Email or password");
			return false;
		}
		return true;
	}
</script>
<style type="text/css">
body {
  background-image: url('imageproj\mrk.jpg');
}
</style>
</head>
<body>
<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("emailSession")==null)
      //response.sendRedirect("login.jsp");

  %> 
 <center>
	<img src="imageproj\ma.jpg" width="180" height="180">
	<H1> Login </H1><br><br>
	<form action = "LoginServlet" name="loginForm" method = "post" autocomplete="of" onsubmit = "return formValidation()">
	<div>
		UserEmail : <input type="text" name="email" placeholder = "useremail"><br><br>
		Password : <input type="password" name="password" placeholder = 'password'><br><br><br>
		<input type=submit value="Login"><br><br><br>
		Don't have an account? <a href = "Registration.jsp"> Signup </a>
	</div>
	</form>
	</center>
	
</body>
</html>