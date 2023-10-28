package bloodbankmanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Searching {
    private String table;    
    private static Connection con = null; 
    private static PreparedStatement pst = null;
    
    
    
public Searching(String tab)
{
    this.table = tab;
    
    try {
          con =  DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Searching.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public ResultSet searchByString(String n,String column)
    {
        try {  
            String QuerySelect = "SELECT * FROM "+table+" WHERE "+column+" LIKE ('%"+n+"%')";
            pst = con.prepareStatement(QuerySelect);
            ResultSet rs = pst.executeQuery();           
            return rs;                          
        } catch (SQLException ex) {
            Logger.getLogger(Searching.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet searchByStringAbs(String n,String column)
    {
        try {  
            String QuerySelect = "SELECT * FROM "+table+" WHERE "+column+"= '"+n+"'";
            pst = con.prepareStatement(QuerySelect);
            ResultSet rs = pst.executeQuery();           
            return rs;   
                       
        } catch (SQLException ex) {
            Logger.getLogger(Searching.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    
    public ResultSet searchByID(int id,String column)
    {
        try {  
            String QuerySelect = "SELECT * FROM "+table+" WHERE "+column+" = " + id ;
            pst = con.prepareStatement(QuerySelect);
            ResultSet rs = pst.executeQuery();             
            return rs;   
                       
        } catch (SQLException ex) {
            Logger.getLogger(Searching.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
