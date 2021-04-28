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

public class WoodenBox extends ObstacleBase{

	//constructor
	public WoodenBox(int[] coordinate) {
		super(coordinate);
		setValue(15);
	}
	
	//Task 
	//1.randomItem create item and define coordinate of item 
	
	public ItemBase randomItem() {
		ItemBase[] allItem = {new Armor(this.getCoordinate()), 
							  new Boot(this.getCoordinate()), 
							  new Fire(this.getCoordinate()), 
							  new Hammer(this.getCoordinate()), 
							  new Medicine(this.getCoordinate())};
		Random random = new Random();
		return allItem[random.nextInt(allItem.length)];
	}
	
}
