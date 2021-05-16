package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.*;

public class ViewManager {

	public static String playerName;

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;

	private static final int MENU_BUTTONS_START_X = 70;
	private static final int MENU_BUTTONS_START_Y = 150;

	private ViewSubScene helpSubScene;
	private ViewSubScene itemSubScene;
	private ViewSubScene creditSubScene;
	private ViewSubScene characterChooserSubScene;
	private ViewSubScene nameSubScene;
	
	private ViewSubScene sceneToHide;
	
	private TextField inputName;

	List<ViewButton> menuButtons;
	List<CharacterPicker> charactersList;

	private static CHARACTER choosenCharacter;

	public ViewManager() {
		menuButtons = new ArrayList<>();
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		mainStage.setResizable(false);
		this.createSubScene();
		this.createButton();
		this.createBackground();
		this.createLogo();
		

	}

	private void showSubScene(ViewSubScene subScene) {
		if (this.sceneToHide != null) {
			sceneToHide.moveSubScene();
		}
		subScene.moveSubScene();
		sceneToHide = subScene;
	}

	private void createSubScene() {
		helpSubScene = new ViewSubScene();
		this.mainPane.getChildren().add(helpSubScene);

		itemSubScene = new ViewSubScene();
		this.mainPane.getChildren().add(itemSubScene);

		characterChooserSubScene = new ViewSubScene();
		this.mainPane.getChildren().add(characterChooserSubScene);

		creditSubScene = new ViewSubScene();
		this.mainPane.getChildren().add(creditSubScene);
		
		createNameSubScene();

		createCharacterChooserSubScene();
	}
	
	// add information to credit,help,item
	
	
	private void createNameSubScene() {
		nameSubScene = new ViewSubScene();
		this.mainPane.getChildren().add(nameSubScene);
		InfoLabel enterName = new InfoLabel("ENTER YOU NAME");
		enterName.setLayoutX(20);
		enterName.setLayoutY(40);
		
		inputName = new TextField();
		inputName.setLayoutX(120);
		inputName.setLayoutY(150);
		
		nameSubScene.getPane().getChildren().add(enterName);
		nameSubScene.getPane().getChildren().add(inputName);
		nameSubScene.getPane().getChildren().add(createLinkButton());
	}
	
	private ViewButton createLinkButton() {
		ViewButton linkButton = new ViewButton("NEXT");
		linkButton.setLayoutX(180);
		linkButton.setLayoutY(226);
		linkButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (inputName.getText()=="") {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText("Player name is required!");
					alert.setContentText("Please enter your name.");
					alert.show();
				}else {
					showSubScene(characterChooserSubScene);
					playerName = inputName.getText();
				}
				
			}
			
		});
		return linkButton;
		
	}

	private void createCharacterChooserSubScene() {
		characterChooserSubScene = new ViewSubScene();
		this.mainPane.getChildren().add(characterChooserSubScene);

		InfoLabel chooseCharacterLabel = new InfoLabel("CHOOSE YOUR CHARACTER");
		chooseCharacterLabel.setLayoutX(20);
		chooseCharacterLabel.setLayoutY(20);

		characterChooserSubScene.getPane().getChildren().add(chooseCharacterLabel);
		characterChooserSubScene.getPane().getChildren().add(createCharacterToChoose());
		characterChooserSubScene.getPane().getChildren().add(createButtonToPlay());

	}

	private HBox createCharacterToChoose() {
		HBox box = new HBox();
		box.setSpacing(30);
		this.charactersList = new ArrayList<>();

		for (CHARACTER character : CHARACTER.values()) {
			CharacterPicker characterToPick = new CharacterPicker(character);
			box.getChildren().add(characterToPick);
			this.charactersList.add(characterToPick);

			characterToPick.setOnMouseClicked(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					for (CharacterPicker character : charactersList) {
						character.setIscircleChosen(false);
					}
					characterToPick.setIscircleChosen(true);
					choosenCharacter = characterToPick.getCharacter();

				}

			});
		}

		box.setLayoutX(64);
		box.setLayoutY(100);
		return box;

	}

	private ViewButton createButtonToPlay() {
		ViewButton playButton = new ViewButton("START");
		playButton.setLayoutX(180);
		playButton.setLayoutY(226);

		playButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (choosenCharacter != null) {

					GameViewManager gameManager = new GameViewManager();
					gameManager.createNewGame(mainStage, choosenCharacter);
					

				}

			}

		});
		return playButton;

	}

	public Stage getMainStage() {
		return this.mainStage;
	}

	private void addMenuButton(ViewButton button) {
		button.setLayoutX(MENU_BUTTONS_START_X);
		button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size() * 80);
		menuButtons.add(button);
		this.mainPane.getChildren().add(button);

	}

	private void createButton() {
		createStartButton();
		createHelpButton();
		createItemButton();
		createCreditButton();
		createExitButton();

	}

	private void createStartButton() {
		ViewButton startButton = new ViewButton("PLAY!");
		addMenuButton(startButton);

		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(nameSubScene);

			}

		});
	}

	private void createHelpButton() {
		ViewButton helpButton = new ViewButton("HELP");
		addMenuButton(helpButton);

		helpButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(helpSubScene);
			}

		});
	}

	private void createItemButton() {
		ViewButton itemButton = new ViewButton("ITEM");
		addMenuButton(itemButton);

		itemButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSubScene(itemSubScene);

			}

		});
	}

	private void createCreditButton() {
		ViewButton creditButton = new ViewButton("CREDIT");
		addMenuButton(creditButton);

		creditButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				showSubScene(creditSubScene);

			}

		});

	}

	private void createExitButton() {
		ViewButton exitButton = new ViewButton("EXIT");
		addMenuButton(exitButton);

		exitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				mainStage.close();

			}

		});
	}

	private void createBackground() {
		String ImagePath = ClassLoader.getSystemResource("Iglu starter Background.png").toString();
		Image backgroundImage = new Image(ImagePath);
		BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
		this.mainPane.setBackground(new Background(background));
	}

	private void createLogo() {
		String logoPath = ClassLoader.getSystemResource("GameLogo.png").toString();
		ImageView logo = new ImageView(new Image(logoPath));
		logo.setFitHeight(200);
		logo.setFitWidth(400);
		logo.setLayoutX(350);
		logo.setLayoutY(50);

		logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(new DropShadow());
			}
		});

		logo.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				logo.setEffect(null);

			}

		});

		this.mainPane.getChildren().add(logo);

	}

	public static CHARACTER getChosenCharacter() {
		return choosenCharacter;
	}

//	public static String getPlayerName() {
//		return playerName;
//	}
}
