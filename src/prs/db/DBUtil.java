package prs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DBUtil {
    
    private static Connection connection;
    
    private DBUtil() {}

    public static synchronized Connection getConnection() throws SQLException {
        try {
            // set the db url, username, and password
            String url = "jdbc:mysql://localhost:3306/prs";
            String username = "prs_user";
            String password = "sesame";

            // get and return connection
            Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            connection = DriverManager.getConnection(
                    url, username, password);
            //return connection;
        } catch (SQLException e) {
        	System.out.println("Error establishing connection!");
            throw e;
        }  
        catch (IllegalAccessException|InstantiationException|ClassNotFoundException me) {
        	System.err.println("exception in DBUtil...");
        	me.printStackTrace();
        }
        return connection;
        
    }
    
    public static synchronized void closeConnection()  throws SQLException{
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
            	System.out.println("Error closing connection!");
                throw e;
            } finally {
                connection = null;                
            }
        }
    }
}