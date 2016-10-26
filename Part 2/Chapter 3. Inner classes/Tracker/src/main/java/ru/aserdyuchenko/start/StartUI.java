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
 *
 */

/**
 * @author Anton Serdyuchenko
 * @since 27.09.2016
 * @version 3.0
 */

public class StartUI {
	private Input input;

	public StartUI(Input input){
		this.input = input;
	}

	public void init(){
		Tracker tracker = new Tracker();
		MenuTracker menu = new MenuTracker(this.input, tracker);
		menu.fillActions();
		do {
			menu.show();
			int key = Integer.valueOf(input.askMenuChoice("Select: "));
			menu.select(key);
		} while (!"4".equals(this.input.askMenuChoice("Exit? (4): ")));
	}

	public static void main(String[] args){
		Input input = new ConsoleInput();
		new StartUI(input).init();
	}
}
