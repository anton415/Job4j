package ru.aserdyuchenko.fileManager;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author Anton Serdyuchenko (anton415@gmail.com).
 * jUnit test for class RealizationSettings.
 */
public class RealizationSettingsTest {
/**
 * Test load app.properties.
 * @throws Exception - Exception.
 */
// Петр, я не могу разобраться, почему у меня не работает ClassLoader.
// Делал всё также, как ты показывал на видео.
// Подскажи пожалуйста, в чем проблема?
/*
	@Test
	public void whenClassLoader() throws Exception {
		RealizationSettings settings = new RealizationSettings();
		ClassLoader loader = RealizationSettings.class.getClassLoader();
		try (InputStream io = loader.getResourceAsStream("app.properties")) {
			settings.load(io);
		}
		String value = settings.getValue("home.path");
		assertThat(value, is("c:\\temp\\"));
	}
*/

/**
 * Test load app.properties.
 * @throws Exception - Exception.
 */
	@Test
	public void whenLoadThenGetFile() throws Exception {
		RealizationSettings settings = new RealizationSettings();
		File file = new File("./src/resources/app.properties");
		try (FileInputStream io = new FileInputStream(file)) {
			settings.load(io);
		}
		String value = settings.getValue("number.port");
		assertThat(value, is("5000"));
	}
}
