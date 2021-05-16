package gamePart;

import java.util.ArrayList;

import application.CSVParser;
import model.*;
import base.Exist;
import base.ItemBase;
import obstacle.*;
import item.*;
import player.Player;
import view.GameController;

public class GameMap {
	private Cell[][] cellmap;
	private int width;
	private int height;

	private ArrayList<Exist> allEntity;

	public GameMap(int column, int row) {
		allEntity = new ArrayList<>();
		setWidth(column);
		setHeight(row);

		cellmap = new Cell[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				cellmap[i][j] = new Cell();
			}
		}

	}

	public GameMap(String[][] map) {
		allEntity = new ArrayList<>();
		int column = map[0].length;
		int row = map.length;

		setWidth(column);
		setHeight(row);

		cellmap = new Cell[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				cellmap[i][j] = new Cell();
				switch (map[i][j]) {
				case "O":
					break;
				case "I":
					addEntity(new Igloo(i, j), j, i);
					break;
				case "W":
					addEntity(new WoodenBox(i, j), j, i);
					break;
				case "F":
					addEntity(new Simple(i, j), j, i);
					break;
				default:
					System.out.println("Error parsing at position x = " + j + " y = " + i
							+ ".\nUnknown Object with Symbol " + map[i][j]);
					break;
				}

			}
		}

	}

	public void printMap() {
		for (Cell[] row : cellmap) {
			String rowstring = "";
			for (Cell c : row) {
				rowstring += c.getSpriteIndex() + " ";
			}
			System.out.println(rowstring);
		}
	}

	public Cell[][] getMap() {
		return cellmap;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	private void setWidth(int column) {
		this.width = column;

	}

	private void setHeight(int row) {
		this.height = row;
	}

	public boolean addEntity(Exist e, int x, int y) {
		allEntity.add(e);

		e.setX(x);
		e.setY(y);
		boolean b = cellmap[y][x].setEntity(e);

		return b;
	}

	public Exist getEntity(int x, int y) {
		try {
			return cellmap[y][x].getEntity();
		}catch(IndexOutOfBoundsException e){
			return null;
		}
	}

	public void removeEntity(int x, int y) {

		allEntity.remove(cellmap[y][x].getEntity());

		cellmap[y][x].removeEntity();
	}
	public ArrayList<Exist> getAllEntity() {
		return allEntity;
	}
	
	public boolean isMovePossible(int targetx, int targety, Exist e) {
		if (targetx < 0 || targetx >= width || targety < 0 || targety >= height) {
			// If Out of bound, cannot move
			return false;
		}
		if (cellmap[targety][targetx].IsEmpty() || (cellmap[targety][targetx].getEntity() instanceof ItemBase)) {
			// If the target cell is empty
			return true;
		} else {
			return false;
		}
	}

}
