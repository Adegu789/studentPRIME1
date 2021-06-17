
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DbPRIME1 {

	      Connection conn = null;
	      public static Connection dbConnector() {
	      try {
	         Class.forName("org.postgresql.Driver");
	         Connection conn = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/students",
	            "postgres", "12345");
	      } catch (Exception e) {
	         JOptionPane.showMessageDialog(null, e);
	         
	        
	         
	      }
		return null;
	      
	   
	

}
}
