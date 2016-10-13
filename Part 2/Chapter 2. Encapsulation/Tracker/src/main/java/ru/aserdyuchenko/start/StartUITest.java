package ru.aserdyuchenko.start;

/**
 *This class fo testing, without console imput.
 */

public class StartUITest {
	private Input input;

	public StartUITest(Input input){
		this.input = input;
	}

	public void init(){
		String choice;
		do {
			choice = input.askMenuChoice("\n\nTracker Program. Used for accounting applications.\nThe application performs the following actions:\n1. Adding a new application\n2. Edit applications\n3. Removing the application\n4. Displays a list of all applications\n5. Exit\nPlease, enter your choice: ");
			input.menuChoice(Integer.parseInt(choice));
		} while (Integer.parseInt(choice) != 5);
	}

	public static void main(String[] args){
		Input input = new StubInput(new String[] {"1","4","5"});
		new StartUITest(input).init();
	}
}
