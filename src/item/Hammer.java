package item;

import java.util.ArrayList;

import base.Destroyable;
import base.Exist;
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
	public Hammer(int[] coordinate) {
		super(coordinate);
		areaItem = new ArrayList<>();
	}

	//Task
	//1. item has area when it works.
	public void setAreaItem(Player player) {
		int x = player.getCoordinate()[0];
		int y = player.getCoordinate()[1];
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
		for (int i = 0 ; i < this.getAreaItem().size() ; i++) {
			int[] co = (int[]) this.getAreaItem().get(i);
			// get obstacle from gameMap >> Obstacle o = 
			if (getfrommap instanceof Obstacle) {
				if (destroy(o)) {
					setPoint(o,player);
				}
			}
		}		
	}
	
	//getter
	public int getDestroy() {
		return DESTROY;
	}
	public ArrayList getAreaItem() {
		return this.areaItem;
	}

	

	

}
