package main.java.ru.aserdyuchenko.SocketBot;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Anton Serdyuchenko (anton415@gmail.com)
 */
public class Server {
/**
 * @param NUMBERONE - NUMBERONE.
 */
public static final int NUMBERONE = 5000;

/**
 * @throws IOException	 		IOException.
 */
	public void startServer() throws IOException {
		Client client = new Client();

		ServerSocket serverSocket = new ServerSocket(NUMBERONE);
		client.startClient();

		Socket socket = serverSocket.accept();

		InputStream inputStream = socket.getInputStream();

		DataInputStream dataInputStream = new DataInputStream(inputStream);
		startTalk(dataInputStream);

		serverSocket.close();
	}
/**
 * @param dataInputStream		dataInputStream.
 * @throws IOException	 		IOException.
 */
	public void startTalk(DataInputStream dataInputStream) throws IOException {
		String clientInput = dataInputStream.readUTF();
		if (clientInput.equals("hello oracle")) {
			System.out.print("Hello, dear friend, I'm a oracle.");
		} else if (clientInput.equals("exit")) {
			System.out.print("Goodbye.");
		} else {
			System.out.print("I am oracle.");
		}
	}
}
