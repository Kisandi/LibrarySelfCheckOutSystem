package interfaces;


import codes.DBConnect;
import java.sql.Connection;
import java.util.Properties;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.regex.*;
import javax.swing.RowFilter;


public class borrow extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
   private DefaultTableModel tableModel;
    
    public borrow() {
        initComponents();
        //add(lblindexno);
        tableModel = (DefaultTableModel) tbltransact.getModel();
        conn = DBConnect.connect();
         
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Failed to connect to database", "Error", JOptionPane.ERROR_MESSAGE);
            // Optionally, disable functionality or handle gracefully
        } else {
            id_autoincrement();
            
            
        
            //fetchTransactions();
        }
    }

borrow(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    private void id_autoincrement(){
        try{
            String sqlquery = "SELECT TransactionId FROM transaction ORDER BY TransactionId DESC LIMIT 1";
            pst = conn.prepareStatement(sqlquery);
            rs = pst.executeQuery();
            
            if(rs.next()){
               int id = rs.getInt(1);
            txttransactid.setText(Integer.toString(id + 1));
            }else {
            txttransactid.setText("1"); // Default to 1 if no entries exist
        }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error closing resources: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }
    
    
    private void fetchTransactions() {
    String sql = "SELECT * FROM transaction WHERE Returned = FALSE";
    
   
    try {
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        tableModel.setRowCount(0); // Clear existing rows
        
        
        while (rs.next()) {
            int transactionId = rs.getInt("TransactionId");
            String ISBN = rs.getString("ISBN");
            String IndexNo = rs.getString("IndexNo");
            Date transactionDate = rs.getDate("TransactDate");
            Date dueDate = rs.getDate("DueDate");
            Boolean Returned = rs.getBoolean("Returned");
            tableModel.addRow(new Object[]{transactionId, ISBN, IndexNo, transactionDate, dueDate, Returned});
        }
        
          // Filter on the third column (index 2)
        
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
    
    public void returnb(int transactionId) {
        String sql = "UPDATE transaction SET Returned = TRUE WHERE TransactionId = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, transactionId);
            int updated = pst.executeUpdate();
            if (updated > 0) {
                JOptionPane.showMessageDialog(null, "Book returned successfully");
                fetchTransactions(); // Refresh the table
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtbid = new javax.swing.JTextField();
        txtisbn = new javax.swing.JTextField();
        txtbauthor = new javax.swing.JTextField();
        txtbpublisher = new javax.swing.JTextField();
        txtbtitle = new javax.swing.JTextField();
        btnretrive = new javax.swing.JButton();
        btnaddtob = new javax.swing.JButton();
        btnbconfirm = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltransact = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txttransactid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtindexno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel1.setText("ISBN");

        jLabel2.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel2.setText("TITLE");

        jLabel3.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel3.setText("BOOK_ID");

        jLabel4.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel4.setText("AUTHOR");

        jLabel5.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel5.setText("PUBLISHER");

        txtbid.setEditable(false);
        txtbid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbidActionPerformed(evt);
            }
        });

        txtbauthor.setEditable(false);
        txtbauthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbauthorActionPerformed(evt);
            }
        });

        txtbpublisher.setEditable(false);

        txtbtitle.setEditable(false);
        txtbtitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbtitleActionPerformed(evt);
            }
        });

        btnretrive.setText("Retrieve");
        btnretrive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnretriveActionPerformed(evt);
            }
        });

        btnaddtob.setText("Add");
        btnaddtob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddtobActionPerformed(evt);
            }
        });

        btnbconfirm.setText("Confirm and Go back");
        btnbconfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbconfirmActionPerformed(evt);
            }
        });

        tbltransact.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction ID", "ISBN", "Index No", "Trasaction Date", "Due Date ", "Returned"
            }
        ));
        jScrollPane1.setViewportView(tbltransact);

        jLabel6.setText("Transaction_Id");

        txttransactid.setEditable(false);
        txttransactid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttransactidActionPerformed(evt);
            }
        });

        jLabel7.setText("Index No");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnbconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(44, 44, 44)
                                .addComponent(txttransactid, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(23, 23, 23)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtisbn, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                            .addComponent(txtbid, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                            .addComponent(txtbtitle, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                            .addComponent(txtbpublisher, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                            .addComponent(txtbauthor, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnaddtob, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnretrive)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtindexno, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(63, 63, 63)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(284, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtindexno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)
                                        .addComponent(txtbid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtbtitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)
                                        .addComponent(txtbauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnretrive)
                                        .addGap(8, 8, 8)
                                        .addComponent(btnaddtob)))
                                .addGap(18, 18, 18)
                                .addComponent(txtbpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(71, 71, 71)
                        .addComponent(btnbconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txttransactid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(181, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void clearTextFields() {
        txtisbn.setText("");
        txtbtitle.setText("");
        txtbpublisher.setText("");
        txtbid.setText("");
        txtbauthor.setText("");
        
   }
    
    private void txtbauthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbauthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbauthorActionPerformed

    private void txtbtitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbtitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbtitleActionPerformed

    private void txtbidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbidActionPerformed
       
    }//GEN-LAST:event_txtbidActionPerformed

    private void btnretriveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnretriveActionPerformed
        String isbn = txtisbn.getText();
        String sql = "SELECT * FROM books WHERE ISBN = ?";
        
        try{
           pst = conn.prepareStatement(sql);
           pst.setString(1, isbn); 
                           
                     
            rs = pst.executeQuery();
            
            if (rs.next()) {
                txtbid.setText(rs.getString("BookId"));
                txtbtitle.setText(rs.getString("TITLE"));
                txtbauthor.setText(rs.getString("AUTHOR"));
                txtbpublisher.setText(rs.getString("PUBLISHER"));
            } else {
                JOptionPane.showMessageDialog(null, "No book found with this ISBN");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnretriveActionPerformed

    private void btnaddtobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddtobActionPerformed
String indexno = txtindexno.getText().trim();

    if (indexno.isEmpty()) {
        // Show an error message
        JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    } 

    // Check the number of books already borrowed by the user
    int borrowedBookCount = 0;
    for (int i = 0; i < tableModel.getRowCount(); i++) {
        if (tableModel.getValueAt(i, 2).equals(indexno)) {
            borrowedBookCount++;
        }
    }

    if (borrowedBookCount >= 4) {
        JOptionPane.showMessageDialog(this, "You can only borrow up to 4 books at a time.", "Limit Reached", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Get data from text fields
    String isbn1 = txtisbn.getText().trim();
    String title = txtbtitle.getText().trim();
    String publisher = txtbpublisher.getText().trim();
    String bid = txtbid.getText().trim();
    String author = txtbauthor.getText().trim();
    
    if (isbn1.isEmpty() || title.isEmpty() || publisher.isEmpty() || bid.isEmpty() || author.isEmpty() || indexno.isEmpty()) {
        // Show an error message
        JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    TableRowSorter<TableModel> sorter = new TableRowSorter<>(tbltransact.getModel());
    tbltransact.setRowSorter(sorter);
            
    String filterText = txtindexno.getText();
    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(filterText), 2));

    // Get data from text fields
    int TransactionId = Integer.parseInt(txttransactid.getText());
    String isbn = txtisbn.getText();
    String IndexNo = txtindexno.getText();
    Date transactionDate = new Date(System.currentTimeMillis()); // Current date

    // Set due date (example: 14 days from now)
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DAY_OF_MONTH, 14);
    Date dueDate = new Date(cal.getTimeInMillis());

    // Add data to the table model
    tableModel.addRow(new Object[]{TransactionId, isbn, IndexNo, transactionDate, dueDate, false}); // Add 'false' for Returned

    // Clear text fields
    clearTextFields();

    // Insert data into the Transactions table in the database
    String insertSql = "INSERT INTO transaction (TransactionId, ISBN, IndexNo, TransactDate, DueDate, Returned) VALUES (?, ?, ?, ?, ?, ?)";
    try {
        // Prepare the SQL statement
        pst = conn.prepareStatement(insertSql);
        
        // Set parameters for the prepared statement
        pst.setInt(1, TransactionId);
        pst.setString(2, isbn);
        pst.setString(3, IndexNo);
        pst.setDate(4, transactionDate); // Assuming current date as TransactionDate
        pst.setDate(5, dueDate); // Due date
        pst.setBoolean(6, false); 

        // Execute the insert statement
        int rowsInserted = pst.executeUpdate();
        
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Data added to Transactions table successfully");
            id_autoincrement();

            // Update the book quantity
            String updateSql = "UPDATE books SET Quantity = Quantity - 1 WHERE ISBN = ?";
            pst = conn.prepareStatement(updateSql);
            pst.setString(1, isbn);
            pst.executeUpdate();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add data to Transactions table", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        // Refresh the transactions table display
        fetchTransactions(); // Assuming fetchTransactions() updates the JTable with current data
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error inserting data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (pst != null) {
                pst.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error closing statement: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    }//GEN-LAST:event_btnaddtobActionPerformed

    private void btnbconfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbconfirmActionPerformed
       
        
        int yesorno = JOptionPane.showConfirmDialog(null, "Are you sure you want to borrow books only theese books? ", "Borrowing", JOptionPane.YES_NO_OPTION);
        
        if(yesorno == 0){
            
            
            JOptionPane.showMessageDialog(null, "Have a nice day"); 
            
        home hom = new home();
         hom.setVisible(true);
         // Remove this form (Home.java)
         this.dispose();
        } else{
           this.show();
        }
           
    }//GEN-LAST:event_btnbconfirmActionPerformed

    private void txttransactidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttransactidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttransactidActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new borrow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddtob;
    private javax.swing.JButton btnbconfirm;
    private javax.swing.JButton btnretrive;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbltransact;
    private javax.swing.JTextField txtbauthor;
    private javax.swing.JTextField txtbid;
    private javax.swing.JTextField txtbpublisher;
    private javax.swing.JTextField txtbtitle;
    private javax.swing.JTextField txtindexno;
    public javax.swing.JTextField txtisbn;
    public javax.swing.JTextField txttransactid;
    // End of variables declaration//GEN-END:variables
}
