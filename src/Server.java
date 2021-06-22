import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;


public class Server {
	
	public static void main(String[]args) {
		
		System.out.println("Server is starting ....");
		
		Server S = new Server();
		S.init();
	}
	
	public void init() {
	try {
		HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8003), 0);
		server.createContext("/test", new  ServerHandler());
		//server.setExecutor(threadPoolExecutor);
		server.start();
	}
	catch(IOException ex) {
		System.out.println("io Exception on web server" + ex);
	}

}
}

