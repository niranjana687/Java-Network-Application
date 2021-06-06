package advancedTCP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public Client() throws Exception { 
		
		Socket socket = new Socket("localhost", 6969);
		System.out.println("Succesful connection to the server");
		
		//I/O Stream
		BufferedReader inSocket = new BufferedReader (new InputStreamReader (socket.getInputStream()));
		PrintWriter outSocket = new PrintWriter (new OutputStreamWriter (socket.getOutputStream()), true);
		var keyboard = new Scanner (System.in);
		String userNumber;
		
		while((inSocket.readLine()).startsWith("Guess")) {
			System.out.println("Server says: Guess a number [1-10] ");
			userNumber = keyboard.nextLine();
			outSocket.println(userNumber);
		}
		
		socket.close();
		System.out.println("Socket closed");
		
	}

	public static void main(String[] args) {
		try {
			new Client();
			
		} catch (Exception e) {
			//TODO exception
			e.printStackTrace();
		}
	}
	
	
}
