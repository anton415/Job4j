package main.java.ru.aserdyuchenko.SocketBot;

import java.io.IOException;
/**
 * @author Anton Serdyuchenko (anton415@gmail.com)
 */
public class Start {
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
		Start(String[] userInput) {
			setAnswers(userInput);
			setPosition(userInput.length - 1);
		}

	/**
	 * @throws IOException	 		IOException.
	 */
		public void startApplication() throws IOException {
			while (position >= 0) {
				client.startTalk(answers[position--]);
			}
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
