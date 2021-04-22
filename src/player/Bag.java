package player;

import java.util.ArrayList;
import base.Destroyable;
import base.ItemBase;

public class Bag {
	private String owner;
	private ArrayList<ItemBase> itemList;
	
	//constructor
	public Bag(String owner) {
		setOwner(owner);
		itemList = new ArrayList<>();
	}
	//getter-setter
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public ArrayList<ItemBase> getItemList(){
		return itemList;
	}
	public ItemBase getItem(int index) {
		return itemList.get(index);
	}
	
	//Task
	//1.remove item
	public void removeItem() {
		
	}
	//2. add item
	public void addItem(ItemBase item) {
		if(item instanceof Destroyable) {
			itemList.add(item);
		}
	}
	

}
