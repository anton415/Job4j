package main.java.ru.aserdyuchenko.socket;

import java.io.IOException;
/**
 * @author Anton Serdyuchenko (anton415@gmail.com)
 */
public class Menu {
/**
 * @param client				client.
 */
	private Client client = new Client();
/**
 * @param answers				answers.
 */
	private static String[] answers;
/**
 * @param position				position.
 */
	private int position = 0;
/**
 * Constructor for answers.
 * @param userInput				userInput.
 */
	Menu(String[] userInput) {
		setAnswers(userInput);
		setPosition(userInput.length - 1);
	}

/**
 * @throws IOException	 		IOException.
 */
	public void startMenu() throws IOException {
		String homeDirectory = ".";

		while (position >= 0) {
			String choice = answers[position--];
			if (choice.equals("SeeDirectory")) {
				client.seeDirectory(answers[position--]);
			} else if (choice.equals("SeeHomeDirectory")) {
				homeDirectory = answers[position--];
				client.seeDirectory(homeDirectory);
			} else if (choice.equals("GoHomeDirectory")) {
				client.seeDirectory(homeDirectory);
			} else {
				System.out.print("No correct");
			}
		}
	}
/**
 * @return this.answers			answers.
 */
	public String[] getDirectory() {
		return this.answers;
	}
/**
 * @param userInput				userInput.
 */
	public void setAnswers(String[] userInput) {
		this.answers = userInput;
	}
/**
 * @param userInput				userInput.
 */
	public void setPosition(int userInput) {
		this.position = userInput;
	}
}
