
package bloodbankmanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Donation {
    
    private int donation_id,donor_id;
    private double quantity;
    private String blood_group,donation_date;

    private static PreparedStatement pst = null;
    private static Connection con = null;    
    private DBConnector dcon = null;    
    
    
    
    public Donation()
    {
        try {          
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Donation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
    public void Insert(int donation_id,int donor_id,String blood_group,double quantity,String donation_date)
    {         
         try {    
               String InsertQuery = "INSERT INTO donation ( donation_id,donor_id, blood_group,quantity,donation_date ) VALUES(?,?,?,?,?)";
               pst = con.prepareStatement(InsertQuery);               
               pst.setInt(1, donation_id);
               pst.setInt(2, donor_id);
               pst.setString(3, blood_group);
               pst.setDouble(4, quantity);
               pst.setString(5, donation_date);                         
               pst.executeUpdate();
               System.out.println(quantity+" Litre "+blood_group+" Blood Has been Added to Stock!");                
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }            
    }
    
    public int getLastId()
    {
        String qSelect = "SELECT donation_id FROM donation ORDER BY donation_id DESC LIMIT 1";
        try {                
            pst = con.prepareStatement(qSelect); 
            ResultSet rs = pst.executeQuery();
            int lastReg=0;
            while(rs.next())
            {
                 lastReg = rs.getInt("donation_id");
            }   
            return lastReg;
            
        } catch (SQLException ex) {
            Logger.getLogger(Donation.class.getName()).log(Level.SEVERE, null, ex);
           return 0;
        }
    }
}
