package aserdyuchenko;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для класса Calculate.
 * @author Anton Serdyuchenko (anton415@gmail.com)
 * @version $Id$
 * @since 28.08.2016
 */
public class CalculateTest {
/**
 * whenYouWantSeeHelloWorld.
 */
    @Test
    public void whenYouWantSeeHelloWorld() {
        Calculate hello = new Calculate();
        String result = hello.Hello("");
        assertThat(result, is("Hello world"));
     }

}
