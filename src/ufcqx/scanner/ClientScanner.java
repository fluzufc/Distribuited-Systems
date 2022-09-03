package src.ufcqx.scanner;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientScanner {
	
	//Creating socket and out-stream
	private Socket client;
	private PrintStream out;
	
	public ClientScanner() {
		try {
			//Starting the socket
			this.client = new Socket("127.0.0.1", ServerScanner.port);
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
		ClientScanner client = new ClientScanner();
		client.sendMessage("A");
	}

}
