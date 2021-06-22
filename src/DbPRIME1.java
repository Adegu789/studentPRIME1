
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DbPRIME1 {

	      Connection conn = null;
	      public void   dbConnector() {
	      try {
	         Class.forName("org.postgresql.Driver");
	        conn = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/students",
	            "postgres", "12345");
	      } catch (Exception e) {
	         JOptionPane.showMessageDialog(null, e);
	         
	        
	      
	      }
		
	      
	   
	

}
	      
	      public String getStudents() {
	  		String query = "select * from students";
	  		String showResponse="<p><table>";
	  		try {
	  			Statement statement = (Statement) conn.createStatement();
	  			ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(query);
	  			while(resultSet.next()) {
	  				showResponse += "<tr><td>"+ resultSet.getString("student_name")+ "</td></tr>";
	  				
	  			}
	  			showResponse += "<table></p>";
	  		}catch(SQLException e) {
	  			System.out.println("Sql connection error" + e);
	  			
	  		}
	  		return showResponse;
	  	}
}
