
package UI;

import bloodbankmanagementsystem.*;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class FindDonor extends javax.swing.JFrame {

    private static ResultSet rs = null;
    private Donor donor = new Donor();
    private Searching search = new Searching("donor");
    
    public FindDonor() {
        initComponents();
        displayAllDonor();
        String iconPath = "/Res/icon_blood-pressure.png";        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(iconPath))); 
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
            Logger.getLogger(ViewStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
            Logger.getLogger(FindDonor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void clear()
    {
            txtDonorId.setText("");        
            txtDonorName.setText("");       
            txtAge.setText("");       
            txtGender.setText("");       
            txtPhone.setText("");       
            txtCity.setText("");       
            txtBloodGroup.setText("");       
            txtSearch.setText("");       
            cbSearchFilter.setSelectedIndex(0);
            displayAllDonor();
            
    }
    
    private void displaySelectedRow()
    {
        DefaultTableModel recordTable = (DefaultTableModel)tblDonor.getModel();   
        int selectedRow = tblDonor.getSelectedRow();     
        if(selectedRow>=0)
        {
            txtDonorId.setText(recordTable.getValueAt(selectedRow,0).toString());        
            txtDonorName.setText(recordTable.getValueAt(selectedRow,1).toString()); 
            txtAge.setText(recordTable.getValueAt(selectedRow,2).toString()); 
            txtGender.setText(recordTable.getValueAt(selectedRow,3).toString()); 
            txtPhone.setText("0"+recordTable.getValueAt(selectedRow,4).toString()); 
            txtCity.setText(recordTable.getValueAt(selectedRow,5).toString());             
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
        txtSearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDonorName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtGender = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtBloodGroup = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        cbSearchFilter = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        TableHolder = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDonor = new javax.swing.JTable();
        txtDonorId = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        txtPhone = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        BGImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FIND DONOR");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setOpaque(false);
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(255, 51, 51));
        Header.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 260, 10));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("FIND DONOR");
        Header.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 40));

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1200, 60));

        body.setOpaque(false);
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("ID");
        body.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 60, 40));

        txtSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });
        body.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 490, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Full Name");
        body.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 70, 40));

        txtDonorName.setEditable(false);
        txtDonorName.setBackground(new java.awt.Color(255, 51, 51));
        txtDonorName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDonorName.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtDonorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 410, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Age");
        body.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 50, 40));

        txtGender.setEditable(false);
        txtGender.setBackground(new java.awt.Color(255, 51, 51));
        txtGender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtGender.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 150, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Phone");
        body.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 60, 60));

        txtBloodGroup.setEditable(false);
        txtBloodGroup.setBackground(new java.awt.Color(255, 51, 51));
        txtBloodGroup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBloodGroup.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtBloodGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 110, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("City");
        body.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 40, 40));

        btnClose.setBackground(new java.awt.Color(255, 51, 51));
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("CLOSE");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        body.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 130, 50));

        cbSearchFilter.setBackground(new java.awt.Color(255, 51, 51));
        cbSearchFilter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbSearchFilter.setForeground(new java.awt.Color(255, 255, 255));
        cbSearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NAME", "CITY", "BLOOD GROUP" }));
        body.add(cbSearchFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 120, 40));

        btnSearch.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        body.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 110, 40));

        TableHolder.setBackground(new java.awt.Color(255, 255, 255));
        TableHolder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 2));
        TableHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDonor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        tblDonor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblDonorKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblDonor);
        if (tblDonor.getColumnModel().getColumnCount() > 0) {
            tblDonor.getColumnModel().getColumn(0).setMinWidth(50);
            tblDonor.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblDonor.getColumnModel().getColumn(0).setMaxWidth(60);
            tblDonor.getColumnModel().getColumn(1).setMinWidth(150);
            tblDonor.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblDonor.getColumnModel().getColumn(2).setPreferredWidth(40);
            tblDonor.getColumnModel().getColumn(2).setMaxWidth(40);
            tblDonor.getColumnModel().getColumn(4).setMinWidth(120);
            tblDonor.getColumnModel().getColumn(4).setPreferredWidth(120);
            tblDonor.getColumnModel().getColumn(6).setMinWidth(90);
            tblDonor.getColumnModel().getColumn(6).setPreferredWidth(90);
            tblDonor.getColumnModel().getColumn(6).setMaxWidth(150);
        }

        TableHolder.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 610, 400));

        body.add(TableHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 630, 420));

        txtDonorId.setEditable(false);
        txtDonorId.setBackground(new java.awt.Color(255, 51, 51));
        txtDonorId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDonorId.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtDonorId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 410, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Blood Group");
        body.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 100, 40));

        btnReset.setBackground(new java.awt.Color(255, 51, 51));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        body.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 140, 50));

        txtPhone.setEditable(false);
        txtPhone.setBackground(new java.awt.Color(255, 51, 51));
        txtPhone.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 410, 60));

        txtCity.setEditable(false);
        txtCity.setBackground(new java.awt.Color(255, 51, 51));
        txtCity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCity.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 170, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Gender");
        body.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 60, 40));

        txtAge.setEditable(false);
        txtAge.setBackground(new java.awt.Color(255, 51, 51));
        txtAge.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAge.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 80, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("SEARCH BY:");
        body.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 110, 40));

        btnPrint.setBackground(new java.awt.Color(255, 51, 51));
        btnPrint.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setText("PRINT");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        body.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, 130, 40));

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

    private void tblDonorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblDonorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDonorKeyPressed

    private void tblDonorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonorMouseClicked
        displaySelectedRow();
    }//GEN-LAST:event_tblDonorMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clear();
    }//GEN-LAST:event_btnResetActionPerformed

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

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        String o = java.time.LocalDateTime.now().toString();
        String old = o.replace("T"," ");
        LocalDateTime datetime = LocalDateTime.parse(old, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        String newDate = datetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        MessageFormat header = new MessageFormat("DONOR LIST - "+newDate);        
        MessageFormat footer = new MessageFormat("BLOOD BANK MANAGEMENT SYSTEM - DEVELOPED BY SHAMIM MD JONY");
        try {
            tblDonor.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(ViewPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrintActionPerformed

   
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
            java.util.logging.Logger.getLogger(FindDonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FindDonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FindDonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FindDonor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FindDonor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGImage;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel TableHolder;
    private javax.swing.JPanel body;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbSearchFilter;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblDonor;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtBloodGroup;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtDonorId;
    private javax.swing.JTextField txtDonorName;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
