package player;

import java.util.ArrayList;

import base.Attackable;
import base.CountdownTimer;
import base.Destroyable;
import base.Exist;
import base.ItemBase;
import base.ObstacleBase;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import logic.Direction;
import obstacle.Simple;
import obstacle.WoodenBox;
import view.GameController;
import view.GameViewManager;

public class Bomb extends Exist implements Destroyable, Attackable, CountdownTimer {
	private final int DESTROY = 10;
	private int cooldown;
	private ArrayList areaItem;

	// constructor
	public Bomb(int x, int y) {
		super(x, y);
		areaItem = new ArrayList<>();
	}

	// Task
	// 1. item has area when it works.
	public void setAreaItem(Player player) {
		int x = player.getX();
		int y = player.getY();
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
		if (o instanceof Simple || o instanceof WoodenBox) {
			return true;
		}
		return false;
	}

	// 3. set point to obstacle and add to score player
	@Override
	public void setPoint(ObstacleBase o, Player player) {
		int point = o.getValue() * DESTROY;
		player.setScore(player.getScore() + point);
	}

	// 4. Bomb can attack currentLifepoint
	@Override
	public void attack(Player player) {
		player.setCurrentLifePoint(player.getCurrentLifePoint() - 40);
	}

	// 5. check item ready to action
	@Override
	public boolean isTimeOut(Player player) {
		if (this.cooldown == 0) {
			return true;
		} else {
			this.cooldown = cooldown - 1;
			return false;
		}
	}

	// 6. action
	///fix this method
	 public void bomb() {
		  if (GameController.getCurrentMap().getEntity(x, y) instanceof Player
		    || GameController.getCurrentMap().getEntity(x + 1, y) instanceof Player
		    || GameController.getCurrentMap().getEntity(x - 1, y) instanceof Player
		    || GameController.getCurrentMap().getEntity(x, y + 1) instanceof Player
		    || GameController.getCurrentMap().getEntity(x, y - 1) instanceof Player) {

		  } else {

		   if (GameController.getCurrentMap().getEntity(x, y) instanceof ObstacleBase) {
		    setBomb(x, y);
		   }

		   if (GameController.getCurrentMap().getEntity(x + 1, y) instanceof ObstacleBase && x <= 12) {
		    setBomb(x + 1, y);
		   }

		   if (GameController.getCurrentMap().getEntity(x - 1, y) instanceof ObstacleBase && x >= 1) {
		    setBomb(x - 1, y);
		   }

		   if (GameController.getCurrentMap().getEntity(x, y + 1) instanceof ObstacleBase && y <= 7) {
		    setBomb(x, y + 1);
		   }

		   if (GameController.getCurrentMap().getEntity(x, y - 1) instanceof ObstacleBase && y >= 1) {
		    setBomb(x, y - 1);
		   }
		  }
		 }
	
	 public void setBomb(int x, int y) {
		  if (destroy((ObstacleBase) GameController.getCurrentMap().getEntity(x, y))) {
		   setPoint((ObstacleBase) GameController.getCurrentMap().getEntity(x, y), GameController.getPlayer());
		   if (GameController.getCurrentMap().getEntity(x, y) instanceof WoodenBox) {
		    ItemBase addItem = ((WoodenBox)GameController.getCurrentMap().getEntity(x, y)).randomItem();
		    GameController.getCurrentMap().removeEntity(x, y);
		    GameController.getCurrentMap().addEntity(addItem, x, y);
		   } else {
		    GameController.getCurrentMap().removeEntity(x, y);
		   }
		   GameViewManager.itemControlPane.setScoreLabelText(GameController.getPlayer().getScore());

		  }
	}
	
	// getter-setter
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

	@Override
	public int getSprite() {
		// TODO Auto-generated method stub
		return 6;
	}

}
