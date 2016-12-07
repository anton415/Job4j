package ru.aserdyuchenko;
import java.io.InputStream;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.apache.commons.io.IOUtils;

/**
 * @author Anton Serdyuchenko (anton415@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class EvenNumberTest {
/**
 * Test for check, this number is even?
 * 2 is even.
 * @throws Exception - Exception.
 */
	@Test
	public void whenTwoIsEvenNumber() throws Exception {
		InputStream input = IOUtils.toInputStream("2");
		EvenNumber number = new EvenNumber();
		int userNumber = number.readInputStreamAsInt(input);
		boolean result = number.checkNumber(userNumber);
		assertThat(result, is(true));
	}
/**
 * Test for check, this number is even?
 * 1 is odd or not even.
 * @throws Exception - Exception.
 */
	@Test
	public void whenOneIsOddOrNotEvenNumber() throws Exception {
		InputStream input = IOUtils.toInputStream("1");
		EvenNumber number = new EvenNumber();
		int userNumber = number.readInputStreamAsInt(input);
		boolean result = number.checkNumber(userNumber);
		assertThat(result, is(false));
	}
}
