
package UI;

import bloodbankmanagementsystem.Stock;
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


public class ViewStock extends javax.swing.JFrame {
    private Stock stock = new Stock();
    private static ResultSet rs = null;

    
    public ViewStock() {
        initComponents();
        displayAllStockData();
        
        String iconPath = "/Res/icon_blood-pressure.png";        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(iconPath))); 
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
            Logger.getLogger(ViewStock.class.getName()).log(Level.SEVERE, null, ex);
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
        jButton2 = new javax.swing.JButton();
        TableHolder = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        btnPrint = new javax.swing.JButton();
        BGImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VIEW STOCK");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setOpaque(false);
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(255, 51, 51));
        Header.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 260, 10));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("BLOOD STOCK");
        Header.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 40));

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1200, 60));

        body.setOpaque(false);
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CLOSE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        body.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 160, 60));

        TableHolder.setBackground(new java.awt.Color(255, 255, 255));
        TableHolder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 2));
        TableHolder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblStock.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
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
        tblStock.setRowHeight(45);
        tblStock.setSelectionBackground(new java.awt.Color(255, 51, 51));
        jScrollPane2.setViewportView(tblStock);
        if (tblStock.getColumnModel().getColumnCount() > 0) {
            tblStock.getColumnModel().getColumn(0).setMinWidth(120);
            tblStock.getColumnModel().getColumn(0).setPreferredWidth(150);
            tblStock.getColumnModel().getColumn(0).setMaxWidth(180);
        }

        TableHolder.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1080, 390));

        body.add(TableHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 1100, 410));

        btnPrint.setBackground(new java.awt.Color(255, 51, 51));
        btnPrint.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setText("PRINT");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        body.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 160, 60));

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1180, 620));

        BGImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BGImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/AddDonorBG.png"))); // NOI18N
        getContentPane().add(BGImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Home home = new Home();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        String o = java.time.LocalDateTime.now().toString();        
        String old = o.replace("T"," ");        
        LocalDateTime datetime = LocalDateTime.parse(old, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));        
        String newDate = datetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));      
        
        MessageFormat header = new MessageFormat("BLOOD STOCK - "+newDate);
        MessageFormat footer = new MessageFormat("BLOOD BANK MANAGEMENT SYSTEM - DEVELOPED BY SHAMIM MD JONY");
        try {
            tblStock.print(JTable.PrintMode.FIT_WIDTH, header, footer);
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
            java.util.logging.Logger.getLogger(ViewStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new ViewStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGImage;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel TableHolder;
    private javax.swing.JPanel body;
    private javax.swing.JButton btnPrint;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblStock;
    // End of variables declaration//GEN-END:variables
}
