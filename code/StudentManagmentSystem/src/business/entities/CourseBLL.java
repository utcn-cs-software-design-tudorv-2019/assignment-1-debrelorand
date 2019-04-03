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
	
	public int newCourse(Course curs)
	{
		return courseDAO.newCourse(curs);
	}
	
	public List<Course> getAll()
	{
		return courseDAO.getAll();
	}
	
	public List<Course> getByidAdmin(Course course)
	{
		return courseDAO.getByidAdmin(course);
	}
}
