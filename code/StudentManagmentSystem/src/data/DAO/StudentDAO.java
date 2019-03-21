package data.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import data.entities.Student;
import data.connection.ConnectionFactory;

public class StudentDAO {
	protected static final Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO student (nume,prenume,username,password,cnp,adresa,email,grupa)" 
			+ " VALUES (?,?,?,?,?,?,?,?)";
	private final static String updateStatementString = "UPDATE students SET username=?, cardID=?, cnp=?, address=?, groupID=?, username=?, password=?"
					+ " WHERE studentID=?";
	private final static String selectStatementString = "SELECT * From student where username=?";
	public int insert(Student student) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		int new_id=-1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			
			insertStatement.setString(1,student.getNume());
			insertStatement.setString(2, student.getPrenume());
			insertStatement.setString(3, student.getUsername());
			insertStatement.setString(4, student.getPassword());
			insertStatement.setInt(5, student.getCnp());
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
			//System.out.println(finderStatement);
			rs = finderStatement.executeQuery();
			rs.next();
			
			rezultat = new Student(rs.getString("nume"),rs.getString("prenume"),rs.getString("username"),rs.getString("password"),rs.getInt("cnp"),rs.getString("adresa"),rs.getString("email"),rs.getString("grupa"),rs.getInt("idStudent"));
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDao:insert " + e.getMessage());
		} finally {
			
			ConnectionFactory.close(finderStatement);
			ConnectionFactory.close(dbConnection);
		}
		return rezultat;
	}
	
	// update a student
	
	public void update(Student student)
	{
		
	}
	
	// delete student
	
	public void delete(int studentID){
		
	}
}
