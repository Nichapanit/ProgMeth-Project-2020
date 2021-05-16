package item;

import base.IncreaseAbilityPlayer;
import base.ItemBase;
import obstacle.WoodenBox;
import player.Player;

public class Medicine extends ItemBase implements IncreaseAbilityPlayer{
	private int heal;
	
	//constructor
	public Medicine(int x,int y) { // x,y 
		super(x,y);
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

	@Override
	public boolean isTimeOut(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSprite() {
		// TODO Auto-generated method stub
		return 3;
	}

}
