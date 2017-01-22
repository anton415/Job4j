package ru.aserdyuchenko.socket;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.apache.commons.io.output.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author Anton Serdyuchenko (anton415@gmail.com)
 * @version 1
 * @since 20.01.2017
 */

public class ServerTest {
/**
 * @throws Exception		Exception.
 */
	@Test
	public void whenYouWantGoToDirectorySrcMain() throws Exception {
		Server server = new Server();
		String directory = "src/main";
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		InputStream input = new ByteArrayInputStream(directory.getBytes());
		server.showDirectory(input, out);
		assertThat(out.toString(), is("[java]"));
	}
}
