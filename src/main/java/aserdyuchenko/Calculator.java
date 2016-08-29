package aserdyuchenko;
public class Calculator {
	public double result;
	public void add (double first, double second){
		/**
		 * Метод add выполняет сложение чисел first и second. Затем записывает значение в поле result.
		 */
		this.result = first + second;
	}
	public void substruct (double first, double second){
		/**
		 * Метод substruct выполняет разность чисел first и second. Затем записывает значение в поле result.
		 */
		this.result = first - second;
	}
	public void div (double first, double second){
		/**
		 * Метод div выполняет деление чисел first и second. Затем записывает значение в поле result.
		 */
		this.result = first / second;
	}
	public void multiple (double first, double second){
		/**
		 * Метод multiple выполняет умножение чисел first и second. Затем записывает значение в поле result.
		 */
		this.result = first * second;
	}
}
