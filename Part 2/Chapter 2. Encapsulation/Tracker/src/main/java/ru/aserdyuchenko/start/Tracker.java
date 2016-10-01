package ru.aserdyuchenko.start;

import ru.aserdyuchenko.models.*;
import java.util.*;

/**
 * В данном классе хранятся все заявки.
 * Возможно добавлять, редактировать и удалять заявки, также 
 * возможен вывод списка всех заявок и вывод списка по фильтру.
 */

public class Tracker {
	private Item[] items = new Item[10];
	private int position = 0;
	private static final Random RN = new Random(); 
/**
 * Добавление заявок
 */
	public Item add(Item item) {
		item.setId(this.generateId());
		this.items[position++] = item;
		return item;	
	}
/**
 * Поиск по id
 */
	protected Item findById(String id) {
		Item result = null;
		for (Item item : items)	{
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}
/**
 * Поиск по name
 */
	protected Item findByName(String name) {
		Item result = null;
		for (Item item : items)	{
			if (item != null && item.getName().equals(name)) {
				result = item;
				break;
			}
		}
		return result;
	}
/**
 * Создание id
 */
	String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
	}
/**
 * Вывод всех заявок
 */
	public Item[] getAll() {
		Item[] result = new Item[position];
		for (int index=0; index!=this.position; index++) {
			result[index] = this.items[index];		
		}
		return result;
	}
/**
 * Редактирование описания
 */
	public Item editingDesc(Item item, String newDescription){
		item.setDescription(newDescription);	
		return item;		
	}
/**
 * Удаление заявки
 */
	public Item removal(Item item) {
		item.setId(this.generateId());
		this.items[position--] = item;
		return item;	
	}
}
