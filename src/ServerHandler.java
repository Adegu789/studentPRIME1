
import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class ServerHandler implements HttpHandler {
	
	@Override    
	public void handle(HttpExchange httpExchange) {
		System.out.println("Reached handle");
		
		 handleResponse(httpExchange);
		
	}
	
	
	
	 private void handleResponse(HttpExchange httpExchange )  {
		 DbPRIME1 conn= new DbPRIME1();
		 conn.dbConnector(); 
		 String response=conn.getStudents();
		 
		 try {
			 OutputStream outputStream = httpExchange.getResponseBody();
			  StringBuilder createHtml = new StringBuilder();
			  createHtml.append("<html>")
			  .append("<body>")
			  .append("<h1>")
			  .append("Hello ")
			  .append("</h1>")
			  .append(response)
			  .append("</body>")
			  .append("</html>");
			  // encode HTML content 
			  String htmlResponse = createHtml.toString();
			  // this line is a must
			  httpExchange.sendResponseHeaders(200, htmlResponse.length());
			  outputStream.write(htmlResponse.getBytes());
			  outputStream.flush();
			  outputStream.close();
		 }catch (IOException e){
			 System.out.println("SERver has an error, " + e);
			 
		 }

	 
 }



}
