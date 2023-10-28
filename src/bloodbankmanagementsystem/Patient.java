
package bloodbankmanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Patient {
    private int p_id,age,phone;
    private String name,gender,city,blood_group,disease;

    private static PreparedStatement pst = null;
    private static Connection con = null;    
    private DBConnector dcon = null;   
    private static ResultSet rs = null;
    
    
    
    public Patient()
    {
        try { 
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void Insert(int p_id,String name, int age, String gender, int phone, String city, String blood_group,String disease)
    {         
         try {
               String QueryInsert = "INSERT INTO patient (p_id, name, age,gender,phone,city,blood_group,disease ) VALUES(?,?,?,?,?,?,?,?)";                         
               pst = con.prepareStatement(QueryInsert);               
               pst.setInt(1, p_id);
               pst.setString(2, name);
               pst.setInt(3, age);
               pst.setString(4, gender);
               pst.setInt(5, phone);  
               pst.setString(6, city);   
               pst.setString(7, blood_group);    
               pst.setString(8, disease);  
               pst.executeUpdate();
               System.out.println("Patient: "+ name +" Has Been Added!");                
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }            
    }
    public void Delete(int id)
    {
        try {
            String DeleteQuery = "DELETE FROM patient WHERE p_id="+id;
            DBConnector dc = new DBConnector();
            con = dc.getConnection();             
            pst = con.prepareStatement(DeleteQuery); 
            pst.executeUpdate();      
            System.out.println("Patient Has Been Deleted!"); 
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public void updateDataById(int p_id,String name, int age, int phone, String city,String disease)
        {
            String UpdateQuery = "UPDATE patient SET name = ?, age = ?,phone = ?, city=?, disease=? WHERE p_id ="+p_id;
            try {             
                pst = con.prepareStatement(UpdateQuery);                
                pst.setString(1,name);
                pst.setInt(2,age);
                pst.setInt(3,phone);
                pst.setString(4,city);
                pst.setString(5,disease);                
                pst.executeUpdate();    
                System.out.println("Donor Data Has Been Updated!");
                } catch (SQLException ex) {
                Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    
    public String bloodGroupByID(int id)
    {
            
        try {            
            DBConnector dc = new DBConnector();
            con = dc.getConnection();       
            String blood_group;
            String qSelectBGroup = "SELECT blood_group FROM patient WHERE p_id ="+id;
            pst = con.prepareStatement(qSelectBGroup); 
            rs = pst.executeQuery(); 
            if(rs.next())
            {
                blood_group = rs.getString("blood_group");
                return blood_group;
            }
            else{
                return null;
            }    
        } catch (SQLException ex) {
            Logger.getLogger(Donor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }                   
      
    }  
    
    public int getLastId()
    {
        String qSelect = "SELECT p_id FROM patient ORDER BY p_id DESC LIMIT 1";
        try {                
            pst = con.prepareStatement(qSelect); 
            rs = pst.executeQuery();
            int lastReg=0;
            while(rs.next())
            {
                 lastReg = rs.getInt("p_id");
            }   
            return lastReg;            
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
           return 0;
        }
    }
        
    public ResultSet getAllData()
        {
            String SelectQuery = "SELECT * FROM patient";            
            try {             
                pst = con.prepareStatement(SelectQuery);                               
                rs = pst.executeQuery();
                return rs;                
                } catch (SQLException ex) {
                Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }            
        }
    }