package view;

import model.CHARACTER;
import gamePart.GameMap;
import player.Player;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import logic.Direction;

public class GameController {

	private static GameMap gameMap;

	private static Player player;

	private static int coin_count;

	private static boolean is_win;

	private static boolean game_switch;

	public static final int MAX_COOLDOWN_TIME = 11;

	public static AudioClip gameBgm;
//	public static MediaPlayer gameBgm;
	static {
		loadResource();
	}

	public static void InitializeMap(String[][] map, int px, int py, CHARACTER character) {
		player = new Player(px,py,ViewManager.playerName,character);

		gameMap = new GameMap(map);

		gameMap.addEntity(player, px, py);

	}

	public static void printMap() {
		gameMap.printMap();
	}

	public static GameMap getCurrentMap() {
		return gameMap;
	}

	public static void movePlayer(Direction dir) {
		player.move(dir);
	}

	public static Player getPlayer() {
		return player;
	}

	public static void loadResource() {
		try {		
			gameBgm = new AudioClip(ClassLoader.getSystemResource("gameBgm2.wav").toString());
//			gameBgm = new MediaPlayer(new Media(ClassLoader.getSystemResource("audio/gameBgm.mp3").toString()));
		} catch (NoClassDefFoundError e) {
			e.printStackTrace();}

	}

}
