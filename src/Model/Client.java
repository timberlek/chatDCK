package Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import View.PanelClient;

public class Client extends Thread{

	private final int PORT = 9000;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	private String message;
	private String pseudo;
	private PanelClient pnlClt;
	private boolean bPseudo = false;

	public Client(PanelClient pnlClt) {
		this.pnlClt = pnlClt;
	}

	public void run() {
		try {
			clientSocket = new Socket("172.26.7.35", 9000);

			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			this.pnlClt.appendTxt(in.readLine());

			while(!clientSocket.isClosed()) {

				if(bPseudo == false) {
					if(message != null) {
						out.println(message);
						this.message = null;
						bPseudo = true;
					}
				}

				if(bPseudo)
					if(message != null) {				
						out.println(message);
						this.message = null;
					}
					
				if(in.ready()) {
					this.pnlClt.appendTxt(in.readLine());
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void setMessage(String msg) { this.message = msg; }
	public String getPseudo(){return this.pseudo;}
}