package data.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import data.entities.Course;
import data.entities.Enrolment;
import data.entities.Student;
import data.connection.ConnectionFactory;

public class StudentDAO {
	protected static final Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO student (nume,prenume,username,password,cnp,adresa,email,grupa)" + " VALUES (?,?,?,?,?,?,?,?)";
	private final static String updateStatementString = "UPDATE student SET nume=?,prenume=?,username=?,password=?,cnp=?,adresa=?,email=?,grupa=?" + " WHERE idStudent=?";
	private final static String selectStatementString = "SELECT * From student where username=?";
	private final static String deleteStatementString = "DELETE from student where idStudent=?";
	private final static String selectByID = "SELECT * from student where idStudent=?";
	private final static String getAll = "SELECT * from student";
	
	public int registerStudent(Student student) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		int new_id=-1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			
			insertStatement.setString(1,student.getNume());
			insertStatement.setString(2, student.getPrenume());
			insertStatement.setString(3, student.getUsername());
			insertStatement.setString(4, student.getPassword());
			insertStatement.setString(5, student.getCnp());
			insertStatement.setString(6, student.getAdresa());
			insertStatement.setString(7, student.getEmail());
			insertStatement.setString(8, student.getGrupa());
			
			insertStatement.executeUpdate();
			
			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				new_id = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDao:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return new_id;
	}
	
	public Student getByName(String name)
	{
		Student rezultat=null;
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement finderStatement = null;
		try {
			ResultSet rs = null;
			finderStatement = dbConnection.prepareStatement(selectStatementString, Statement.RETURN_GENERATED_KEYS);
			
			finderStatement.setString(1,name);
			rs = finderStatement.executeQuery();
			rs.next();
			
			rezultat = new Student(rs.getString("nume"),rs.getString("prenume"),rs.getString("username"),rs.getString("password"),rs.getString("cnp"),rs.getString("adresa"),rs.getString("email"),rs.getString("grupa"),rs.getInt("idStudent"));
			
		} catch (SQLException e) {
			//LOGGER.log(Level.WARNING, "StudentDao:insert " + e.getMessage());
		} finally {
			
			ConnectionFactory.close(finderStatement);
			ConnectionFactory.close(dbConnection);
		}
		return rezultat;
	}
	
	public Student getByID(int id)
	{
		Student rezultat=null;
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement finderStatement = null;
		try {
			ResultSet rs = null;
			finderStatement = dbConnection.prepareStatement(selectByID, Statement.RETURN_GENERATED_KEYS);
			
			finderStatement.setInt(1,id);
			rs = finderStatement.executeQuery();
			rs.next();
			
			rezultat = new Student(rs.getString("nume"),rs.getString("prenume"),rs.getString("username"),rs.getString("password"),rs.getString("cnp"),rs.getString("adresa"),rs.getString("email"),rs.getString("grupa"),rs.getInt("idStudent"));
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDao:insert " + e.getMessage());
		} finally {
			
			ConnectionFactory.close(finderStatement);
			ConnectionFactory.close(dbConnection);
		}
		return rezultat;
	}
	
	public boolean updateStudent(Student student)
	{
//private final static String updateStatementString = "UPDATE student SET nume=?,prenume=?,username=?,password=?,cnp=?,adresa=?,email=?,grupa=?" + " WHERE idStudent=?";
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;	
		int ID = student.getNrIdentificare();

		try {			
			updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);		
			updateStatement.setString(1,student.getNume());
			updateStatement.setString(2,student.getPrenume());
			updateStatement.setString(3,student.getUsername());
			updateStatement.setString(4,student.getPassword());
			updateStatement.setString(5,student.getCnp());
			updateStatement.setString(6,student.getAdresa());
			updateStatement.setString(7,student.getEmail());
			updateStatement.setString(8, student.getGrupa());
			updateStatement.setInt(9,ID);		
			updateStatement.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			LOGGER.log(Level.WARNING, "StudentDao:update " + e.getMessage());
			return false;
	    } finally {
		 ConnectionFactory.close(updateStatement);
		 ConnectionFactory.close(dbConnection);
	    }	
	}
	
	public boolean deleteStudent(int ID){
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement deleteStatement = null;
		
		try {
			deleteStatement = dbConnection.prepareStatement(deleteStatementString);
			deleteStatement.setInt(1, ID);
			deleteStatement.executeUpdate();
			return true;
		}
		catch(SQLException e)
		 {
			 LOGGER.log(Level.WARNING, "StudentDao:delete " + e.getMessage());
			 return false;
	     } finally {
		  ConnectionFactory.close(deleteStatement);
		  ConnectionFactory.close(dbConnection);
	    }
	}
	
	public List<Student> getAll()
	{
		List<Student> rez = new ArrayList<Student>();

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement finderStatement = null;
		try {
			ResultSet rs = null;
			finderStatement = dbConnection.prepareStatement(getAll, Statement.RETURN_GENERATED_KEYS);
			//System.out.println(finderStatement);
			rs = finderStatement.executeQuery();
			
			while (rs.next())
			{
//public Student(String nume, String prenume, String username, String password, String cnp, String adresa, String email, String grupa,int nrIdentificare) {
				
				Student student = new Student(rs.getString("nume"),rs.getString("prenume"),rs.getString("username"),rs.getString("password"),rs.getString("cnp"),rs.getString("adresa"),rs.getString("email"),rs.getString("grupa"),rs.getInt("idStudent"));
				rez.add(student);
			}
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDao:getAll " + e.getMessage());
		} finally {
			
			ConnectionFactory.close(finderStatement);
			ConnectionFactory.close(dbConnection);
		}
		
		return rez;
	}
}
