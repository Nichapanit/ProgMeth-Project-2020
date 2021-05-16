package model;

import javafx.geometry.Pos;import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class CharacterPicker extends VBox{
	private ImageView circleImage;
	private ImageView characterImage;
	private static final int OFFSETX = 0;
	private static final  int OFFSETY = 0;
	private static final  int WIDTH = 64;
	private static final  int HEIGHT = 64;
	
	private String circleNotChosen = ClassLoader.getSystemResource("grey_circle.png").toString();
	private String circleChosen = ClassLoader.getSystemResource("yellow_boxTick.png").toString();
	
	private CHARACTER character;
	
	private boolean isCircleChosen;
	
	public CharacterPicker(CHARACTER character) {
		this.circleImage = new ImageView(this.circleNotChosen);
		this.character = character;
		this.characterImage = new ImageView(character.getCharacterUrl());
		
		//this.characterImage.setFitWidth(70);
		//this.characterImage.setFitHeight(62);
		this.characterImage.setViewport(new Rectangle2D(OFFSETX, OFFSETY, WIDTH, HEIGHT));
//		this.characterImage.setFitWidth(70);
//		this.characterImage.setFitHeight(62);
		this.isCircleChosen = false;
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
		
		this.getChildren().add(circleImage);
		this.getChildren().add(characterImage);
		
		
		
		
		
	}
	
	public CHARACTER getCharacter() {
		return this.character;
	}
	
	public boolean getIsCircleChosen() {
		return this.isCircleChosen;
	}
	
	public void setIscircleChosen(boolean isCircleChosen) {
		this.isCircleChosen = isCircleChosen;
		String imageToSet;
		if(this.isCircleChosen) {
			imageToSet = this.circleChosen;
		}else {
			imageToSet = this.circleNotChosen;
		}
		this.circleImage.setImage(new Image(imageToSet));
		
	}

	
	
	

}
