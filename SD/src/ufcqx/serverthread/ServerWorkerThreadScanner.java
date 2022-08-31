package src.ufcqx.serverthread;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerWorkerThreadScanner extends Thread {
    private Socket client;
    private int id;

    public ServerWorkerThreadScanner(Socket client, int id) {
        this.client = client;
        this.id = id;
    }

    @Override
    public void run() {
                  
        Scanner in;
        try {
            in = new Scanner(client.getInputStream());
            while(in.hasNextLine()) {
                System.out.println(client.getInetAddress().getHostAddress() + " [" + this.id + "] >>> " + in.nextLine());
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
  
    }
}
