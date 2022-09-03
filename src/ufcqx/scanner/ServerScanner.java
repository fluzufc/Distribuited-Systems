package src.ufcqx.scanner;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerScanner {
	
	//Setting default port
	public final static int port = 3345;
	
	public static void main(String[] args) {
		
		try {
			//Starting the server
			ServerSocket server = new ServerSocket(ServerScanner.port);
			System.out.println("Server started on port: " + ServerScanner.port);
			
			//Accepting a client
			Socket client = server.accept();
			System.out.println("Client connected with IP: " 
			+ client.getInetAddress().getHostAddress());
			
			//Reading data from the client
			Scanner in = new Scanner(client.getInputStream());
			while(in.hasNextLine()) {
				System.out.println(in.nextLine());
			}
			
			//Closing in-stream and the server
			in.close();
			server.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}