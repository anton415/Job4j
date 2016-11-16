package aserdyuchenko;
/**
 * 3.1. Создать программу вычисления площади треугольника.
 * Создать класс Point c двумя полями x, y.
 * Этот класс будет описывать точку в системе координат. Дано. три точки.
 * Нужно составить программу которая будет вычислять площадь треугольника образованного этими точками.
 * Программа должна учитывать условия невозможности построить треугольник через эти точки.
 *
 * @author Anton Serdyuchenko (anton415@gmail.com)
 * @version $Id$
 * @since 31.08.2016
 *
 */
public class Calculate {
/**
 * main(String[] args).
 * @param args - args.
 */
    public static void main(String[] args) {
        Point first = new Point(0, 0);
        Point second = new Point(2, 0);
/**
 * @param result - result.
 */
        double result = first.distanceTo(second);
     }
/**
 * hello(String text).
 * @param text - text.
 * @return "Hello world" - "Hello world".
 */
    public static String hello(String text) {
        return "Hello world";
    }
}