package PersonalMedicalHistory.Model;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;

/**

 * A DataSource for the system. This Class holds the {@link Connection} object for the databsae.This class is responsible 

 * to initialize the {@link Connection} object and 

 * @author Abhishek

 *

 */

public class DataSource 

{

	private static final String DB_URL="jdbc:sqlite:C:\\Users\\PG077675\\eclipse-workspace2\\PersonalMedicalHistoryF\\PersonalMedicalHistoryDb.db";

	private Connection conn;

	private static DataSource instance;

	private DataSource() throws ClassNotFoundException

	{	

		try 

		{	
			Class.forName("org.sqlite.JDBC");
			conn=DriverManager.getConnection(DB_URL);
			System.out.println("Connection Established");

		}

		catch(SQLException e)

		{

			System.err.print(e.getMessage());

		}

	}

	/**

	 * This method returns an instance of the {@linkplain DataSource} class.If the Singleton instance has not 

	 * been initialized then it initializes the it and returns the same 

	 * @return an singleton instance of the {@link DataSource} class
	 * @throws ClassNotFoundException 

	 */

	public static DataSource getConnection() throws ClassNotFoundException 

	{	

		if(instance==null)

		{

			synchronized(DataSource.class)

			{

				if(instance==null)

				{	

					instance=new DataSource();

				}

			}

		}

		return instance;

	}

	/**

	 * This Statement returns an {@link PreparedStatement} with the help of the {@link Connection} class object

	 * that has been already initialized.

	 * @param statement  an SQL statement that may contain one or more '?' IN parameter placeholders

	 * @return a new default {@link PreparedStatement} object containing thepre-compiled SQL statement

	 * @throws SQLException if a database access error occurs or this method is called on a closed connection

	 */

	public PreparedStatement createPreparedStatement(String statement) throws SQLException

	{

		return conn.prepareStatement(statement);

	}

}