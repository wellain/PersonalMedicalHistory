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
import javax.servlet.http.HttpSession;

import PersonalMedicalHistory.Model.MedicalVisitDao;
import PersonalMedicalHistory.Model.Person;
import PersonalMedicalHistory.Model.PersonDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger;
	public Logger getLogger() {

		return Logger.getLogger(LoginServlet.class.getName());

	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		Person personObject;
		logger= getLogger();
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		logger.info("successfull login");
		String emailLowerCase = email.toLowerCase();
		String password = request.getParameter("password");
		PersonDao personDaoObj = getPersonDAO();
		try {
			HttpSession session = request.getSession();
			session.setAttribute("emailSession", emailLowerCase);
			personObject=personDaoObj.Authentication(emailLowerCase, password);
			//if correct useremail or password
			if(personObject!=null)
			{
			session.setAttribute("personObject", personObject);
			response.sendRedirect("Home.jsp");
			logger.info("ok");
			}
			//if invalid useremail or password
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Invalid Email or Password');");
				out.println("location='login.jsp';");
				out.println("</script>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
	}

	public PersonDao getPersonDAO() {
		return new PersonDao();
	}

}
