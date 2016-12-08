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

public class EvenNumberTest {
/**
 * Test for check, this number is even?
 * 12 is even.
 * @throws Exception - Exception.
 */
	@Test
	public void whenTwoIsEvenNumber() throws Exception {
		String numberForCheck = "12";
		InputStream input = new ByteArrayInputStream(numberForCheck.getBytes());
		EvenNumber number = new EvenNumber();
		int userNumber = number.readInputStreamAsInt(input);
		boolean result = number.checkNumber(userNumber);
		assertThat(result, is(true));
	}
/**
 * Test for check, this number is even?
 * 111 is odd or not even.
 * @throws Exception - Exception.
 */
	@Test
	public void whenOneHundredElevenIsOddOrNotEvenNumber() throws Exception {
		String numberForCheck = "111";
		InputStream input = new ByteArrayInputStream(numberForCheck.getBytes());
		EvenNumber number = new EvenNumber();
		int userNumber = number.readInputStreamAsInt(input);
		boolean result = number.checkNumber(userNumber);
		assertThat(result, is(false));
	}
}
