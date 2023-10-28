
package UI;

import bloodbankmanagementsystem.*;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class NewDonation extends javax.swing.JFrame {
    
    private static ResultSet rs = null;
    private Donor donor = new Donor();
    private Donation donation = new Donation();
    private Stock stock = new Stock();
    
    private Searching search = new Searching("donor");

    
    public NewDonation() {
        initComponents();
        setCurrentTime();
        displayAllDonor();
        setLastId();
        
        String iconPath = "/Res/icon_blood-pressure.png";        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(iconPath))); 
    }
    
    private void setLastId()
    {        
        int lastReg = donation.getLastId();
        int newReg = lastReg+1;
        txtDonationId.setText(String.valueOf(newReg));
        txtQuantity.requestFocus();
        
    }
    
    private void displaySearchData(ResultSet rs)
    {
        try {                         
            ResultSetMetaData enData;
            enData = rs.getMetaData();
            int q = enData.getColumnCount();
            DefaultTableModel recordTable = (DefaultTableModel)tblDonor.getModel();
            recordTable.setRowCount(0);                       
                        while(rs.next())
                        {           
                        Vector columData = new Vector();
                        for(int i =1 ; i<=q ; i++)
                        {
                            columData.add(rs.getInt("d_id"));
                            columData.add(rs.getString("full_name"));
                            columData.add(rs.getInt("age"));   
                            columData.add(rs.getString("gender"));
                            columData.add(rs.getInt("phone"));   
                            columData.add(rs.getString("city"));   
                            columData.add(rs.getString("blood_group"));       

                        }
                        recordTable.addRow(columData);                           
                    }              
        } catch (SQLException ex) {
            Logger.getLogger(UpdateDonor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private void clear()
    {
        txtDonationId.setText("");
        txtDonorId.setText("");
        txtDonorName.setText("");
        txtBloodGroup.setText("");
        txtQuantity.setText("");
        txtDonationDate.setText("");
        txtSearch.setText("");
        cbSearchFilter.setSelectedIndex(0);
        displayAllDonor();
        setLastId();
    }
    
    private boolean validInput()
    {
        if( txtDonationId.getText().length()!=0  && txtDonorId.getText().length()!=0 && 
            txtDonorName.getText().length()!=0   && txtQuantity.getText().length()!=0 &&
            txtBloodGroup.getText().length()!=0  && txtDonationDate.getText().length()!=0  )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    private void setCurrentTime()
    {
        
        String o = java.time.LocalDateTime.now().toString();        
        String old = o.replace("T"," ");        
        LocalDateTime datetime = LocalDateTime.parse(old, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));        
        String newDate = datetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));      
        txtDonationDate.setText(newDate);       
        
    }
    
    private void displayAllDonor()
    {
        try {            
            rs = donor.getAllData();          
            ResultSetMetaData enData;
            enData = rs.getMetaData();            
            int q = enData.getColumnCount();
            DefaultTableModel recordTable = (DefaultTableModel)tblDonor.getModel();
            recordTable.setRowCount(0);         
            while(rs.next())
            {           
                Vector columData = new Vector();
                for(int i =1 ; i<=q ; i++)
                {
                    columData.add(rs.getInt("d_id"));
                    columData.add(rs.getString("full_name"));
                    columData.add(rs.getInt("age"));   
                    columData.add(rs.getString("gender"));
                    columData.add(rs.getInt("phone"));   
                    columData.add(rs.getString("city"));   
                    columData.add(rs.getString("blood_group"));                        
                }
                recordTable.addRow(columData);
            }              
        } catch (SQLException ex) {
            Logger.getLogger(NewDonation.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    private void displaySelectedRow()
    {
        DefaultTableModel recordTable = (DefaultTableModel)tblDonor.getModel();   
        int selectedRow = tblDonor.getSelectedRow();     
        if(selectedRow>=0)
        {
            txtDonorId.setText(recordTable.getValueAt(selectedRow,0).toString());        
            txtDonorName.setText(recordTable.getValueAt(selectedRow,1).toString());    
            txtBloodGroup.setText(recordTable.getValueAt(selectedRow,6).toString());   
            
                    
        }
        else{
            clear();
        }    
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Header = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtDonationId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDonorName = new javax.swing.JTextField();
        txtBloodGroup = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDonationDate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        txtDonorId = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        txtSearch = new javax.swing.JTextField();
        cbSearchFilter = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        TableHolder = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDonor = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        BGImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("New Donation");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setOpaque(false);
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(255, 51, 51));
        Header.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 280, 10));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("NEW DONATION");
        Header.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 40));

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1200, 50));

        body.setOpaque(false);
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Serial Number");
        body.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 110, 40));

        txtDonationId.setEditable(false);
        txtDonationId.setBackground(new java.awt.Color(255, 51, 51));
        txtDonationId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDonationId.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtDonationId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 380, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("DONOR");
        body.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 60, 40));

        txtDonorName.setEditable(false);
        txtDonorName.setBackground(new java.awt.Color(255, 51, 51));
        txtDonorName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDonorName.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtDonorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 290, 40));

        txtBloodGroup.setEditable(false);
        txtBloodGroup.setBackground(new java.awt.Color(255, 51, 51));
        txtBloodGroup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBloodGroup.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtBloodGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 80, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Quantity (L)");
        body.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 100, 40));

        txtDonationDate.setBackground(new java.awt.Color(255, 51, 51));
        txtDonationDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDonationDate.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtDonationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 380, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Donation Date");
        body.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 110, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Blood Group");
        body.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 90, 40));

        btnClose.setBackground(new java.awt.Color(255, 51, 51));
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("CLOSE");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        body.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 110, 50));

        btnSave.setBackground(new java.awt.Color(255, 51, 51));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        body.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 110, 50));

        btnReset.setBackground(new java.awt.Color(255, 51, 51));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        body.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 120, 50));

        txtDonorId.setEditable(false);
        txtDonorId.setBackground(new java.awt.Color(255, 51, 51));
        txtDonorId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDonorId.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtDonorId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 80, 40));

        txtQuantity.setBackground(new java.awt.Color(255, 51, 51));
        txtQuantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtQuantity.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 160, 40));

        txtSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });
        body.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 230, 40));

        cbSearchFilter.setBackground(new java.awt.Color(255, 51, 51));
        cbSearchFilter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbSearchFilter.setForeground(new java.awt.Color(255, 255, 255));
        cbSearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NAME", "CITY", "BLOOD GROUP" }));
        body.add(cbSearchFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 40, 120, 40));

        btnSearch.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        body.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 40, 110, 40));

        TableHolder.setBackground(new java.awt.Color(255, 255, 255));
        TableHolder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 2));
        TableHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDonor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblDonor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Age", "Gender", "Phone", "City", "Blood Group"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDonor.setRowHeight(25);
        tblDonor.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tblDonor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDonorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDonor);
        if (tblDonor.getColumnModel().getColumnCount() > 0) {
            tblDonor.getColumnModel().getColumn(0).setMinWidth(50);
            tblDonor.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblDonor.getColumnModel().getColumn(0).setMaxWidth(60);
            tblDonor.getColumnModel().getColumn(1).setMinWidth(100);
            tblDonor.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblDonor.getColumnModel().getColumn(2).setMinWidth(40);
            tblDonor.getColumnModel().getColumn(2).setPreferredWidth(40);
            tblDonor.getColumnModel().getColumn(2).setMaxWidth(40);
            tblDonor.getColumnModel().getColumn(3).setMaxWidth(70);
            tblDonor.getColumnModel().getColumn(4).setMinWidth(120);
            tblDonor.getColumnModel().getColumn(4).setPreferredWidth(120);
        }

        TableHolder.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 590, 320));

        body.add(TableHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 610, 340));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("-->");
        body.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 40, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("DONOR LIST");
        body.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 90, 120, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("SEARCH BY:");
        body.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 90, 40));

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1180, 620));

        BGImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BGImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/AddDonorBG.png"))); // NOI18N
        getContentPane().add(BGImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        Home home = new Home();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clear();
    }//GEN-LAST:event_btnResetActionPerformed

    private void tblDonorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonorMouseClicked
        displaySelectedRow();
    }//GEN-LAST:event_tblDonorMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(validInput())
        {
                int DonationId = Integer.parseInt(txtDonationId.getText());
                int DonorId = Integer.parseInt(txtDonorId.getText());
                String blood_group = txtBloodGroup.getText();
                double quantity = Double.parseDouble(txtQuantity.getText());
                String date = txtDonationDate.getText();
                int bloodID = stock.getBloodIdByName(blood_group);                
                donation.Insert(DonationId, DonorId, blood_group, quantity, date);                
                double oldQuantity = stock.getBloodQuantityById(bloodID);
                double newQuantity = oldQuantity + quantity;
                stock.updateStockById(bloodID, newQuantity);
                JOptionPane.showMessageDialog(this, "Blood Stock Updated Successfuly!");
                clear();                
            
        }
        else{
            JOptionPane.showMessageDialog(this, "Please fill all information correctly!");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
       if(cbSearchFilter.getSelectedIndex()==0)
        {
            char a = evt.getKeyChar();
            if(!Character.isDigit(a))
            {
                if(Character.isAlphabetic(a))
                {                          
                    evt.consume();
                }
                evt.consume();                 
            }
        }
    }//GEN-LAST:event_txtSearchKeyTyped

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if(cbSearchFilter.getSelectedIndex()==0)
        {
            char a = evt.getKeyChar();
            if(!Character.isDigit(a))
            {
                if(Character.isAlphabetic(a))
                {                          
                    evt.consume();
                }
                evt.consume();                 
            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if(txtSearch.getText().length()!=0)
        {
            
            int i;
            i = cbSearchFilter.getSelectedIndex();
            switch(i)   
            {
                case 1:
                    ResultSet rsName;
                    rsName = search.searchByString(txtSearch.getText(),"full_name");
                    displaySearchData(rsName);                    
                    break;
                case 0:  
                    ResultSet rsID;
                     rsID = search.searchByID(Integer.parseInt(txtSearch.getText()),"d_id");
                     displaySearchData(rsID);                    
                    break;
                case 2:
                    ResultSet rsC;
                    rsC = search.searchByString(txtSearch.getText().toString(),"city");
                    displaySearchData(rsC);                    
                    break;    
                case 3:
                     ResultSet rsBG;
                     rsBG = search.searchByStringAbs(txtSearch.getText().toString(),"blood_group");
                     displaySearchData(rsBG);                    
                    break;    
                    
                default:
                    break;
            }           
        }
        else{
            clear();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewDonation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewDonation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewDonation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewDonation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewDonation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGImage;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel TableHolder;
    private javax.swing.JPanel body;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbSearchFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblDonor;
    private javax.swing.JTextField txtBloodGroup;
    private javax.swing.JTextField txtDonationDate;
    private javax.swing.JTextField txtDonationId;
    private javax.swing.JTextField txtDonorId;
    private javax.swing.JTextField txtDonorName;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
