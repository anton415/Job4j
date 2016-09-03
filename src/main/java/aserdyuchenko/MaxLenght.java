package aserdyuchenko;

/**3.2. Класс определяет максимальную длинну стороны треугольника.
 * Построенного в классе Triangle.
 *
 * @author Anton Serdyuchenko
 * @since 02.09.2016
 * @version 1.0
 *
 */

/*
Сначала вызов метода area. Мы должны быть уверены, что треугольник можно построить.
Потом узнать какая сторона больше. Стороны из треугольника, которого мы построили.
 */
public class MaxLenght {
    public Point a;
    public Point b;
    public Point c;

    public MaxLenght(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String max() {
        String maximum;
        Triangle triangle = new Triangle(a,b,c);
        double distanceAB = Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
        double distanceAC = Math.sqrt(Math.pow((a.x - c.x), 2) + Math.pow((a.y - c.y), 2));
        double distanceBC = Math.sqrt(Math.pow((b.x - c.x), 2) + Math.pow((b.y - c.y), 2));
        if (distanceAB == 0) {maximum = "Невозможно построить треугольник!";
        } else if (triangle.area()==0) { maximum = "Невозможно построить треугольник!";
        } else if (distanceAB > distanceAC) { maximum = "Distance AB is maximum";
        } else if (distanceBC > distanceAC) { maximum = "Distance BC is maximum";
        } else { maximum = "Distance AC is maximum";
        } return maximum;
    }
}
