package aserdyuchenko;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тест для класса Point.
 *
 * whenCalculateDistanceBetweenTwoPoints()
 * Когда необходимо найти длинну между двумя точками.
 */
public class PointTest {
    @org.testng.annotations.Test
    public void whenCalculateDistanceBetweenTwoPoints(){
        Point first = new Point(0,0);
        Point second = new Point(2,0);
        double distance = Math.sqrt(Math.pow((first.x - second.x),2) + Math.pow((first.y - second.y),2));
        assertThat(distance, is(2d));
    }
}