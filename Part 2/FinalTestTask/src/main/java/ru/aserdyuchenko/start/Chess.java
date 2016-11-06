package ru.aserdyuchenko.start;

import ru.aserdyuchenko.models.*;
import java.util.*;

public class Chess {
	Figure figure = new Figure();
	public Figure[][] locationBoard = new Figure[8][8];
	String name;
	int locationBoardX;
	int locationBoardY;
	int newLocationBoardX;
	int newLocationBoardY;
	boolean check = false;

	//Show board
	public void showBoard() {
		System.out.println();
		for (int locationBoardX = 0; locationBoardX < 8; locationBoardX++) {
   			for (int locationBoardY = 0; locationBoardY < 8; locationBoardY++) {
				if (locationBoard[locationBoardX][locationBoardY] != null) {
        			System.out.print("[" + locationBoard[locationBoardX][locationBoardY].getName()+ "]" + "\t");
				} else {
					System.out.print("[ ]" + "\t");
				}
    		}
    		System.out.println();
		}
		System.out.println();
	}

	//New figure in the board
	public Figure addFigure(Figure figure) {
		this.locationBoard[figure.getLocationBoardX()][figure.getLocationBoardY()] = figure;
		return figure;
	}

	public void findOldLocationByNameAndRemove(String name) {
		for (int locationBoardX = 0; locationBoardX < 8; locationBoardX++) {
   			for (int locationBoardY = 0; locationBoardY < 8; locationBoardY++) {
				if (locationBoard[locationBoardX][locationBoardY] != null && locationBoard[locationBoardX][locationBoardY].getName().equals(name)) {
					locationBoard[locationBoardX][locationBoardY] = null;
					break;
				}
    		}
		}
	}

	public boolean checkNewLocationIsEmpty(int newLocationBoardX, int newLocationBoardY) {
		Chess chess = new Chess();
		boolean check = false;
		if (locationBoard[newLocationBoardX][newLocationBoardY] == null) {
			check = true;
		} else check = false;
	return check;
	}



	//Move figure
	public void moveFigure(Figure figure, int newLocationBoardX, int newLocationBoardY) {
		this.name = figure.getName();
		findOldLocationByNameAndRemove(this.name);
		if (checkNewLocationIsEmpty(newLocationBoardX, newLocationBoardY) == true) {
			if (checkHowMoveFigure(figure, newLocationBoardX, newLocationBoardY) == true ) {
				addFigure(new Figure(this.name, newLocationBoardX, newLocationBoardY));
				System.out.print("Move correct.");
			}
		} else System.out.print("Location is not empty!");
	}

	public boolean checkHowMoveFigure(Figure figure, int newLocationBoardX, int newLocationBoardY){
		this.name = figure.getName();
		this.locationBoardX = figure.getLocationBoardX();
		this.locationBoardY = figure.getLocationBoardY();;
		this.newLocationBoardX = newLocationBoardX;
		this.newLocationBoardY = newLocationBoardY;

		if (name == "King") {
			if (checkHowMoveKing() == true) {
				check = true;
			}
		} else if (name == "Queen") {
			if (checkHowMoveQueen() == true) {
				if (checkIsOnTheRoadAnotherFigure() == true) {
					check = true;
				}
			}
		} else if (name == "Rook") {
			if (checkHowMoveRook() == true) {
				if (checkIsOnTheRoadAnotherFigure() == true) {
					check = true;
				}
			}
		} else if (name == "Elephant") {
			if (checkHowMoveElephant() == true) {
				if (checkIsOnTheRoadAnotherFigure() == true) {
					check = true;
				}
			}
		} else if (name == "Horse") {
			if (checkHowMoveHorse() == true) {
				check = true;
			}
		} else if (name == "Pawn") {
			if (checkHowMovePawn() == true) {
				check = true;
			}
		}
	return check;
	}

	public boolean checkHowMoveKing(){
		if (Math.abs(newLocationBoardX - locationBoardX) > 1) {
			System.out.print("Move ancorrect!");
		} else if (Math.abs(newLocationBoardY - locationBoardY) > 1) {
			System.out.print("Move ancorrect!");
		} else {
			check = true;
		}
	return check;
	}

	public boolean checkHowMoveQueen(){
		if (newLocationBoardX==locationBoardX) {
			check = true;
		} else if (newLocationBoardY==locationBoardY) {
			check = true;
		} else if (Math.abs(newLocationBoardX - locationBoardX)==Math.abs(newLocationBoardY - locationBoardY)) {
			check = true;
		} else {
			System.out.print("Move ancorrect! Queen can not do this.");
		}
	return check;
	}

	public boolean checkIsOnTheRoadAnotherFigureByHorizontal(){
		if (newLocationBoardX == locationBoardX) {
			if (newLocationBoardY > locationBoardY) {
				for (int index = locationBoardY; index < newLocationBoardY; index++) {
					if (checkNewLocationIsEmpty(locationBoardX, index)==false) {
						System.out.print("Move ancorrect! Figure on the road.");
						check = false;
					}
				}
			} else if (newLocationBoardY < locationBoardY) {
				for (int index = newLocationBoardY; index < locationBoardY; index++) {
					if (checkNewLocationIsEmpty(locationBoardX, index)==false) {
						System.out.print("Move ancorrect! Figure on the road.");
						check = false;
					}
				}
			}
		}
	return check;
	}

	public boolean checkIsOnTheRoadAnotherFigureByVertical(){
		if (newLocationBoardY == locationBoardY) {
			if (newLocationBoardX > locationBoardX) {
				for (int index = locationBoardX; index < newLocationBoardX; index++) {
					if (checkNewLocationIsEmpty(index, locationBoardY)==false) {
						System.out.print("Move ancorrect! Figure on the road.");
						check = false;
					}
				}
			} else if (newLocationBoardX < locationBoardX) {
				for (int index = newLocationBoardX; index < locationBoardX; index++) {
					if (checkNewLocationIsEmpty(index, locationBoardY)==false) {
						System.out.print("Move ancorrect! Figure on the road.");
						check = false;
					}
				}
			}
		}
		return check;
	}

	public boolean checkIsOnTheRoadAnotherFigureByDiagonal(){
		if ((newLocationBoardX > locationBoardX) && (newLocationBoardY > locationBoardY)) {
			for (int index = locationBoardX; index < newLocationBoardX; index++ ) {
				if (checkNewLocationIsEmpty(index, locationBoardY)==false) {
					System.out.print("Move ancorrect! Figure on the road.");
					check = false;
				}
			locationBoardY++;
			}
		} else if ((newLocationBoardX > locationBoardX) && (newLocationBoardY < locationBoardY)) {
			for (int index = locationBoardX; index < newLocationBoardX; index++ ) {
				if (checkNewLocationIsEmpty(index, locationBoardY)==false) {
					System.out.print("Move ancorrect! Figure on the road.");
					check = false;
				}
			locationBoardY++;
			}
		} else if ((newLocationBoardX < locationBoardX) && (newLocationBoardY > locationBoardY)) {
			for (int index = locationBoardX; index < newLocationBoardX; index++ ) {
				if (checkNewLocationIsEmpty(index, locationBoardY)==false) {
					System.out.print("Move ancorrect! Figure on the road.");
					check = false;
				}
				locationBoardY++;
			}
		} else if ((newLocationBoardX < locationBoardX) && (newLocationBoardY < locationBoardY)) {
			for (int index = locationBoardX; index < newLocationBoardX; index++ ) {
				if (checkNewLocationIsEmpty(index, locationBoardY)==false) {
					System.out.print("Move ancorrect! Figure on the road.");
					check = false;
				}
				locationBoardY++;
			}
		}
		return check;
	}

	public boolean checkIsOnTheRoadAnotherFigure(){
		Chess chess = new Chess();
		if (newLocationBoardX == locationBoardX) {
			checkIsOnTheRoadAnotherFigureByHorizontal();
		} else if (newLocationBoardY == locationBoardY) {
			checkIsOnTheRoadAnotherFigureByVertical();
		} else if (Math.abs(newLocationBoardX - locationBoardX)==Math.abs(newLocationBoardY - locationBoardY)) {
			checkIsOnTheRoadAnotherFigureByDiagonal();
		}
		return check;
	}

	public boolean checkHowMoveRook(){
		if (newLocationBoardX==locationBoardX) {
			check = true;
		} else if (newLocationBoardY==locationBoardY) {
			check = true;
		} else {
			System.out.print("Move ancorrect!");
		}
		return check;
	}

	public boolean checkHowMoveElephant(){
		if (Math.abs(newLocationBoardX - locationBoardX)==Math.abs(newLocationBoardY - locationBoardY)) {
			check = true;
		} else {
			System.out.print("Move ancorrect!");
		}
		return check;
	}

	public boolean checkHowMoveHorse(){
		if (Math.abs(newLocationBoardX - locationBoardX)==2 && Math.abs(newLocationBoardY - locationBoardY)==1) {
			check = true;
		} else if (Math.abs(newLocationBoardY - locationBoardY)==2 && Math.abs(newLocationBoardX - locationBoardX)==1) {
			check = true;
		} else {
			System.out.print("Move ancorrect!");
		}
		return check;
	}

	public boolean checkHowMovePawn(){
		if (((locationBoardX - newLocationBoardX)==1) && (locationBoardY == newLocationBoardY)) {
			check = true;
		} else {
			System.out.print("Move ancorrect!");
		}
		return check;
	}
}
