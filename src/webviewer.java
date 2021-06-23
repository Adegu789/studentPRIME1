import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class webviewer {
	Connection conn = null;

	
	public void connect( ) {
		try {
			String url = "jdbc:postgresql://localhost/students";
			conn = DriverManager.getConnection(url, "postgres", "invert");
		}catch(SQLException ex) {
			System.out.println("SQL DB Connecton error : " + ex);
			
		}
	}
	
	public String readstudents() {
		String resp = "<p><table><colgroup><col span=\"1\" ></colgroup><p><tr><th>Student Name</th><th>Registration Number</th><th>Course Taken</th><th>Marks</th><th>Average</th></tr></p>";
		String query ="select student_id, student_name, registration_number, course, marks, average from students";
		try {
			Statement stnt = conn.createStatement();
			ResultSet rs = stnt.executeQuery(query);
			while (rs.next()) {
				resp += " <tr><td>"+ rs.getString("student_name")+"</td><td>"+ rs.getString("registration_number")+"</td><td>"+ rs.getString("course")+"</td><td>"+ rs.getString("marks")+"</td><td>"+ rs.getString("average")+"</td></tr>";
				
				
			}
			resp += "</table></p>";
		}catch (SQLException ex) {
			System.out.println("SQL DB Connesction error : " + ex);
		}
		return resp;
	}
	public void close() {
		try {
			if(conn != null) conn.close();
		} catch(SQLException ex) {
			System.out.println("SQL DB Connection error : " + ex);
		}
	}

	public void dbConnector() {
		// TODO Auto-generated method stub
		
	}
}

	
	
	


