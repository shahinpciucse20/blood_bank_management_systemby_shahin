
package UI;

import bloodbankmanagementsystem.*;
import java.awt.Color;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Home extends javax.swing.JFrame {

    private Stock stock;
    
    public Home() {
        initComponents();
        setCurrentTime();
        //setBloodQuantity();  
        setIcon();
    }
    
    private void setIcon()
    {
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
    private void setBloodQuantity()
    {
        stock = new Stock();
        double aPos = stock.getBloodQuantityById(1);
        double aNeg = stock.getBloodQuantityById(2);
        double bPos = stock.getBloodQuantityById(3);
        double bNeg = stock.getBloodQuantityById(4);
        double oPos = stock.getBloodQuantityById(5);
        double oNeg = stock.getBloodQuantityById(6);
        double abPos = stock.getBloodQuantityById(7);
        double abNeg = stock.getBloodQuantityById(8);
        
        lblAPos.setText(String.valueOf(aPos)+" L");
        lblANeg.setText(String.valueOf(aNeg)+" L");
        lblBPos.setText(String.valueOf(bPos)+" L");
        lblBNeg.setText(String.valueOf(bNeg)+" L");
        lblABPos.setText(String.valueOf(abPos)+" L");
        lblABNeg.setText(String.valueOf(abNeg)+" L");
        lblOPos.setText(String.valueOf(oPos)+" L");
        lblONeg.setText(String.valueOf(oNeg)+" L");
        
        if(aPos == 0)
        {
            lblAPos.setForeground(Color.red);
        }
        if(aNeg == 0)
        {
            lblANeg.setForeground(Color.red);
        }
        if(bPos == 0)
        {
            lblBPos.setForeground(Color.red);
        }
        if(bNeg == 0)
        {
            lblBNeg.setForeground(Color.red);
        }
        if(abPos == 0)
        {
            lblABPos.setForeground(Color.red);
        }
        if(abNeg == 0)
        {
            lblABNeg.setForeground(Color.red);
        }
        if(oPos == 0)
        {
            lblOPos.setForeground(Color.red);
        }
        if(oNeg == 0)
        {
            lblONeg.setForeground(Color.red);
        }
        
        
        
                
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TopBar = new javax.swing.JPanel();
        findDonor = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        addDonor = new javax.swing.JButton();
        updateDonor = new javax.swing.JButton();
        lblAPos = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        addPatient = new javax.swing.JButton();
        updatePatient = new javax.swing.JButton();
        viewPatient = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblANeg = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblBPos = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblBNeg = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblABPos = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblABNeg = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblOPos = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblONeg = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        Bottom = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        DATE = new javax.swing.JPanel();
        txtDate = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BGImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home - Blood Bank Management System");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TopBar.setOpaque(false);
        TopBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        findDonor.setBackground(new java.awt.Color(255, 51, 51));
        findDonor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        findDonor.setText("FIND");
        findDonor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        findDonor.setContentAreaFilled(false);
        findDonor.setFocusCycleRoot(true);
        findDonor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findDonorActionPerformed(evt);
            }
        });
        TopBar.add(findDonor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 70, 30));

        jSeparator1.setForeground(new java.awt.Color(255, 51, 51));
        TopBar.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, 10));

        addDonor.setBackground(new java.awt.Color(255, 51, 51));
        addDonor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addDonor.setText("Add");
        addDonor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        addDonor.setContentAreaFilled(false);
        addDonor.setFocusCycleRoot(true);
        addDonor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDonorActionPerformed(evt);
            }
        });
        TopBar.add(addDonor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, 30));

        updateDonor.setBackground(new java.awt.Color(255, 51, 51));
        updateDonor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updateDonor.setText("UPDATE");
        updateDonor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        updateDonor.setContentAreaFilled(false);
        updateDonor.setFocusCycleRoot(true);
        updateDonor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDonorActionPerformed(evt);
            }
        });
        TopBar.add(updateDonor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 70, 30));

        lblAPos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAPos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAPos.setText("00 L");
        TopBar.add(lblAPos, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 50, 20));

        jSeparator2.setForeground(new java.awt.Color(255, 51, 51));
        TopBar.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 240, 10));

        addPatient.setBackground(new java.awt.Color(255, 51, 51));
        addPatient.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addPatient.setText("Add");
        addPatient.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        addPatient.setContentAreaFilled(false);
        addPatient.setFocusCycleRoot(true);
        addPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPatientActionPerformed(evt);
            }
        });
        TopBar.add(addPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 70, 30));

        updatePatient.setBackground(new java.awt.Color(255, 51, 51));
        updatePatient.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updatePatient.setText("UPDATE");
        updatePatient.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        updatePatient.setContentAreaFilled(false);
        updatePatient.setFocusCycleRoot(true);
        updatePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePatientActionPerformed(evt);
            }
        });
        TopBar.add(updatePatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 70, 30));

        viewPatient.setBackground(new java.awt.Color(255, 51, 51));
        viewPatient.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewPatient.setText("VIEW ALL");
        viewPatient.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        viewPatient.setContentAreaFilled(false);
        viewPatient.setFocusCycleRoot(true);
        viewPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPatientActionPerformed(evt);
            }
        });
        TopBar.add(viewPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 80, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PATIENT");
        TopBar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 250, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("A+");
        TopBar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 50, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("A- ");
        TopBar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 50, 30));

        lblANeg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblANeg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblANeg.setText("00 L");
        TopBar.add(lblANeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 50, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("B+");
        TopBar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 50, 20));

        lblBPos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblBPos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBPos.setText("00 L");
        TopBar.add(lblBPos, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 50, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("B- ");
        TopBar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 50, 20));

        lblBNeg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblBNeg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBNeg.setText("00 L");
        TopBar.add(lblBNeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 40, 50, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("AB+");
        TopBar.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 50, 20));

        lblABPos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblABPos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblABPos.setText("00 L");
        TopBar.add(lblABPos, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 50, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("AB-");
        TopBar.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 50, 20));

        lblABNeg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblABNeg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblABNeg.setText("00 L");
        TopBar.add(lblABNeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, 50, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("O+");
        TopBar.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 50, 20));

        lblOPos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblOPos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOPos.setText("00 L");
        TopBar.add(lblOPos, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 50, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("O-");
        TopBar.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, 50, 20));

        lblONeg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblONeg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblONeg.setText("00 L");
        TopBar.add(lblONeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, 50, 20));

        jSeparator3.setForeground(new java.awt.Color(255, 51, 51));
        TopBar.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 240, 10));

        jSeparator4.setForeground(new java.awt.Color(255, 51, 51));
        TopBar.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 240, 30));

        jSeparator5.setForeground(new java.awt.Color(255, 51, 51));
        TopBar.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 240, 10));

        jSeparator6.setForeground(new java.awt.Color(255, 51, 51));
        TopBar.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 240, 10));

        jSeparator7.setForeground(new java.awt.Color(255, 51, 51));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        TopBar.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 10, 120));

        jSeparator8.setForeground(new java.awt.Color(255, 51, 51));
        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        TopBar.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 20, 120));

        jSeparator9.setForeground(new java.awt.Color(255, 51, 51));
        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        TopBar.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 10, 90));

        jSeparator10.setForeground(new java.awt.Color(255, 51, 51));
        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        TopBar.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 10, 120));

        jSeparator11.setForeground(new java.awt.Color(255, 51, 51));
        TopBar.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 240, 20));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("DONOR");
        TopBar.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 240, -1));

        getContentPane().add(TopBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 860, 130));

        Bottom.setOpaque(false);
        Bottom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("View Stock");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Bottom.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 280, 50));

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("+ New Donation");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Bottom.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 280, 50));

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("- New Hand Over");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Bottom.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 280, 50));

        getContentPane().add(Bottom, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 380, 230));

        DATE.setOpaque(false);
        DATE.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDate.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DATE.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 7, 240, 30));

        getContentPane().add(DATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 140, 270, 50));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/rsz_logout_4.png"))); // NOI18N
        jLabel19.setToolTipText("SIGN OUT");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SIGN OUT");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 90, 40));

        BGImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BGImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/BG_Blood-1200x700.png"))); // NOI18N
        getContentPane().add(BGImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void findDonorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findDonorActionPerformed
        FindDonor finDon = new FindDonor();
        finDon.setVisible(true);
        dispose();
    }//GEN-LAST:event_findDonorActionPerformed

    private void addDonorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDonorActionPerformed
        AddDonor addDonor = new AddDonor();
        addDonor.setVisible(true);
        dispose();
    }//GEN-LAST:event_addDonorActionPerformed

    private void updateDonorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDonorActionPerformed
       UpdateDonor upDon = new UpdateDonor();
       upDon.setVisible(true);
       dispose();
    }//GEN-LAST:event_updateDonorActionPerformed

    private void addPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPatientActionPerformed
        AddPatient addPat = new AddPatient();
        addPat.setVisible(true);
        dispose();
    }//GEN-LAST:event_addPatientActionPerformed

    private void updatePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePatientActionPerformed
       UpdatePatient upPat = new UpdatePatient();
       upPat.setVisible(true);
       dispose();
    }//GEN-LAST:event_updatePatientActionPerformed

    private void viewPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPatientActionPerformed
       ViewPatient viPat = new ViewPatient();
       viPat.setVisible(true);
       dispose();
    }//GEN-LAST:event_viewPatientActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       NewDonation newDonation = new NewDonation();
       newDonation.setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       NewHandOver newHand = new NewHandOver();
       newHand.setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ViewStock viStock = new ViewStock();
       viStock.setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
       
        int deleteItem = JOptionPane.showConfirmDialog(null,"Do You Want to Sign Out?", "WARNING!",JOptionPane.YES_NO_OPTION );
            if(deleteItem == JOptionPane.YES_OPTION)
            {                              
                Login login = new Login();
                login.setVisible(true);
                dispose();              
                
            }
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        int deleteItem = JOptionPane.showConfirmDialog(null,"Do You Want to Sign Out?", "WARNING!",JOptionPane.YES_NO_OPTION );
            if(deleteItem == JOptionPane.YES_OPTION)
            {                              
                Login login = new Login();
                login.setVisible(true);
                dispose();              
                
            }
    }//GEN-LAST:event_jLabel1MouseClicked

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGImage;
    private javax.swing.JPanel Bottom;
    private javax.swing.JPanel DATE;
    private javax.swing.JPanel TopBar;
    private javax.swing.JButton addDonor;
    private javax.swing.JButton addPatient;
    private javax.swing.JButton findDonor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblABNeg;
    private javax.swing.JLabel lblABPos;
    private javax.swing.JLabel lblANeg;
    private javax.swing.JLabel lblAPos;
    private javax.swing.JLabel lblBNeg;
    private javax.swing.JLabel lblBPos;
    private javax.swing.JLabel lblONeg;
    private javax.swing.JLabel lblOPos;
    private javax.swing.JLabel txtDate;
    private javax.swing.JButton updateDonor;
    private javax.swing.JButton updatePatient;
    private javax.swing.JButton viewPatient;
    // End of variables declaration//GEN-END:variables
}
