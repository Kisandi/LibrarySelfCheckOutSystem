package interfaces;

import javax.swing.JOptionPane;
import codes.DBConnect;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class home extends javax.swing.JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
        public home() {
        initComponents();
        conn = DBConnect.connect();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUname = new javax.swing.JTextField();
        btnlogin = new javax.swing.JButton();
        txtpswrd = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(java.awt.SystemColor.controlLtHighlight);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        jLabel1.setText("Welcome to \nLibrary Self-Checkout");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel2.setText("Index Number");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, -1));

        txtUname.setFont(new java.awt.Font("Open Sans", 0, 12)); // NOI18N
        jPanel1.add(txtUname, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 170, 30));

        btnlogin.setBackground(new java.awt.Color(204, 255, 204));
        btnlogin.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        btnlogin.setText("Login");
        btnlogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnloginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnloginMouseExited(evt);
            }
        });
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        jPanel1.add(btnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 170, 40));
        jPanel1.add(txtpswrd, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 170, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Function to clear text fields
    private void clearTextFields() {
        txtUname.setText("");
        txtpswrd.setText("");
   }
    
    
    //Login Button Code
    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
       //Declare Variable
       String uname;
       String mailno;
       
       //Initialize the Variable
       //Get the text on the textbox to variables
       uname = txtUname.getText().trim();
       mailno = txtpswrd.getText().trim();
       
       String unamesql = "SELECT * FROM member WHERE IndexNo = ?";
       String mailsql = "SELECT * FROM member WHERE Email = ?";
   
       try {
        
       if (uname.isEmpty() && mailno.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Fill the Index No and Email");
        clearTextFields();
        return;
        } else if (uname.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Fill the username");
        clearTextFields();
         return;
         } else if (mailno.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill the email/phone number");
            clearTextFields();
            return;
        }

        // Check if username exists
        pst = conn.prepareStatement(unamesql);
        pst.setString(1, uname);
        rs = pst.executeQuery();

        boolean usernameCorrect = rs.next(); // Check if username exists

        // Check if email/phone number matches the username
        pst.close(); // Close previous statement

        pst = conn.prepareStatement(mailsql);
        pst.setString(1, mailno);
        rs = pst.executeQuery();

        boolean mailnoCorrect = rs.next(); // Check if email/phone number exists

        pst.close();

        if (!usernameCorrect && !mailnoCorrect) {
            JOptionPane.showMessageDialog(null, "Both username and email/phone number are wrong");
            clearTextFields();
            return;
        } else if (!usernameCorrect) {
            JOptionPane.showMessageDialog(null, "Username is wrong");
            clearTextFields();
            return;
        } else if (!mailnoCorrect) {
            JOptionPane.showMessageDialog(null, "Email/phone number is wrong");
            clearTextFields();
            return;
        }

           
        // Both username and email/phone number are correct
        // Going to 2nd Form
        selection sel = new selection();
        
        sel.setVisible(true);
        
        // Remove this form (Home.java)
        this.dispose();
        
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error1 " + e.getMessage());
        }finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }}
                                          


       
    }//GEN-LAST:event_btnloginActionPerformed

    private void btnloginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnloginMouseExited
        btnlogin.setBackground(new Color(204,255,204));
    }//GEN-LAST:event_btnloginMouseExited

    private void btnloginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnloginMouseEntered
        btnlogin.setBackground(new Color(0,255,51));
    }//GEN-LAST:event_btnloginMouseEntered

    
    

    
    
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField txtUname;
    private javax.swing.JPasswordField txtpswrd;
    // End of variables declaration//GEN-END:variables
}
