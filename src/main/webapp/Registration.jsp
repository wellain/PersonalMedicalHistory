<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("emailSession")==null)
      response.sendRedirect("login.jsp");

  %> 
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
function formValidation()
{	var flag=false;
	var emailCheck = document.RegisterationForm.email;
	var passCheck = document.RegisterationForm.password;
	var nameCheck = document.RegisterationForm.uname;
	var birthDateCheck = document.RegisterationForm.birthdate;
	var genderCheck = document.RegisterationForm.gender;
	if(ValidateEmail(emailCheck))
	{
		if(ValidatePassword(passCheck,5,20))
		{
			if(ValidateUname(nameCheck))
			{
				if(ValidateBirthdate(birthDateCheck))
				{
					if(ValidateGender(genderCheck))
					{
						flag=true;
					}
				}
			}
			
		}
	}
	if(flag==true)
		return true;
	else
		return false;
}

function ValidateEmail(emailCheck)
{
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(emailCheck.value.match(mailformat))
	{
		return true;
	}
	else
	{
		alert("You have entered an invalid email address!");
		emailCheck.focus();
		return false;
	}
}
function ValidatePassword(passCheck,mx,my)
{
	var passlen = passCheck.value.length;
	if (passlen == 0 ||passlen >= my || passlen < mx)
	{
		alert("Password should not be empty / length be between "+mx+" to "+my);
		passCheck.focus();
		return false;
	}
	return true;
}
function ValidateUname(nameCheck)
{ 
	var letters = /^[A-Za-z]+$/;
	if(nameCheck.value.match(letters))
	{
		return true;
	}
	else
	{
		alert('Enter a valid user name');
		nameCheck.focus();
		return false;
	}
}
function ValidateBirthdate(birthDateCheck)
{
	if(birthDateCheck.value=="")
	{
		alert("Birtdate Cannot be blank");
		birthDateCheck.focus();
		return false;
	}
	return true;
}
function ValidateGender(genderCheck)
{
	if(genderCheck.value=="")
	{
		alert("Gender Cannot be blank");
		genderCheck.focus();
		return false;
	}
	return true;

}
</script>
</head>
<body>
<center>
	<img src="imageproj\ma.jpg" width="150" height="150">
	<H1> Registration </H1><br><br>
	<form action = "RegistrationServlet" method = "post" name = "RegisterationForm"  onsubmit = "return formValidation()">
	<div>
		*UserEmail : <input type="text" name="email" placeholder = "useremail"><br><br>
		*Password : <input type="password" name="password" placeholder = 'password'><br><br>
		*UserName : <input type="text" name="uname" placeholder = "name"><br><br>
		*BirthDate : <input type="date" name="birthdate" placeholder = "birthdate"><br><br>
		* Gender     : <input type="text" name="gender" placeholder = "gender"><br><br>
		<input type=submit value="Register"><br><br><br>
		Already have an account? <a href = "login.jsp"> Login </a>
		<p>(* Indicates mandatory field)</p>
	</div>
	</form>
</center>
</body>
</html>