
package UI;

import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    private static final String userName = "shahin";
    private static final String passWord = "1234";
    
    public Login() {
        initComponents();
        String iconPath = "/Res/icon_blood-pressure.png";        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(iconPath))); 
        txtPassWord.setEchoChar('*');
    }

    private boolean loginValid()
    {
        String pass =txtPassWord.getText().toString();
        String user = txtUserName.getText().toString();
        if(pass.equals(passWord) && user.equals(userName))
        {
            return true;
        }
        else{
            return false;
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassWord = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jrbtnShowPassword = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        bgImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 3));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Username");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 320, 30));

        txtUserName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 320, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 320, 30));

        txtPassWord.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPassWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassWordActionPerformed(evt);
            }
        });
        jPanel1.add(txtPassWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 320, 40));

        btnLogin.setBackground(new java.awt.Color(255, 51, 51));
        btnLogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("SIGN IN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 320, 40));

        btnHome.setBackground(new java.awt.Color(255, 51, 51));
        btnHome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHome.setText("CLOSE");
        btnHome.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnHome.setContentAreaFilled(false);
        btnHome.setFocusCycleRoot(true);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        jPanel1.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 320, 40));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("BLOOD BANK ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 350, 60));

        jrbtnShowPassword.setForeground(new java.awt.Color(255, 51, 51));
        jrbtnShowPassword.setText("Show Password");
        jrbtnShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbtnShowPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(jrbtnShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, -1));

        body.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 380, 580));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("MV Boli", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 51));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("DEVELOPED BY Md Shahin Shah");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, 330, 60));

        bgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/LoginBG_.png"))); // NOI18N
        jPanel2.add(bgImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 600));

        body.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 490, 580));

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
      if(txtPassWord.getText().length()!=0 && txtUserName.getText().length()!=0)
      {
          if(loginValid())
          {
              Home home = new Home();
              home.setVisible(true);
              dispose();
          }
          else{
              JOptionPane.showMessageDialog(this, "Username or Passoword Didn't Matched!!");
          }
      }
      else{
              JOptionPane.showMessageDialog(this, "Inavlid Username or Password!");
          }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
       txtPassWord.requestFocus();
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void txtPassWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassWordActionPerformed
        if(txtPassWord.getText().length()!=0 && txtUserName.getText().length()!=0)
      {
          if(loginValid())
          {
              Home home = new Home();
              home.setVisible(true);
              dispose();
          }
          else{
              JOptionPane.showMessageDialog(this, "Username or Passoword Didn't Matched!!");
          }
      }
      else{
              JOptionPane.showMessageDialog(this, "Inavlid Username or Password!");
          }
    }//GEN-LAST:event_txtPassWordActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        
    System.exit(0);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void jrbtnShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbtnShowPasswordActionPerformed
        if(jrbtnShowPassword.isSelected())
        {
            txtPassWord.setEchoChar((char)0);
        }
        else if(!jrbtnShowPassword.isSelected())
        {
            txtPassWord.setEchoChar('*');
        }
    }//GEN-LAST:event_jrbtnShowPasswordActionPerformed

   
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgImage;
    private javax.swing.JPanel body;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jrbtnShowPassword;
    private javax.swing.JPasswordField txtPassWord;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
