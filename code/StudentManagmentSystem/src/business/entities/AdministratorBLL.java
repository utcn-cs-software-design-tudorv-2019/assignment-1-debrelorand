package business.entities;

import data.DAO.AdministratorDAO;
import data.entities.Administrator;

public class AdministratorBLL {
	private AdministratorDAO administratorDAO;
	
	public AdministratorBLL() {
		administratorDAO = new AdministratorDAO();
	}
	
	public int registAdministrator(Administrator admin){
		return administratorDAO.registAdministrator(admin);
	}
	
	public Administrator getByName(Administrator admin)
	{
		return administratorDAO.getByName(admin);
	}
	
	public boolean updateAdministrator(Administrator admin)
	{
		return administratorDAO.updateAdministrator(admin);
	}
	
	public boolean deleteAdministrator(Administrator admin) {
		return administratorDAO.deleteAdministrator(admin);
	}
}
