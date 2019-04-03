package business.entities;

import java.util.List;

import data.DAO.StudentDAO;
import data.entities.Student;

public class StudentBLL {
	private StudentDAO studentDAO;
	
	public StudentBLL()
	{
		studentDAO=new StudentDAO();
	}
	
	public int registerStudent(Student student)
	{
		return studentDAO.registerStudent(student);
	}
	
	public Student getByID(int id)
	{
		return studentDAO.getByID(id);
	}
	
	public Student getByName(String Name)
	{
		return studentDAO.getByName(Name);
	}
	
	public boolean updateStudent(Student student)
	{
		return studentDAO.updateStudent(student);
	}
	
	public boolean deleteStudent(int ID)
	{
		return studentDAO.deleteStudent(ID);
	}
	
	public List<Student> getAll()
	{
		return studentDAO.getAll();
	}
}
