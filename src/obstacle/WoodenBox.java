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
		public WoodenBox(int x,int y) {
			super(x,y);
			setValue(15);
		}
		
		//Task 
		//1.randomItem create item and define coordinate of item 
		
		public ItemBase randomItem() {
			ItemBase[] allItem = {new Armor(this.x,this.y), 
								  new Boot(this.x,this.y), 
								  new Fire(this.x,this.y), 
								  new Hammer(this.x,this.y), 
								  new Medicine(this.x,this.y)};
			Random random = new Random();
			return allItem[random.nextInt(allItem.length)];
		}

		@Override
		public int getSprite() {
			// TODO Auto-generated method stub
			return 8;
		}
	

}
