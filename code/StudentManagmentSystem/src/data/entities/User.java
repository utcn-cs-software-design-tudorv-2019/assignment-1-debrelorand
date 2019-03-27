package data.entities;

public class User {
	private String nume;
	private String prenume;
	private String username;
	private String password;
	private String cnp;
	private String adresa;
	private String email;
	
	public User()
	{
		
	}
	
	public User(String nume, String prenume, String username, String password, String cnp, String adresa,
			String email) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.username = username;
		this.password = password;
		this.cnp = cnp;
		this.adresa = adresa;
		this.email = email;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
