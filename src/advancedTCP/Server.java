package advancedTCP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public Server() throws Exception {
		
		var serverSocket = new ServerSocket(6969); //opening a new port.
		System.out.println("Port 6969 is open");
		
		Socket socket = serverSocket.accept();
		System.out.println("Client: " + socket.getInetAddress() + " has connected");
		
		// I/O Buffers.
		BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter outSocket = new PrintWriter(new OutputStreamWriter (socket.getOutputStream()));
		
		String message;
		int secretNumber = (int)(Math.random()*10+1);
		
		do {
			outSocket.println("Guess a number [1-10]: ");
			message = inSocket.readLine();
		} while ( !(Integer.parseInt(message) == secretNumber));
		
		outSocket.println("You got the number right! \n Exiting the app");
		
		serverSocket.close();
		socket.close();
		System.out.println("Socket is closed");
				
	}
	
	public static void main(String[] args) {
		
		try {
			new Server();
			
		} catch (Exception e) {
			//TODO: handle  exception 
			e.printStackTrace();
		}
	}
}