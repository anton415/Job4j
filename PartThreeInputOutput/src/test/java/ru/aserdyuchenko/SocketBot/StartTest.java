package main.java.ru.aserdyuchenko.SocketBot;

import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
/**
 * @author Anton Serdyuchenko (anton415@gmail.com)
 */
public class StartTest {
/**
 * Test.
 * @throws IOException	 		IOException.
 */
	@Test
	public void whenSayHelloAndExit() throws IOException {
		Start start = new Start(new String[] {"hello oracle", "exit"});
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		start.startApplication();
		assertThat(out.toString(), is("Goodbye.Hello, dear friend, I'm a oracle."));
	}
/**
 * Test.
 * @throws IOException	 		IOException.
 */
	@Test
	public void whenSayHello() throws IOException {
		Start start = new Start(new String[] {"hello oracle"});
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		start.startApplication();
		assertThat(out.toString(), is("Hello, dear friend, I'm a oracle."));
	}
}
