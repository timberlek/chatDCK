package src;

import java.io.IOException;

import src.app.Server;

public class Main {
	private static final int PORT = 9000;

	public static void main(String[] args) throws IOException {
		new Server(PORT);
	}
}