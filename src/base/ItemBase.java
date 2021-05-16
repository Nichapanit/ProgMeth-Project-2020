package base;
import player.Player;

public abstract class ItemBase extends Exist {
	//constructor
	public ItemBase(int x,int y) {
		super(x,y);
	}
	
	abstract public void action(Player player);
	public abstract boolean isTimeOut(Player player);
	abstract public int getSprite();

}
