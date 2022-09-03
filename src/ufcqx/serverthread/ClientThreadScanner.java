package src.ufcqx.serverthread;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientThreadScanner {
	
	//Creating socket and out-stream
	private Socket client;
	private PrintStream out;
	
	public ClientThreadScanner() {
		try {
			//Starting the socket
			this.client = new Socket("172.18.102.141", ServerThreadScanner.port);
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
		ClientThreadScanner client = new ClientThreadScanner();
		client.sendMessage("Eae boy");
	}

}
