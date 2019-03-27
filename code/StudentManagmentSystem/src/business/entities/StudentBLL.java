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
	
	public int insert(Student student)
	{
		return studentDAO.insert(student);
	}
	
	public Student getByID(int id)
	{
		return studentDAO.getByID(id);
	}
	
	public Student getByName(String Name)
	{
		return studentDAO.getByName(Name);
	}
	
	public boolean update(Student student)
	{
		return studentDAO.update(student);
	}
	
	public boolean delete(int ID)
	{
		return studentDAO.delete(ID);
	}
	
	public List<Student> getAll()
	{
		return studentDAO.getAll();
	}
}
