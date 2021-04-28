package base;

public class ObstacleBase extends Exist {
	protected int value;
	
	//constructor
	public ObstacleBase(int[] coordinate) {
		super(coordinate);
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
