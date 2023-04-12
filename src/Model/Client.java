package Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread{

	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	private String message;

	public void run() {
		try {
			clientSocket = new Socket("localhost", 9000);

			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			while(!clientSocket.isClosed()) {
				if(message != null) {
					out.println(message);
					this.message = null;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void setMessage(String msg) { this.message = msg; }
}