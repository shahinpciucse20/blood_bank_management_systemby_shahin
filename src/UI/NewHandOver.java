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


public class NewHandOver extends javax.swing.JFrame {
    
    private static ResultSet rs = null;
    private Donor donor = new Donor();
    private HandOver handOver = new HandOver();
    
    private Stock stock = new Stock();
    private Patient patient = new Patient();
    
    private Searching search = new Searching("patient");

    
    public NewHandOver() {
        initComponents();
        displayAllPatient();
        displayAllStockData();
        setCurrentTime();
        setLastId();
        
        String iconPath = "/Res/icon_blood-pressure.png";        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(iconPath))); 
    }
    
    private void setCurrentTime()
    {
        
        String o = java.time.LocalDateTime.now().toString();        
        String old = o.replace("T"," ");        
        LocalDateTime datetime = LocalDateTime.parse(old, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));        
        String newDate = datetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));      
        txtDate.setText(newDate);       
        
    }
    private boolean checkBloodStockById(int id)
    {
        double old = stock.getBloodQuantityById(id);
        if(old>0)
        {
            return true;
        }
        else{
            return false;
        }
    }
    
    private boolean validInput()
    {
        if( txtHandOverId.getText().length()!=0  && txtPatientId.getText().length()!=0 && 
            txtPatientName.getText().length()!=0 && txtQuantity.getText().length()!=0 &&
            txtBloodGroup.getText().length()!=0  && txtDate.getText().length()!=0  )
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
        txtHandOverId.setText("");
        txtPatientId.setText("");
        txtPatientName.setText("");
        txtBloodGroup.setText("");
        txtQuantity.setText("");        
        txtSearch.setText("");
        cbSearchFilter.setSelectedIndex(0);
        txtStockWarning.setText("");
        displayAllPatient();
        displayAllStockData();        
        setLastId();
        txtQuantity.enable();
    }
    private void setLastId()
    {        
        int lastReg = handOver.getLastId();
        int newReg = lastReg+1;
        txtHandOverId.setText(String.valueOf(newReg));
        txtQuantity.requestFocus();
        
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
            Logger.getLogger(NewHandOver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void displaySelectedRow()
    {
        DefaultTableModel recordTable = (DefaultTableModel)tblPatient.getModel();   
        int selectedRow = tblPatient.getSelectedRow();     
        if(selectedRow>=0)
        {
            txtPatientId.setText(recordTable.getValueAt(selectedRow,0).toString());        
            txtPatientName.setText(recordTable.getValueAt(selectedRow,1).toString());    
            txtBloodGroup.setText(recordTable.getValueAt(selectedRow,6).toString());             
        }
        else{
            clear();
        }    
    }
    
    private void displayAllStockData()
    {
        try {            
            rs = stock.getAllData();          
            ResultSetMetaData enData;
            enData = rs.getMetaData();            
            int q = enData.getColumnCount();
            DefaultTableModel recordTable = (DefaultTableModel)tblStock.getModel();
            recordTable.setRowCount(0);         
            while(rs.next())
            {           
                Vector columData = new Vector();
                for(int i =1 ; i<=q ; i++)
                {
                    columData.add(rs.getInt("blood_id"));
                    columData.add(rs.getString("blood_group"));
                    columData.add(rs.getDouble("quantity"));                                 
                       
                }
                recordTable.addRow(columData);
            } 
            
            
        } catch (SQLException ex) {
            Logger.getLogger(NewHandOver.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(NewHandOver.class.getName()).log(Level.SEVERE, null, ex);
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
        txtHandOverId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPatientName = new javax.swing.JTextField();
        txtBloodGroup = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        txtPatientId = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        txtSearch = new javax.swing.JTextField();
        cbSearchFilter = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        TableHolder = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPatient = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        TableHolder1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        txtStockWarning = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        BGImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("New Handover");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setOpaque(false);
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(255, 51, 51));
        Header.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 280, 10));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("NEW HANDOVER");
        Header.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 40));

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1200, 50));

        body.setOpaque(false);
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Serial Number");
        body.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 110, 40));

        txtHandOverId.setEditable(false);
        txtHandOverId.setBackground(new java.awt.Color(255, 51, 51));
        txtHandOverId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtHandOverId.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtHandOverId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 350, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Patient");
        body.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 80, 40));

        txtPatientName.setEditable(false);
        txtPatientName.setBackground(new java.awt.Color(255, 51, 51));
        txtPatientName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPatientName.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtPatientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 250, 40));

        txtBloodGroup.setEditable(false);
        txtBloodGroup.setBackground(new java.awt.Color(255, 51, 51));
        txtBloodGroup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtBloodGroup.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtBloodGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 90, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("PATIENT LIST");
        body.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 120, 30));

        txtDate.setBackground(new java.awt.Color(255, 51, 51));
        txtDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDate.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 350, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Recieve Date");
        body.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 110, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Blood Group");
        body.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 90, 40));

        btnClose.setBackground(new java.awt.Color(255, 51, 51));
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("CLOSE");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        body.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 120, 50));

        btnSave.setBackground(new java.awt.Color(255, 51, 51));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        body.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 100, 50));

        btnReset.setBackground(new java.awt.Color(255, 51, 51));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        body.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 110, 50));

        txtPatientId.setEditable(false);
        txtPatientId.setBackground(new java.awt.Color(255, 51, 51));
        txtPatientId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPatientId.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtPatientId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 90, 40));

        txtQuantity.setBackground(new java.awt.Color(255, 51, 51));
        txtQuantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtQuantity.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 140, 40));

        txtSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });
        body.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 280, 40));

        cbSearchFilter.setBackground(new java.awt.Color(255, 51, 51));
        cbSearchFilter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbSearchFilter.setForeground(new java.awt.Color(255, 255, 255));
        cbSearchFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "NAME", "CITY", "BLOOD GROUP", "DISEASE" }));
        body.add(cbSearchFilter, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 120, 40));

        jButton5.setBackground(new java.awt.Color(255, 51, 51));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        body.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 10, 110, 40));

        TableHolder.setBackground(new java.awt.Color(255, 255, 255));
        TableHolder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 2));
        TableHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            tblPatient.getColumnModel().getColumn(0).setMinWidth(30);
            tblPatient.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblPatient.getColumnModel().getColumn(1).setMinWidth(120);
            tblPatient.getColumnModel().getColumn(1).setPreferredWidth(150);
        }

        TableHolder.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 630, 490));

        body.add(TableHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 650, 510));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Quantity (L)");
        body.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 90, 40));

        TableHolder1.setBackground(new java.awt.Color(255, 255, 255));
        TableHolder1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 2));
        TableHolder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblStock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Blood ID", "Blood Group", "Quantity (Litre)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStock.setRowHeight(27);
        tblStock.setSelectionBackground(new java.awt.Color(255, 51, 51));
        jScrollPane3.setViewportView(tblStock);

        TableHolder1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 450, 250));

        body.add(TableHolder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 470, 270));

        txtStockWarning.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtStockWarning.setForeground(new java.awt.Color(255, 51, 51));
        txtStockWarning.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        body.add(txtStockWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 190, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("SEARCH BY:");
        body.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 90, 40));

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

    private void tblPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPatientMouseClicked
                displaySelectedRow();
            
                String blood_group = txtBloodGroup.getText();                             
                int bloodID = stock.getBloodIdByName(blood_group);                
                if(!checkBloodStockById(bloodID))
                {
                    txtStockWarning.setText(blood_group+" BLOOD STOCK OUT!!");
                    txtQuantity.disable();
                }
                else{
                    txtStockWarning.setText("");
                    txtQuantity.enable();
                }
                
            
            
    }//GEN-LAST:event_tblPatientMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(validInput())
        {
                int handOverId = Integer.parseInt(txtHandOverId.getText());
                int patientId = Integer.parseInt(txtPatientId.getText());
                String blood_group = txtBloodGroup.getText();
                double quantity = Double.parseDouble(txtQuantity.getText());
                String date = txtDate.getText();
                
                int bloodID = stock.getBloodIdByName(blood_group); 
                
                if(!checkBloodStockById(bloodID))
                {
                    JOptionPane.showMessageDialog(this, blood_group+" BLOOD STOCK OUT!!");
                    clear();                    
                }            

                double oldQuantity = stock.getBloodQuantityById(bloodID);
                if(oldQuantity < quantity)
                {
                    JOptionPane.showMessageDialog(this, blood_group+" BLOOD STOCK EXCEED!!\n"+"MAXIMUM HANDOVER "+oldQuantity+" Litre!");                    
                }
                else{
                    handOver.Insert(handOverId, patientId, blood_group, quantity, date); 
                
                    double newQuantity = oldQuantity - quantity;
                    stock.updateStockById(bloodID, newQuantity);

                    JOptionPane.showMessageDialog(this, "Blood Stock Updated Successfuly!");
                    clear(); 
                }                               
            
        }
        else if(txtQuantity.getText().length()==0)
        {
            JOptionPane.showMessageDialog(this, "Please Enter Blood Quantity correctly!");
        }
        
        else{
            JOptionPane.showMessageDialog(this, "Please fill all information correctly!");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
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
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(NewHandOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewHandOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewHandOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewHandOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewHandOver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGImage;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel TableHolder;
    private javax.swing.JPanel TableHolder1;
    private javax.swing.JPanel body;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbSearchFilter;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblPatient;
    private javax.swing.JTable tblStock;
    private javax.swing.JTextField txtBloodGroup;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtHandOverId;
    private javax.swing.JTextField txtPatientId;
    private javax.swing.JTextField txtPatientName;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JLabel txtStockWarning;
    // End of variables declaration//GEN-END:variables
}
