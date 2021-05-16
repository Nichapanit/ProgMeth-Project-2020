package obstacle;

import base.ObstacleBase;

public class Igloo extends ObstacleBase{
	
	//constructor 
	public Igloo(int x, int y) {
		super(x,y);
		setValue(20);
	}

	@Override
	public int getSprite() {
		// TODO Auto-generated method stub
		return 7;
	}

}
