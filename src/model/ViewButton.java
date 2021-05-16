package model;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class ViewButton extends Button {
	private final String FONT_PATH = "res/kenvector_future.ttf";
	//private final String BUTTON_PRESSED_PATH = ClassLoader.getSystemResource("yellow_button05.png").toString();
	//private final String BUTTON_RELEASED_PATH = ClassLoader.getSystemResource("yellow_button04.png").toString();
	
	private final String BUTTON_PRESSED_STYLE = "-fx-background-color:transparent; -fx-background-image: url('yellow_button05.png');";
	private final String BUTTON_RELEASED_STYLE = "-fx-background-color:transparent; -fx-background-image: url('yellow_button04.png');";
	
	public ViewButton(String text) {
		this.setText(text);
		this.setButtonFont();
		this.setPrefWidth(190);
		this.setPrefHeight(48);
		this.setStyle(BUTTON_RELEASED_STYLE);
		this.initializeButtonListener();
		
	}
	private void setButtonFont() {
		try{
			this.setFont(Font.loadFont(new FileInputStream(FONT_PATH),23));
		}catch(FileNotFoundException e) {
			this.setFont(Font.font("Verdana",23));
			System.out.println("Font is not connected");
			
		}
	}
	private void setButtonPressedStyle() {
		this.setStyle(BUTTON_PRESSED_STYLE);
		this.setPrefHeight(45);
		this.setLayoutY(this.getLayoutY() + 4);
	}
	
	private void setButtonReleasedStyle() {
		this.setStyle(BUTTON_RELEASED_STYLE);
		this.setPrefHeight(49);
		this.setLayoutY(this.getLayoutY() - 4);
	}
	
	private void initializeButtonListener() {
		this.setOnMouseReleased(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonReleasedStyle();
				}
			}
			
		});
		
		this.setOnMousePressed(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonPressedStyle();
				}
			}
			
		});
		
		this.setOnMouseEntered(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setEffect(new DropShadow());
				}
			}
			
		});
		
		this.setOnMouseExited(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					setEffect(null);
				}
			}
			
		});
	}
}

