package item;

import base.CountdownTimer;
import base.IncreaseAbilityPlayer;
import base.ItemBase;
import player.Player;

public class Boot extends ItemBase implements IncreaseAbilityPlayer,CountdownTimer {
	private int cooldown;
	private int speedUp; 
	
	//constructor
	public Boot(int[] coordinate) {
		super(coordinate);
		speedUp = 3;
	}
	
	//Task
	//1.item will increase speed
	@Override
	public void action(Player player) {
		player.setCurrentSpeed(player.getGeneralSpeed() + speedUp);
		setCooldown(5);
	}
	
	//2. Check item expired
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
	public int getSpeedUp() {
		return speedUp;
	}

	

	

}
