package obstacle;

import java.util.Random;
import base.ItemBase;
import base.ObstacleBase;
import item.Armor;
import item.Boot;
import item.Fire;
import item.Hammer;
import item.Medicine;
import player.Player;

public class Wood extends ObstacleBase{

	//constructor
	public Wood(int x,int y) {
		super(x,y);
	}
	
	//Task 
	//1.randomItem create item and define coordinate of item 
	
	public ItemBase randomItem() {
		ItemBase[] allItem = {new Armor(this), new Boot(this), new Fire(this), new Hammer(this), new Medicine(this)};
		Random random = new Random();
		return allItem[random.nextInt(allItem.length)];
	}
	
}
