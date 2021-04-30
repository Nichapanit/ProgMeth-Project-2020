package item;

import base.CountdownTimer;
import base.Destroyable;
import base.IncreaseAbilityPlayer;
import base.ItemBase;
import obstacle.WoodenBox;
import player.Player;

public class Armor extends ItemBase implements IncreaseAbilityPlayer,CountdownTimer{
	private int cooldown;
	private int defense;
	
	//constructor
	public Armor(int[] coordinate) {
		super(coordinate);
		defense = 10;
		setCooldown(10);
	}
	
	//Task
	//1.item will increase defense. 
	@Override
	public void action(Player player) {
		player.setDefense(defense);
			
	}
	
	//2. Check item expired
	@Override
	public boolean isTimeOut(Player player) {
		if (this.cooldown == 0) {
			player.setDefense(0);
			return true;
		}
		else {
			this.cooldown = cooldown  - 1;
			return false;
		}
	}
	
	// getter-setter
	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

}	