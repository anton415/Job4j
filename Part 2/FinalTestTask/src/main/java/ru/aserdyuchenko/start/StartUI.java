package ru.aserdyuchenko.start;

import ru.aserdyuchenko.models.*;

/**
 * @author Anton Serdyuchenko
 * @since 04.11.2016
 * @version 1.0
 */
public class StartUI {
	public static void main(String[] args) {
		//start program
Chess chess = new Chess();
		chess.showBoard();
		chess.addFigure(new Figure("Queen", 0, 2));
		chess.addFigure(new Figure("Pawn", 0, 3));
		chess.showBoard();
		chess.moveFigure((new Figure("Queen", 0, 1)), 0, 4);
		chess.showBoard();
	}
}
