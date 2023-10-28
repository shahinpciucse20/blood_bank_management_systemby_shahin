
package UI;

import bloodbankmanagementsystem.*;
import java.awt.Toolkit;
import javax.swing.JOptionPane;


public class AddPatient extends javax.swing.JFrame {

    private Patient patient = new Patient();
    
    public AddPatient() {
        initComponents();
        setLastId();
        String iconPath = "/Res/icon_blood-pressure.png";        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(iconPath))); 
    }
    
    private boolean validInput()
    {
        if( txtId.getText().length()!=0 && txtFullName.getText().length()!=0 && 
            txtAge.getText().length()!=0   && txtPhone.getText().length()!=0 &&
            txtDisease.getText().length()!=0 &&
            cbCity.getSelectedIndex()>=0    && cbBloodGroup.getSelectedIndex() >= 0 
            && ( rbMale.isSelected() || rbFemale.isSelected() ) )
        {
            return true;
        }
        else{
                return false;
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
    private void clear()
    {
        txtId.setText("");
        txtFullName.setText("");
        txtAge.setText("");
        txtPhone.setText("");
        txtDisease.setText("");
        cbCity.setSelectedIndex(-1);
        rbGroupMaleFemale.clearSelection();
        cbBloodGroup.setSelectedIndex(-1);
        setLastId();
        
    }
    private void setLastId()
    {        
        int lastReg = patient.getLastId();
        int newReg = lastReg+1;
        txtId.setText(String.valueOf(newReg));
        txtFullName.requestFocus();
    }


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbGroupMaleFemale = new javax.swing.ButtonGroup();
        Header = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        cbCity = new javax.swing.JComboBox<>();
        cbBloodGroup = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        Gender = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        rbFemale = new javax.swing.JRadioButton();
        rbMale = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        txtDisease = new javax.swing.JTextField();
        txtPhoneWarning = new javax.swing.JLabel();
        BGImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Patient");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setOpaque(false);
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(255, 51, 51));
        Header.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 250, 10));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ADD PATIENT");
        Header.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 40));

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1200, 50));

        body.setOpaque(false);
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("ID");
        body.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 120, 40));

        txtId.setEditable(false);
        txtId.setBackground(new java.awt.Color(255, 51, 51));
        txtId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtId.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 460, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Full Name");
        body.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 120, 40));

        txtFullName.setBackground(new java.awt.Color(255, 51, 51));
        txtFullName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtFullName.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 460, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Age");
        body.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 120, 40));

        txtAge.setBackground(new java.awt.Color(255, 51, 51));
        txtAge.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtAge.setForeground(new java.awt.Color(255, 255, 255));
        txtAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAgeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAgeKeyTyped(evt);
            }
        });
        body.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 90, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Phone");
        body.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 120, 40));

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
        body.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 460, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("City");
        body.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 120, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Blood Group");
        body.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 120, 40));

        btnClose.setBackground(new java.awt.Color(255, 51, 51));
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setText("CLOSE");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        body.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 140, 50));

        cbCity.setBackground(new java.awt.Color(255, 51, 51));
        cbCity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbCity.setForeground(new java.awt.Color(255, 255, 255));
        cbCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GEC", "KHULSHI ", "PAHARTOLI", "KATTOLI", "HALISHAHAR", "PATENGA", "AGRABAD", "BAKOLIA", "2 NO GATE", "BAHADDARHAT", "MURADPUR", "KOTOWALI", "SADARGHAT" }));
        cbCity.setSelectedIndex(-1);
        body.add(cbCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 460, 40));

        cbBloodGroup.setBackground(new java.awt.Color(255, 51, 51));
        cbBloodGroup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbBloodGroup.setForeground(new java.awt.Color(255, 255, 255));
        cbBloodGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "AB+", "AB-", "B+", "B-", "O+", "O-" }));
        cbBloodGroup.setSelectedIndex(-1);
        body.add(cbBloodGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 120, 320, 40));

        btnSave.setBackground(new java.awt.Color(255, 51, 51));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        body.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 140, 50));

        btnReset.setBackground(new java.awt.Color(255, 51, 51));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        body.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 400, 140, 50));

        Gender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 2));
        Gender.setOpaque(false);
        Gender.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Gender");
        Gender.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 40));

        rbGroupMaleFemale.add(rbFemale);
        rbFemale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbFemale.setText("FEMALE");
        Gender.add(rbFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 5, 100, 30));

        rbGroupMaleFemale.add(rbMale);
        rbMale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbMale.setText("MALE");
        Gender.add(rbMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 5, 90, 30));

        body.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 300, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Disease");
        body.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 110, 40));

        txtDisease.setBackground(new java.awt.Color(255, 51, 51));
        txtDisease.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDisease.setForeground(new java.awt.Color(255, 255, 255));
        body.add(txtDisease, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, 320, 40));

        txtPhoneWarning.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPhoneWarning.setForeground(new java.awt.Color(255, 51, 51));
        txtPhoneWarning.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        body.add(txtPhoneWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, 120, 40));

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

    private void txtAgeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgeKeyReleased
        char a = evt.getKeyChar();
        if(!Character.isDigit(a))
        {
            if(Character.isAlphabetic(a))
            {                          
                evt.consume();
            }
            evt.consume();                 
        }
    }//GEN-LAST:event_txtAgeKeyReleased

    private void txtAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgeKeyTyped
        char a = evt.getKeyChar();
        if(!Character.isDigit(a))
        {
            if(Character.isAlphabetic(a))
            {                          
                evt.consume();
            }
            evt.consume();                 
        }
    }//GEN-LAST:event_txtAgeKeyTyped

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clear();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(validInput())
        {
            if(txtPhone.getText().length()==11)
            {
                int id = Integer.parseInt(txtId.getText());
                String name = txtFullName.getText();
                int age = Integer.parseInt(txtAge.getText());
                String gender = null;
                if(rbMale.isSelected())
                {
                    gender = "MALE";
                }
                else if(rbFemale.isSelected())
                {
                    gender = "FEMALE";
                }
                int phone = Integer.parseInt(txtPhone.getText());
                String city = cbCity.getSelectedItem().toString()  ;   
                String bloodGroup =  cbBloodGroup.getSelectedItem().toString();
                String dis = txtDisease.getText();                
                patient.Insert(id,name,age,gender,phone,city,bloodGroup,dis);
                JOptionPane.showMessageDialog(this, "Patient Added Successfuly!");
                clear();                
            }
            else{
                JOptionPane.showMessageDialog(this, "Invalid Phone Number!");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Please fill all information correctly!");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPatient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGImage;
    private javax.swing.JPanel Gender;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel body;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbBloodGroup;
    private javax.swing.JComboBox<String> cbCity;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.ButtonGroup rbGroupMaleFemale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtDisease;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JLabel txtPhoneWarning;
    // End of variables declaration//GEN-END:variables
}
