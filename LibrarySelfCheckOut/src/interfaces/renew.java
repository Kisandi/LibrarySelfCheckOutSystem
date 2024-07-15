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


public class renew extends javax.swing.JFrame {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private DefaultTableModel tableModel1;


    
    public renew() {
        initComponents();
        tableModel1 = (DefaultTableModel) tbltransact.getModel();
        conn = DBConnect.connect();  
        
//        if (conn == null) {
//            JOptionPane.showMessageDialog(this, "Failed to connect to database", "Error", JOptionPane.ERROR_MESSAGE);
//            // Optionally, disable functionality or handle gracefully
//        } 
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
        btnrenew = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        btnhome = new javax.swing.JButton();
        txtindexno = new javax.swing.JTextField();
        btnfind = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltransact = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnrenew.setText("Renew");
        btnrenew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrenewActionPerformed(evt);
            }
        });

        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        btnhome.setText("Home");
        btnhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhomeActionPerformed(evt);
            }
        });

        btnfind.setText("Find Books");
        btnfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfindActionPerformed(evt);
            }
        });

        tbltransact.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(tbltransact);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnrenew, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnhome, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(txtindexno, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnfind))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtindexno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfind))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnrenew, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnhome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnrenewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrenewActionPerformed
     int yesorno = JOptionPane.showConfirmDialog(null, "Are you sure you want to renew these books? ", "Renewing", JOptionPane.YES_NO_OPTION);
    
    if (yesorno == 0) {
        DefaultTableModel model = (DefaultTableModel) tbltransact.getModel();
        int[] selectedRows = tbltransact.getSelectedRows();
        
      
            

            
            // Prepare SQL statements
        String updatesql = "UPDATE transaction SET  ISBN = ?, IndexNo = ?, TransactDate = ?, DueDate = ?, Returned = ? WHERE TransactionId = ?";
        
        try {
            // Iterate over selected rows
            for (int row : selectedRows) {
                int transactionId = (int) model.getValueAt(row, 0); // Assuming TransactionId is in the first column
                String isbn = (String) model.getValueAt(row, 1); // Assuming ISBN is in the second column
                String indexNo = (String) model.getValueAt(row, 2); // Assuming IndexNo is in the third column
                Date transactionDate = new Date(System.currentTimeMillis()); // Current date
                // Set due date (example: 21 days from now)
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DAY_OF_MONTH, 21);
                Date dueDate = new Date(cal.getTimeInMillis());

                // Update operation
                pst = conn.prepareStatement(updatesql);

                // Set parameters for the prepared statement
                pst.setInt(6, transactionId);
                 pst.setString(1, isbn);
                pst.setString(2, indexNo);
                pst.setDate(3, transactionDate);
                pst.setDate(4, dueDate);
                pst.setBoolean(5, false);
                
                 // Condition for update (original TransactionId)
                 // Condition for update (original DueDate)
                

                // Execute the update statement
                int rowsUpdated = pst.executeUpdate();
                
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Transaction renewed successfully");
                    
                    // Example: Update the table model after successful update
                    model.setValueAt(transactionId, row, 0);
                    model.setValueAt(isbn, row, 1);
                    model.setValueAt(indexNo, row, 2);
                    model.setValueAt(transactionDate, row, 3);
                    model.setValueAt(dueDate, row, 4);
                    model.setValueAt(false, row, 5); // Assuming Returned is in the 6th column
                    
                    // Refresh the transactions table display
                    fetchTransactions(); // Assuming fetchTransactions() updates the JTable with current data
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update transaction", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error updating transaction: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
    }//GEN-LAST:event_btnrenewActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        selborrow selbor = new selborrow();
        //selbor.txtindexno.setText(txtindexno.getText()); // Assuming lblindexno is a JLabel in selection
        selbor.setVisible(true);
        
        // Remove this form (Home.java)
        this.dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhomeActionPerformed
        home hom = new home();
        hom.setVisible(true);
        
        // Remove this form (Home.java)
        this.dispose();
    }//GEN-LAST:event_btnhomeActionPerformed

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
            java.util.logging.Logger.getLogger(renew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(renew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(renew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(renew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new renew().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnfind;
    private javax.swing.JButton btnhome;
    private javax.swing.JButton btnrenew;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbltransact;
    private javax.swing.JTextField txtindexno;
    // End of variables declaration//GEN-END:variables

   private void addDataToTable(DefaultTableModel model, Object[] rowData) {
    model.addRow(rowData);
}
    

 
}
