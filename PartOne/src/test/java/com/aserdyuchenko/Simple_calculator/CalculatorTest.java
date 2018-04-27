package com.aserdyuchenko.Simple_calculator;

import com.aserdyuchenko.Simple_calculator.Calculator;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * 2.3. Создать программу калькулятор.
 * Тест для класса Calculator.
 *
 * @author Anton Serdyuchenko (anton415@gmail.com)
 * @version $Id$
 * @since 28.08.2016
 */
public class CalculatorTest {
    /**
     * Main class.
     */
    private Calculator calculate;
/**
 * @param NUMBER - NUMBER.
 */
public static final int NUMBER = 3;
/**
 * @param NUMBERDIV - NUMBERDIV.
 */
public static final int NUMBERDIV = 4;

    @Before
    public void initialize() {
        calculate = new Calculator();
    }

/**
 * When add two numbers 1 and 1 then result is 2.
 */
    @Test
    public void whenAddTwoNumbers() {
        this.calculate = new Calculator();
        calculate.add(1, 1);
        double result = calculate.getResult();
        assertThat(result, is(2d));
    }
/**
 * whenSubstructTwoNumbers().
 */
    @Test
    public void whenSubstructTwoNumbers() {
        this.calculate = new Calculator();
        calculate.substruct(NUMBER, 1);
        double result = calculate.getResult();
        assertThat(result, is(2d));
    }
/**
 * whenDivTwoNumbers().
 */
    @Test
    public void whenDivTwoNumbers() {
        this.calculate = new Calculator();
        calculate.div(NUMBERDIV, 2);
        double result = calculate.getResult();
        assertThat(result, is(2d));
    }
/**
 * whenMultipleTwoNumbers().
 */
    @Test
    public void whenMultipleTwoNumbers() {
        this.calculate = new Calculator();
        calculate.multiple(2, 1);
        double result = calculate.getResult();
        assertThat(result, is(2d));
    }
}
