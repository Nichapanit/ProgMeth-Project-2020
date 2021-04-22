package base;

import obstacle.Wood;
import player.Player;

abstract public class ItemBase {
	protected int x;
	protected int y;
	
	//constructor
	public ItemBase(Wood wood) {
		setX(wood.getX());
		setY(wood.getY());
	}
	
	//abstract method 
	abstract public boolean givenItem(Player player);
	
	//getter-setter
	public int getX() {
		return this.x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return this.y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
