package ru.aserdyuchenko;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
/**
 * Class InputOutput.
 * @author Anton Serdyuchenko (anton415@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class EvenNumber {
/**
 * convertStreamToInt method.
 * @param in - Scanner.
 * @return result - result Scanner.
 * @throws IOException - IOException.
 */
	public static int readInputStreamAsInt(InputStream in) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF8"))) {
    		int result = Integer.parseInt(reader.readLine());
    		return result;
		}
	}
/**
 * checkNumber method.
 * @param number - user number.
 * @return result - result check.
 */
	public boolean checkNumber(int number) {
/**
 * @param result - result check.
 */
		boolean result = false;
		if (number % 2 == 0) {
			result = true;
		}
		return result;
	}
}
