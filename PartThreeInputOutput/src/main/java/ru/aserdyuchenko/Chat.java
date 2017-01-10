package ru.aserdyuchenko;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.RandomAccessFile;

/**
 * Class Chat.
 * @author Anton Serdyuchenko (anton415@gmail.com)
 * @version 2
 * @since 06.01.2017
 */
public class Chat {
/**
 * @param isSwitchOn		Switch on, then bot answer to you.
 */
	private boolean isSwitchOn = true;
/**
 * @param userInput			This string for work with user input.
 */
	private String userInput;
/**
 * @param in					InputStream.
 * @throws IOException	 		IOException.
 */
	public void start(InputStream in) throws IOException {
		try (Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(in)))) {
			RandomAccessFile historyFile = new RandomAccessFile("history.txt", "rw");
			RandomAccessFile answerFile = new RandomAccessFile("answer.txt", "r");
			while (reader.hasNext()) {
				userInput = reader.next();
				if (userInput.equals("stop")) {
					historyFile.writeBytes(userInput);
					historyFile.writeBytes("\n");
					isSwitchOn = false;
				} else if (userInput.equals("continue")) {
					historyFile.writeBytes(userInput);
					historyFile.writeBytes("\n");
					isSwitchOn = true;
				} else if (userInput.equals("end")) {
					historyFile.writeBytes(userInput);
					break;
				} else {
					historyFile.writeBytes(userInput);
					historyFile.writeBytes("\n");
					if (isSwitchOn) {
						historyFile.writeBytes(answerFile.readLine());
						historyFile.writeBytes("\n");
					}
				}
			}
		}
		System.out.print("end");
	}
}
