package ru.aserdyuchenko.start;

import java.util.*;
import ru.aserdyuchenko.models.Task;
import ru.aserdyuchenko.models.Item;

public class ConsoleInput implements Input{
	Tracker tracker = new Tracker();
	private Scanner scanner = new Scanner (System.in);

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

	public int menuChoice(int choice) {
		/**
		 * Add new item
		 */
		if (choice == 1) {
			System.out.println("Your choice is: Adding a new application.");
			String name = new ConsoleInput().askNameForNewItem("Enter name for new item: ");
			String desc = new ConsoleInput().askDescForNewItem("Enter desc for new item: ");
			tracker.add(new Task(name, desc));
			System.out.println("Add new item.");
		/**
		 * Edit item
		 */
		} else if (choice == 2) {
			System.out.println("Your choice is: Edit applications.");
			String itemId = new ConsoleInput().askItemId("Enter itemId for editing item: ");
			String name = new ConsoleInput().askNameForNewItem("Enter new name for item: ");
			String desc = new ConsoleInput().askDescForNewItem("Enter new desc for item: ");
			tracker.updateItem(itemId, new Task(name, desc));
			System.out.println("Item is edit.");
		/**
		 * Remove item
		 */
		} else if (choice == 3) {
			System.out.println("Your choice is: Removing the application.");
			String itemId = new ConsoleInput().askItemId("Enter itemId for removing item: ");
			tracker.delete(itemId);
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
