import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import PersonalMedicalHistory.Model.Person;
import PersonalMedicalHistory.Model.PersonDao;
import PersonalMedicalHistory.Servlet.RegistrationServlet;

public class TestRegistrationServlet {
	Person p;
	PersonDao pdobj;
	HttpServletRequest request;
	HttpServletResponse response;
	PrintWriter out;
	RegistrationServlet rs = Mockito.spy(new RegistrationServlet());
	
	@Before
	public void setup()
	{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		p = Mockito.mock(Person.class);
		pdobj = Mockito.mock(PersonDao.class);
		out = Mockito.mock(PrintWriter.class);
		
	}
	
	

	@Test
	public void TestRegistrationServletPositive() throws ClassNotFoundException, SQLException, IOException, ServletException
	{
		//Mockito.when(request.getParameter(Mockito.anyString())).thenReturn(Mockito.anyString());
		Mockito.when(request.getParameter("email")).thenReturn("palak@gmail.com");
		Mockito.when(rs.getPersonObject()).thenReturn(p);
		Mockito.when(rs.getPersonDaoObject()).thenReturn(pdobj);
		Mockito.when(pdobj.Registeration(p)).thenReturn(true);
		Mockito.when(response.getWriter()).thenReturn(out);
		Mockito.doNothing().when(out).println(Mockito.anyString());
		rs.doPost(request,response);
		
	}
	@Test
	public void TestRegistrationServletNegative() throws ClassNotFoundException, SQLException, IOException, ServletException
	{
		Mockito.when(request.getParameter("email")).thenReturn("palak@gmail.com");
		Mockito.when(rs.getPersonObject()).thenReturn(p);
		Mockito.when(rs.getPersonDaoObject()).thenReturn(pdobj);
		Mockito.when(pdobj.Registeration(p)).thenReturn(false);
		Mockito.when(response.getWriter()).thenReturn(out);
		Mockito.doNothing().when(out).println(Mockito.anyString());
		rs.doPost(request,response);
	}
}
