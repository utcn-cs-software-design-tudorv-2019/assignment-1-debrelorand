package business.entities;

import java.sql.Date;
import java.util.List;

import data.DAO.EnrolmentDAO;
import data.entities.Enrolment;

public class EnrolmentBLL {
	private EnrolmentDAO enrolmentDAO;
	
	public EnrolmentBLL()
	{
		enrolmentDAO = new EnrolmentDAO();
	}
	
	public int insert(int idStudent,int idCourse, Date startDate, Date finishDate, int nota)
	{
		return enrolmentDAO.insert(idStudent, idCourse,startDate,finishDate,nota);
	}
	
	public List<Enrolment> getById(int id)
	{
		return enrolmentDAO.getById(id);
	}
	
	public List<Enrolment> getByIdCourse(int id)
	{
		return enrolmentDAO.getByIdCourse(id);
	}
	
	public void update (int id, int nota) {
		enrolmentDAO.update(id, nota);
	}
}
