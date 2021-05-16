package player;

import java.util.ArrayList;

import base.Destroyable;
import base.Exist;
import base.IncreaseAbilityPlayer;
import base.ItemBase;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import logic.Direction;
import model.CHARACTER;
import view.GameController;

public class Player extends Exist{
	private String name;
	private CHARACTER character;
	private int score;
	private int defense;
	private final int MAX_LIFEPOINT = 120; 
	private int currentLifePoint;
	private final int GENERAL_SPEED = 20;
	private int currentSpeed;
	private Bag bag;
	private Direction direction;
	
	//---------------------graphic------------------------------------
	private int offsetX;
	private int offsetY;

	private int translateX;
	private int translateY;
	private static final int WIDTH = 64;
	private static final int HEIGHT = 64;

	public static final int FRONT = 0;
	public static final int RIGHT = 1;
	public static final int LEFT = 2;
	public static final int BACK = 3;
	
	private WritableImage img;
	private Image image;
	
	//constructor
	public Player(int x, int y,String name,CHARACTER character) {
		super(x,y);
		setCharacter(character);
		setCurrentLifePoint(120);
		setScore(0);
		bag = new Bag(name);
		setDirection(Direction.NONE);
	//-------------------------------------player image-------------------------------//	
		this.offsetX = 0;
		this.offsetY = 0;
		image = new Image(character.getCharacterUrl());
		img = new WritableImage(image.getPixelReader(), offsetX, offsetY, 64, 64);
	}
	
	//getter-setter
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		if(name.isBlank()) {
			this.name = "Player";
		}
		else {
			this.name = name;
		}
	}
	public CHARACTER getCharacter() {
		return this.character;
	}
	public void setCharacter(CHARACTER character) {
		this.character = character;
	}
	public int getScore() {
		return this.score;
	}
	public void setScore(int score) {
		if (score <= 0) {
			this.score = 0;
		}
		else {
			this.score = score;
		}
	}
	public int getDefense() {
		return this.defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getMaxLifePoint() {
		return MAX_LIFEPOINT;
	}
	public int getCurrentLifePoint() {
		return this.currentLifePoint;
	}
	public void setCurrentLifePoint(int currentLifePoint) {
		if (currentLifePoint < 0) {
			this.currentLifePoint = 0;
		}
		this.currentLifePoint = currentLifePoint;
	}
	public int getGeneralSpeed() {
		return GENERAL_SPEED;
	}
	public int getCurrentSpeed() {
		return currentLifePoint;
	}
	public void setCurrentSpeed(int speed) {
		currentSpeed = speed;
	}
	public Bag getBag() {
		return bag;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	//Task
	//1.player use item
	public void useItem() {
		bag.getItem(0).action(this);
		bag.getItemList().remove(0);
		
	}
	
	//2.player get item
	public boolean getItem(ItemBase item) {
		if(item instanceof IncreaseAbilityPlayer) {
			item.action(this);
			return true;
		}
		if(item instanceof Destroyable) {
			bag.getItemList().add(item);
			return true;
		}
		return false;
	}
	
	//3. move
	 public boolean move(Direction dir) {
		  int targetX = this.x;
		  int targetY = this.y;

		  direction = dir; // Update move position

		  switch (dir) {
		  case LEFT:
		   targetX -= 1;
		   break;
		  case UP:
		   targetY -= 1;
		   break;
		  case RIGHT:
		   targetX += 1;
		   break;
		  case DOWN:
		   targetY += 1;
		   break;
		  default:
		   break;
		  }
		  if(GameController.getCurrentMap().isMovePossible(targetX, targetY,this)) {
		   if(GameController.getCurrentMap().getEntity(targetX, targetY) instanceof ItemBase) {
		    GameController.getCurrentMap().removeEntity(targetX, targetY);
		   }
		   GameController.getCurrentMap().removeEntity(this.x,this.y);
		   GameController.getCurrentMap().addEntity(this, targetX, targetY);
		   return true;
		  }else {
		   return false;
		  }
		 }
	
	public WritableImage getWritableImage(int index) {
		return new WritableImage(image.getPixelReader(), offsetX, index*64, 64, 64);
	}
	
	//4. Bomb 
	public Bomb bomb() {
		return new Bomb(x,y);
	}

	@Override
	public int getSprite() {
		// TODO Auto-generated method stub
		return 0;
	}

}
