package base;

import java.util.ArrayList;

import player.Player;

public abstract class Exist {
//	protected int[] coordinate;
	protected int x;
	protected int y;
	
	//constructor
	public Exist(int x,int y) {
//		setCoordinate(coordinate);
		setX(x);
		setY(y);
	}
	
	//getter-setter
//	public int[] getCoordinate() {
//		return coordinate;
//	}
//	public int getCoordinateX() {
//		return coordinate[0];
//	}
//	public int getCoordinateY() {
//		return coordinate[1];
//	}
//	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
	
//	public void setCoordinate(int[] coordinate) {
//		this.coordinate = coordinate;
//	}
//	public void setCoordinateX(int x) {
//		coordinate[0] = x;
//	}
//	public void setCoordinateY(int y) {
//		coordinate[1] = y;
//	}
	
	//Task
//	public boolean equals(int[] coordinate) {
//		int[] coordinate1 = this.getCoordinate();
//		int[] coordinate2 = coordinate;
//		if(coordinate1[0] == coordinate2[0] && coordinate1[1] == coordinate2[1]) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
//	public String toString(int[] cooridinate) {
//		return "[" + coordinate[0] + "," + coordinate[1] + "]";
//	}
	
	public abstract int getSprite();


	

}
