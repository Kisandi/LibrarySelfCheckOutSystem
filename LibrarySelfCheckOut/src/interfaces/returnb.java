package interfaces;

import codes.DBConnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class returnb extends javax.swing.JFrame {
     Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private DefaultTableModel tableModel1;

        public returnb() {
        initComponents();
        tableModel1 = (DefaultTableModel) tbltransact.getModel();
        conn = DBConnect.connect();  
        
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Failed to connect to database", "Error", JOptionPane.ERROR_MESSAGE);
            // Optionally, disable functionality or handle gracefully
        }
    }
     
        
         private void fetchTransactions() {
    String sql = "SELECT * FROM transaction WHERE Returned = FALSE";
    try {
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        tableModel1.setRowCount(0); // Clear existing rows
        while (rs.next()) {
            int transactionId = rs.getInt("TransactionId");
            String ISBN = rs.getString("ISBN");
            String IndexNo = rs.getString("IndexNo");
            Date transactionDate = rs.getDate("TransactDate");
            Date dueDate = rs.getDate("DueDate");
            Boolean Returned = rs.getBoolean("Returned");
            tableModel1.addRow(new Object[]{transactionId, ISBN, IndexNo, transactionDate, dueDate, Returned});
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error fetching transactions: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    }             

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltransact = new javax.swing.JTable();
        txtreturn = new javax.swing.JButton();
        btnborrow = new javax.swing.JButton();
        btnhome = new javax.swing.JButton();
        txtindexno = new javax.swing.JTextField();
        btnfind = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbltransact.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction ID", "ISBN", "Index No", "Transaction Date", "Due Date", "Returned"
            }
        ));
        jScrollPane1.setViewportView(tbltransact);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 650, 180));

        txtreturn.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        txtreturn.setText("Return");
        txtreturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtreturnActionPerformed(evt);
            }
        });
        jPanel1.add(txtreturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 130, 50));

        btnborrow.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        btnborrow.setText("Go Back");
        btnborrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnborrowActionPerformed(evt);
            }
        });
        jPanel1.add(btnborrow, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 130, 50));

        btnhome.setFont(new java.awt.Font("Open Sans", 1, 18)); // NOI18N
        btnhome.setText("Home");
        btnhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhomeActionPerformed(evt);
            }
        });
        jPanel1.add(btnhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 130, 50));
        jPanel1.add(txtindexno, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 130, -1));

        btnfind.setText("Find Books");
        btnfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfindActionPerformed(evt);
            }
        });
        jPanel1.add(btnfind, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    private void txtreturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtreturnActionPerformed
      int yesorno = JOptionPane.showConfirmDialog(null, "Are you sure you want to return these books? ", "Returning", JOptionPane.YES_NO_OPTION);

    if (yesorno == 0) {
        DefaultTableModel model = (DefaultTableModel) tbltransact.getModel();
        int[] selectedRows = tbltransact.getSelectedRows();

        for (int row : selectedRows) {
            int transactionId = (int) model.getValueAt(row, 0);
            String isbn = (String) model.getValueAt(row, 1);
            String indexNo = (String) model.getValueAt(row, 2);
            Date transactionDate = (Date) model.getValueAt(row, 3);
            Date dueDate = (Date) model.getValueAt(row, 4);

            // Delete from transaction table
            String deleteSql = "DELETE FROM transaction WHERE TransactionId = ?";
            try {
                pst = conn.prepareStatement(deleteSql);
                pst.setInt(1, transactionId);
                pst.executeUpdate();
                pst.close(); // Close the statement after execution
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error deleting data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Update 'Returned' status in transaction table
            String updateSql = "UPDATE transaction SET Returned = TRUE WHERE TransactionId = ?";
            try {
                pst = conn.prepareStatement(updateSql);
                pst.setInt(1, transactionId);
                pst.executeUpdate();
                pst.close(); // Close the statement after execution
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error updating 'Returned' status: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Insert into history table
            String insertHistorySql = "INSERT INTO history (TransactionId, ISBN, IndexNo, TransactDate, DueDate, Returned) VALUES (?, ?, ?, ?, ?, ?)";
            try {
                pst = conn.prepareStatement(insertHistorySql);
                pst.setInt(1, transactionId);
                pst.setString(2, isbn);
                pst.setString(3, indexNo);
                pst.setDate(4, transactionDate);
                pst.setDate(5, dueDate);
                pst.setBoolean(6, true);
                pst.executeUpdate();
                pst.close(); // Close the statement after execution
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error inserting into history: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Remove the row from the JTable
            model.removeRow(row);

            // Update quantity in books table
            try {
                // Retrieve current quantity
                String retrieveSql = "SELECT Quantity FROM books WHERE ISBN = ?";
                pst = conn.prepareStatement(retrieveSql);
                pst.setString(1, isbn);
                rs = pst.executeQuery();

                int currentQuantity = 0;
                if (rs.next()) {
                    currentQuantity = rs.getInt("Quantity");
                }
                rs.close(); // Close result set

                // Update quantity
                String updateQuantitySql = "UPDATE books SET Quantity = ? WHERE ISBN = ?";
                pst = conn.prepareStatement(updateQuantitySql);
                pst.setInt(1, currentQuantity + 1); // Increment quantity
                pst.setString(2, isbn);
                pst.executeUpdate();
                pst.close(); // Close the statement after execution

                JOptionPane.showMessageDialog(this, "Quantity updated in books table");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error updating quantity in books table: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (pst != null) {
                        pst.close();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error closing statement: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }  
        
    }//GEN-LAST:event_txtreturnActionPerformed

    private void btnhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhomeActionPerformed
       int yesorno = JOptionPane.showConfirmDialog(null, "Are you sure you want to go to login page? ", "Borrowing", JOptionPane.YES_NO_OPTION);
        
        if(yesorno == 0){
           
            
        home hom = new home();
         hom.setVisible(true);
         // Remove this form (Home.java)
         this.dispose();
        } else{
           this.show();
        }
    }//GEN-LAST:event_btnhomeActionPerformed

    private void btnborrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnborrowActionPerformed
       int yesorno = JOptionPane.showConfirmDialog(null, "Are you sure you want to go to back to borrow books ", "Borrowing", JOptionPane.YES_NO_OPTION);
        
        if(yesorno == 0){
            
            
        borrow bor = new borrow();
         bor.setVisible(true);
         // Remove this form (Home.java)
         this.dispose();
        } else{
           this.show();
        }
    }//GEN-LAST:event_btnborrowActionPerformed

    private void btnfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfindActionPerformed
        String indexno = txtindexno.getText().trim();

    if (indexno.isEmpty()) {
        // Show an error message
        JOptionPane.showMessageDialog(null, "Please fill the index number", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
        fetchTransactions();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tbltransact.getModel());
   tbltransact.setRowSorter(sorter);
            
    String filterText = txtindexno.getText();
    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(filterText), 2));
    
    }//GEN-LAST:event_btnfindActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(returnb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(returnb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(returnb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(returnb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new returnb().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnborrow;
    private javax.swing.JButton btnfind;
    private javax.swing.JButton btnhome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbltransact;
    private javax.swing.JTextField txtindexno;
    private javax.swing.JButton txtreturn;
    // End of variables declaration//GEN-END:variables
}
