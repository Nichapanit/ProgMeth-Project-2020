package item;

import base.CountdownTimer;
import base.Destroyable;
import base.ItemBase;
import obstacle.Wood;
import player.Player;

public class Armor extends ItemBase implements CountdownTimer{
	private static final int DEFENSE = 15;
	
	//constructor
	public Armor(Wood wood) {
		super(wood);
	}
	
	//Task
	//1.Player gets item and increase ability. 
	@Override
	public boolean givenItem(Player player) {
		if (player.getX() == this.getX() && player.getY() == this.getY()) {
			player.setDefense(DEFENSE);
			return true;
		}
		return false;
	}
	//2.check armor defense from destroyable
	public void defense(Destroyable d,Player player) {
		if(d instanceof Hammer) {
			
			return false;
		}
		else{
			player.setDefense(0);
			return true;
		}
	}

	@Override
	public boolean isTimeOut(Player player) {
		// TODO Auto-generated method stub
		return false;
	}
}	