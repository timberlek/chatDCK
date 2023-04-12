package src.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{

	private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;
    private Server server;

    public ClientThread(Socket socket, Server server) {
        this.clientSocket = socket;
        this.server = server;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("Bienvenue sur le serveur de chat !");

            while (true) {
                String inputLine = in.readLine();
                if (inputLine == null) {
                    break;
                }
                System.out.println("Message recu de " + clientSocket.getInetAddress().getHostAddress() + ": " + inputLine);
                server.sendMsg(inputLine);
            }

            System.out.println("Connexion fermee par " + clientSocket.getInetAddress().getHostAddress());
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
