package aserdyuchenko;

/**
 * Класс Point вычисляет расстояние между двумя точками в системе координат.
 *
 * Расстояние (distance) вычисляется следующим образом:
 * 1. Координата x первой точки минус координата x второй точки.
 * 2. Координата у первой точки минус координата у второй точки.
 * 3. Сумма квадратов, первых двух вычислений.
 * 4. Корень получивщегося значения в пункте 3.
 */
public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point point) {
        Point first = new Point(0,0);
        Point second = new Point(2,0);
        double distance = Math.sqrt(Math.pow((first.x - second.x),2) + Math.pow((first.y - second.y),2));
        return -1;
    }
}
