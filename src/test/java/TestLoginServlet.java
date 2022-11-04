import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import PersonalMedicalHistory.Model.MedicalVisitDao;
import PersonalMedicalHistory.Model.Person;
import PersonalMedicalHistory.Model.PersonDao;
import PersonalMedicalHistory.Servlet.LoginServlet;

public class TestLoginServlet {
	Person p;
	HttpSession session;
	PersonDao personDaoObj;
	HttpServletRequest request;
	HttpServletResponse response;
	PrintWriter out;
	LoginServlet ls = Mockito.spy(new LoginServlet());
	@Before
	public void setup()
	{
		session = Mockito.mock(HttpSession.class);
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		personDaoObj = Mockito.mock(PersonDao.class);
		out = Mockito.mock(PrintWriter.class);
		p = Mockito.spy(new Person());
	}
	@Test
	public void TestLogin() throws ClassNotFoundException, SQLException, ServletException, IOException {
		Mockito.when(ls.getPersonDAO()).thenReturn(personDaoObj);
		Mockito.when(request.getParameter("email")).thenReturn("palak@gmail.com");
        Mockito.when(request.getParameter("password")).thenReturn("palak");
		Mockito.when(request.getSession()).thenReturn(session);
		//Mockito.when(personDaoObj.Authentication("","")).thenReturn(p);
		//p = personDaoObj.Authentication("email", "password");
		Mockito.when(personDaoObj.Authentication(Mockito.anyString(),Mockito.anyString())).thenReturn(p);
		//Mockito.doReturn(p).when(personDaoObj).Authentication("email","password");
		
		ls.doPost(request,response);
		//Mockito.verify(personDaoObj).Authentication(Mockito.anyString(), Mockito.anyString());
		//Mockito.doNothing().when(response).Redirect(request, response);
	}
	@Test
	public void TestLoginNegative() throws IOException, ClassNotFoundException, SQLException, ServletException
	{
		Mockito.when(response.getWriter()).thenReturn(out);
		Mockito.when(ls.getPersonDAO()).thenReturn(personDaoObj);
		Mockito.when(request.getParameter("email")).thenReturn("palak@gmail.com");
        Mockito.when(request.getParameter("password")).thenReturn("palak");
		Mockito.when(request.getSession()).thenReturn(session);
		Mockito.when(personDaoObj.Authentication(Mockito.anyString(),Mockito.anyString())).thenReturn(null);
		Mockito.doNothing().when(out).println(Mockito.anyString());
		ls.doPost(request,response);
	}

}
