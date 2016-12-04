package ru.aserdyuchenko;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Anton Serdyuchenko (anton415@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class InputStreamTest {
/**
 * Test for check, this number is even?
 * 2 is even.
 * @throws Exception - Exception.
 */
	@Test
	public void whenTwoIsEvenNumber() throws Exception {
		InputStream input = new InputStream(2);
		boolean result = input.isNumber(input);
		assertThat(result, is(true));
	}
/**
 * Test for check, this number is even?
 * 1 is odd or not even.
 * @throws Exception - Exception.
 */
	@Test
	public void whenOneIsOddOrNotEvenNumber() throws Exception {
		InputStream input = new InputStream(1);
		boolean result = input.isNumber(input);
		assertThat(result, is(false));
	}
}
