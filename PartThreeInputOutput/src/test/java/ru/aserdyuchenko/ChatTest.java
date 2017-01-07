package ru.aserdyuchenko;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.apache.commons.io.output.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author Anton Serdyuchenko (anton415@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ChatTest {
/**
 * @throws Exception - Exception.
 */
	@Test
	public void whenYouTalkWithBot() throws Exception {
		String myPhrase = "a b stop c continue d end";
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		InputStream input = new ByteArrayInputStream(myPhrase.getBytes());
		Chat.start(input);
		assertThat(out.toString(), is("end"));
	}
}
