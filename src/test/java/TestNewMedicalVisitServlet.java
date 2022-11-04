import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import PersonalMedicalHistory.Model.MedicalVisit;
import PersonalMedicalHistory.Model.MedicalVisitDao;
import PersonalMedicalHistory.Model.Person;
import PersonalMedicalHistory.Model.PersonDao;
import PersonalMedicalHistory.Servlet.LoginServlet;
import PersonalMedicalHistory.Servlet.NewMedicalVisitServlet;

public class TestNewMedicalVisitServlet {
	MedicalVisit mv;
	HttpSession session;
	HttpServletRequest request;
	HttpServletResponse response;
	MedicalVisitDao mvdobj;
    NewMedicalVisitServlet nms = Mockito.spy(new NewMedicalVisitServlet());
    PrintWriter out;
	@Before
	public void setup()
	{
		session = Mockito.mock(HttpSession.class);
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		mvdobj = Mockito.mock(MedicalVisitDao.class);
		out = Mockito.mock(PrintWriter.class);
		mv = Mockito.mock(MedicalVisit.class);
		//mv = Mockito.spy(new MedicalVisit());
		
	}

	@Test
	public void TestMedicalVisitServlet() throws ServletException, IOException, ClassNotFoundException, SQLException {
		Mockito.when(request.getParameter("hospitalName")).thenReturn("hs");
		Mockito.when(nms.getMedicalVisitObject()).thenReturn(mv);
		Mockito.doNothing().when(mv).setDoctor_name(Mockito.anyString());
		Mockito.when(nms.getMedicalVisitDaoObject()).thenReturn(mvdobj);
		Mockito.when(request.getSession()).thenReturn(session);
		Mockito.when(session.getAttribute("emailSession")).thenReturn("palak@gmail.com");
		
		Mockito.when(mvdobj.addMedicalVisit(mv)).thenReturn(true);
		Mockito.when(response.getWriter()).thenReturn(out);
		Mockito.doNothing().when(out).println(Mockito.anyString());
		nms.doPost(request,response);	
	}
	@Test
	public void TestMedicalVisitServletNegative() throws ClassNotFoundException, SQLException, IOException, ServletException
	{
		Mockito.when(request.getParameter("hospitalName")).thenReturn("hs");
		Mockito.when(nms.getMedicalVisitObject()).thenReturn(mv);
		Mockito.doNothing().when(mv).setDoctor_name(Mockito.anyString());
		Mockito.when(nms.getMedicalVisitDaoObject()).thenReturn(mvdobj);
		Mockito.when(request.getSession()).thenReturn(session);
		Mockito.when(mvdobj.addMedicalVisit(mv)).thenReturn(false);
		Mockito.when(response.getWriter()).thenReturn(out);
		Mockito.doNothing().when(out).println(Mockito.anyString());
		nms.doPost(request,response);
	}

}
