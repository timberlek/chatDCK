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

	private String username;
	private String password;

    public ClientThread(Socket socket, String username, String password) {
        this.clientSocket = socket;
		this.username     = username;
		this.password     = password;
    }

	public ClientThread(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("Bienvenue sur le serveur de chat !");

            while (true) {
                String inputLine = in.readLine();
                if (inputLine.equals("STOP")) {
                    break;
                }
                System.out.println("Message recu de " + this.getUsername() + " : " + inputLine);
            }

            System.out.println("Connexion fermee par " + this.getUsername());
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
