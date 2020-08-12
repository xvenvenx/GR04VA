/*package book.jakarta8.calypsojpa.jpa;

//import java.sql.*;

public class DBConnection {
	
	private static String DRIVER= "org.apache.derby.jdbc.ClientDriver";
	//private static String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	//private static String JDBC_URL = "jdbc:derby:ConnectingCreatingJavaDB;create-true";
	//private static String JDBC_URL = "\"jdbc:derby:\\localhost:1527\C:\Users\DonMoky\MyDB;create=true\"";
	private static String JDBC_URL = "jdbc:derby://localhost:1527/calypso;user=user0;password=pw715";
	Connection conn;
	
	public DBConnection() {
		try {
			this.conn = DriverManager.getConnection(JDBC_URL);
			if(this.conn != null) {
				System.out.println("Connection Successful");
			}
		}
		catch(SQLException e){
			System.out.println("Connection Failed");
		}
	}

}
*/
package book.jakarta8.calypsojpa.jpa;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
/**
 * This program demonstrates how to connect to Apache Derby (Java DB) database
 * for the network client driver.
 * @author www.codejava.net
 *
 */
public class DBConnection {
 
    public static void main(String[] args) {
         
        try {
             
            // connect method #2 - network client driver
            String dbURL2 = "jdbc:derby://localhost:1527/calypso;create=true";
            String user = "user0";
            String password = "pw715";
            Connection conn2 = DriverManager.getConnection(dbURL2, user, password);
            if (conn2 != null) {
                System.out.println("Connected to database #2");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}