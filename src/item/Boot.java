package item;

import base.CountdownTimer;
import base.ItemBase;
import obstacle.Wood;
import player.Player;

public class Boot extends ItemBase implements CountdownTimer {
	
	private int cooldown;
	private static final int SPEEDUP = 3; // ** what speed should be
	
	//constructor
	public Boot(Wood wood) {
		super(wood);
	}
	
	//Task 
	//1.Player gets item and increase ability.
	@Override
	public boolean givenItem(Player player) {
		if (player.getX() == this.getX() && player.getY() == this.getY()) {
			player.setCurrentSpeed(player.getGeneralSpeed() + SPEEDUP);  
			setCooldown(5);
			return true;
		}
		return false;
	}
	
	//2.check if item expired and reset ability
	@Override
	public boolean isTimeOut(Player player) {
		if (this.cooldown == 0) {
			player.setCurrentSpeed(player.getGeneralSpeed());
			return true;
		}
		else {
			this.cooldown = cooldown  - 1;
			return false;
		}
		
	}
	
	//getter-setter
	public int getCooldown() {
		return cooldown;
	}
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}
	

}
