	package src.ufcqx.scannerthread;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientThreadScanner {
	
	//Creating socket and out-stream
	private Socket client;
	private PrintStream out; 
	
	public ClientThreadScanner() {
		try {
			//Starting the socket
			this.client = new Socket("127.0.0.1", ServerThreadScanner.port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String message) {
		try {
			out = new PrintStream(this.client.getOutputStream());
			out.println(message);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		if(this.out!=null)
			this.out.close();
	}
	
	public static void main(String[] args) {
		try {
			ClientThreadScanner client = new ClientThreadScanner();
			client.sendMessage("oi");
			ServerSocket clientServer = new ServerSocket(ServerThreadScanner.port);
			Socket serv = clientServer.accept();

			try {
				Scanner in;
				try {
					in = new Scanner(serv.getInputStream());
					while(in.hasNextLine()) {
						System.out.println(serv.getInetAddress().getHostAddress() + " >>> " + in.nextLine());
					}
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				clientServer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
