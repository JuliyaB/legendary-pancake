package Homework2_6;

import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
        new Thread() {
            public void run() {
                while (true) {
                    String message = null;
                    try {
                        message = server.inReader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (message != null) {
                        try {
                            server.sendMessage(message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                try {
                    server.writeToConsole();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

class Server {
    ServerSocket serverSocket=null;
    Socket sock=null;
    PrintWriter writer=null;
    BufferedReader reader=null, inReader=null;

    public void start() throws IOException {
        serverSocket = new ServerSocket(8189);
        System.out.println("Сервер запущен. В ожидании клиента...");
        sock = serverSocket.accept();
        System.out.println("Клиент подключен.");
        inReader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        writer = new PrintWriter(sock.getOutputStream(),true);
    }

    public void sendMessage(String message) throws IOException {
        if (message.equalsIgnoreCase("конец")){
            writer.close();
            inReader.close();
            reader.close();
            sock.close();
            serverSocket.close();
        }
        writer.println("Клиент: " + message);
        System.out.println(message);
    }

    public void writeToConsole() throws IOException {
        while (true) {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String message = reader.readLine();
            sendMessage(message);
        }
    }
}
