package model;

import base.*;


public class Cell {
	private Exist myEntity;
	private boolean isEmpty;
	
	public Cell() {
		isEmpty = true;
	}
	
	public boolean IsEmpty() {
		return isEmpty;
	}
	public boolean setEntity(Exist entity) {
		if (isEmpty) {
			myEntity = entity;
			isEmpty = false;
			return true;
		}else {
//			if(myEntity instanceof Consumable) {
//				Consumable d = (Consumable) myEntity;
//				return d.consume(myEntity);
//			}else {
//				return false;
//			}
			return false;
		}
	}
	public	Exist getEntity() {
		return myEntity;
	}
	
	public void removeEntity() {
		myEntity = null;
		isEmpty = true;
	}
	
	public int getSpriteIndex() {
		if(isEmpty) {
			return -1;
		}
		return myEntity.getSprite();
	}
	

}
