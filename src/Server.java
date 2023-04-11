package src;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
	public Server(int port) throws IOException {
		ServerSocket serverSocket = new ServerSocket(port);

		System.out.println("Le serveur de chat est en ligne sur le port 9000...");

		while (true) {
			Socket clientSocket = serverSocket.accept();
			System.out.println("Nouvelle connexion de " + clientSocket.getInetAddress().getHostAddress());
			new ClientThread(clientSocket).start();
		}
	}
}