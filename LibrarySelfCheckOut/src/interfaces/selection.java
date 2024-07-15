package interfaces;

import java.awt.Color;
import javax.swing.JOptionPane;

public class selection extends javax.swing.JFrame {

    public selection() {
        initComponents();         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnborrow = new javax.swing.JButton();
        btnreturn = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(java.awt.SystemColor.controlLtHighlight);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnborrow.setBackground(new java.awt.Color(204, 255, 204));
        btnborrow.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        btnborrow.setText("Borrow");
        btnborrow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnborrowMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnborrowMouseExited(evt);
            }
        });
        btnborrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnborrowActionPerformed(evt);
            }
        });
        jPanel1.add(btnborrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 49, 160, 230));

        btnreturn.setBackground(new java.awt.Color(204, 255, 204));
        btnreturn.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        btnreturn.setText("Return");
        btnreturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnreturnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnreturnMouseExited(evt);
            }
        });
        btnreturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreturnActionPerformed(evt);
            }
        });
        jPanel1.add(btnreturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 160, 230));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnborrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnborrowActionPerformed
        int yesorno = JOptionPane.showConfirmDialog(null, "Are you sure you want to borrow books? ", "Borrowing", JOptionPane.YES_NO_OPTION);
        
        if(yesorno == 0){
        selborrow selbor = new selborrow(); 
       
         selbor.setVisible(true);
         // Remove this form (Home.java)
         this.dispose();
        }else{
            this.show();
        }
    }//GEN-LAST:event_btnborrowActionPerformed

    private void btnreturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreturnActionPerformed
       
        
        
        int yesorno = JOptionPane.showConfirmDialog(null, "Are you sure you want to return books? ", "Returning", JOptionPane.YES_NO_OPTION);
        
        if(yesorno == 0){
        returnb  ret= new returnb();
         ret.setVisible(true);
         // Remove this form (Home.java)
         this.dispose();
        }else{
            this.show();
        }
    }//GEN-LAST:event_btnreturnActionPerformed

    
    
    private void btnborrowMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnborrowMouseEntered
         btnborrow.setBackground(new Color(0,255,51));
    }//GEN-LAST:event_btnborrowMouseEntered

    private void btnreturnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnreturnMouseExited
        btnreturn.setBackground(new Color(204,255,204));
    }//GEN-LAST:event_btnreturnMouseExited

    private void btnreturnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnreturnMouseEntered
        btnreturn.setBackground(new Color(0,255,51));
    }//GEN-LAST:event_btnreturnMouseEntered

    private void btnborrowMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnborrowMouseExited
        btnborrow.setBackground(new Color(204,255,204));
    }//GEN-LAST:event_btnborrowMouseExited

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       home hom = new home();
        hom.setVisible(true);
       
        // Remove this form (Home.java)
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

   
    
    
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
            java.util.logging.Logger.getLogger(selection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(selection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(selection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new selection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnborrow;
    private javax.swing.JButton btnreturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
