
import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class ServerHandler implements HttpHandler {
	
	@Override    
	public void handle(HttpExchange httpExchange) {
		System.out.println("Reached handle");
		
		String sInput = httpExchange.getRequestURI().toString();
		System.out.println(sInput);
		
		 handleResponse(httpExchange);
		
	}
	
	
	
	 private void handleResponse(HttpExchange httpExchange )  {
		 webviewer web= new webviewer();
		 web.connect(); 
		 String resp=web.readstudents();
		 web.close();
		 
		 
		 try {
			 OutputStream outputStream = httpExchange.getResponseBody();
			  StringBuilder createHtml = new StringBuilder();
			  createHtml.append("<html>")
			  .append("<body>")
			  .append("<h1>")
			  .append("Students Records ")
			  .append("</h1>")
			  .append(resp)
			  .append("</body>")
			  .append("</html>");
			  // encode HTML content 
			  String htmlResponse = createHtml.toString();
			  // this line is a must
			  httpExchange.sendResponseHeaders(200, htmlResponse.length());
			  
			  outputStream.write(htmlResponse.getBytes());
			  outputStream.flush();
			  outputStream.close();
		 } catch (IOException ex){
			 System.out.println("SERver has an error, " + ex);
			 
		 }

	 
 }



}
