package ru.aserdyuchenko.start;

import java.util.*;
import ru.aserdyuchenko.models.Task;
import ru.aserdyuchenko.models.Item;

/**
 *This class fo testing, without console imput.
 */

public class StubInput implements Input {
	private String[] answers;
	private int position = 0;
	Tracker tracker = new Tracker();

	public StubInput(String[] answers) {
		this.answers = answers;
	}

	public String askMenuChoice(String menuQuestion) {
		return answers[position++];
	}

	public String askNameForNewItem(String nameForNewItem){
		return answers[position++];
	}

	public String askDescForNewItem(String descForNewItem){
		return answers[position++];
	}

	public String askItemId(String itemId){
		return answers[position++];
	}

	public int menuChoice(int choice) {
		/**
		 * Add new item
		 */
		if (choice == 1) {
			System.out.println("Your choice is: Adding a new application.");
			String name = new StubInput(new String[] {"first name"}).askNameForNewItem("Enter name for new item: ");
			System.out.format("Your enter name: %s", name);
			String desc = new StubInput(new String[] {"first desc"}).askDescForNewItem("Enter desc for new item: ");
			System.out.format("\nYour enter desc: %s", desc);
			tracker.add(new Task(name, desc));
			System.out.println("\nAdd new item.");
		/**
		 * Edit item
		 */
		} else if (choice == 2) {
			System.out.println("Your choice is: Edit applications.");
			System.out.println("Item is edit.");
		/**
		 * Remove item
		 */
		} else if (choice == 3) {
			System.out.println("Your choice is: Removing the application.");
			System.out.println("Item is removing.");
		/**
		 * Displays a list of all item
		 */
		} else if (choice == 4) {
			System.out.println("Your choice is: Displays a list of all applications.");
			for (Item item : tracker.getAll()){
            	if (item != null){
               		System.out.println("Item Id: " + item.getId());
					System.out.println("Name: " + item.getName());
					System.out.println("Desc: " + item.getDescription());
				/**
		 		 * if this item already remove
		 		 */
            	} else {
                	System.out.println("Now, this item is null");
            	}
			}
			System.out.println("Displays a list of all applications.");
		/**
		 * Exite
		 */
		} else if (choice == 5) {
			System.out.println("Your choice is: Exite.");
		/**
		 * if you console number dont 1-5
		 */
		} else {
			System.out.println("Your choice is incorrect, please enter number from 1 to 5!");
		}
	return choice;
	}
}
