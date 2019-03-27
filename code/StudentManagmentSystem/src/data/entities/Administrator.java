package data.entities;

import java.util.ArrayList;
import java.util.List;

public class Administrator extends User{
	
	private int nrIdentificare;
	private String catedra;
	
	public Administrator(String nume, String prenume, String username, String password, String cnp, String adresa,
			String email, String catedra) {
		super(nume, prenume, username, password, cnp, adresa, email);
		this.catedra = catedra;
	}
	
	public Administrator(String nume, String prenume, String username, String password, String cnp, String adresa,
			String email, String catedra, int nrIdentificare) {
		super(nume, prenume, username, password, cnp, adresa, email);
		this.catedra = catedra;
		this.nrIdentificare=nrIdentificare;
	}

	public int getNrIdentificare() {
		return nrIdentificare;
	}

	public void setNrIdentificare(int nrIdentificare) {
		this.nrIdentificare = nrIdentificare;
	}

	public String getCatedra() {
		return catedra;
	}

	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}
	
}
