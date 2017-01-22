package ru.aserdyuchenko.socket;

import java.util.Arrays;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * @author Anton Serdyuchenko (anton415@gmail.com)
 * @version 1
 * @since 20.01.2017
 */
public class Server {
/**
 * @param NUMBERONE - NUMBERONE.
 */
public static final int NUMBERONE = 5000;
/**
 * @param inputStream			InputStream.
 * @param outputStream			OutputStream.
 * @throws IOException	 		IOException.
 */
	public void showDirectory(InputStream inputStream, OutputStream outputStream) throws IOException {
        int port = NUMBERONE;
		try (Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(inputStream)))) {
			while (reader.hasNext()) {
            	ServerSocket serverSocket = new ServerSocket(port);
            	Socket socket = serverSocket.accept();

	            InputStream socketInStr = socket.getInputStream();
	            OutputStream socketOutStr = socket.getOutputStream();

            	DataInputStream in = new DataInputStream(socketInStr);
				DataOutputStream out = new DataOutputStream(socketOutStr);

				String clientInput = reader.next();
				String[] list = new File(clientInput).list();
				outputStream.write(Arrays.toString(list).getBytes());
				serverSocket.close();
			}
		}
	}
}
