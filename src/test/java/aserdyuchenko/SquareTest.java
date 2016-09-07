package aserdyuchenko;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.*;

/**
 * Тест для рассчета формулы квадратного уровнения.
 * Подробное описание поиска площади, расписано в классе Square.
 */
public class SquareTest {
    @Test
    public void whenLookingValueQuadraticEquation() {
        Square square = new Square(2f, 2f, 2f);
        float result = square.calculate(2);
        assertThat(result, is(14f));
    }
    @Test
    public void whenDisplayedScreenFunctionValueByStep() throws IOException {
        Square square = new Square(1f, 1f, 1f);
        float start = square.calculate(1);
        float finish = square.calculate(2);
        float step = 1f;
        square.show(start,finish, step);
        float result = square.outContent;
        assertThat(result, is(7f));
    }
}