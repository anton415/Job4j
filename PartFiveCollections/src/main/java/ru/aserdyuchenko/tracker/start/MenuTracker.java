package ru.aserdyuchenko.tracker.start;

import ru.aserdyuchenko.tracker.models.*;
import ru.aserdyuchenko.tracker.start.Input;
import ru.aserdyuchenko.tracker.start.Tracker;
import java.util.*;

class EditItem extends BaseAction {
	String nameAction;
	public EditItem(String nameAction) {
		super(nameAction);
		this.nameAction = nameAction;
	}

	public int key() {
		return 2;
	}

	public void execute (Input input, Tracker tracker) {
		System.out.println("Your choise, edit item!");
		String id = input.askItemId("Enter the taks`s id: ");
		String name = input.askNameForNewItem("Enter the taks`s name: ");
		String desc = input.askDescForNewItem("Enter the taks`s desc: ");
		Task task = new Task(name, desc);
		task.setId(id);
		tracker.updateItem(id, task);
	}

	public String info() {
		return String.format("%s. %s", this.key(), this.nameAction);
	}
}

class RemoveItem extends BaseAction {
	String nameAction;
	public RemoveItem(String nameAction) {
		super(nameAction);
		this.nameAction = nameAction;
	}

	public int key() {
		return 3;
	}

	public void execute (Input input, Tracker tracker) {
		System.out.println("Your choise, remove item!");
		String id = input.askItemId("Enter the taks`s id: ");
		tracker.delete(id);
	}

	public String info() {
		return String.format("%s. %s", this.key(), this.nameAction);
	}
}

public class MenuTracker {
	private Input input;
	private Tracker tracker;
	private List<UserAction> actions = new ArrayList<UserAction>();
	private int position = 0;

	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}

	public void fillActions() {
		this.actions.add(new AddItem("Add"));
		this.actions.add(new MenuTracker.ShowItems("Show"));
		this.actions.add(new EditItem("Edit"));
		this.actions.add(new RemoveItem("Remove"));
	}

	public void addAction(UserAction action) {
		this.actions.add(action);
	}

	public void select(int key) {
		this.actions.get(key).execute(this.input, this.tracker);
	}

	public void show() {
		for (UserAction action : this.actions) {
			if (action !=null) {
				System.out.println(action.info());
			}
		}
	}

	private class AddItem extends BaseAction {
		String nameAction;
		public AddItem(String nameAction) {
			super(nameAction);
			this.nameAction = nameAction;
		}

		public int key() {
			return 0;
		}

		public void execute(Input input, Tracker tracker) {
			System.out.println("Your choise, add new item!");
			String name = input.askNameForNewItem("Enter the taks`s name: ");
			String desc = input.askDescForNewItem("Enter the taks`s desc: ");
			tracker.add(new Task(name, desc));
		}

		public String info() {
			return String.format("%s. %s", this.key(), this.nameAction);
		}
	}

	private static class ShowItems extends BaseAction {
		String nameAction;
		public ShowItems(String nameAction) {
			super(nameAction);
			this.nameAction = nameAction;
		}

		public int key() {
			return 1;
		}

		public void execute(Input input, Tracker tracker) {
			System.out.println("Your choise, see all items!");
			for (Item item : tracker.getAll()) {
				if (item != null) {
					System.out.println(
						String.format("%s. %s", item.getId(), item.getName())
					);
				}
			}
		}

		public String info() {
			return String.format("%s. %s", this.key(), this.nameAction);
		}
	}
}
