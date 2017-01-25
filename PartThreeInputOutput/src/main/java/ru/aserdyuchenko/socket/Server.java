package main.java.ru.aserdyuchenko.socket;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

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
		seeDirectory(dataInputStream);

		serverSocket.close();
	}
/**
 * @param dataInputStream		dataInputStream.
 * @throws IOException	 		IOException.
 */
	public void seeDirectory(DataInputStream dataInputStream) throws IOException {
		String clientInput = dataInputStream.readUTF();
		String[] list = new File(clientInput).list();
		System.out.print(Arrays.toString(list));
	}
}
