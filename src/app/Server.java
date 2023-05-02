package src.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;


public class Server
{
	private LinkedList<ClientThread> threads;

	public Server(int port) throws IOException {
		ServerSocket serverSocket = new ServerSocket(port);
		threads = new LinkedList<ClientThread>();

		System.out.println("Le serveur de chat est en ligne sur le port 9000...");

		while (true) {
			Socket clientSocket = serverSocket.accept();
			System.out.println("Nouvelle connexion de " + clientSocket.getInetAddress().getHostAddress());

            //Recup pseudo
            String pseudo="";

			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

			//Flag : 5f4ky478l1qs35d178ksd5
			if (!in.readLine().equals("5f4ky478l1qs35d178ksd5")) {
				out.println("Flag non reconnue !");
				System.out.println("Connexion fermee par " + clientSocket.getInetAddress().getHostAddress());
				clientSocket.close();
			} else {
				out.println("Rentrez votre pseudo : ");
				pseudo = in.readLine();

				threads.add( new ClientThread(clientSocket, this, pseudo));
				threads.getLast().start();
			}
		}
	}

	public void sendMsg(String msg) throws IOException {
		for(ClientThread client : threads) {
			if(!client.getSocket().isClosed()) {
				PrintWriter out = new PrintWriter(client.getSocket().getOutputStream(), true);
				out.println(msg);
			}
		}
	}
}
