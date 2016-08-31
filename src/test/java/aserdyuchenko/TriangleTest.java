package aserdyuchenko;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тест для рассчета площади треугольника.
 * Подробное описание поиска площади, расписано в классе Triangle.
 *
 * 1. whenYouAreLookingForTheDistanceAB()
 * Поиск расстояния между точками A и B.
 *
 * 2. whenYouAreLookingForTheDistanceAC()
 * Поиск расстояния между точками A и C.
 *
 * 3. whenYouAreLookingForTheDistanceBC()
 * Поиск расстояния между точками B и C.
 *
 * 4. whenYouAreLookingForTheSemiperimeter()
 * Поиск полупериметра треугольника.
 *
 * 5. whenYouAreLookingForTheTriangleArea()
 * Поиск площади треугольника.
 *
 * 6. whenThereIsNoAreaOfTheTriangle()
 * Проверка, когда у треугольгика нет площади.
 */
public class TriangleTest {
    @Test
    public void whenYouAreLookingForTheDistanceAB() {
        Point a = new Point(0,0);
        Point b = new Point(2,0);
        double distanceAB = Math.sqrt(Math.pow((a.x - b.x),2) + Math.pow((a.y - b.y),2));
        assertThat(distanceAB, is(2d));
    }
    @Test
    public void whenYouAreLookingForTheDistanceAC() {
        Point a = new Point(0,0);
        Point c = new Point(0,2);
        double distanceAC = Math.sqrt(Math.pow((a.x - c.x),2) + Math.pow((a.y - c.y),2));
        assertThat(distanceAC, is(2d));
    }
    @Test
    public void whenYouAreLookingForTheDistanceBC() {
        Point b = new Point(2,0);
        Point c = new Point(0,2);
        double distanceBC = Math.sqrt(Math.pow((b.x - c.x),2) + Math.pow((b.y - c.y),2));
        assertThat(distanceBC, is(2.8284271247461903));
    }
    @Test
    public void whenYouAreLookingForTheSemiperimeter() {
        double distanceAB = 2;
        double distanceAC = 2;
        double distanceBC = 2.8284271247461903;
        double semiperimeter = (distanceAB+distanceAC+distanceBC)/2;
        assertThat(semiperimeter, is(3.414213562373095));
    }
    @Test
    public void whenYouAreLookingForTheTriangleArea() {
        double distanceAB = 2;
        double distanceAC = 2;
        double distanceBC = 2.8284271247461903;
        double semiperimeter = 3.414213562373095;
        double square = Math.sqrt((semiperimeter-distanceAB)*(semiperimeter-distanceAC)*(semiperimeter-distanceBC)*semiperimeter);
        assertThat(square, is(1.9999999999999991));
    }
    @Test
    public void whenThereIsNoAreaOfTheTriangle() {
        Point a = new Point(0,0);
        Point b = new Point(0,0);
        Point c = new Point(0,0);
        double distanceAB = Math.sqrt(Math.pow((a.x - b.x),2) + Math.pow((a.y - b.y),2));
        double distanceAC = Math.sqrt(Math.pow((a.x - c.x),2) + Math.pow((a.y - c.y),2));
        double distanceBC = Math.sqrt(Math.pow((b.x - c.x),2) + Math.pow((b.y - c.y),2));
        double semiperimeter = (distanceAB+distanceAC+distanceBC)/2;
        double square = Math.sqrt((semiperimeter-distanceAB)*(semiperimeter-distanceAC)*(semiperimeter-distanceBC)*semiperimeter);
        assertThat(square, is(0.0));
    }
}