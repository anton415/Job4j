package main.java.ru.aserdyuchenko.socket;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
/**
 * @author Anton Serdyuchenko (anton415@gmail.com)
 */
public class ClientTest {
/**
 * Test.
 * @throws IOException	 		IOException.
 */
	@Test
	public void whenYouWantSeeDirectorySrc() throws IOException {
		Client client = new Client();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		client.seeDirectory();
		assertThat(out.toString(), is("[main, test]"));
	}

}
