package business.entities;

import java.util.List;

import data.DAO.CourseDAO;
import data.entities.Course;

public class CourseBLL {
	private CourseDAO courseDAO;
	
	public CourseBLL()
	{
		courseDAO = new CourseDAO();
	}
	
	public int insert(Course curs)
	{
		return courseDAO.insert(curs);
	}
	
	public List<Course> getAll()
	{
		return courseDAO.getAll();
	}
	
	public List<Course> getByidAdmin(int id)
	{
		return courseDAO.getByidAdmin(id);
	}
}
