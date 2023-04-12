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

	private String username;
	private String password;

    public ClientThread(Socket socket, String username, String password, Server server) {
        this.clientSocket = socket;
		this.username     = username;
		this.password     = password;
		this.server       = server;
    }


    public ClientThread(Socket socket, Server server) {
        this.clientSocket = socket;
        this.server = server;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
			Scanner sc = new Scanner(System.in);

			if(this.username == null)
			{
				System.out.println("Username :");
				this.setUsername(sc.nextLine());
			}
			
			
			if(this.password == null)
			{
				System.out.println("Nouveau password :");
				this.setPassword(sc.nextLine());
			}
			else
			{
				System.out.println("Password :");
				if (sc.nextLine() != this.password)
				{
					break;
				}
			}

            out.println("Bienvenue sur le serveur de chat !");

            while (true) {
                String inputLine = in.readLine();
                if (inputLine == null) {
                    break;
                }
                System.out.println("Message recu de " + this.getUsername() + " : " + inputLine);
                server.sendMsg(inputLine);
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
