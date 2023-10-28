
package bloodbankmanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HandOver {
    
    private int handover_id,patient_id;
    private double quantity;
    private String blood_group,handover_date;

    private static PreparedStatement pst = null;
    private static Connection con = null;    
    private DBConnector dcon = null;    
    
    
    
    public HandOver()
    {
        try {  
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(HandOver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void Insert(int handover_id,int patient_id,String blood_group,double quantity,String handover_date)
    {         
         try {   
                String InsertQuery = "INSERT INTO hand_over ( handover_id,patient_id, blood_group,quantity,handover_date ) VALUES(?,?,?,?,?)";
               pst = con.prepareStatement(InsertQuery);               
               pst.setInt(1, handover_id);
               pst.setInt(2, patient_id);
               pst.setString(3, blood_group);
               pst.setDouble(4, quantity);
               pst.setString(5, handover_date);                         
               pst.executeUpdate();
               System.out.println(quantity+" Litre "+blood_group+" Blood Has been Given to The Patient (ID:"+patient_id+")");                
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }            
    }
    public int getLastId()
    {
        String qSelect = "SELECT handover_id FROM hand_over ORDER BY handover_id DESC LIMIT 1";
        try {                
            pst = con.prepareStatement(qSelect); 
            ResultSet rs = pst.executeQuery();
            int lastId=0;
            while(rs.next())
            {
                 lastId = rs.getInt("handover_id");
            }   
            return lastId;
            
        } catch (SQLException ex) {
            Logger.getLogger(HandOver.class.getName()).log(Level.SEVERE, null, ex);
           return 0;
        }
    }
    
}
