package aserdyuchenko;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тест для рассчета площади треугольника.
 * Подробное описание поиска площади, расписано в классе Triangle.
 */
public class TriangleTest {
    @Test
    public void whenFinaleTest() {
        Point a = new Point(0,0);
        Point b = new Point(2,0);
        Point c = new Point(4,0);
        Triangle triangle = new Triangle(a, b, c);
        double square = triangle.area();
        assertThat(square, is(0.0));
    }
}