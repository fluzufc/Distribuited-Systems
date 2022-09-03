package src.ufcqx.object;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientObject {
    
    private Socket client;

    public ClientObject() {
        try {
            this.client = new Socket("127.0.0.1", 3322);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendObject(Person person) {
        ObjectOutputStream out;

        try {
            out = new ObjectOutputStream(this.client.getOutputStream());
            out.writeObject(person);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClientObject client = new ClientObject();
        client.sendObject(new Person("Fábio", 20));
    }
}
