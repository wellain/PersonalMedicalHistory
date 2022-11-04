

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import PersonalMedicalHistory.Model.DataSource;
import PersonalMedicalHistory.Model.MedicalVisit;
import PersonalMedicalHistory.Model.MedicalVisitDao;

public class TestMedicalVisitDao {
	DataSource ds;
	FileInputStream inputStream;
	PreparedStatement statement;
	ResultSet rs;
	MedicalVisitDao mvd;
	File image;

	@Before
	public void setup()
	{
		ds=Mockito.mock(DataSource.class);
		statement=Mockito.mock(PreparedStatement.class);
		inputStream = Mockito.mock(FileInputStream.class);
		rs=Mockito.mock(ResultSet.class);
		mvd=Mockito.spy(new MedicalVisitDao());
		image = Mockito.mock(File.class);
		
	}

	@Test
	public void testAddMedicalVisit() throws ClassNotFoundException, SQLException, FileNotFoundException {
		MedicalVisit mv = new MedicalVisit();
		mv.setPhoto("photo");
		mv.setDate_of_Visit("01/01/2001");
		mv.setDoctor_name("doc");
		mv.setHospital_name("hos");
		mv.setNew_medical_visit_id(1);
		mv.setNext_appointment("02/01/2001");
		mv.setP_email("abc@gmail.com");
		Mockito.when(mvd.getDataSource()).thenReturn(ds);
		Mockito.when(mvd.processImage(mv)).thenReturn(0);
		Mockito.when(mvd.getImage(mv)).thenReturn(image);
		Mockito.when(ds.createPreparedStatement(Mockito.anyString())).thenReturn(statement);
		//Mockito.when(mvd.getInputStream1(image)).thenReturn(inputStream);
		

		Mockito.when(statement.executeQuery()).thenReturn(rs);
		Mockito.when(rs.getString("Hospital_name")).thenReturn("hos");
		Mockito.when(rs.getString("Doctor_name")).thenReturn("doc");
		Mockito.when(rs.getInt("New_medical_visit_id")).thenReturn(1);
		boolean val=mvd.addMedicalVisit(mv);
		assertTrue(val);
		//Mockito.verify(statement,Mockito.atLeastOnce()).executeQuery();
	}
	@Test
	public void testAddMedicalVisitNegative() throws FileNotFoundException, ClassNotFoundException, SQLException
	{
		MedicalVisit mv = new MedicalVisit();
		mv.setPhoto("photo");
		Mockito.when(mvd.getDataSource()).thenReturn(ds);
		Mockito.when(mvd.processImage(mv)).thenReturn(-1);
		boolean val=mvd.addMedicalVisit(mv);
		assertFalse(val);
		
	}
	@Test
	public void testDeleteMedicalVisitPositive() throws ClassNotFoundException, SQLException
	{
		MedicalVisit mv = new MedicalVisit();
		Mockito.when(mvd.getDataSource()).thenReturn(ds);
		Mockito.when(ds.createPreparedStatement(Mockito.anyString())).thenReturn(statement);
		Mockito.doNothing().when(statement).setString(1,"TMH");
		Mockito.doNothing().when(statement).setString(2,"Sanjeev");
		Mockito.doNothing().when(statement).setString(3,"02/2020/01");
		Mockito.doNothing().when(statement).setString(4,"kamal@gmail.com");
		boolean val = mvd.deleteMedicalVisit(mv);
		assertTrue(true);
	}
	@Test
	public void testDeleteMedicalVisitNegative() throws ClassNotFoundException, SQLException
	{
		MedicalVisit mv = new MedicalVisit();
		Mockito.when(mvd.getDataSource()).thenReturn(ds);
		Mockito.when(ds.createPreparedStatement(Mockito.anyString())).thenReturn(statement);
		Mockito.doNothing().when(statement).setString(Mockito.anyInt(), Mockito.anyString());
		boolean val = mvd.deleteMedicalVisit(mv);
		assertFalse(val);
	}

}
