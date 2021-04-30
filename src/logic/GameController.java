package logic;

import java.util.ArrayList;
import java.util.Scanner;

import entity.base.Entity;
import entity.base.Updatable;
import exception.IllegalValueException;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import player.Player;

public class GameController {
	private static int game_time;
	private static boolean is_lose;
	// gameMap
	
	public static void IntializeGame(int[] coordinate) {
		// new gameMap
		Scanner playerName = new Scanner(System.in); 
		// get character from player click
		Player player = new Player(coordinate, playerName.next(), character);
		setGameTime(180);
		setIsLose(false);
	}
	
	private void addEventListener(Scene s,GraphicsContext gc) {
		s.setOnKeyPressed((event) -> {
			//System.out.println("KeyPressed : " + event.getCode().toString());
			KeyCode keycode = event.getCode();
			if(!GameController.isGameWin()) {
			switch(keycode) {
			case LEFT:
				GameController.movePlayer(Direction.LEFT);
				break;
			case RIGHT:
				GameController.movePlayer(Direction.RIGHT);
				break;
			case UP:
				GameController.movePlayer(Direction.UP);
				break;
			case DOWN:
				GameController.movePlayer(Direction.DOWN);
				break;
			case R:
				GameController.IntializeMap(gameMap,1,12); //Reset Map
				break;
			default:
				System.out.println("Invalid Key.");
				break;
			}
			}else {
				Platform.exit();
		        System.exit(0);
			}
			
			
			ArrayList<Entity> allEntity = GameController.getCurrentMap().getAllEntity();
			
			for(Entity e:allEntity) {
				if(e instanceof Updatable) {
					try {
						((Updatable) e).update();
					}
					catch (IllegalValueException ex) {
						((Updatable) e).valueCorrection();
					}
					
				}
			}
			
			drawGameBoard(gc);
		});
	}
	
	
	//getter-setter
	public static int getGameTime() {
		return game_time;
	}
	public static void setGameTime(int time) {
		GameController.game_time = time;
	}
	public static boolean getIsLose() {
		return is_lose;
	}
	public static void setIsLose(boolean islose) {
		GameController.is_lose = islose;
	}
}
