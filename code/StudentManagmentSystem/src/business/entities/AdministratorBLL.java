package business.entities;

import data.DAO.AdministratorDAO;
import data.entities.Administrator;

public class AdministratorBLL {
	private AdministratorDAO administratorDAO;
	
	public AdministratorBLL() {
		administratorDAO = new AdministratorDAO();
	}
	
	public int insert(Administrator admin){
		return administratorDAO.insert(admin);
	}
	
	public Administrator getByName(String name)
	{
		return administratorDAO.getByName(name);
	}
}
