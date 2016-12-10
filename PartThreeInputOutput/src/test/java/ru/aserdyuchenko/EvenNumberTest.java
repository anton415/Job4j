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

public class EvenNumberTest {
/**
 * Test for check, this number is even?
 * 12 is even.
 * @throws Exception - Exception.
 */
	@Test
	public void whenTwoIsEvenNumber() throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		String numberForCheck = "12";
		InputStream input = new ByteArrayInputStream(numberForCheck.getBytes());
		EvenNumber number = new EvenNumber();
		number.readInputStreamAsInt(input);
		assertThat(out.toString(), is("Is number: 12 even? -true"));
	}
/**
 * Test for check, this number is even?
 * 111 is odd or not even.
 * @throws Exception - Exception.
 */
	@Test
	public void whenOneHundredElevenIsOddOrNotEvenNumber() throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		String numberForCheck = "111";
		InputStream input = new ByteArrayInputStream(numberForCheck.getBytes());
		EvenNumber number = new EvenNumber();
		number.readInputStreamAsInt(input);
		assertThat(out.toString(), is("Is number: 111 even? -false"));
	}
/**
 * Test for check, this number is even?
 * "2\r\n3" is first even and second odd?
 * @throws Exception - Exception.
 */
	@Test
	public void whenCheckFirstTwoAndSecondThree() throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		String numberForCheck = "2\r\n3";
		InputStream input = new ByteArrayInputStream(numberForCheck.getBytes());
		EvenNumber number = new EvenNumber();
		number.readInputStreamAsInt(input);
		assertThat(out.toString(), is("Is number: 2 even? -trueIs number: 3 even? -false"));
	}
}
