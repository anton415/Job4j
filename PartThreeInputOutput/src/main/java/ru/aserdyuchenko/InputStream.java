package ru.aserdyuchenko;

/**
 * Class InputOutput.
 * @author Anton Serdyuchenko (anton415@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class InputStream {
/**
 * @param userNumber - user number.
 */
	private int userNumber;
/**
 * @param userNumber - user number.
 */
	private InputStream input;
/**
 * Constructor InputStream.
 * @param userNumberForCheck - user number.
 */
	public InputStream(int userNumberForCheck) {
		this.userNumber = userNumberForCheck;
	}
/**
 * isNumber method.
 * @param in - user number.
 * @return result - result check.
 * @throws Exception - Exception.
 */
	public boolean isNumber(InputStream in) throws Exception {
/**
 * @param result - result check.
 */
		boolean result = false;
		userNumber = Integer.valueOf(in.userNumber);
		if (userNumber % 2 == 0) {
			result = true;
		}
		return result;
	}
}
