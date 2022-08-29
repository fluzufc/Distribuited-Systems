package src.ufcqx.object;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerObject {
    public static void main(String[] args) {
        
        try {
            // Starting the server
            ServerSocket server = new ServerSocket(3322);
            System.out.println("Server started on port 3322");

            // Accepting a client
            Socket client = server.accept();
            System.out.println("Connected to client IP: " + client.getInetAddress().getHostAddress());
            
            //Reading client's data
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());

            Person person = (Person)in.readObject();
            System.out.println(person.toString());
            

            //Closing
            in.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}