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
import data.connection.ConnectionFactory;

public class CourseDAO {
	protected static final Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());
	private static final String getAllStatementString = "Select * from course";
	private static final String getByidAdminStatementString = "Select * from course where idAdministrator=?";
	private static final String insertStatementString = "INSERT INTO course (idAdministrator,nume,credit)" + " VALUES (?,?,?)";
	
	public int insert(Course curs)
	{
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		int new_id=-1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			
			insertStatement.setInt(1,curs.getidAdministrator());
			insertStatement.setString(2,curs.getNume());
			insertStatement.setInt(3,curs.getCredit());
			
			insertStatement.executeUpdate();
			
			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				new_id = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "CourseDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return new_id;
	}
	
	public List<Course> getAll()
	{		
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findAllStatement = null;
        ResultSet rs = null;
        
        List<Course> cursurile = new ArrayList<Course>();
		
		try {
			findAllStatement = dbConnection.prepareStatement(getAllStatementString);
			rs = findAllStatement.executeQuery();
			
			while(rs.next())
			{   
			    Course curse = new Course(rs.getInt("idCourse"),rs.getString("nume"),rs.getInt("credit"),rs.getInt("idAdministrator"));
			    cursurile.add(curse);
			}		
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"CourseDao:findAll " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findAllStatement);
			ConnectionFactory.close(dbConnection);
		}
     
		return cursurile;
	}
	
	public List<Course> getByidAdmin(int id){
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement getByidStatement=null;
		ResultSet rs = null;
		
		List<Course> cursurile = new ArrayList<Course>();
		
		try {
			getByidStatement = dbConnection.prepareStatement(getByidAdminStatementString);
			getByidStatement.setInt(1, id);
			rs = getByidStatement.executeQuery();
			
			while(rs.next())
			{   
			    Course curse = new Course(rs.getInt("idCourse"),rs.getString("nume"),rs.getInt("credit"),rs.getInt("idAdministrator"));
			    cursurile.add(curse);
			}		
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"CourseDao:findAll " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(getByidStatement);
			ConnectionFactory.close(dbConnection);
		}
		
		return cursurile;
	}
}
