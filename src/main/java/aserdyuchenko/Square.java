package aserdyuchenko;

import java.io.*;

/**
 * 4.1. Создать программу вычисляющую формулу квадратного уравнения
 * Создать класс Square в нем один методы float calculate(int x) и void show(start, finish, step).
 * Метод должен вычислять значение функции y = a*x2 + b * x + c;
 * параметры a b c задаются через конструктор.
 * void show(start, finish, step) - вывести на экран значение функции в диапазоне от x1 до x2 c шагом step.
 *
 * @author Anton Serdyuchenko
 * @since 05.09.2016
 * @version 3.0
 */

public class Square {
    public float a;
    public float b;
    public float c;

    public Square(float a,float b,float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    float calculate(int x){
        float y = this.a*((float)Math.pow(x,2)) + this.b*x + this.c;
        System.out.println(String.format("Значение квадратного уровнения: %s", y));
        return y;
    }

    void show(float start, float finish, float step) throws java.io.IOException {
        for (float index=start; index<=finish; index=index+step){
            System.out.println(String.format("Значение функции, при выполнении цикла: %s", index));
        }
    }
}
