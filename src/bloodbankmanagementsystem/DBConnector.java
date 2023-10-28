
package bloodbankmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnector {
    
    public static Connection getConnection() throws SQLException
    {
        final String url = "jdbc:mysql://localhost:3306/bbms";
        final String UserName = "root";
        final String Password = "";
             
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,UserName,Password);
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
