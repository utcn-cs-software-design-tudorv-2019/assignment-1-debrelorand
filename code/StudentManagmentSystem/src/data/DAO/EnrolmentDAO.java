package data.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import data.connection.ConnectionFactory;
import data.entities.Course;
import data.entities.Enrolment;

public class EnrolmentDAO {
	protected static final Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO enrollment (idStudent, idCourse, startDate, finishDate, nota)" + " VALUES (?,?,?,?,?)";
	private static final String getByIdStudentStatementString = "SELECT * from enrollment where idStudent=?";
	private static final String getByIdCourseStatementString = "SELECT * from enrollment where idCourse=?";
	private final static String updateStatementString = "UPDATE enrollment SET nota=?" + " WHERE idEnrollment=?";
	
	public int enroll(Enrolment enrolment) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		int new_id=-1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			
			insertStatement.setInt(1, enrolment.getStudentID());
			insertStatement.setInt(2,enrolment.getCurs().getId());
			insertStatement.setDate(3, enrolment.getStartDate());
			insertStatement.setDate(4, enrolment.getFinishDate());
			insertStatement.setInt(5, enrolment.getNota());
			
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
	
	public List<Enrolment> getById(Enrolment enrolment)
	{
		List<Enrolment> rez = new ArrayList<Enrolment>();

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement finderStatement = null;
		PreparedStatement finderStatement2 = null;
		try {
			ResultSet rs = null;
			ResultSet rs2 = null;
			finderStatement = dbConnection.prepareStatement(getByIdStudentStatementString, Statement.RETURN_GENERATED_KEYS);
			finderStatement.setInt(1,enrolment.getStudentID());
			//System.out.println(finderStatement);
			rs = finderStatement.executeQuery();
			
			while (rs.next())
			{
				finderStatement2 = dbConnection.prepareStatement("select * from course where idCourse="+rs.getInt("idCourse"),Statement.RETURN_GENERATED_KEYS);
				rs2 = finderStatement2.executeQuery();
				rs2.next();
				Course curs = new Course(rs2.getInt("idCourse"),rs2.getString("nume"),rs2.getInt("credit"),rs2.getInt("idAdministrator"));
				Enrolment rezultat = new Enrolment(curs,rs.getDate("startDate"),rs.getDate("finishDate"),rs.getInt("nota"),rs.getInt("idStudent"));
				rez.add(rezultat);
			}
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDao:insert " + e.getMessage());
		} finally {
			
			ConnectionFactory.close(finderStatement);
			ConnectionFactory.close(finderStatement2);
			ConnectionFactory.close(dbConnection);
		}
		
		return rez;
	}
	
	public List<Enrolment> getByIdCourse(Course course)
	{
		List<Enrolment> rez = new ArrayList<Enrolment>();

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement finderStatement = null;
		PreparedStatement finderStatement2 = null;
		try {
			ResultSet rs = null;
			ResultSet rs2 = null;
			finderStatement = dbConnection.prepareStatement(getByIdCourseStatementString, Statement.RETURN_GENERATED_KEYS);
			finderStatement.setInt(1,course.getId());
			//System.out.println(finderStatement);
			rs = finderStatement.executeQuery();
			
			while (rs.next())
			{
				finderStatement2 = dbConnection.prepareStatement("select * from course where idCourse="+rs.getInt("idCourse"),Statement.RETURN_GENERATED_KEYS);
				rs2 = finderStatement2.executeQuery();
				rs2.next();
				Course curs = new Course(rs2.getInt("idCourse"),rs2.getString("nume"),rs2.getInt("credit"),rs2.getInt("idAdministrator"));
				Enrolment rezultat = new Enrolment(curs,rs.getDate("startDate"),rs.getDate("finishDate"),rs.getInt("nota"),rs.getInt("idStudent"),rs.getInt("idEnrollment"));
				rez.add(rezultat);
			}
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDao:insert " + e.getMessage());
		} finally {
			
			ConnectionFactory.close(finderStatement);
			ConnectionFactory.close(finderStatement2);
			ConnectionFactory.close(dbConnection);
		}
		
		return rez;
	}
	
	public void updateEnrolment (Enrolment enrolment) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;	

		try {			
			updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);		
			updateStatement.setInt(1,enrolment.getNota());
			updateStatement.setInt(2, enrolment.getEnrolmentID());
			updateStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			LOGGER.log(Level.WARNING, "StudentDao:update " + e.getMessage());
		
	    } finally {
		 ConnectionFactory.close(updateStatement);
		 ConnectionFactory.close(dbConnection);
	    }	
	}
}
