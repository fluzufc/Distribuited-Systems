package src.ufcqx.serverthread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThreadScanner {
        
    //Setting default port
    public final static int port = 3345;
    
    public static void main(String[] args) {

        int clientNumbers = 0;
        
        try {
            //Starting the server
            ServerSocket server = new ServerSocket(ServerThreadScanner.port);
            System.out.println("Server started on port: " + ServerThreadScanner.port);
            
            while(true) {
                Socket client = server.accept();
                clientNumbers++;
                System.out.println("Client connected with IP: " + client.getInetAddress().getHostAddress());
                new ServerWorkerThreadScanner(client, clientNumbers).start();
            }
            
            //server.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
