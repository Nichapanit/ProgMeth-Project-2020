package item;

import java.util.ArrayList;

import base.Destroyable;
import base.ItemBase;
import base.ObstacleBase;
import logic.Direction;
import obstacle.Igloo;
import obstacle.WoodenBox;
import player.Player;

public class Hammer extends ItemBase implements Destroyable{
	private final int DESTROY = 15;
	private ArrayList areaItem;
	//constructor
	public Hammer(int x, int y) {
		super(x,y);
		areaItem = new ArrayList<>();
	}

	//Task
	//1. item has area when it works.
	public void setAreaItem(Player player) {
		int x = player.getX();
		int y = player.getY();
		int[] coordinate = {x,y};	
		Direction direction = player.getDirection(); 

		switch (direction) {
		case LEFT:
			coordinate[0] -= 1;
			break;
		case UP:
			coordinate[1] += 1;
			break;
		case RIGHT:
			coordinate[0] += 1;
			break;
		case DOWN:
			coordinate[1] -= 1;
			break;
		default:
			break;
		}
		areaItem.add(coordinate);
	}
	
	//2. check this item can destroy Obstacle
	@Override
	public boolean destroy(ObstacleBase o) {
		if(o instanceof Igloo) {
			return true;
		}
		return false;
	}
	
	//3.if this item can destroy set point to obstacle
	@Override
	public void setPoint(ObstacleBase o, Player player) {
			int point = o.getValue() * DESTROY;
			player.setScore(player.getScore() + point);
	}
	
	//4. action
	@Override
	public void action(Player player) {
		// TODO Auto-generated method stub
		
	}
	
	//getter
	public int getDestroy() {
		return DESTROY;
	}
	public ArrayList getAreaItem() {
		return this.areaItem;
	}

	@Override
	public boolean isTimeOut(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSprite() {
		// TODO Auto-generated method stub
		return 5;
	}


}
