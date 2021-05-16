package model;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;
import javafx.scene.layout.BackgroundPosition;

public class ViewSubScene extends SubScene {

	private static final String FONT_PATH = "res/kenvextor_future.ttf";
	private static final String BACKGROUND_IMAGE = "yellow_panel.png";

	private boolean isHidden;

	public ViewSubScene() {
		super(new AnchorPane(), 400, 300);
		this.prefWidth(400);
		this.prefHeight(300);

		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 400, 300, false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		AnchorPane root2 = (AnchorPane) this.getRoot();
		root2.setBackground(new Background(image));

		isHidden = true;

		this.setLayoutX(1024);
		this.setLayoutY(200);

	}

	public void moveSubScene() {
		TranslateTransition transition = new TranslateTransition();// take a look at it
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);

		if (isHidden) {
			transition.setToX(-676);
			isHidden = false;
		} else {
			transition.setToX(0);
			isHidden = true;
		}

		transition.play();
	}
	
	public AnchorPane getPane() {
		return (AnchorPane)this.getRoot();
	}

}
