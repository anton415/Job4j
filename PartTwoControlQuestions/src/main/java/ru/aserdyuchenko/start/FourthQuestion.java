package ru.aserdyuchenko;
/*
Есть массив, из открывающихся и закрывающихся скобок.
Нужно проверить, все ли скобки закрыты.
*/
/**
 * @author Anton Serdyuchenko (anton415@gmail.com)
 * @version $Id$
 * @since 28.11.2016
 */
public class FourthQuestion {
/**
 * @param check - this array is true or false.
 */
private boolean check = false;
/**
 * @param countO - count Open Bracket.
 */
private int countO;
/**
 * @param countC - count Close Bracket.
 */
private int countC;
/**
 * Method for check array.
 * @param array - array for check.
 * @return check - result of check.
 */
	public boolean checkArray(String[] array) {
		for (String index : array) {
System.out.print(index);
			if (index.equals("(")) {
				countO++;
			} else {
				countC++;
			}
			if (countO < countC) {
				check = false;
				break;
			} else if (countO != countC) {
				check = false;
			} else {
				check = true;
			}
		}
	return check;
	}
}
