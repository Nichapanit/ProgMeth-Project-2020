package gamePart;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.CHARACTER;
import view.GameController;
import view.ViewManager;
import model.InfoLabel;
import model.ViewButton;

public class ItemControlPane extends HBox {

	public static final String FONT_PATH = "res/kenvector_future.ttf";

	private ItemPane itemPane;
	private VBox imagePane;
	private Label scoreLabel;
	private Label nameLabel;
	private ImageView playerImageView;

	public ItemControlPane() {
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(832);
		this.setPrefHeight(160);
		this.setMaxWidth(832);
		this.setMaxHeight(160);
		this.setSpacing(15);
		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));

		createPlayerImagePane(ViewManager.getChosenCharacter());

		setLabelFont(nameLabel);
		setLabelFont(scoreLabel);

		itemPane = new ItemPane();

		this.getChildren().addAll(imagePane, itemPane);

	}

	public void setScoreLabelText(int score) {
		// TODO Auto-generated method stub
		scoreLabel.textProperty().setValue("SCORE : " + score);

	}

	private void createPlayerImagePane(CHARACTER playerUrl) {
		imagePane = new VBox();
		imagePane.setAlignment(Pos.CENTER);
		playerImageView = new ImageView(new Image(playerUrl.getCharacterUrl()));
		playerImageView.setViewport(new Rectangle2D(0, 0, 64, 64));
		playerImageView.setFitHeight(48);
		playerImageView.setFitWidth(48);
		nameLabel = new Label();
		nameLabel.textProperty().setValue("Name :" + ViewManager.playerName);
		nameLabel.setFont(new Font(12));
		scoreLabel = new Label();
		setScoreLabelText(0);
		scoreLabel.setFont(new Font(18));
		imagePane.getChildren().addAll(playerImageView, nameLabel, scoreLabel);

	}

	private void setLabelFont(Label label) {
		try {
			label.setFont(Font.loadFont(new FileInputStream(FONT_PATH), 10));
		} catch (FileNotFoundException e) {
			label.setFont(Font.font("Verdana", 10));
			System.out.println("Font is not connected");

		}
	}

}
