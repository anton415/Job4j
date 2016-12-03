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
 */
	@Test
	public void whenTwoIsEvenNumber() {
		InputStream input = new InputStream();
		boolean result = input.isNumber(2);
		assertThat(result, is(true));
	}
/**
 * Test for check, this number is even?
 * 1 is odd or not even.
 */
	@Test
	public void whenOneIsOddOrNotEvenNumber() {
		InputStream input = new InputStream();
		boolean result = input.isNumber(1);
		assertThat(result, is(false));
	}
}
