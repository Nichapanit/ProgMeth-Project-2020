package item;

import java.util.ArrayList;

import com.sun.jdi.connect.AttachingConnector;

import base.Attackable;
import base.CountdownTimer;
import base.Destroyable;
import base.ItemBase;
import base.ObstacleBase;
import logic.Direction;
import obstacle.Simple;
import obstacle.WoodenBox;
import player.Player;

public class Fire extends ItemBase implements Destroyable,Attackable,CountdownTimer {
	private final int DESTROY = 13;
	private int cooldown;
	private ArrayList<int[]> areaItem;
	
	//constructor
	public Fire(int[] coordinate) {
		super(coordinate);
		areaItem = new ArrayList<>();
	}

	//Task
	//1. item has area when it works.
	public void setAreaItem(Player player) {
		int x = player.getCoordinate()[0];
		int y = player.getCoordinate()[1];
		int[] coordinate1 = {x,y};
		int[] coordinate2 = {x,y};
		Direction direction = player.getDirection(); 

		//{1,2}
		areaItem = {{2,2},{3,2}}
		areaItem = {co1,co2}
		switch (direction) {
		case LEFT:
			coordinate1[0] -= 1;
			coordinate2[0] -= 2;
			break;
		case UP:
			coordinate1[1] += 1;
			coordinate2[1] += 2;
			break;
		case RIGHT:
			coordinate1[0] += 1;
			coordinate2[0] += 2;
			break;
		case DOWN:
			coordinate1[1] -= 1;
			coordinate2[1] -= 2;
			break;
		default:
			break;
		}
		areaItem.add(coordinate1);
		areaItem.add(coordinate2);
	}
	
	
	//2. check this item can destroy Obstacle
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
	
	//4.fire can attack currentLifepoint 
	@Override
	public void attack(Player player) {
		player.setCurrentLifePoint(player.getCurrentLifePoint() - 60);
	}
	
	//5. check item expired
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
	@Override
	public void action(Player player) {
		while (!isTimeOut(player)) {
			for (int[] co : areaItem) {  //areaItem = {{2,2},{3,2}} 
			     // {2,2} i = 0
				// get obstacle from gameMap >> Obstacle o =
				if (getfrommap instanceof Obstacle) {
					if (destroy(o)) {
						setPoint(o, player);
						if (o instanceof WoodenBox) {
							// remove obstacle
							// Gamemap.add(o.randomItem());
						}
					}
					if (player.getCoordinate().equals(co)) {
						attack(player);
					}
				}

			}
		}

	}
	
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
