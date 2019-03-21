package data.entities;

import java.sql.Date;

public class Enrolment {
	private Course curs;
	private Date startDate;
	private Date finishDate;
	private int nota;
	
	public Enrolment(Course curs, Date startDate, Date finishDate, int nota) {
		super();
		this.curs = curs;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.nota = nota;
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
	
	
}
