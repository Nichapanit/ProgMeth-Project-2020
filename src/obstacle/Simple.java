package obstacle;

import base.ObstacleBase;

public class Simple extends ObstacleBase{
	//constructor 
	public Simple(int x,int y) {
		super(x,y);
		setValue(10);
	}

	@Override
	public int getSprite() {
		// TODO Auto-generated method stub
		return 9;
	}

}
