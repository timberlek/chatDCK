package src;


import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.net.*;

public class Server
{
	private int port;

	public Server(int port)
	{
		this.port = port;
		run();
	}

	//Getteur
	public int getPort(){return this.port;}

	public void run()
	{
		try
		{
			ServerSocket ss = new ServerSocket(this.getPort());
			System.out.println("En attente d'un client");
			Socket toClient = ss.accept();
			System.out.println("un client est arrive");

			PrintWriter   out   = new PrintWriter(toClient.getOutputStream(),true);
			BufferedReader in = new BufferedReader(new InputStreamReader(toClient.getInputStream()));

			out.println("connected");

		}
		catch(Exception e)
		{
			System.out.println("Ya un probleme frerot");
		}




	}


}