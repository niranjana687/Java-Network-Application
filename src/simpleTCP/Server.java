package simpleTCP;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public Server() throws Exception {
		ServerSocket serverSocket = new ServerSocket(6969); //opening a new port
		System.out.println("Port 6969 is open");
		
		Socket socket = serverSocket.accept();
		System.out.println("Client: " + socket.getInetAddress() + " has connected");
	}
	
	public static void main(String[] args) {
		
		try {
			new Server();
		} catch (Exception e) {
			//TODO exception 
			e.printStackTrace();
		}
	}
}
