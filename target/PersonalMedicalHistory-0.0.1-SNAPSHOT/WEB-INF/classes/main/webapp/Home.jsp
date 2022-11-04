<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
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
    <title>Index page</title>
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

    <!--coursel-->
    <div class="bd-example pb-2 pt-5">
            <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
              <ol class="carousel-indicators">
                <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                <li data-target="#carouselExampleCaptions" data-slide-to="3"></li>
              </ol>
              <div class="carousel-inner">
                <div class="carousel-item active" style="height: 333 px; width: 883 px;">
                        <img src="imageproj/heart.jpg" class="d-block w-100" alt="..." style="height: 333 px;width: 883 px;height: 430px;width: 600px;">
                </div>
                <div class="carousel-item">
                        <img src="imageproj/oo.jpg" class="d-block w-100" alt="..." style="
                        height: 430px;
                    ">
                </div>
                <div class="carousel-item">
                        <img src="imageproj/fg.jpg" class="d-block w-100" alt="..." style="
                        height: 430px;
                        ">
                </div>
              <div class="carousel-item">
                    <img src="imageproj/l.jpg" class="d-block w-100" alt="..." style="
                    height: 430px;
                    ">
    
                    <div class="carousel-caption d-none d-md-block">
                    </div>
                  </div>
                  </div>
              <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
              </a>
              <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
              </a>
            </div>
          </div>
   
    <!--save recycle n all-->
    <center>
			<br><br>
			<span class="h1">Best platform to store your Medical History</span><br><br>
			<span class="h4">Worried about loosing your lab reports and prescription?</span><br><br>
			<span class="h5">If yes, you are at the right place!</span><br><br>
			<p> A platform where you can store details about your Medical Visit, Lab Test and reports and what not about your medical record.</p><br>
			<br>
			<img src="imageproj\sh.jpg" class="img-responsive" alt="Berry Lace Dress">
    </center>
    <br><br>
    <!-- Footer-->
    <footer>
            <div class="container-fluid pt-4  bg-dark text-light">
                <div class="container">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="row">
                                <h5>Meta</h5>
                            </div>
                            <div class="row mb-4">
                                <div class="underline bg-light" style="width: 50px"></div>
                            </div>
                            <p><i class="fa fa-chevron-right" aria-hidden="true"></i> Suggestions</p>
                            <!-- <p><i class="fa fa-chevron-right" aria-hidden="true"></i> Log In</p>-->
                            <p><i class="fa fa-chevron-right" aria-hidden="true"></i> Comments</p>
                        </div>
                    	
                            <div class="col-md-6">
                                <div class="row">
                                    <h5>About Us</h5>
                                </div>
                                <div class="row mb-4">
                                    <div class="underline bg-light" style="width: 50px"></div> 
                                </div>
                                <div class="row">
                                    <p>
                                             Worried to loose your prescriptions and medical records? Worry not! Because Personal Medical History is here. Its team is committed to bring to you the best platform to store your medical history with ease and security.</p>
                                </div>
                            </div>
                            
                            <div class="col-md-3">
                                <div class="row pb-4">
                                    <h5>Contact Us</h5>
                                </div>
                                <div class="row mb-4">
                                    <p> PersonalMedicalHistory.com<br>
                                            Banglore,<br>
                                            P:+91-9672284949<br>
                                            Email: cs@pmh.com
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> 
            </footer>
</body>
</html>