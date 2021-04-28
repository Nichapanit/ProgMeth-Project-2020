package item;

import base.IncreaseAbilityPlayer;
import base.ItemBase;
import obstacle.WoodenBox;
import player.Player;

public class Medicine extends ItemBase implements IncreaseAbilityPlayer {
	private int heal;
	
	//constructor
	public Medicine(int[] coordinate) { // x,y 
		super(coordinate);
		heal = 20;
	}

	//getter-setter
	public int getHeal() {
		return heal;
	}
	
	//Task 
	//1.item will increase currentLifepoint
	@Override
	public void increase(Player player) {
		int total = player.getCurrentLifePoint() + heal;
		player.setCurrentLifePoint(total < player.getMaxLifePoint() ? total : player.getMaxLifePoint());
	}

	//2. action
	@Override
	public void action(Player player) {
		increase(player);
	}

	 
	
	
	
	
}
