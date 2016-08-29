package aserdyuchenko;
/**2.3. Создать программу калькулятор.
 * Нужно сделать файл Calculator.java
 * и создать в нем класс Calculator.
 * в классе должно быть внутреннее поле double result.
 * и четыре метода add(double first, double second)
 * по аналогии substruct div multiple. Методы должны быть void.
 * Каждый метод вычисляет арифметическую операцию
 * и записывает ее в поле result.
 *
 * @author Anton Serdyuchenko
 * @since 28.08.2016
 * @version 1.0
 */
public class Calculator {
	public double result;
	public static void main(String[] args) {
		Calculator calculate = new Calculator();
		calculate.add(1,1);
		calculate.substruct(3,1);
		calculate.div(4,2);
		calculate.multiple(2,1);
	}
	public void add (double first, double second){
		/**
		 * Метод add выполняет сложение чисел first и second. Затем записывает значение в поле result.
		 */
		this.result = first + second;
		System.out.println("Add: " + this.result);
	}
	public void substruct (double first, double second){
		/**
		 * Метод substruct выполняет разность чисел first и second. Затем записывает значение в поле result.
		 */
		this.result = first - second;
		System.out.println("Substruct: " + this.result);
	}
	public void div (double first, double second){
		/**
		 * Метод div выполняет деление чисел first и second. Затем записывает значение в поле result.
		 */
		this.result = first / second;
		System.out.println("Div: " + this.result);
	}
	public void multiple (double first, double second){
		/**
		 * Метод multiple выполняет умножение чисел first и second. Затем записывает значение в поле result.
		 */
		this.result = first * second;
		System.out.println("Multiple: " + this.result);
	}
}
