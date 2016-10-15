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
	private Scanner scanner = new Scanner (System.in);
	Tracker tracker = new Tracker();

	public String askMenuChoice(String menuQuestion){
		System.out.print(menuQuestion);
		return scanner.nextLine();
	}

	public String askNameForNewItem(String nameForNewItem){
		System.out.print(nameForNewItem);
		return scanner.nextLine();
	}

	public String askDescForNewItem(String descForNewItem){
		System.out.print(descForNewItem);
		return scanner.nextLine();
	}

	public String askItemId(String itemId){
		System.out.print(itemId);
		return scanner.nextLine();
	}

	public void addNewItem(){
		System.out.println("Your choice is: Adding a new application.");
		tracker.add(new Task("first name", "first desc"));
		System.out.println("Add new item.");
	}

	public void editItem(){
		System.out.println("Your choice is: Edit applications.");
		String itemId = tracker.findIdByName("first name");
		tracker.updateItem(itemId, new Task("new edit first name", "new edit first description"));
		System.out.println("Item is edit.");
	}

	public void removeItem(){
		System.out.println("Your choice is: Removing the application.");
		String itemId = tracker.findIdByName("first name");
		tracker.delete(itemId);
		System.out.println("Item is removing.");
	}

	public void displaysAListOfAllItem(){
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
	}

	public int menuChoice(int choice) {
		/**
		 * Add new item
		 */
		if (choice == 1) {
		/**
		 * Add new item
		 */
			addNewItem();

		} else if (choice == 2) {
		/**
		 * Edit item
		 */
			editItem();

		} else if (choice == 3) {
		/**
		 * Remove item
		 */
			removeItem();

		} else if (choice == 4) {
		/**
		 * Displays a list of all item
		 */
			displaysAListOfAllItem();

		} else if (choice == 5) {
		/**
		 * Exite
		 */
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
