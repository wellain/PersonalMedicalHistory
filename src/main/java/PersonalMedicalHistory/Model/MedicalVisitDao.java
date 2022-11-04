package PersonalMedicalHistory.Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;


/**
 * Adding medical Visit
 * @author Abhishek
 *
 */
public class MedicalVisitDao {
	private DataSource ds;
	Logger logger;
	public Logger getLogger() {

		return Logger.getLogger(MedicalVisitDao.class.getName());

	}

	/**
	 * Used to add the details about new medical visit
	 * @param medicalVisitObject
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public boolean addMedicalVisit(MedicalVisit medicalVisitObject) throws SQLException, FileNotFoundException
	{
		try
		{
			ds = getDataSource();
			logger= getLogger();
			FileInputStream inputStream = null;
			File image = getImage(medicalVisitObject);
			int flag = processImage(medicalVisitObject);
			//file path doesnot exists
			if(flag==-1)
				return false;
			//file exists and is not null
			if(flag==1)
				inputStream = getInputStream1(image);
			String sql = "INSERT INTO NewMedicalVisit (Hospital_name, Doctor_name, Date_of_visit, Next_appointment, P_email,Photo) " +
	                "VALUES (?,?,?,?,?,?);";
			PreparedStatement statement = ds.createPreparedStatement(sql);
			statement.setString(1, medicalVisitObject.getHospital_name());
	        statement.setString(2, medicalVisitObject.getDoctor_name());
	        statement.setString(3, medicalVisitObject.getDate_of_Visit());
	        statement.setString(4, medicalVisitObject.getNext_appointment());
	        statement.setString(5, medicalVisitObject.getP_email());
	        if(flag==1)
	        statement.setBinaryStream(6, (InputStream) inputStream, (int)(image.length()));
	        if(flag==0)
	        statement.setString(6,"");
	        statement.executeUpdate();
	        inputStream.close();
		}
		catch(Exception e) {
			logger.error(e);
		}
		return true;
	}
	public FileInputStream getInputStream1(File image) throws FileNotFoundException {
		return new FileInputStream(image);
	}
	public File getImage(MedicalVisit medicalVisitObject/*, bool isUT*/) {
		return new File("C:\\Users\\PG077675\\eclipse-workspace2\\PersonalMedicalHistoryF\\src\\main\\webapp\\images", medicalVisitObject.getPhoto());
	}
	public DataSource getDataSource() throws ClassNotFoundException
	{
		return DataSource.getConnection();
	}
	public int processImage(MedicalVisit medicalVisitObject) throws FileNotFoundException
	{
		int flag=0;
		String imageName = medicalVisitObject.getPhoto();
		//if user didnot upload file
		if(imageName=="")
			return 0;
		File image = getImage(medicalVisitObject);
		//file exists and is not null
		if(image.exists() && image!=null)
			flag= 1;
		//file path doesnot exists
		else if(!image.exists())
			flag= -1;
		return flag;	
	}
	public boolean deleteMedicalVisit(MedicalVisit medicalVisitObject)
	{
		int rs = -1;
		try
		{
			ds = getDataSource();
			logger= getLogger();
			String sql = "DELETE from NewMedicalVisit where Hospital_name = ? and Doctor_name = ? and Date_of_visit = ? and P_email = ?";
			PreparedStatement statement = ds.createPreparedStatement(sql);
			statement.setString(1, medicalVisitObject.getHospital_name());
	        statement.setString(2, medicalVisitObject.getDoctor_name());
	        statement.setString(3, medicalVisitObject.getDate_of_Visit());
	        statement.setString(4, medicalVisitObject.getP_email());
	        rs = statement.executeUpdate();
		}
		catch(Exception e)
		{
			
		}
		if(rs>0)
        	return true;
        else 
        	return false;
	}
}
