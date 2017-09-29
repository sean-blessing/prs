package prs.db.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import prs.business.User;
import prs.db.DBUtil;

public class UserDB implements UserDAO {
	Connection connection = null;
	
	public UserDB() {
		try {
			connection = DBUtil.getConnection();
		}
		catch (SQLException sqle) {
			System.out.print("Error getting connection: ");
			sqle.printStackTrace();
		}
	}
	

	@Override
	public User getUserByUserName(String inUserName) {
		User usr = null;
		String sql = "Select * FROM User where UserName = '"+inUserName+"'";
		try
		{
			ResultSet rs = getResultSetFromQuery(sql);
			while (rs.next()) {
				usr = getUserFromResultSet(rs);
			}
			DBUtil.closeConnection();
		}
		catch (SQLException sqle) {
			System.out.println("Error retrieving user for username '"+inUserName+"'!");
			sqle.printStackTrace();
		}
		
		return usr;
	}

	@Override
	public boolean addUser(User u) {
		String sql = "insert into user (UserName,Password,FirstName,LastName,Phone,Email,IsReviewer,IsAdmin)" +
				 "values (?, ?, ?, ?, ?, ?, ?, ?)";
		int rowsUpdated = 0;
		boolean success = false;
		
		try (Connection connection = DBUtil.getConnection();
       		PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) { // need the oid back after insert
           ps.setString(1, u.getUserName());
           ps.setString(2, u.getPassword());
           ps.setString(3, u.getFirstName());
           ps.setString(4, u.getLastName());
           ps.setString(5, u.getPhoneNumber());
           ps.setString(6, u.getEmail());
           ps.setBoolean(7, u.isReviewer());
           ps.setBoolean(8, u.isAdmin());
           rowsUpdated = ps.executeUpdate();
           //upon successful insert, get the generated key from prepared statement
           try (ResultSet generatedKey = ps.getGeneratedKeys()) {
        	   if (generatedKey.next()) {
        		   u.setId(generatedKey.getInt(1));
        	   }
           }
		}
		catch (SQLException sqle) {
			System.out.println("Error adding user!");
			sqle.printStackTrace();
		}
       if (rowsUpdated>0) success=true;
       return success;
	}

	private User getUserFromResultSet(ResultSet rs) throws SQLException{
		User u = new User();
		u.setId(rs.getInt(1));
		u.setUserName(rs.getString(2));
		u.setPassword(rs.getString(3));
		u.setFirstName(rs.getString(4));
		u.setLastName(rs.getString(5));
		u.setPhoneNumber(rs.getString(6));
		u.setEmail(rs.getString(7));
		u.setReviewer(rs.getBoolean(8));
		u.setAdmin(rs.getBoolean(9));
		return u;
	}
	
	private ResultSet getResultSetFromQuery(String sqlStmt) throws SQLException{
		
		try
		{
			Connection connection = DBUtil.getConnection();
			PreparedStatement ps = connection.prepareStatement(sqlStmt);
			ResultSet rs = ps.executeQuery();
			return rs;
		}
		catch (SQLException sqle) {
			throw sqle;
		}

	}

}
