<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@page import="java.io.IOException"%>
<%@ page import="java.io.OutputStream"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="javax.servlet.RequestDispatcher"%>
<%@ page import="javax.servlet.ServletException"%>
<%@ page import="javax.servlet.ServletOutputStream"%>
<%@ page import="javax.servlet.annotation.WebServlet"%>
<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="javax.servlet.http.HttpSession"%>
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
    <script>
    function showTextBox()
    {
        if (document.getElementById('dov').checked) {
            document.getElementById('dovt').style.visibility = 'visible';
        }
        else document.getElementById('dovt').style.visibility = 'hidden';
        if (document.getElementById('hn').checked) {
            document.getElementById('hnt').style.visibility = 'visible';
        }
        else document.getElementById('hnt').style.visibility = 'hidden';
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
                <div class="col-md-8 "> 
                    <h4> PERSONAL MEDICAL HISTORY</h4>
                </div>
                <!--<i class="fa fa-user-o" aria-hidden="true"></i> <a href="/login/logn.html">Login</a>-->
                <span> &nbsp; </span>
                <a href="login.jsp">Logout </a>  &nbsp &nbsp &nbsp &nbsp <%  String emailSession = (String) session.getAttribute("emailSession");
                	out.println("(" +emailSession+ ")");%>
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
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Delete Medical History
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="DeleteMedicalVisit.jsp">Delete Medical Visits</a>
          <a class="dropdown-item" href="#">Lab reports</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Surgeries</a>
        </div>
      </li>
      <!-- <li class="nav-item">
        <a class="nav-link" href="#">Unprescribed Lab Test</a>
      </li>-->
    </ul>
  </div>
</nav>
<!-- end of bars -->
		<br>
		<center><h2> View Medical Visits</h2></center>
		<div style="margin:40px">
	    <form method="post">
	    <b>Select</b><br>
	    <input type="radio" onclick="javascript:showTextBox();" name="radio" id="dov">Enter Date of Visit<br>
	    <input type="radio" onclick="javascript:showTextBox();" name="radio" id="hn">Enter Hospital Name
        <div id="ifYes" style="visibility:hidden">
        <input type="date" name="dateOfVisit" placeholder="Date of Visit" id="dovt">
    	</div>
    	<div id="hndiv" style="visibility:hidden">
        <input type="text" name="hospitalName" placeholder="Hospital Name" id="hnt">
    	</div>
		<br> <input type="submit" value="Submit">
		</div>
		<%!public byte[] viewPrescription(String hospitalName, String doctorName, String dateOfVisit, String pEmail) {
		Connection conn = null;
		PreparedStatement statement = null;
		byte[] img = null;
		try {
			//connection
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\PG077675\\eclipse-workspace2\\PersonalMedicalHistoryF\\PersonalMedicalHistoryDb.db");
			conn.setAutoCommit(false);
			//fetching photo
			String sql = "Select Photo from NewMedicalVisit where P_email= ? and Date_of_visit = ? and Doctor_name = ?";
			statement = conn.prepareStatement(sql);
			statement.setString(1, pEmail);
			statement.setString(2, dateOfVisit);
			statement.setString(3, doctorName);
			System.out.println("reaching");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				img = rs.getBytes("Photo");
			}
			conn.commit();
			conn.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return img;
	}%>
	<%!public static String encode(byte[] data)
    {
        char[] tbl = {
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
            'Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f',
            'g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v',
            'w','x','y','z','0','1','2','3','4','5','6','7','8','9','+','/' };

        StringBuilder buffer = new StringBuilder();
        int pad = 0;
        for (int i = 0; i < data.length; i += 3) {

            int b = ((data[i] & 0xFF) << 16) & 0xFFFFFF;
            if (i + 1 < data.length) {
                b |= (data[i+1] & 0xFF) << 8;
            } else {
                pad++;
            }
            if (i + 2 < data.length) {
                b |= (data[i+2] & 0xFF);
            } else {
                pad++;
            }

            for (int j = 0; j < 4 - pad; j++) {
                int c = (b & 0xFC0000) >> 18;
                buffer.append(tbl[c]);
                b <<= 6;
            }
        }
        for (int j = 0; j < pad; j++) {
            buffer.append("=");
        }

        return buffer.toString();
    } %>
	<%		String hospitalName1 = request.getParameter("hospitalName");
			String hospitalNameLowerCase =null;
			if(hospitalName1!=null)
			hospitalNameLowerCase = hospitalName1.toUpperCase();
			System.out.println("okkkkkkkkkk" +hospitalNameLowerCase);
			int flag=0;
			String dateOfVisit = request.getParameter("dateOfVisit");
			ServletOutputStream sos = null;
			Connection conn = null;
			try {
				//String emailSession = (String) session.getAttribute("emailSession");
				//connection
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\PG077675\\eclipse-workspace2\\PersonalMedicalHistoryF\\PersonalMedicalHistoryDb.db");
				conn.setAutoCommit(false);
				System.out.println("Connection established");

				//session variable
				session.setAttribute("filterdate", dateOfVisit);
				//session.setAttribute("filterHospital", hospitalName1);

				//fetching data
				String sql = "Select * from NewMedicalVisit where (P_email = ? and Date_of_visit = ?) OR (P_email = ? and Hospital_name = ?)";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, emailSession);
				statement.setString(2, dateOfVisit);
				statement.setString(3,emailSession);
				statement.setString(4, hospitalNameLowerCase);
				ResultSet rs = statement.executeQuery();
	%>
			<table cellpadding="10"cellspacing="10">
			<tr>
				<th>Hospital Name</th>
				<th>Doctor Name</th>
				<th>Date of Visit</th>
				<th>Next Appointment</th>
				<th>Prescription</th>
			</tr>
			<%
				while (rs.next()) {
			%>
			<tr>
				<%
					flag=1;
					String hospital_Name = rs.getString("Hospital_name");
							String doctor_Name = rs.getString("Doctor_name");
							String date_Of_Visit = rs.getString("Date_of_visit");
							String p_email = rs.getString("P_email");
							String photo = rs.getString("Photo");
							byte[] img = null;
				%>
				<td><%=rs.getString("Hospital_name")%></td>
				<td><%=rs.getString("Doctor_name")%></td>
				<td><%=rs.getString("Date_of_visit")%></td>
				<%
					//session.setAttribute("FromTableDoc", rs.getString("Doctor_name"));
				%><td><%=rs.getString("Next_appointment")%></td>
				<td> <%  img = viewPrescription(hospital_Name, doctor_Name, date_Of_Visit, p_email);
				String imgDataBase64=encode(img);
				         %> <img src="data:image/gif;base64,<%= imgDataBase64 %>" alt="Prescription not uploaded" width="130px" height="90px" ondblclick="this.width=800; this.height=600" onclick="this.width=130; this.height=90"  /></td>
			</tr>
			<% }
				if(!rs.next() && flag==0)
				{%>
					<tr> <td colspan = "5"> No data found. </td></tr>
				<%}%>
		</table>
		<%
			conn.commit();
				conn.close();
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}
		%>
	</form>
</body>
</html>