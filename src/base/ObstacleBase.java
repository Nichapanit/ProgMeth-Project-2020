package base;

import player.Player;

public abstract class ObstacleBase extends Exist{
	protected int value;
	
	//constructor
	public ObstacleBase(int x, int y) {
		super(x,y);
	}
	//getter
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		if(value < 0) {
			//throw 
		}
		else {
			this.value = value;
		}
	}


	

}
