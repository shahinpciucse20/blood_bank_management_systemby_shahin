
package UI;

import bloodbankmanagementsystem.*;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class UpdatePatient extends javax.swing.JFrame {

    private Patient patient = new Patient();
    private static ResultSet rs = null;
    
    private Searching search = new Searching("patient");
    
    
    public UpdatePatient() {
        initComponents();
        displayAllPatient();
        
        String iconPath = "/Res/icon_blood-pressure.png";        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(iconPath))); 
    }
    
    private boolean validInput()
    {
        if( txtPatientId.getText().length()!=0 && txtPatientName.getText().length()!=0  && 
            txtAge.getText().length()!=0     && txtPhone.getText().length()!=0      &&
            txtGender.getText().length()!=0  && txtCity.getText().length()!=0       &&
            txtBloodGroup.getText().length()!=0 )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private void clear()
    {
            txtPatientId.setText("");        
            txtPatientName.setText("");       
            txtAge.setText("");       
            txtGender.setText("");       
            txtPhone.setText("");       
            txtCity.setText("");       
            txtBloodGroup.setText("");       
            txtSearch.setText("");       
            cbSearchFilter.setSelectedIndex(0);
            txtDisease.setText("");
            displayAllPatient();            
            txtPhoneWarning.setText("");
            
    }
    
    private void displaySelectedRow()
    {
        DefaultTableModel recordTable = (DefaultTableModel)tblPatient.getModel();   
        int selectedRow = tblPatient.getSelectedRow();     
        if(selectedRow>=0)
        {
            txtPatientId.setText(recordTable.getValueAt(selectedRow,0).toString());        
            txtPatientName.setText(recordTable.getValueAt(selectedRow,1).toString()); 
            txtAge.setText(recordTable.getValueAt(selectedRow,2).toString()); 
            txtGender.setText(recordTable.getValueAt(selectedRow,3).toString()); 
            txtPhone.setText("0"+recordTable.getValueAt(selectedRow,4).toString()); 
            txtCity.setText(recordTable.getValueAt(selectedRow,5).toString());             
            txtBloodGroup.setText(recordTable.getValueAt(selectedRow,6).toString());   
            txtDisease.setText(recordTable.getValueAt(selectedRow,7).toString());   
            
            txtPhoneWarning.setText("");          
        }
        else{
            clear();
        }    
    }
    
    private void showPhoneWarning(String num)
    {
        if(num.length()!=11)
        {
            txtPhoneWarning.setText("Invalid Number!");
        }
        if(num.length()==11)
        {
            txtPhoneWarning.setText("");
        }
        if(num.length()==0)
        {
            txtPhoneWarning.setText("Can not Empty!");
        }
            
    }
    
    private void displayAllPatient()
    {
        try {            
            rs = patient.getAllData();          
            ResultSetMetaData enData;
            enData = rs.getMetaData();            
            int q = enData.getColumnCount();
            DefaultTableModel recordTable = (DefaultTableModel)tblPatient.getModel();
            recordTable.setRowCount(0);         
            while(rs.next())
            {           
                Vector columData = new Vector();
                for(int i =1 ; i<=q ; i++)
                {
                    columData.add(rs.getInt("p_id"));
                    columData.add(rs.getString("name"));
                    columData.add(rs.getInt("age"));   
                    columData.add(rs.getString("gender"));
                    columData.add(rs.getInt("phone"));   
                    columData.add(rs.getString("city"));   
                    columData.add(rs.getString("blood_group"));  
                    columData.add(rs.getString("disease"));        
                    
                }
                recordTable.addRow(columData);
            }  
            
        } catch (SQLException ex) {
            Logger.getLogger(UpdatePatient.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    private void displaySearchData(ResultSet rs)
    {
        try {                         
            ResultSetMetaData enData;
            enData = rs.getMetaData();
            int q = enData.getColumnCount();
            DefaultTableModel recordTable = (DefaultTableModel)tblPatient.getModel();
            recordTable.setRowCount(0);                       
                        while(rs.next())
                        {           
                        Vector columData = new Vector();
                        for(int i =1 ; i<=q ; i++)
                        {
                            columData.add(rs.getInt("p_id"));
                            columData.add(rs.getString("name"));
                            columData.add(rs.getInt("age"));   
                            columData.add(rs.getString("gender"));
                            columData.add(rs.getInt("phone"));   
                            columData.add(rs.getString("city"));   
                            columData.add(rs.getString("blood_group"));  
                            columData.add(rs.getString("disease"));        

                        }
                        recordTable.addRow(columData);                           
                    }              
        } catch (SQLException ex) {
            Logger.getLogger(UpdatePatient.class.getName()).log(Level.SEVERE, null, ex);
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
        txtPatientName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        cbSearchFilter = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPatient = new javax.swing.JTable();
        txtPatientId = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        txtGender = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtBloodGroup = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPhoneWarning = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtDisease = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        BGImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Update Patient");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setOpaque(false);
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(255, 51, 51));
        Header.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 260, 10));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("UPDATE PATIENT");
        Header.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 40));

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1200, 60));

        body.setOpaque(false);
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("ID");
        body.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 60, 40));

        txtSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });
        body.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 350, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Name");
        body.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 60, 40));

        txtPatientName.setBackground(new java.awt.Color(255, 51, 51));
        txtPatientName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPatientName.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtPatientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 370, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Age");
        body.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 50, 40));

        txtAge.setBackground(new java.awt.Color(255, 51, 51));
        txtAge.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAge.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 100, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Phone");
        body.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 70, 40));

        txtPhone.setBackground(new java.awt.Color(255, 51, 51));
        txtPhone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(255, 255, 255));
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneKeyTyped(evt);
            }
        });
        body.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 370, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Gender");
        body.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 60, 40));

        btnClose.setBackground(new java.awt.Color(255, 51, 51));
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("CLOSE");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        body.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 110, 50));

        cbSearchFilter.setBackground(new java.awt.Color(255, 51, 51));
        cbSearchFilter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbSearchFilter.setForeground(new java.awt.Color(255, 255, 255));
        cbSearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NAME", "CITY", "BLOOD GROUP", "DISEASE" }));
        body.add(cbSearchFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 120, 40));

        btnSearch.setBackground(new java.awt.Color(255, 51, 51));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        body.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 10, 110, 40));

        btnRemove.setBackground(new java.awt.Color(255, 51, 51));
        btnRemove.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("X   REMOVE PATIENT");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        body.add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 370, 50));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 2));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPatient.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblPatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Age", "Gender", "Phone", "City", "Blood Group", "Disease"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPatient.setRowHeight(25);
        tblPatient.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tblPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPatientMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPatient);
        if (tblPatient.getColumnModel().getColumnCount() > 0) {
            tblPatient.getColumnModel().getColumn(0).setMinWidth(40);
            tblPatient.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblPatient.getColumnModel().getColumn(1).setMinWidth(130);
            tblPatient.getColumnModel().getColumn(1).setPreferredWidth(130);
        }

        jPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 690, 400));

        body.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 710, 420));

        txtPatientId.setEditable(false);
        txtPatientId.setBackground(new java.awt.Color(255, 51, 51));
        txtPatientId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPatientId.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtPatientId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 370, 40));

        btnUpdate.setBackground(new java.awt.Color(255, 51, 51));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        body.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 370, 110, 50));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Blood Group");
        body.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 100, 40));

        btnReset.setBackground(new java.awt.Color(255, 51, 51));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        body.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 100, 50));

        txtGender.setEditable(false);
        txtGender.setBackground(new java.awt.Color(255, 51, 51));
        txtGender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtGender.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 150, 40));

        txtCity.setBackground(new java.awt.Color(255, 51, 51));
        txtCity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCity.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 150, 40));

        txtBloodGroup.setEditable(false);
        txtBloodGroup.setBackground(new java.awt.Color(255, 51, 51));
        txtBloodGroup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBloodGroup.setForeground(new java.awt.Color(255, 255, 255));
        txtBloodGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBloodGroupActionPerformed(evt);
            }
        });
        body.add(txtBloodGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 80, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("City");
        body.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 40, 40));

        txtPhoneWarning.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPhoneWarning.setForeground(new java.awt.Color(255, 51, 51));
        txtPhoneWarning.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        body.add(txtPhoneWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 220, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Disease");
        body.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 60, 40));

        txtDisease.setBackground(new java.awt.Color(255, 51, 51));
        txtDisease.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDisease.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtDisease, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 370, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("SEARCH BY:");
        body.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 90, 40));

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

    private void txtBloodGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBloodGroupActionPerformed
        
    }//GEN-LAST:event_txtBloodGroupActionPerformed

    private void txtPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyReleased
        char a = evt.getKeyChar();
        if(!Character.isDigit(a))
        {
            if(Character.isAlphabetic(a))
            {                          
                evt.consume();
            }
            evt.consume();                 
        }
        showPhoneWarning(txtPhone.getText());
    }//GEN-LAST:event_txtPhoneKeyReleased

    private void txtPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyTyped
        char a = evt.getKeyChar();
        if(!Character.isDigit(a))
        {
            if(Character.isAlphabetic(a))
            {                          
                evt.consume();
            }
            evt.consume();                 
        }
        showPhoneWarning(txtPhone.getText());
    }//GEN-LAST:event_txtPhoneKeyTyped

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clear();
    }//GEN-LAST:event_btnResetActionPerformed

    private void tblPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPatientMouseClicked
        displaySelectedRow();
    }//GEN-LAST:event_tblPatientMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(validInput())    
        {
            int AGE =Integer.parseInt(txtAge.getText());
            if(txtPhone.getText().length()==11 && AGE>=18)
            {
                int id = Integer.parseInt(txtPatientId.getText());
                String name = txtPatientName.getText();
                int age = Integer.parseInt(txtAge.getText());
                int phone = Integer.parseInt(txtPhone.getText());
                String city = txtCity.getText();  
                String disease = txtDisease.getText();
                patient.updateDataById(id, name, age, phone, city,disease);
                JOptionPane.showMessageDialog(this, "Patient Data Successfully Updated!");
                clear();
            }
            else if(txtPhone.getText().length()!=11){
                JOptionPane.showMessageDialog(this, "Invalid Phone Number!");
            }
            
   
        }
        else{
            JOptionPane.showMessageDialog(this, "Please fill all information correctly!");
        } 
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        if(validInput())
        {           
            
            int deleteItem = JOptionPane.showConfirmDialog(null,"Do You Want to Remove?", "WARNING!",JOptionPane.YES_NO_OPTION );
            if(deleteItem == JOptionPane.YES_OPTION)
            {
                int id = Integer.parseInt(txtPatientId.getText());
                patient.Delete(id);
                JOptionPane.showMessageDialog(this, "Patient Successfuly Removed!");
                clear();
            }
            {
                clear();
            }
            
        }
        else{
            JOptionPane.showMessageDialog(this, "Please Select Atleast One Record to Remove!");
        } 
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
      if(txtSearch.getText().length()!=0)
        {
            
            int i;
            i = cbSearchFilter.getSelectedIndex();
            switch(i)   
            {
                case 1:
                    ResultSet rsName;
                    rsName = search.searchByString(txtSearch.getText(),"name");
                    displaySearchData(rsName);                    
                    break;
                case 0:  
                    ResultSet rsID;
                     rsID = search.searchByID(Integer.parseInt(txtSearch.getText()),"p_id");
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
                    
                case 4:
                    ResultSet rsDis;
                    rsDis = search.searchByString(txtSearch.getText().toString(),"disease");
                    displaySearchData(rsDis);                    
                    break;      
                    
                    
                default:
                    break;
            }
           
        }
        else{
            clear();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(UpdatePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdatePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdatePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdatePatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdatePatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGImage;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel body;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbSearchFilter;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblPatient;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtBloodGroup;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtDisease;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtPatientId;
    private javax.swing.JTextField txtPatientName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JLabel txtPhoneWarning;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
