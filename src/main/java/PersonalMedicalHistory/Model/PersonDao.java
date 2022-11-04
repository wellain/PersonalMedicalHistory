package PersonalMedicalHistory.Model;

import java.sql.PreparedStatement;
import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

/**
 * Login and registring the user
 * @author Abhishek
 *
 */
public class PersonDao {
	Logger logger;
	public Logger getLogger() 
	{
		return Logger.getLogger(PersonDao.class.getName());
	}
	private DataSource ds;

	/**
	 * Authenticating the user
	 * @param P_email
	 * @param Password
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Person Authentication(String P_email, String Password) throws SQLException
	{	Person personObject=new Person();
		logger= getLogger();
		
		try
		{
			ds = getDataSource();
			PreparedStatement statement = ds.createPreparedStatement("Select * from login where P_email= ? and Password = ?");
			statement.setString(1, P_email);
			statement.setString(2,Password);
			ResultSet rs = statement.executeQuery();
			if(rs.next())
			{
				personObject.setP_name(rs.getString("P_name"));
				personObject.setP_email(rs.getString("P_email"));
				personObject.setPassword(rs.getString("Password"));
				personObject.setP_gender(rs.getString("P_gender"));
				personObject.setP_birthDate(rs.getString("p_birthDate"));
				return personObject;	
			}
		}
		catch(Exception e)
		{
			logger.error(e);
		}
		return null;
	}
	/**
	 * Checking for duplicating registration and doing the registration
	 * @param personObject
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean Registeration(Person personObject) throws SQLException, ClassNotFoundException
	{
		 ds = getDataSource();
		 ResultSet rs = null;
		 try
		 {
			 PreparedStatement statement = ds.createPreparedStatement("Select P_email from login where P_email=?");
			 statement.setString(1,personObject.getP_email());
			 rs = statement.executeQuery();
			 
			 //If user is not already registered then register user
			 if(!rs.next())
			 {	System.out.println("Going in 2");
				 statement = ds.createPreparedStatement("INSERT INTO login (P_email, P_name, P_birthDate, P_gender, Password) " +
	                 "VALUES (?,?,?,?,?)");
			 statement.setString(1,personObject.getP_email());
			 statement.setString(2,personObject.getP_name());
			 statement.setString(3,personObject.getP_birthDate() );
			 statement.setString(4,personObject.getP_gender());
			 statement.setString(5,personObject.getPassword());
			 statement.executeUpdate();
			 return true;
			 }
		 }
		 catch(Exception e)
		 {
			 logger.error(e);
		 }	 
		return false;
	}
	public DataSource getDataSource() throws ClassNotFoundException
	{
		return DataSource.getConnection();
	}
}
