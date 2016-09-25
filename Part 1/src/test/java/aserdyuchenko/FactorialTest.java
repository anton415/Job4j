package aserdyuchenko;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для вычисления факториала.
 * Подробное описание вычисления факториала, расписано в классе Factorial.
 */
public class FactorialTest {
    @Test
    public void whenCalculateTheFactorial() {
        Factorial factorial = new Factorial();
        float result = factorial.calculation(5f);
        assertThat(result, is(120f));
    }
}