package player;

import java.util.ArrayList;

import base.Destroyable;
import base.Exist;
import base.IncreaseAbilityPlayer;
import base.ItemBase;
import logic.Direction;

public class Player extends Exist {
	private String name;
	private String character;
	private int score;
	private int defense;
	private final int MAX_LIFEPOINT = 120; 
	private int currentLifePoint;
	private final int GENERAL_SPEED = 20;
	private int currentSpeed;
	private Bag bag;
	private Direction direction;
	
	//constructor
	public Player(int[] coordinate,String name,String character) {
		super(coordinate);
		setName(name);
		setCurrentLifePoint(120);
		setScore(0);
		bag = new Bag(name);
		setDirection(Direction.NONE);
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
	public String getCharacter() {
		return this.character;
	}
	public void setCharacter(String character) {
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
	
	//4. Bomb 
	public Bomb bomb() {
		return new Bomb(getCoordinate());
	}
	
}
