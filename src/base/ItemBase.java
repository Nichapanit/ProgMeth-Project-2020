package base;

import player.Player;

abstract public class ItemBase extends Exist {
	
	//constructor
	public ItemBase(int[] coordinate) {
		super(coordinate);
	}
	
	abstract public void action(Player player);
	
}
