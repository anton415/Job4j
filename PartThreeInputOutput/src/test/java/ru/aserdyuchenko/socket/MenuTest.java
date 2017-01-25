package main.java.ru.aserdyuchenko.socket;

import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import org.junit.Test;

/**
 * @author Anton Serdyuchenko (anton415@gmail.com)
 */
public class MenuTest {
/**
 * Test.
 * @throws IOException	 		IOException.
 */
	@Test
	public void whenSeeDirectorySrc() throws IOException {
		Menu menu = new Menu(new String[] {"src", "SeeDirectory"});
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		menu.startMenu();
		assertThat(out.toString(), is("[main, test]"));
	}
/**
 * Test.
 * @throws IOException	 		IOException.
 */
	@Test
	public void whenSeeHomeDirectory() throws IOException {
		Menu menu = new Menu(new String[] {"src", "SeeDirectory"});
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		menu.startMenu();
		assertThat(out.toString(), is("[main, test]"));
	}
/**
 * Test.
 * @throws IOException	 		IOException.
 */
	@Test
	public void whenMenuChoiceDoNotCorrect() throws IOException {
		Menu menu = new Menu(new String[] {"QWER"});
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		menu.startMenu();
		assertThat(out.toString(), is("No correct"));
	}
/**
 * Test.
 * @throws IOException	 		IOException.
 */
	@Test
	public void whenSeeHomeThenSeeSrcThenGoHome() throws IOException {
		Menu menu = new Menu(new String[] {"GoHomeDirectory", "src/main", "SeeDirectory", "src", "SeeHomeDirectory"});
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		menu.startMenu();
		assertThat(out.toString(), is("[main, test][java][main, test]"));
	}
}
