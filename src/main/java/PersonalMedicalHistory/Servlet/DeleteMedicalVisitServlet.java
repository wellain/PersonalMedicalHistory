package PersonalMedicalHistory.Servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import PersonalMedicalHistory.Model.MedicalVisit;
import PersonalMedicalHistory.Model.MedicalVisitDao;

/**
 * Servlet implementation class DeleteMedicalVisitServlet
 */
@WebServlet("/DeleteMedicalVisitServlet")
public class DeleteMedicalVisitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger;
	public Logger getLogger() {

		return Logger.getLogger(NewMedicalVisitServlet.class.getName());

	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMedicalVisitServlet() {
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
		PrintWriter out = response.getWriter();
		
		MedicalVisit medicalVisitObject = getMedicalVisitObject();
		medicalVisitObject.setDate_of_Visit(dateOfVisit);
		medicalVisitObject.setDoctor_name(doctorName);
		medicalVisitObject.setHospital_name(hospitalNameLowerCase);

			MedicalVisitDao mvdao = getMedicalVisitDaoObject();
			HttpSession session = request.getSession();
			String emailSession = (String)session.getAttribute("emailSession");
			medicalVisitObject.setP_email(emailSession);
			//when data is correct
			if(mvdao.deleteMedicalVisit(medicalVisitObject))
			{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Data deleted successfully');");
			out.println("location='Home.jsp';");
			out.println("</script>");
			}
			//when filepath is wrong
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Data not found');");
				out.println("location='DeleteMedicalVisit.jsp';");
				out.println("</script>");
			}
	}

	public MedicalVisit getMedicalVisitObject() {
		return new MedicalVisit();
	}

	public MedicalVisitDao getMedicalVisitDaoObject() {
		return new MedicalVisitDao();
	}
}


