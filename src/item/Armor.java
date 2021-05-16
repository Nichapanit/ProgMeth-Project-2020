package item;

import base.CountdownTimer;
import base.Destroyable;
import base.IncreaseAbilityPlayer;
import base.ItemBase;
import obstacle.WoodenBox;
import player.Player;

public class Armor extends ItemBase implements IncreaseAbilityPlayer{
	private int cooldown;
	private int defense;
	
	//constructor
	public Armor(int x,int y) {
		super(x,y);
		defense = 10;
	}
	
	//Task
	//1.item will increase defense. 
	@Override
	public void increase(Player player) {
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
	
	//3.
	@Override
	public void action(Player player) {
		increase(player);
			
	}
	
	// getter-setter
	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	@Override
	public int getSprite() {
		// TODO Auto-generated method stub
		return 4;
	}

}
