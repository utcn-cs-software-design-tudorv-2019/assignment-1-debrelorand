package data.entities;

public class Course {
	private int id;
	private String nume;
	private int credit;
	private int idAdministrator;
	
	public Course(int id, String nume, int credit, int idAdministrator) {
		super();
		this.id = id;
		this.nume = nume;
		this.credit = credit;
		this.idAdministrator=idAdministrator;
	}
	
	public Course(String nume, int credit, int idAdministrator) {
		super();
		this.nume = nume;
		this.credit = credit;
		this.idAdministrator=idAdministrator;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public int getidAdministrator()
	{
		return idAdministrator;
	}
	
	public void setidAdministrator(int idAdministrator)
	{
		this.idAdministrator=idAdministrator;
	}
	
	
}
