package business.entities;

import data.DAO.StudentDAO;
import data.entities.Student;

public class StudentBLL {
	private StudentDAO studentDAO;
	
	public StudentBLL()
	{
		studentDAO=new StudentDAO();
	}
	
	public int insert(Student student)
	{
		return studentDAO.insert(student);
	}
	
	public Student getByName(String Name)
	{
		return studentDAO.getByName(Name);
	}
}
