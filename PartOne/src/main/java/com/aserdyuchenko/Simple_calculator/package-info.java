package com.aserdyuchenko.Simple_calculator;
/*
Прочитайте Хорстманн Java. Библиотека профессионала станицы 72.

1. Создайте файл chapter_001\src\main\java\ru\job4j\calculator\Calculator.java

2. Создать в нем класс Calculator. В классе должно быть внутреннее поле double result и методы

void add(double first, double second); - метод должен складывать  аргумент first и second и записывать результат в поле this.result. Пример реализации ниже.

по аналогии добавьте методы subtract div multiple. Вычитание, деление и умножение.

3. Методы должны быть void. Каждый метод вычисляет арифметическую операцию и записывает ее в поле this.result.

К полям класса обращаться надо через this; - Например. this.result;

4. Добавить методы double getResult() - метод должен возвращать значение поля result.

package ru.job4j.calculator;

public class Calculator {
    private double result;

    public void add(double first, double second) {
        this.result = first + second;
    }

    public double getResult() {
        return this.result;
    }
}

5. Прочитать главу про тестирование ссылка. Примеры в документе выполнять не надо. Они только демонстрируют примеры тестирования.

6. Добавьте файл  chapter_001\src\test\java\ru\job4j\calculator\CalculatorTest.java

Добавить тест CalculatorTest.

package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
}

Более детально про строку - assertThat(result, is(expected));

assertThat - это статический метод из класса org.junit.Assert.assertThat;

Этот метод принимает две переменных. result и Matcher.

Matcher - в данном примере - это методы статический метод из класса import static org.hamcrest.core.Is.is;

Он определяет как сравнивать две переменных result и except.

В этом пример он сравнивает из по значению. то есть

result == except - если объекты равны. то код выполняется успешно. если выражения не равны. то программа падает с ошибкой.

AssertException.

Например.

java.lang.AssertionError:
Expected: is <2>
 but: was <4>

Это значит. что Вы ожидали результат вычисления 2, а по факту получилось 4. Значит программа работает не верно и надо искать ошибку.



7. По аналогии добавьте методы тесты на методы вычитания, умножения и деления.

Все тест-методы должны начинаться с аннотации @Test

Например.

@Test
public void whenDiv2On2Then1() {
}


8. Залейте код на github.

Что делать не надо.

1. Здесь не надо использовать Scanner, System.in, System.out.println.

2. В программе не должно быть ввода и вывода данных.

3. Код всей программы проверяется через тесты.

4. Не надо создавать метод public static void main(String[] args) - так вы занимаетесь ручным тестированием. В курсе используется только автоматическое тестирование за счет JUnit.
 */