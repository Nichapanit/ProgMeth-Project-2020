package player;

import java.util.ArrayList;

import base.Attackable;
import base.CountdownTimer;
import base.Destroyable;
import base.Exist;
import base.ObstacleBase;
import logic.Direction;
import obstacle.Simple;
import obstacle.WoodenBox;

public class Bomb extends Exist implements Destroyable,Attackable,CountdownTimer{
	private final int DESTROY = 10;
	private int cooldown;
	private ArrayList areaItem;
	
	//constructor
	public Bomb(int[] coordinate) {
		super(coordinate);
		areaItem = new ArrayList<>();
	}

	//Task
	//1. item has area when it works.
	public void setAreaItem(Player player) {
		int x = player.getCoordinate()[0];
		int y = player.getCoordinate()[1];
		int[] coordinate1 = { x + 1, y };
		int[] coordinate2 = { x, y + 1 };
		int[] coordinate3 = { x - 1, y };
		int[] coordinate4 = { x, y - 1 };
		areaItem.add(coordinate1);
		areaItem.add(coordinate2);
		areaItem.add(coordinate3);
		areaItem.add(coordinate4);
	}

	//2. destroy obstacle
	@Override
	public boolean destroy(ObstacleBase o) {
		if(o instanceof Simple || o instanceof WoodenBox) {
			return true;
		}
		return false;
	}
	
	//3. set point to obstacle and add to score player
	@Override
	public void setPoint(ObstacleBase o, Player player) {
		int point = o.getValue() * DESTROY;
		player.setScore(player.getScore() + point);
	}
	
	//4. Bomb can attack currentLifepoint
	@Override
	public void attack(Player player) {
		player.setCurrentLifePoint(player.getCurrentLifePoint() - 40);
	}

	//5. check item ready to action
	@Override
	public boolean isTimeOut(Player player) {
		if (this.cooldown == 0) {
			return true;
		}
		else {
			this.cooldown = cooldown  - 1;
			return false;
		}
	}
	
	//6. action
	

	

	//getter-setter
	public int getDestroy() {
		return DESTROY;
	}
	public int getCooldown() {
		return cooldown;
	}
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	public ArrayList getAreaItem() {
		return this.areaItem;
	}

	

	
}
