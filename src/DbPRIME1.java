
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DbPRIME1 {

	      static Connection conn = null;
	      public static Connection   dbConnector() {
	      try {
	         Class.forName("org.postgresql.Driver");
	        conn = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/students",
	            "postgres", "12345");
	      } catch (Exception e) {
	         JOptionPane.showMessageDialog(null, e);
	         
	        
	      
	      }
		return conn;
	
	      
	   
	

}
		public String getStudents() {
			// TODO Auto-generated method stub
			return null;
		}
}
	  