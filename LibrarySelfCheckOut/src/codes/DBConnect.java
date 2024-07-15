package codes;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class DBConnect {
    
    public static Connection connect(){
        
        Connection conn = null;
        
    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/libraryselfcheckout","root","");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error:main connection " + e.getMessage());
        }
        
        return conn;
    }
    
}