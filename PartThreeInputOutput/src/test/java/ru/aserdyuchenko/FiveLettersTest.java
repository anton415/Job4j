package ru.aserdyuchenko;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Anton Serdyuchenko (anton415@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class FiveLettersTest {
/**
 * Test for check, this number is palindrome?
 * Anton is palindrome.
 * @throws Exception - Exception.
 */
	@Test
	public void whenAntonIsPalindrome() throws Exception {
		String wordForCheck = "Anton";
		InputStream input = new ByteArrayInputStream(wordForCheck.getBytes());
		FiveLetters word = new FiveLetters();
		boolean result = word.readWord(input);
		assertThat(result, is(true));
	}
/**
 * Test for check, this number is palindrome?
 * Petr is not palindrome.
 * @throws Exception - Exception.
 */
	@Test
	public void whenPetrIsNotPalindrome() throws Exception {
		String wordForCheck = "Petr";
		InputStream input = new ByteArrayInputStream(wordForCheck.getBytes());
		FiveLetters word = new FiveLetters();
		boolean result = word.readWord(input);
		assertThat(result, is(false));
	}
}
