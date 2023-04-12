package src.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread extends Thread{

	private Socket clientSocket;
    private String pseudo;
    private BufferedReader in;
    private PrintWriter out;
    private Server server;

    public ClientThread(Socket socket, Server server,String pseudo) 
    {
        this.clientSocket = socket;
        this.server = server;
        this.pseudo = pseudo;
    }

    public void run() {

		boolean bool = true;

        try {

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
			Scanner sc = new Scanner(System.in);
			

            out.println("Bienvenue sur le serveur de chat !");

            while (bool) {
                String inputLine = in.readLine();
                if (inputLine == null) {
                    break;
                }
                System.out.println("Message recu de " + clientSocket.getInetAddress().getHostAddress() + " : " + inputLine);
                server.sendMsg(this.pseudo + ": " + inputLine);
            }

            System.out.println("Connexion fermee par " + clientSocket.getInetAddress().getHostAddress());
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() { return this.clientSocket; }

}
