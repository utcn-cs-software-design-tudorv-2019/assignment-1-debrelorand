package data.entities;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
	private int nrIdentificare;
	private String grupa;
	
	public Student()
	{
		super();
	}
	
	public Student(String nume, String prenume, String username, String password, String cnp, String adresa, String email, String grupa) {
		super(nume, prenume, username, password, cnp, adresa, email);
		this.grupa=grupa;
	}
	
	public Student(String nume, String prenume, String username, String password, String cnp, String adresa, String email, String grupa,int nrIdentificare) {
		super(nume, prenume, username, password, cnp, adresa, email);
		this.grupa=grupa;
		this.nrIdentificare=nrIdentificare;
	}

	public int getNrIdentificare() {
		return nrIdentificare;
	}

	public void setNrIdentificare(int nrIdentificare) {
		this.nrIdentificare = nrIdentificare;
	}

	public String getGrupa() {
		return grupa;
	}

	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}

	@Override
	public String toString() {
		return "Student [nrIdentificare=" + nrIdentificare + ", grupa=" + grupa 
				+ ", getNume()=" + getNume() + ", getPrenume()=" + getPrenume() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getCnp()=" + getCnp() + ", getAdresa()=" + getAdresa()
				+ ", getEmail()=" + getEmail() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
