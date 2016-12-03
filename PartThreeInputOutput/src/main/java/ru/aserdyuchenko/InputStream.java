package ru.aserdyuchenko;

/**
 * @author Anton Serdyuchenko (anton415@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.Scanner;
/**
 * Class InputOutput.
 */
public class InputStream {
/**
 * Main method.
 * @param args - main args.
 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter number: ");
/**
 * @param number - user number.
 */
			int number = scanner.nextInt();
			isNumber(number);
		}
	}
/**
 * isNumber method.
 * @param userNumber - user number.
 * @return result - result check.
 */
	public static boolean isNumber(int userNumber) {
/**
 * @param result - result check..
 */
		boolean result = false;
		if (userNumber % 2 == 0) {
			result = true;
		}
		return result;
	}
}
