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
 * @result - result.
 */
	private boolean result = false;
/**
 * convertStreamToInt method.
 * @param in - Scanner.
 * @throws IOException - IOException.
 * @return result - result checking.
 */
	public boolean readInputStreamAsInt(InputStream in) throws IOException {
		try (Scanner reader = new Scanner(new BufferedReader(new InputStreamReader(in, "UTF8"))).useDelimiter("\\s*\n\\s*")) {
			while (reader.hasNext()) {
				String nextNumber = reader.next();
				int userNumber = Integer.valueOf(nextNumber);
				if (userNumber % 2 == 0) {
					result = true;
				} else {
					result = false;
				}
			}
			reader.close();
		}
		return result;
	}
}
