package ru.aserdyuchenko.start;

import ru.aserdyuchenko.models.*;
/**
 * Программа Tracker. Служит для учета заявок.
 * Приложение осуществляет следующие действия:
 * 1. Добавление новой заявки
 * 2. Редактирования заявки
 * 3. Удаления заявки
 * 4. Отображение списка всех заявок
 * 5. Отображения заявок с условием фильтра
 * 6. Добавлять к заявки комментарий
 *
 * В заявке может быть следующая информация: имя, описание, дата
 * создания и список комментариев.
 */

/**
 * 1. Используя класс ConsoleInput в классе StartUI обеспечить
 * полноценную работу всего приложения
 * Используя класс ConsoleInput в классе StartUI обеспечить
 * полноценную работу всего приложения.
 * Пользователю должно отображаться меню.
 * Он может выйти из приложения и выполнять все действия
 * описанные в первом задании.
 */

/**
 * @author Anton Serdyuchenko
 * @since 27.09.2016
 * @version 2.0
 */

public class StartUI {
	private Input input;

	public StartUI(Input input){
		this.input = input;
	}

	public void init(){
		String choice;
		do {
			choice = input.askMenuChoice("\n\nTracker Program. Used for accounting items.\nThe item performs the following actions:\n1. Adding a new item\n2. Edit item\n3. Removing the item\n4. Displays a list of all items\n5. Exit\nPlease, enter your choice: \n\n");
			input.menuChoice(choice);
		} while (choice != "5");
	}

	public static void main(String[] args){
		Input input = new ConsoleInput();
		new StartUI(input).init();
	}
}
