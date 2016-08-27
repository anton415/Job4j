package aserdyuchenko;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by anton on 27.08.16.
 */
public class CalculateTest {

    @Test
    public void whenYouWantSeeHelloWorld() {
        //assign
        Calculate hello = new Calculate();

        //act
        String result = hello.Hello("");

        //action
        Assert.assertThat(result, is("Hello world"));
    }
}
