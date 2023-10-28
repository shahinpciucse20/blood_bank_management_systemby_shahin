package bloodbankmanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Stock {
    
    private int blood_id;
    private double quantity;
    private String blood_group;
    
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;
    private static Connection con = null;    
    private DBConnector dcon = null; 
    
    
    public Stock()
    {
        try { 
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateStockById(int id,double q)
        {
            String UpdateQuery = "UPDATE stock SET quantity = ? WHERE blood_id ="+id;            
            try {             
                pst = con.prepareStatement(UpdateQuery);                
                pst.setDouble(1,q);                           
                pst.executeUpdate();    
                System.out.println("Stock Has been Updated!");
                } catch (SQLException ex) {
                Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    public ResultSet getAllData()
        {
            String SelectQuery = "SELECT * FROM stock";            
            try {             
                pst = con.prepareStatement(SelectQuery);                               
                rs = pst.executeQuery();
                return rs;                
                } catch (SQLException ex) {
                Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }            
        }
    public int getBloodIdByName(String n)
        {
            int id=0;
            String SelectQuery = "SELECT blood_id FROM stock WHERE blood_group='"+n+"'";            
            try {             
                pst = con.prepareStatement(SelectQuery);  
                
                rs = pst.executeQuery();
                if(rs.next())
                {
                    id = rs.getInt("blood_id");                    
                }
                return id; 
                               
                } catch (SQLException ex) {
                Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }            
        }
    public double getBloodQuantityById(int id)
        {
            double q = 0.0;
            String SelectQuery = "SELECT quantity FROM stock WHERE blood_id="+id;            
            try {             
                pst = con.prepareStatement(SelectQuery);                               
                rs = pst.executeQuery();
                if(rs.next())
                {
                    q = rs.getDouble("quantity");                    
                }
                return q; 
                               
                } catch (SQLException ex) {
                Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
                return q;
            }            
        }
    
    
    
    
    
    
}
