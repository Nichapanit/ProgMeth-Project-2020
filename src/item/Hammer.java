package item;

import base.Destroyable;
import base.ItemBase;
import base.ObstacleBase;
import obstacle.Wood;
import player.Player;

public class Hammer extends ItemBase implements Destroyable{

	//constructor
	public Hammer(Wood wood) {
		super(wood);
	}

	//Task
	//1. player get item
	@Override
	public boolean givenItem(Player player) {
		if (player.getX() == this.getX() && player.getY() == this.getY()) {
			this.setX(player.getX());
			this.setY(player.getY());
			player.getBag().addItem(this);
			return true;
		}
		return false;
	}
	//2. check this item can destroy Obstacle
	@Override
	public boolean destroy(ObstacleBase o, Player player) {
		// TODO Auto-generated method stub
		return false;
	}
	//3.if this item can destroy set point to obstacle
	@Override
	public int setPoint(ObstacleBase o) {
		if(this.destroy(o, null)) {
			return 150;
		}
		return 0;
	}

}
