package ru.aserdyuchenko;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.util.Scanner;
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
 * @throws IOException - IOException.
 */
	public void readInputStreamAsInt(InputStream in) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF8"))) {
			Scanner s = new Scanner(reader).useDelimiter("\\s*\n\\s*");
			while (s.hasNext()) {
				String nextNumber = s.next();
				int result = Integer.parseInt(nextNumber);
				checkNumber(result);
			}
			s.close();
		}
	}
/**
 * checkNumber method.
 * @param number - user number.
 */
	public void checkNumber(int number) {
/**
 * @param result - result check.
 */
		boolean result = false;
		if (number % 2 == 0) {
			result = true;
		}
		System.out.print("Is number: " + number + " even? -" + result);
	}
}
