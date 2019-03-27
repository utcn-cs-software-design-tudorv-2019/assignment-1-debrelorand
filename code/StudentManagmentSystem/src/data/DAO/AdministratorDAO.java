package data.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import data.connection.ConnectionFactory;
import data.entities.Administrator;

public class AdministratorDAO {
	protected static final Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO administrator (nume,prenume,username,password,cnp,adresa,email,catedra)" + " VALUES (?,?,?,?,?,?,?,?)";
	private final static String updateStatementString = "UPDATE administrator SET nume=?,prenume=?,username=?,password=?,cnp=?,adresa=?,email=?,catedra=?" + " WHERE idAdministrator=?";
	private final static String selectStatementString = "SELECT * From administrator where username=?";
	private final static String deleteStatementString = "DELETE from administrator where idAdministrator=?";
	
	public int insert(Administrator admin) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		int new_id=-1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			
			insertStatement.setString(1,admin.getNume());
			insertStatement.setString(2, admin.getPrenume());
			insertStatement.setString(3, admin.getUsername());
			insertStatement.setString(4, admin.getPassword());
			insertStatement.setString(5, admin.getCnp());
			insertStatement.setString(6, admin.getAdresa());
			insertStatement.setString(7, admin.getEmail());
			insertStatement.setString(8, admin.getCatedra());
			
			insertStatement.executeUpdate();
			
			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				new_id = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "AdministratorDao:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return new_id;
	}
	
	public Administrator getByName(String name)
	{
		Administrator rezultat=null;
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement finderStatement = null;
		try {
			ResultSet rs = null;
			finderStatement = dbConnection.prepareStatement(selectStatementString, Statement.RETURN_GENERATED_KEYS);
			
			finderStatement.setString(1,name);
			//System.out.println(finderStatement);
			rs = finderStatement.executeQuery();
			rs.next();
			
			rezultat = new Administrator(rs.getString("nume"),rs.getString("prenume"),rs.getString("username"),rs.getString("password"),rs.getString("cnp"),rs.getString("adresa"),rs.getString("email"),rs.getString("catedra"),rs.getInt("idAdministrator"));
			
		} catch (SQLException e) {
			//LOGGER.log(Level.WARNING, "StudentDao:insert " + e.getMessage());
		} finally {
			
			ConnectionFactory.close(finderStatement);
			ConnectionFactory.close(dbConnection);
		}
		return rezultat;
	}
	
	public boolean update(Administrator admin)
	{
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;	
		int ID = admin.getNrIdentificare();

		try {			
			updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);		
			updateStatement.setString(1,admin.getNume());
			updateStatement.setString(2,admin.getPrenume());
			updateStatement.setString(3,admin.getUsername());
			updateStatement.setString(4,admin.getPassword());
			updateStatement.setString(5,admin.getCnp());
			updateStatement.setString(6,admin.getAdresa());
			updateStatement.setString(7,admin.getEmail());
			updateStatement.setString(8,admin.getCatedra());
			updateStatement.setInt(9,ID);		
			updateStatement.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			LOGGER.log(Level.WARNING, "AdministratorDao:update " + e.getMessage());
			return false;
	    } finally {
		 ConnectionFactory.close(updateStatement);
		 ConnectionFactory.close(dbConnection);
	    }
	}
	
	public boolean delete(int adminID){
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement deleteStatement = null;
		
		try {
			deleteStatement = dbConnection.prepareStatement(deleteStatementString);
			deleteStatement.setInt(1, adminID);
			deleteStatement.executeUpdate();
			return true;
		}
		catch(SQLException e)
		 {
			 LOGGER.log(Level.WARNING, "AdministratorDAO:delete " + e.getMessage());
			 return false;
	     } finally {
		  ConnectionFactory.close(deleteStatement);
		  ConnectionFactory.close(dbConnection);
	    }
	}
}
