package item;

import base.ItemBase;
import obstacle.Wood;
import player.Player;

public class Fire extends ItemBase {

	//constructor
	public Fire(Wood wood) {
		super(wood);
	}

	//Task
	//1.Player can get item 
	@Override
	public boolean givenItem(Player player) {
		if (player.getX() == this.getX() && player.getY() == this.getY()) {
			this.setX(player.getX());
			this.setY(player.getY());
			player.getBag().addItem(this);
			return true;
		}
		return false;
	}

}
