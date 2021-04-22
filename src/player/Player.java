package player;

import java.util.ArrayList;

import base.ItemBase;

public class Player {
	private int x;
	private int y;
	private String name;
	private String character;
	private int score;
	private int defense;
	private final int MAX_LIFEPOINT = 120; 
	private int currentLifePoint;
	private final int GENERAL_SPEED = 20;
	private int currentSpeed;
	private Bag bag;
	
	//constructor
	public Player(String name,String character) {
		setName(name);
		setCurrentLifePoint(120);
		setScore(0);
		bag = new Bag(name);
	}
	
	//getter-setter
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
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
	
	//Task
	//1.heal ** should use getter setter MAX_LIFEPOINT
	public void healPlayer(int heal) {
		int totalHP = getCurrentLifePoint() + heal;
		setCurrentLifePoint(totalHP>getCurrentLifePoint()?MAX_LIFEPOINT:totalHP); 
	}
	
}
