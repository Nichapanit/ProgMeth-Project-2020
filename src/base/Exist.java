package base;

import java.util.ArrayList;

abstract public class Exist {
	protected int[] coordinate = {0,0};
	
	//constructor
	public Exist(int[] coordinate) {
		setCoordinate(coordinate);
	}
	
	//getter-setter
	public int[] getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(int[] coordinate) {
		this.coordinate[0] = coordinate[0];
		this.coordinate[1] = coordinate[1];
	}
	
	//Task
	public boolean equals(int[] coordinate) {
		int[] coordinate1 = this.getCoordinate();
		int[] coordinate2 = coordinate;
		if(coordinate1[0] == coordinate2[0] && coordinate1[1] == coordinate2[1]) {
			return true;
		}
		else {
			return false;
		}
	}
	public String toString(int[] cooridinate) {
		return "[" + coordinate[0] + "," + coordinate[1] + "]";
	}
	
}
