package main.java.ru.aserdyuchenko.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * @author Anton Serdyuchenko (anton415@gmail.com)
 */
public class Client {
/**
 * @param directory				directory.
 */
private static String directory;
/**
 * @param NUMBERONE				NUMBERONE.
 */
public static final int NUMBERONE = 5000;

/**
 * @param userInput				userInput.
 * @throws IOException	 		IOException.
 */
	public void seeDirectory(String userInput) throws IOException {
		setDirectory(userInput);
		Server server = new Server();
		server.startServer();
	}
/**
 * Start client.
 */
	public void startClient() {
		try {
			Socket socket = new Socket("127.0.0.1", NUMBERONE);

			OutputStream outputStream = socket.getOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

			dataOutputStream.writeUTF(getDirectory());
			dataOutputStream.flush();
			socket.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
/**
 * @return this.directory		directory.
 */
	public String getDirectory() {
		return this.directory;
	}
/**
 * @param userInput				userInput.
 */
	public void setDirectory(String userInput) {
		this.directory = userInput;
	}
}
