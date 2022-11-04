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
import PersonalMedicalHistory.Servlet.DeleteMedicalVisitServlet;
import PersonalMedicalHistory.Servlet.NewMedicalVisitServlet;

public class TestDeleteMedicalVisitServlet {

	MedicalVisit mv;
	HttpSession session;
	HttpServletRequest request;
	HttpServletResponse response;
	MedicalVisitDao mvdobj;
    DeleteMedicalVisitServlet dms = Mockito.spy(new DeleteMedicalVisitServlet());
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
	public void TestDeleteMedicalVisitPositive() throws SQLException, IOException, ServletException
	{
		Mockito.when(request.getParameter("hospitalName")).thenReturn("TMH");
		Mockito.when(request.getParameter("doctorName")).thenReturn("Sanjeev");
		Mockito.when(request.getParameter("dateOfVisit")).thenReturn("12/09/2020"); 
		Mockito.when(dms.getMedicalVisitObject()).thenReturn(mv);
		Mockito.doNothing().when(mv).setDate_of_Visit(Mockito.anyString());
		Mockito.doNothing().when(mv).setDoctor_name(Mockito.anyString());
		Mockito.doNothing().when(mv).setHospital_name(Mockito.anyString());
		Mockito.when(dms.getMedicalVisitDaoObject()).thenReturn(mvdobj);
		Mockito.when(request.getSession()).thenReturn(session);
		Mockito.when(mvdobj.deleteMedicalVisit(mv)).thenReturn(true);
		Mockito.when(response.getWriter()).thenReturn(out);
		Mockito.doNothing().when(out).println(Mockito.anyString());
		dms.doPost(request,response);	
	}
	@Test
	public void TestDeleteMedicalVisitNegative() throws SQLException, IOException, ServletException
	{
		Mockito.when(request.getParameter("hospitalName")).thenReturn("TMH");
		Mockito.when(request.getParameter("doctorName")).thenReturn("Sanjeev");
		Mockito.when(request.getParameter("dateOfVisit")).thenReturn("12/09/2020"); 
		Mockito.when(dms.getMedicalVisitObject()).thenReturn(mv);
		Mockito.doNothing().when(mv).setDate_of_Visit(Mockito.anyString());
		Mockito.doNothing().when(mv).setDoctor_name(Mockito.anyString());
		Mockito.doNothing().when(mv).setHospital_name(Mockito.anyString());
		Mockito.when(dms.getMedicalVisitDaoObject()).thenReturn(mvdobj);
		Mockito.when(request.getSession()).thenReturn(session);
		Mockito.when(mvdobj.deleteMedicalVisit(mv)).thenReturn(false);
		Mockito.when(response.getWriter()).thenReturn(out);
		Mockito.doNothing().when(out).println(Mockito.anyString());
		dms.doPost(request,response);	
	}

}
