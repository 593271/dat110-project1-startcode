package no.hvl.dat110.messaging;

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import no.hvl.dat110.TODO;

public class Connection {

	private DataOutputStream outStream; // for writing bytes to the TCP connection
	private DataInputStream inStream; // for reading bytes from the TCP connection
	private Socket socket; // socket for the underlying TCP connection

	public Connection(Socket socket) {

		try {

			this.socket = socket;

			outStream = new DataOutputStream(socket.getOutputStream());

			inStream = new DataInputStream(socket.getInputStream());

		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void send(Message message) {

		byte[] data;

		// TODO - START
		// encapsulate the data contained in the message and write to the output stream

		try {

			data = MessageUtils.encapsulate(message);
			outStream.write(data);

		} catch (IOException e) {
			System.out.println("FEIL I SENDER " + e);
			e.printStackTrace();
		}

		// TODO - END

	}

	public Message receive() {

		Message message = null;
		byte[] data;

		// TODO - START
		// read a segment from the input stream and decapsulate into message

		data = new byte[MessageUtils.SEGMENTSIZE];
		try {
			
			int read = inStream.read(data, 0, MessageUtils.SEGMENTSIZE);
			if (read != MessageUtils.SEGMENTSIZE) {

				throw new IOException("FEIL i RECEIVER");
			}
		} catch (Exception e) {
			System.out.println("FEIL I RECEIVER " + e.getMessage());
			e.printStackTrace();
		}
		
		message = MessageUtils.decapsulate(data);

		// TODO - END

		return message;

	}

	// close the connection by closing streams and the underlying socket
	public void close() {

		try {

			outStream.close();
			inStream.close();

			socket.close();

		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}