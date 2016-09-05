package aserdyuchenko;
/**3.1. Создать программу вычисления площади треугольника.
 * Создать класс Point c двумя полями x, y.
 * Этот класс будет описывать точку в системе координат. Дано. три точки.
 * Нужно составить программу которая будет вычислять площадь треугольника образованного этими точками.
 * Программа должна учитывать условия невозможности построить треугольник через эти точки.
 *
 * @author Anton Serdyuchenko
 * @since 31.08.2016
 * @version 2.0
 *
 */
public class Calculate {
    public static void main(String[] args) {
        Point first = new Point(0,0);
        Point second = new Point(2,0);
        double result = first.distanceTo(second);
     }

    public static String Hello(String text){
        return "Hello world";
    }
}