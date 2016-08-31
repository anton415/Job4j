package aserdyuchenko;

/**
 * Класс Triangle рассчитывает площадь треугольника.
 *
 * Площадь тругольника рассчитывается по формуле Герона:
 * площадь равна корню из произведения разностей полупериметра треугольника (semiperimeter)
 * и каждой из его сторон (distanceAB, distanceAC, distanceBC):
 *
 * Возвращает "Невозможно построить треугольник!", если площадь треугольника равно 0.
 *
 */
public class Triangle {
    public Point a;
    public Point b;
    public Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        Point a = new Point(0,0);
        Point b = new Point(2,0);
        Point c = new Point(4,0);
        double distanceAB = Math.sqrt(Math.pow((a.x - b.x),2) + Math.pow((a.y - b.y),2));
        double distanceAC = Math.sqrt(Math.pow((a.x - c.x),2) + Math.pow((a.y - c.y),2));
        double distanceBC = Math.sqrt(Math.pow((b.x - c.x),2) + Math.pow((b.y - c.y),2));
        double semiperimeter = (distanceAB+distanceAC+distanceBC)/2;
        double square = Math.sqrt((semiperimeter-distanceAB)*(semiperimeter-distanceAC)*(semiperimeter-distanceBC)*semiperimeter);
        if (square==0){System.out.println("Невозможно построить треугольник!");}
        return square;
    }
}
