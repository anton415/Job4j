package aserdyuchenko;

import org.junit.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тест для класса Calculate.
 */
public class CalculateTest {
    @Test
    public void whenYouWantSeeHelloWorld() {
        Calculate hello = new Calculate();
        String result = hello.Hello("");
        Assert.assertThat(result, is("Hello world"));
     }

}