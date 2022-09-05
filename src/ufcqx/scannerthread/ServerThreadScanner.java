package src.ufcqx.scannerthread;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerThreadScanner {
        
    private Socket serv;

    //Setting default port
    public final static int port = 80;

    public ServerThreadScanner(String ip, int porta) {
        try {
            this.serv = new Socket(ip, porta);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 

    public void responseMessage(String res) {
        try {
            PrintStream out = new PrintStream(this.serv.getOutputStream());
            out.println(res);
            out.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        
        int clientNumbers = 0;
        
        try {
            //Starting the server
            ServerSocket server = new ServerSocket(ServerThreadScanner.port);
            System.out.println("Server started on port: " + ServerThreadScanner.port);
            
            Socket client = server.accept();
            clientNumbers++;
            System.out.println("Client connected with IP: " + client.getInetAddress().getHostAddress());
            new ServerWorkerThreadScanner(client, clientNumbers).start();
            ServerThreadScanner serv = new ServerThreadScanner(client.getInetAddress().getHostAddress(), ServerThreadScanner.port);

            while(!client.isClosed()) {
                InputStream msg = client.getInputStream();
                if (msg.equals("oi"))
                    serv.responseMessage("tudo bom :)");
                else if (msg.equals("tchau"))
                    serv.responseMessage("até mais :)");
                else
                    serv.responseMessage("não entendi :)");
            }

            server.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
