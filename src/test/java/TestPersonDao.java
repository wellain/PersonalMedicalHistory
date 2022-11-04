

import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import PersonalMedicalHistory.Model.DataSource;
import PersonalMedicalHistory.Model.Person;
import PersonalMedicalHistory.Model.PersonDao;

public class TestPersonDao 
{
	DataSource ds = null;
	PreparedStatement statement;
	ResultSet rs;
	PersonDao pd;
	@Before
	public void setup()
	{
		ds=Mockito.mock(DataSource.class);
		statement=Mockito.mock(PreparedStatement.class);
		rs=Mockito.mock(ResultSet.class);
		pd=Mockito.spy(new PersonDao());
	}
	@Test
	public void testAuthentication() throws ClassNotFoundException, SQLException 
	{	Mockito.when(pd.getDataSource()).thenReturn(ds);
		Mockito.when(ds.createPreparedStatement(Mockito.anyString())).thenReturn(statement);
		Mockito.when(statement.executeQuery()).thenReturn(rs);
		Mockito.when(rs.next()).thenReturn(true);
		Mockito.when(rs.getString("P_email")).thenReturn("palak@gmail.com");
		Mockito.when(rs.getString("P_name")).thenReturn("Palak");
		Mockito.when(rs.getString("P_birthDate")).thenReturn("13/08/1995");
		Mockito.when(rs.getString("P_gender")).thenReturn("F");
		Mockito.when(rs.getString("Password")).thenReturn("palak");
		assertTrue((pd.Authentication("email","password") instanceof Person));
		Person p=pd.Authentication("email","password");
		assertEquals("palak@gmail.com",p.getP_email());
		assertEquals("Palak", p.getP_name());
		//assertEquals("13/08/1995", p.getP_birthDate());
		assertEquals("F", p.getP_gender());
		assertEquals("palak", p.getPassword());
	}
	@Test
	public void testRegisteration() throws ClassNotFoundException, SQLException {
		Mockito.when(pd.getDataSource()).thenReturn(ds);
		Mockito.when(ds.createPreparedStatement(Mockito.anyString())).thenReturn(statement);
		Mockito.when(statement.executeQuery()).thenReturn(rs);
		Mockito.when(rs.next()).thenReturn(false);
		Mockito.doNothing().when(statement).setString(Mockito.anyInt(), Mockito.anyString());
		boolean val=pd.Registeration(Mockito.mock(Person.class));
		assertTrue(val);
		Mockito.verify(statement,Mockito.atLeastOnce()).executeUpdate();
	}
	@Test
	public void testAuthenticationNegative() throws ClassNotFoundException, SQLException
	{
		Mockito.when(pd.getDataSource()).thenReturn(ds);
		Mockito.when(ds.createPreparedStatement(Mockito.anyString())).thenReturn(statement);
		Mockito.when(statement.executeQuery()).thenReturn(rs);
		Mockito.when(rs.next()).thenReturn(false);
		//assertTrue(pd.Authentication("testEmail", "testPassword") null));
		Person p = pd.Authentication("testEmail", "testPassword");
		assertEquals(null,p);
		
	}
	@Test
	public void testRegisterationNegative() throws ClassNotFoundException, SQLException
	{
		Mockito.when(pd.getDataSource()).thenReturn(ds);
		Mockito.when(ds.createPreparedStatement(Mockito.anyString())).thenReturn(statement);
		Mockito.when(statement.executeQuery()).thenReturn(rs);
		Mockito.when(rs.next()).thenReturn(true);
		boolean val = pd.Registeration(Mockito.mock(Person.class));
		assertEquals(false,val);
		
	}

}
