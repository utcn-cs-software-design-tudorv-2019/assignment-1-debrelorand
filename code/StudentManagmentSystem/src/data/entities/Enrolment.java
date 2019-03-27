package data.entities;

import java.sql.Date;

public class Enrolment {
	private Course curs;
	private Date startDate;
	private Date finishDate;
	private int nota;
	private int studentID;
	private int enrolmentID;
	
	public Enrolment(Course curs, Date startDate, Date finishDate, int nota) {
		super();
		this.curs = curs;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.nota = nota;
	}
	
	public Enrolment(Course curs, Date startDate, Date finishDate, int nota, int studentID) {
		super();
		this.curs = curs;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.nota = nota;
		this.studentID=studentID;
	}
	
	public Enrolment(Course curs, Date startDate, Date finishDate, int nota, int studentID, int enrolmentID) {
		super();
		this.curs = curs;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.nota = nota;
		this.studentID=studentID;
		this.enrolmentID=enrolmentID;
	}
	
	
	public Course getCurs() {
		return curs;
	}
	public void setCurs(Course curs) {
		this.curs = curs;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int getEnrolmentID() {
		return enrolmentID;
	}

	public void setEnrolmentID(int enrolmentID) {
		this.enrolmentID = enrolmentID;
	}
	
	
}
