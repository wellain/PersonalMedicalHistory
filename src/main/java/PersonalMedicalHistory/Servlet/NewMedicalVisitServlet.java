package PersonalMedicalHistory.Servlet;

import java.io.FileNotFoundException;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import PersonalMedicalHistory.Model.MedicalVisit;
import PersonalMedicalHistory.Model.MedicalVisitDao;

/**
 * Servlet implementation class NewMedicalVisitServlet
 */
@WebServlet("/NewMedicalVisitServlet")
public class NewMedicalVisitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger;
	public Logger getLogger() {

		return Logger.getLogger(NewMedicalVisitServlet.class.getName());

	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewMedicalVisitServlet() {
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
		String hospitalName = request.getParameter("hospitalName");
		String hospitalNameLowerCase = null;
		if(hospitalName!= null)
		{
		    hospitalNameLowerCase = hospitalName.toUpperCase();
		}
		String doctorName = request.getParameter("doctorName");
		String dateOfVisit = request.getParameter("dateOfVisit");
		String dateOfAppointment = request.getParameter("dateOfAppointment");
		PrintWriter out = response.getWriter();
		String imgp = request.getParameter("photo");
		logger.info("image"+imgp);
		
		MedicalVisit medicalVisitObject = getMedicalVisitObject();
		medicalVisitObject.setDate_of_Visit(dateOfVisit);
		medicalVisitObject.setDoctor_name(doctorName);
		medicalVisitObject.setHospital_name(hospitalNameLowerCase);
		medicalVisitObject.setNext_appointment(dateOfAppointment);
		medicalVisitObject.setPhoto(request.getParameter("photo"));
		
			MedicalVisitDao mvdao = getMedicalVisitDaoObject();
			try {
				HttpSession session = request.getSession(false);
				String emailSession = (String)session.getAttribute("emailSession");
				medicalVisitObject.setP_email(emailSession);
				//when data is correct
				if(mvdao.addMedicalVisit(medicalVisitObject))
				{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Data stored successfully');");
				out.println("location='Home.jsp';");
				out.println("</script>");
				}
				//when filepath is wrong
				else
				{
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Data not stored successfully, file path is wrong');");
					out.println("location='NewMedicalVisit.jsp';");
					out.println("</script>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error(e);
			}
	}

	public MedicalVisit getMedicalVisitObject() {
		return new MedicalVisit();
	}

	public MedicalVisitDao getMedicalVisitDaoObject() {
		return new MedicalVisitDao();
	}

}
