package src.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;


public class Server
{
	private LinkedList<Socket> threads;

	public Server(int port) throws IOException {
		ServerSocket serverSocket = new ServerSocket(port);
		threads = new LinkedList<Socket>();

		System.out.println("Le serveur de chat est en ligne sur le port 9000...");

		while (true) {
			Socket clientSocket = serverSocket.accept();
			System.out.println("Nouvelle connexion de " + clientSocket.getInetAddress().getHostAddress());
			threads.add(clientSocket);
			new ClientThread(clientSocket, this).start();
		}
	}

	public void sendMsg(String msg) throws IOException {
		for(Socket client : threads) {
			if(!client.isClosed()) {
				PrintWriter out = new PrintWriter(client.getOutputStream(), true);
				out.println(msg);
			}
		}
	}
}