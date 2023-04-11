package server.src.core;


import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.net.*;

public class Serveur
{
	private int port;

	public Serveur(int port)
	{
		this.port = port;
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
			System.out.println("un client est arrivé");

			PrintWriter   out   = new PrintWriter(toClient.getOutputStream(),true);
			BufferedReader in = new BufferedReader(new InputStreamReader(toClient.getInputStream()));

			out.println("connected");

		}
		catch(Exception e)
		{
			System.out.println("Ya un problème frerot");
		}




	}


}