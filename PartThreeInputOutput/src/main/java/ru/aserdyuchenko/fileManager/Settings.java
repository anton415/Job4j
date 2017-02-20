package ru.aserdyuchenko.fileManager;

/**
 * Необходим для чтения app.properties.
 */
interface Settings {
/**
 * Метод для чтения app.properties.
 */
	String getValue(String key);
}
