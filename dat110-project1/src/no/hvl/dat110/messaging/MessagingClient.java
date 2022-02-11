package no.hvl.dat110.messaging;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import no.hvl.dat110.TODO;

public class MessagingClient {

	private String server;
	private int port;

	public MessagingClient(String server, int port) {
		this.server = server;
		this.port = port;
	}

	// connect to messaging server
	public Connection connect() {

		Socket clientSocket = null;
		Connection connection = null;

		System.out.println("Client CONNECTING");
//		 TODO - START
		try {

			clientSocket = new Socket(server, port);

			connection = new Connection(clientSocket);

		} catch (Exception e) {
			System.out.println("Connection feil: " + e.getMessage());
			e.printStackTrace();
		}

		// create TCP socket for client and connection

		// TODO - END
		return connection;
	}
}
