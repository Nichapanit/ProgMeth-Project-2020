package base;

import java.util.ArrayList;
import player.Player;

public interface Destroyable {
	boolean destroy(ObstacleBase o); // Check item destroy obstacle
	void setPoint(ObstacleBase o, Player player); //After destroy player will be given point and add score

}
