package main.java.ru.aserdyuchenko.SocketBot;

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
 * @param userInput				userInput.
 */
	private static String userInput;
/**
 * @param NUMBERONE - NUMBERONE.
 */
public static final int NUMBERONE = 5000;

/**
 * @throws IOException	 		IOException.
 * @param userInput				userInput.
 */
	public void startTalk(String userInput) throws IOException {
		setUserInput(userInput);
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

			dataOutputStream.writeUTF(userInput);
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
		public String getUserInput() {
			return this.userInput;
		}
	/**
	 * @param userInput				userInput.
	 */
		public void setUserInput(String userInput) {
			this.userInput = userInput;
		}
}
