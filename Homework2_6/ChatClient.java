package Homework2_6;

import java.io.*;
import java.net.*;


public class ChatClient {
    public static void main(String[] args) throws IOException {
        Client client = new Client();
        new Thread() {
            public void run() {
                try {
                    client.readMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            public void run() {
                try {
                    client.sendMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

class Client {
    Socket sock=null;
    PrintWriter writer=null;
    String clientMessage, serverMessage;
    BufferedReader reader=null, inReader=null;

    public Client() throws IOException {

        sock = new Socket("localhost", 8189);
        inReader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        writer = new PrintWriter(sock.getOutputStream(), true);
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Сеть установлена.");
    }

    public void readMessage() throws IOException {
        while (true) {
            if ((serverMessage = inReader.readLine()) != null){
            System.out.println(serverMessage);
        }
        }
    }

    public void sendMessage() throws IOException {
        while (true) {
            if ((clientMessage = reader.readLine()) != null) {
                writer.println(clientMessage);
                if (clientMessage.equalsIgnoreCase("конец")) {
                    writer.close();
                    reader.close();
                    inReader.close();
                    sock.close();
                }
            }
        }
    }
}