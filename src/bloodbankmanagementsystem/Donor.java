
package bloodbankmanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Donor {
    private int d_id,age,phone;
    private String full_name,gender,city,blood_group;    
    
    private static PreparedStatement pst = null;
    private static Connection con = null;    
    private static ResultSet rs = null;
    
    
    String InsertQuery = "INSERT INTO donor (d_id, full_name, age,gender,phone,city,blood_group ) VALUES(?,?,?,?,?,?,?)";
    
    public Donor()
    {
        try {          
            con = DBConnector.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Donor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void Insert(int d_id,String full_name, int age, String gender, int phone, String city, String blood_group)
    {         
         try {
               String QueryInsert = "INSERT INTO donor (d_id, full_name, age,gender,phone,city,blood_group ) VALUES(?,?,?,?,?,?,?)";
                                          
               pst = con.prepareStatement(InsertQuery);               
               pst.setInt(1, d_id);
               pst.setString(2, full_name);
               pst.setInt(3, age);
               pst.setString(4, gender);
               pst.setInt(5, phone);  
               pst.setString(6, city);   
               pst.setString(7, blood_group);             
               pst.executeUpdate();
               System.out.println("Donor: "+ full_name +" Has Been Added!");                
        } catch (SQLException ex) {
            Logger.getLogger(Donor.class.getName()).log(Level.SEVERE, null, ex);
        }            
    }
    public void Delete(int id)
    {
        try {
            String DeleteQuery = "DELETE FROM donor WHERE d_id="+id;         
            pst = con.prepareStatement(DeleteQuery); 
            pst.executeUpdate();      
            System.out.println("Donor Has Been Deleted!"); 
        } catch (SQLException ex) {
            Logger.getLogger(Donor.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    
    public String bloodGroupByID(int id)
    {
            
        try {               
            String blood_group;
            String qSelectBGroup = "SELECT blood_group FROM donor WHERE d_id ="+id;
            pst = con.prepareStatement(qSelectBGroup); 
            ResultSet rs = pst.executeQuery(); 
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
    
    
    public void updateDataById(int d_id,String name, int age, int phone, String city)
        {
            String UpdateQuery = "UPDATE donor SET full_name = ?, age = ?,phone = ?, city=?  WHERE d_id ="+d_id;
            try {             
                pst = con.prepareStatement(UpdateQuery);                
                pst.setString(1,name);
                pst.setInt(2,age);
                pst.setInt(3,phone);
                pst.setString(4,city);       
                pst.executeUpdate();    
                System.out.println("Donor Data Has Been Updated!");
                } catch (SQLException ex) {
                Logger.getLogger(Donor.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    
    public int getLastId()
    {
        String qSelect = "SELECT d_id FROM donor ORDER BY d_id DESC LIMIT 1";
        try {                
            pst = con.prepareStatement(qSelect); 
            ResultSet rs = pst.executeQuery();
            int lastReg=0;
            while(rs.next())
            {
                 lastReg = rs.getInt("d_id");
            }   
            return lastReg;
            
        } catch (SQLException ex) {
            Logger.getLogger(Donor.class.getName()).log(Level.SEVERE, null, ex);
           return 0;
        }
    }
    
    public ResultSet getAllData()
        {
            String SelectQuery = "SELECT * FROM donor";            
            try {             
                pst = con.prepareStatement(SelectQuery);                               
                rs = pst.executeQuery();
                return rs;                
                } catch (SQLException ex) {
                Logger.getLogger(Donor.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }            
        }
    
    
 
}
