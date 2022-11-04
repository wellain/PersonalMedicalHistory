<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="style1.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="script.js"></script>
    <script type="text/javascript">
        function preventBack() { window.history.forward(); }
        setTimeout("preventBack()", 0);
        window.onunload = function () { null };
    </script>
    <script type="text/javascript">
	function formValidation()
	{
		var flag=1;
		var val = document.frm.hospitalName.value
		if(!val)
		{
			alert("Please enter Hospital Name");
			flag=0;
			return false;
		}
		if(!(document.frm.dateOfVisit.value))
		{
			alert("Please enter Date of visit");
			flag=0;
			return false;
		}
		if(flag=1)
		return true;
	}
  </script>
  </head>
  <body>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
    <!-- top bar-->
    <div class="container-fluid bg-dark header-top d-none d-md-block">
            <div class="container">
              <div class="row text-light pt-2 pb-2 pt-3">
                <div class="col-md-10 "> 
                    <h4> PERSONAL MEDICAL HISTORY</h4>
                </div>
                <!--<i class="fa fa-user-o" aria-hidden="true"></i> <a href="/login/logn.html">Login</a>-->
                <span> &nbsp; </span>
                <a href="login.jsp">Logout</a>
                    </div>
              </div>
            </div>
          </div>
  
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-light">

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="Home.jsp">Home<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="NewMedicalVisit.jsp">New Medical Visit<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="LabReports.jsp">Lab Reports</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Surgeries.jsp">Surgery</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          View Medical History
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="ViewNewMedicalVisit.jsp">View Medical Visits</a>
          <a class="dropdown-item" href="ViewLabReports.jsp">Lab reports</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="ViewSurgeries.jsp">Surgeries</a>
        </div>
      </li>
      <!-- <li class="nav-item">
        <a class="nav-link" href="#">Unprescribed Lab Test</a>
      </li>-->
    </ul>
  </div>
</nav>
<body>
<center><H1> New Medical Visit </H1></center><br>
<center>
<form action="NewMedicalVisitServlet" method="post" name="frm" onsubmit = "return formValidation()">
Hospital Name : <input type="text" name="hospitalName" placeholder="Hospital Name"><br><br>
Doctor Name : <input type="text" name="doctorName" placeholder="Doctor Name"><br><br>
Date of Visit : <input type="text" name="dateOfVisit" placeholder="Date of Visit"><br><br>
Next Appointment : <input type="text" name="dateOfAppointment" placeholder="Next Appointment"><br><br><br>
Upload Prescription: <input type="file" name="photo" size="50"/><br><br><br>
<input type="submit" value="Submit">
<input type="reset" value="Reset">
</form>
</center>
</body>
</html>