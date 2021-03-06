package item;

import base.CountdownTimer;
import base.IncreaseAbilityPlayer;
import base.ItemBase;
import player.Player;

public class Boot extends ItemBase implements IncreaseAbilityPlayer,CountdownTimer{
	private int cooldown;
	private int speedUp; 
	
	//constructor
	public Boot(int x,int y) {
		super(x,y);
		speedUp = 3;
	}
	
	//Task
	//1.item will increase speed
	@Override
	public void increase(Player player) {
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
	
	//3.
	@Override
	public void action(Player player) {
		increase(player);
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

	@Override
	public int getSprite() {
		// TODO Auto-generated method stub
		return 1;
	}


}
