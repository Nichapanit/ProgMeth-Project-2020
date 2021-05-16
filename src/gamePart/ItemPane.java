package gamePart;

import java.util.ArrayList;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class ItemPane extends HBox {
	private ObservableList<ItemButton> itemButtonList = FXCollections.observableArrayList();
//	private ArrayList<Item> itemList = new ArrayList<>();
	public ItemPane() {
		this.setPrefSize(500, 120);
		this.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
		this.setAlignment(Pos.TOP_LEFT);
		this.setPadding(new Insets(5));
		this.setBorder(new Border(new BorderStroke(Color.AZURE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));

	}

	public void addItemButton(String itemButtonName,int index) {
		ItemButton newItemButton = new ItemButton(itemButtonName,index);
		itemButtonList.add(newItemButton);
		this.getChildren().add(newItemButton);
		
	}
	
//	public void removeItem(Item item) {
//		if (itemList.contains(item)) {
//			itemList.remove(item);
//		}	
//	}
	
//	public void removeItemButton(ItemButton itemButton) {
//		if(itemButton.getItem().getCount == 0) {
//			itemButtonList.remove(itemButton);
//		}
//	}
	


}
