package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import application.CSVParser;
import application.DrawUtil;

import gamePart.*;
import player.Bomb;
import player.Player;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.Direction;
import model.*;
import application.CSVParser;

public class GameViewManager {
	private VBox gamePane;
	private Stage gameStage;
	private Scene gameScene;
	private Stage menuStage;

	private static final int WIDTH = 932;
	private static final int HEIGHT = 732;
//---------------timer variable----------------------------------------------------------
	private static final int SECONDS_PER_MINUTE = 60;
	private Label timerLabel = new Label();
	private Duration duration;
	private AnimationTimer timer;
	private long lastTimeCall;

	// new added
	private HashMap<KeyCode, Boolean> keys = new HashMap<>();
	private CHARACTER chosenCharacter;
//	private PlayerCharacter player;

	public static  ItemControlPane itemControlPane;
	// --------------------new approach variables------------------------------//

	private int draw_originx;
	private int draw_originy;

	// ---------------------------------last sol----------------------------//
	private final String FONT_PATH = "res/kenvector_future.ttf";
	private AnchorPane gameSpace;
	private Button restartButton;
	private Player player;
	private double originX = 64;
	private double originY = 0;

	private int index;

	private String[][] mapCsv = CSVParser.readCSV("levelMap.csv");

	public GameViewManager() {
		this.initializeGameView();
		// this.createKeyListeners();

	}

	private void initializeGameView() {
		gamePane = new VBox(15);
		gamePane.setAlignment(Pos.CENTER);
		gamePane.setPrefWidth(WIDTH);
		gamePane.setPrefHeight(HEIGHT);
		gamePane.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		gameScene = new Scene(gamePane, WIDTH, HEIGHT);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
		gameStage.setResizable(false);
	}

	public void createNewGame(Stage menuStage, CHARACTER chosenCharacter) {

		this.menuStage = menuStage;
		this.menuStage.hide();
		this.chosenCharacter = chosenCharacter;

		GameController.InitializeMap(mapCsv, 4, 3, chosenCharacter);
		player = GameController.getPlayer();
		createNewGameButton(this.gameStage);
		gamePane.getChildren().add(restartButton);
		createMapSpace();

		itemControlPane = new ItemControlPane();
		itemControlPane.getChildren().add(timerLabel);
		gamePane.getChildren().add(itemControlPane);

		Canvas canvas = new Canvas(gameSpace.getMaxWidth(), gameSpace.getMaxHeight());
		GraphicsContext gc = canvas.getGraphicsContext2D();
		drawGameBoard(gc, 0);
		gameSpace.getChildren().add(canvas);
		
//		goBomb(gameScene,gc);
		addEventListener(gameScene, gc);

		this.gameStage.show();
		setTimerLabelFont();
		createTimeCountdown();
	};

//
//	public void createAnimationLoop() {
//
//		gameScene.setOnKeyPressed(event -> keys.put(event.getCode(), true));
//		gameScene.setOnKeyReleased(event -> {
//			keys.put(event.getCode(), false);
//		});
//
//		AnimationTimer timer = new AnimationTimer() {
//
//			@Override
//			public void handle(long now) {
//				update();
//
//			}
//
//		};
//		timer.start();
//	}x

	private void createMapSpace() {
		gameSpace = new AnchorPane();
		gameSpace.setPrefWidth(WIDTH - 100);
		gameSpace.setPrefHeight(HEIGHT - 220);
		gameSpace.setMaxWidth(WIDTH - 100);
		gameSpace.setMaxHeight(HEIGHT - 220);
		gameSpace.setBackground(
				new Background(new BackgroundFill(Color.BLANCHEDALMOND, CornerRadii.EMPTY, Insets.EMPTY)));
		gamePane.getChildren().add(gameSpace);
	}

	private Button createNewGameButton(Stage menuStagex) {
		restartButton = new Button("NEW GAME");
		restartButton.setTextFill(Color.WHITE);
		restartButton
				.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
		;
		try {
			restartButton.setFont(Font.loadFont(new FileInputStream(FONT_PATH), 12));
		} catch (FileNotFoundException e) {
			restartButton.setFont(Font.font("Verdana", 12));
			System.out.println("Font is not connected");

		}

		restartButton.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (event.getButton() == MouseButton.PRIMARY) {
					ViewManager restart = new ViewManager();
					menuStage = menuStagex;
					menuStagex.hide();
					restart.getMainStage().show();
				}

			}

		});

		return restartButton;
	}

//	private void createCharacter(CHARACTER playerURL) {
//		player = new Player(playerURL);
//
//	}

	private void drawGameBoard(GraphicsContext gc, int index) {

		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0)) {
					gc.setFill(Color.LAVENDER);
					gc.fillRect(i * 64, j * 64, 64, 64);
				} else {
					gc.setFill(Color.LAVENDERBLUSH);
					gc.fillRect(i * 64, j * 64, 64, 64);
				}
			}

		}
		Cell[][] gameBoard = GameController.getCurrentMap().getMap();

		int x = 0;
		int y = 0;

		for (Cell[] row : gameBoard) {
			x = 0;
			for (Cell c : row) {
				if (!c.IsEmpty()) {
					if (c.getEntity() instanceof Player) {
						gc.drawImage(player.getWritableImage(index), draw_originx + x * 64, draw_originy + y * 64);
					} else {
						DrawUtil.drawSprite(gc, draw_originx + x * 64, draw_originy + y * 64, c.getSpriteIndex());
					}
					
				}
				x += 1;
			}
			y += 1;
		}
			
//		createCharacter(chosenCharacter);
//		gc.drawImage(player.getWritableImage(index), originX,originY);

	}

	public boolean isOutOfBound() {
		if (originX < 0) {
			originX = 0;
			return true;
		} else if (originX > gameSpace.getMaxWidth() - 64) {
			originX = (gameSpace.getMaxWidth() - 64);

			return true;
		} else if (originY < 0) {
			originY = 0;
			return true;
		} else if (originY > gameSpace.getMaxHeight() - 64) {
			originY = (gameSpace.getMaxHeight() - 64);
			return true;
		}
		return false;
	}

	private void addEventListener2(Scene scene, GraphicsContext gc) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				int index = 0;
				if (!isOutOfBound()) {
					if (event.getCode() == KeyCode.D) {
						originX += 64;
						index = 1;

					} else if (event.getCode() == KeyCode.A) {
						originX -= 64;
						index = 2;
//						player.setTranslateX(originX);
//						player.move(Direction.LEFT);

					} else if (event.getCode() == KeyCode.W) {
						originY -= 64;
						index = 3;
//						player.setTranslateY(originY);
//						player.move(Direction.UP);
					} else if (event.getCode() == KeyCode.S) {
						originY += 64;
						index = 0;
//						player.setTranslateY(originY);
//						player.move(Direction.DOWN);
					}

				}
				drawGameBoard(gc, index);

			}

		});
	}

	private void addEventListener(Scene s, GraphicsContext gc) {
		s.setOnKeyPressed((event) -> {
			// System.out.println("KeyPressed : " + event.getCode().toString());
			KeyCode keycode = event.getCode();

			switch (keycode) {
			case A:
				GameController.movePlayer(Direction.LEFT);
				index = 2;
				break;
			case D:
				GameController.movePlayer(Direction.RIGHT);
				index = 1;
				break;
			case W:
				GameController.movePlayer(Direction.UP);
				index = 3;
				break;
			case S:
				GameController.movePlayer(Direction.DOWN);
				index = 0;
				break;
			case R:
				GameController.InitializeMap(mapCsv, 0, 0, chosenCharacter); // Reset Map
				break;
			case G:
				int x = player.getX();
				int y = player.getY();
				
				createBomb(x,y,gc);
				break;
			default:
				System.out.println("Invalid Key.");
				break;
			}
			drawGameBoard(gc, index);
		});
		
	}

	//add call item part
	 private void prepareBomb(int x, int y, GraphicsContext gc) {
		  Bomb bomb = new Bomb(x, y);
		  GameController.getCurrentMap().addEntity(bomb, x, y);
		  Thread thread = new Thread(() -> {
		   try {
		    Thread.sleep(2000);
		    Platform.runLater(new Runnable() {

		     @Override
		     public void run() {
		      bomb.bomb();
		     }

		    });
		    GameController.getCurrentMap().removeEntity(x, y);
		    drawGameBoard(gc, index);

		    // GameController.getCurrentMap().addEntity(bomb, x, y);
		   } catch (InterruptedException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  });
		  thread.start();

	}
	
	 private void createBomb(int x, int y, GraphicsContext gc) {
		  if (index == 0 && GameController.getCurrentMap().isMovePossible(x, y + 1, player)) {
		   prepareBomb(x, y + 1, gc);
		  } else if (index == 1 && GameController.getCurrentMap().isMovePossible(x + 1, y, player)) {
		   prepareBomb(x + 1, y, gc);
		  } else if (index == 2 && GameController.getCurrentMap().isMovePossible(x - 1, y, player)) {
		   prepareBomb(x - 1, y, gc);
		  } else if (index == 3 && GameController.getCurrentMap().isMovePossible(x, y - 1, player)) {
		   prepareBomb(x, y - 1, gc);

		  }
	}



	private void setTimerLabelFont() {
		try {
			timerLabel.setFont(Font.loadFont(new FileInputStream(FONT_PATH), 16));
		} catch (FileNotFoundException e) {
			timerLabel.setFont(Font.font("Verdana", 23));
			System.out.println("Font is not connected");

		}
	}

	private void createTimeCountdown() {
		GameController.gameBgm.play();
		duration = Duration.minutes(3);
		lastTimeCall = System.nanoTime();
		timer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				if (now > lastTimeCall + 1_000_000_001) {
					duration = duration.subtract(Duration.seconds(1));

					int remainingSeconds = (int) duration.toSeconds();
					int min = (remainingSeconds) / SECONDS_PER_MINUTE;
					int sec = (remainingSeconds) % SECONDS_PER_MINUTE;

					if (min == 0 && sec == 0) {
						timer.stop();
						gameStage.hide();
						GameController.gameBgm.stop();
						System.out.println("Times up");
						// show final score
						//TimesUpSubScene timesUp = new TimesUpSubScene();


					}
					timerLabel.textProperty().setValue(String.format("%02d", min) + " : " + String.format("%02d", sec));
					lastTimeCall = now;
				}

			}

		};
		timer.start();
	}

}
