package aserdyuchenko;

/**
 * Класс Point вычисляет расстояние между двумя точками в системе координат.
 *
 * Расстояние (distance) вычисляется следующим образом:
 * 1. Координата x первой точки минус координата x второй точки.
 * 2. Координата у первой точки минус координата у второй точки.
 * 3. Сумма квадратов, первых двух вычислений.
 * 4. Корень получивщегося значения в пункте 3.
 *
 * @author Anton Serdyuchenko
 * @since 31.08.2016
 * @version 2.0
 */
public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point point) {
        return Math.sqrt(Math.pow((point.x - this.x),2) + Math.pow((point.y - this.y),2));
    }
}
