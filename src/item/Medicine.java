package item;

import base.ItemBase;
import obstacle.Wood;
import player.Player;

public class Medicine extends ItemBase {
	private static final int HEAL = 15;
	
	//constructor
	public Medicine(Wood wood) {
		super(wood);
	}
	
	//Task 
	//1.get item ; when player get medicine it auto heals player. 
	@Override
	public boolean givenItem(Player player) {
		if (player.getX() == this.getX() && player.getY() == this.getY()) {
			player.healPlayer(HEAL);
			return true;
		}
		return false;
	}
	
	

}
