package business.entities;

import java.sql.Date;
import java.util.List;

import data.DAO.EnrolmentDAO;
import data.entities.Course;
import data.entities.Enrolment;

public class EnrolmentBLL {
	private EnrolmentDAO enrolmentDAO;
	
	public EnrolmentBLL()
	{
		enrolmentDAO = new EnrolmentDAO();
	}
	
	public int enroll(Enrolment enrolment)
	{
		return enrolmentDAO.enroll(enrolment);
	}
	
	public List<Enrolment> getById(Enrolment enrolment)
	{
		return enrolmentDAO.getById(enrolment);
	}
	
	public List<Enrolment> getByIdCourse(Course curs)
	{
		return enrolmentDAO.getByIdCourse(curs);
	}
	
	public void updateEnrolment (Enrolment enrolment) {
		enrolmentDAO.updateEnrolment(enrolment);
	}
}
