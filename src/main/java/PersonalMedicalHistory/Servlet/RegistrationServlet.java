package PersonalMedicalHistory.Servlet;

import java.io.IOException;
import org.apache.log4j.Logger;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PersonalMedicalHistory.Model.MedicalVisitDao;
import PersonalMedicalHistory.Model.Person;
import PersonalMedicalHistory.Model.PersonDao;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger;
	public Logger getLogger() {

		return Logger.getLogger(RegistrationServlet.class.getName());

	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		logger= getLogger();
		String email = request.getParameter("email");
		String emailLowerCase = email.toLowerCase();
		String password = request.getParameter("password");
		String uname = request.getParameter("uname");
		String birthdate = request.getParameter("birthdate");
		String gender = request.getParameter("gender");
		PrintWriter out = response.getWriter();
		
		Person personObject=getPersonObject();
		personObject.setP_email(emailLowerCase);
		personObject.setP_birthDate(birthdate);
		personObject.setP_gender(gender);
		personObject.setP_name(uname);
		personObject.setPassword(password);
		
		PersonDao personDaoObj = getPersonDaoObject();
		try {
			//When duplicate registration occurs
			if(!personDaoObj.Registeration(personObject))
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Email Already Registered');");
				out.println("location='Registration.jsp';");
				out.println("</script>");
			}
			//Data is correct and not duplicate registration occurs
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Registration successfull');");
				out.println("location='login.jsp';");
				out.println("</script>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
	}
	
	public PersonDao getPersonDaoObject() {
		return new PersonDao();
	}
	
	public Person getPersonObject() {
		return new Person();
	}

}
