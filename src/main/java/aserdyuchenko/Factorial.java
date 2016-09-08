package aserdyuchenko;

/**
 * 4.2. Создать программу вычисляющую факториал.
 * Написать программу для вычисления факториала. Использовать циклы.
 * Факториал числа n - это произведение чисел от 1 до n.
 * @author Anton Serdyuchenko
 * @since 08.09.2016
 * @version 1.0
 */
public class Factorial {
    public float result=1;
    public float calculation(float fac){
        for (float index=1; index<=fac; index++){
            result *= index;
        }
        System.out.println(String.format("Значение факториала: %s", result));
        return result;
    }
}
