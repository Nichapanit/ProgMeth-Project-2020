package model;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.GameController;
import view.ViewManager;

public class TimesUpSubScene{
	private static final String FONT_PATH = "res/kenvextor_future.ttf";
	private static final String BACKGROUND_IMAGE = "red_panel.png";
	
	private VBox pane;
	private boolean isHidden;
	private InfoLabel namelabel;
	private InfoLabel scorelabel;
	private Scene scene;
	private Stage stage;
	private ViewButton returnButton;
	
	public TimesUpSubScene() {
		pane = new VBox();
		pane.prefHeight(732);
		pane.prefWidth(932);
		pane.maxHeight(732);
		pane.maxWidth(932);
		
		
		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_IMAGE, 400, 300, false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
		
		createLabel();
		createReturnViewPageButton();
		
		scene = new Scene(pane);
		stage = new Stage();
		stage.show();
	
		
	}
	public VBox getPane() {
		return pane;
	}
	
	private void createLabel() {
		namelabel = new InfoLabel("Player name : "+ GameController.getPlayer().getName());
		scorelabel = new InfoLabel("Your score : "+ GameController.getPlayer().getScore());
		pane.getChildren().addAll(namelabel,scorelabel);
	}
	
	private void createReturnViewPageButton() {
		returnButton = new ViewButton("FINISH");
		pane.getChildren().add(returnButton);
		returnButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				stage.hide();
				ViewManager manager = new ViewManager();
			}
		});
	}

		
	
//	public void moveSubScene() {
//		TranslateTransition transition = new TranslateTransition();// take a look at it
//		transition.setDuration(Duration.seconds(0.3));
//		transition.setNode(this);
//
//		if (isHidden) {
//			transition.setToX(-676);
//			isHidden = false;
//		} else {
//			transition.setToX(0);
//			isHidden = true;
//		}
//
//		transition.play();
//	}
	

}
