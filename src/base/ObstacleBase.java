//Obstacle give point to player when player use item to destroy them and only wood give item to player
package base;

import player.Player;

public class ObstacleBase {
	protected int x;
	protected int y;
	protected int point;
	
	//constructor
	public ObstacleBase(int x,int y) {
		this.x = x;
		this.y = y;
		setPoint(0);
	}
	
	public boolean givePoint(Player player) {
		if(point != 0) {
			player.setScore(player.getScore() + point);
			return true;
		}
		return false;
	}
	
	//getter - setter
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
