package base;

import player.Player;

public interface Destroyable {
	public abstract boolean destroy(ObstacleBase o,Player player); // check item can destroy this obstacle
	public abstract int setPoint(ObstacleBase o);
}
