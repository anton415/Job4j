package aserdyuchenko;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**2.3. Создать программу калькулятор.
 * Тест для класса Calculator
 *
 * @author Anton Serdyuchenko
 * @since 28.08.2016
 * @version 1.0
 */
public class CalculatorTest {
    @org.testng.annotations.Test
    public void whenAddTwoNumbers() {
        //assign
        Calculator calculate = new Calculator();
        //act
        calculate.add(1,1);
        double result = calculate.result;
        //action
        assertThat(result, is(2d));
    }
    @org.testng.annotations.Test
    public void whenSubstructTwoNumbers() {
        //assign
        Calculator calculate = new Calculator();
        //act
        calculate.substruct(3,1);
        double result = calculate.result;
        //action
        assertThat(result, is(2d));
    }
    @org.testng.annotations.Test
    public void whenDivTwoNumbers() {
        //assign
        Calculator calculate = new Calculator();
        //act
        calculate.div(4,2);
        double result = calculate.result;
        //action
        assertThat(result, is(2d));
    }
    @org.testng.annotations.Test
    public void whenMultipleTwoNumbers() {
        //assign
        Calculator calculate = new Calculator();
        //act
        calculate.multiple(2,1);
        double result = calculate.result;
        //action
        assertThat(result, is(2d));
    }

}
