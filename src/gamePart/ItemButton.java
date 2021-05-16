package gamePart;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.itemSprites;
import javafx.scene.control.Tooltip;

public class ItemButton extends Button {
//	private Item item;
	private ImageView itemImage;

	public ItemButton(String itemName, int index) {
		Button itemButton = new Button(itemName);
		itemButton.setPadding(new Insets(5));
//		item = new Item(itemName);
		this.itemImage = new ImageView(new Image(itemSprites.ITEM_URL));
		this.itemImage.setViewport(new Rectangle2D(index * 64, 0, 64, 64));
		itemImage.setFitWidth(48);
		itemImage.setFitHeight(48);
		this.setGraphic(itemImage);

		this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setBorder(new Border(
				new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setTooltip();

	}

	private void setTooltip() {
		Tooltip tooltip = new Tooltip();
		tooltip.setFont(new Font(12));
		tooltip.setText("Item test");
//		this.setOnMouseMoved((MouseEvent e) -> {
//			if (item != null)
//			tooltip.show(this, e.getScreenX(), e.getScreenY()+10);
//		});
//		this.setOnMouseExited((MouseEvent e) -> {
//			tooltip.hide();
//		});
	}
	
//	public void getItem() {
//		return this.itemImage;
//	}
}
